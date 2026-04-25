package com.hanyupinyin.feature.upload

import android.content.ContentResolver
import android.net.Uri
import android.util.Log
import com.hanyupinyin.app.data.AppSettings
import com.hanyupinyin.core.model.AnalyzeImageResponse
import com.hanyupinyin.core.model.StudyJson
import com.hanyupinyin.core.model.withoutDebug
import java.io.DataOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString

private const val LOG_TAG = "HanYuPinYinUpload"
private const val CONNECT_TIMEOUT_MS = 20_000
private const val READ_TIMEOUT_MS = 180_000

class UploadRepository {
    suspend fun analyzeImage(
        selectedImage: SelectedImage,
        contentResolver: ContentResolver,
        settings: AppSettings,
    ): AnalyzeImageResponse = withContext(Dispatchers.IO) {
        if (settings.simulateSlowResponses) {
            delay(1200)
        }

        if (settings.normalizedBaseUrl.isBlank()) {
            throw IllegalStateException(
                "Add a backend base URL in Settings before using live analysis.",
            )
        }

        val uri = Uri.parse(selectedImage.uri)
        val mimeType = selectedImage.mimeType ?: contentResolver.getType(uri) ?: "image/jpeg"
        val fileName = selectedImage.displayName.ifBlank { "study-image" }
        val endpoint = settings.analyzeImageEndpoint

        Log.i(
            LOG_TAG,
            "Submitting live analyze-image request to endpoint=$endpoint fileName=$fileName mimeType=$mimeType " +
                "inputLanguage=${settings.inputLanguage} outputLanguage=${settings.outputLanguage} " +
                "connectTimeoutMs=$CONNECT_TIMEOUT_MS readTimeoutMs=$READ_TIMEOUT_MS",
        )

        return@withContext runCatching {
            postAnalyzeRequest(
                endpoint = endpoint,
                uri = uri,
                mimeType = mimeType,
                fileName = fileName,
                contentResolver = contentResolver,
                inputLanguage = settings.inputLanguage,
                outputLanguage = settings.outputLanguage,
            )
        }.mapCatching { response ->
            Log.i(
                LOG_TAG,
                "Analyze-image request succeeded sentences=${response.sentences.size} glossary=${response.glossary.size}",
            )
            logPromptDebugInfo(response)
            response.withoutDebug()
        }.onFailure { error ->
            Log.e(
                LOG_TAG,
                "Analyze-image request failed endpoint=$endpoint fileName=$fileName mimeType=$mimeType",
                error,
            )
        }.getOrThrow()
    }

    private fun postAnalyzeRequest(
        endpoint: String,
        uri: Uri,
        mimeType: String,
        fileName: String,
        contentResolver: ContentResolver,
        inputLanguage: String,
        outputLanguage: String,
    ): AnalyzeImageResponse {
        val boundary = "Boundary-${System.currentTimeMillis()}"
        val connection = (URL(endpoint).openConnection() as HttpURLConnection).apply {
            requestMethod = "POST"
            doInput = true
            doOutput = true
            connectTimeout = CONNECT_TIMEOUT_MS
            readTimeout = READ_TIMEOUT_MS
            setChunkedStreamingMode(0)
            setRequestProperty("Accept", "application/json")
            setRequestProperty("Content-Type", "multipart/form-data; boundary=$boundary")
        }

        try {
            DataOutputStream(connection.outputStream).use { output ->
                output.writeFormField(
                    boundary = boundary,
                    name = "input_language",
                    value = inputLanguage,
                )
                output.writeFormField(
                    boundary = boundary,
                    name = "output_language",
                    value = outputLanguage,
                )
                output.writeUtf8("--$boundary\r\n")
                output.writeUtf8(
                    "Content-Disposition: form-data; name=\"image\"; filename=\"" +
                        "${fileName.replace("\"", "_")}\"" +
                        "\r\n",
                )
                output.writeUtf8("Content-Type: $mimeType\r\n\r\n")
                contentResolver.openInputStream(uri)?.use { input ->
                    input.copyTo(output)
                } ?: throw IOException("Couldn't read the selected image.")
                output.writeUtf8("\r\n--$boundary--\r\n")
                output.flush()
            }

            val responseBody = connection.readResponseBody()
            if (connection.responseCode !in 200..299) {
                Log.e(
                    LOG_TAG,
                    "Backend returned non-success status=${connection.responseCode} body=${responseBody.take(500)}",
                )
                throw IOException(errorMessageFor(connection.responseCode, responseBody))
            }
            if (responseBody.isBlank()) {
                Log.e(LOG_TAG, "Backend returned an empty response for endpoint=$endpoint")
                throw IOException("The backend returned an empty response.")
            }
            return StudyJson.decodeFromString(responseBody)
        } finally {
            connection.disconnect()
        }
    }

    private fun HttpURLConnection.readResponseBody(): String {
        val stream = if (responseCode in 200..299) {
            inputStream
        } else {
            errorStream
        } ?: return ""
        return stream.bufferedReader(Charsets.UTF_8).use { reader -> reader.readText() }
    }

    private fun errorMessageFor(statusCode: Int, responseBody: String): String {
        val body = responseBody.trim()
        return if (body.isBlank()) {
            "The backend request failed with status $statusCode."
        } else {
            "The backend request failed with status $statusCode: $body"
        }
    }

    private fun DataOutputStream.writeUtf8(value: String) {
        write(value.toByteArray(Charsets.UTF_8))
    }

    private fun logPromptDebugInfo(response: AnalyzeImageResponse) {
        val debug = response.debug ?: run {
            Log.i(LOG_TAG, "Analyze-image response contained no debug prompt bundle.")
            return
        }

        Log.i(
            LOG_TAG,
            buildString {
                appendLine("OpenRouter prompt debug bundle follows.")
                appendLine("=== visionPrompt ===")
                appendLine(debug.visionPrompt.orEmpty())
                appendLine("=== textSystemPrompt ===")
                appendLine(debug.textSystemPrompt.orEmpty())
                appendLine("=== textUserPrompt ===")
                appendLine(debug.textUserPrompt.orEmpty())
                appendLine("=== glossarySystemPrompt ===")
                appendLine(debug.glossarySystemPrompt.orEmpty())
                appendLine("=== glossaryUserPrompt ===")
                appendLine(debug.glossaryUserPrompt.orEmpty())
                append("=== endPromptDebug ===")
            },
        )
    }

    private fun DataOutputStream.writeFormField(
        boundary: String,
        name: String,
        value: String,
    ) {
        writeUtf8("--$boundary\r\n")
        writeUtf8("Content-Disposition: form-data; name=\"$name\"\r\n\r\n")
        writeUtf8("$value\r\n")
    }
}
