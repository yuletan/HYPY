package com.hanyupinyin.app.data

import android.util.Log
import java.net.HttpURLConnection
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val LOG_TAG = "HanYuPinYinWarmup"
private const val WARMUP_CONNECT_TIMEOUT_MS = 8_000
private const val WARMUP_READ_TIMEOUT_MS = 8_000

class BackendWarmupRepository {
    suspend fun warmUp(settings: AppSettings): Unit = withContext(Dispatchers.IO) {
        if (settings.normalizedBaseUrl.isBlank()) {
            return@withContext
        }

        runCatching {
            val connection = (URL(settings.healthEndpoint).openConnection() as HttpURLConnection).apply {
                requestMethod = "GET"
                connectTimeout = WARMUP_CONNECT_TIMEOUT_MS
                readTimeout = WARMUP_READ_TIMEOUT_MS
                setRequestProperty("Accept", "application/json")
            }

            try {
                connection.inputStream.use { input -> input.readBytes() }
                Log.i(LOG_TAG, "Backend warmup succeeded status=${connection.responseCode}")
            } finally {
                connection.disconnect()
            }
        }.onFailure { error ->
            Log.w(LOG_TAG, "Backend warmup failed for ${settings.healthEndpoint}", error)
        }
    }
}
