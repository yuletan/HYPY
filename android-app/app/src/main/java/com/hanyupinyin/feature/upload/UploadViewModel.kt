package com.hanyupinyin.feature.upload

import android.app.Application
import android.content.ContentResolver
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.hanyupinyin.app.data.AppSettingsRepository
import java.net.ConnectException
import java.net.MalformedURLException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val LOG_TAG = "HanYuPinYinUpload"

class UploadViewModel(application: Application) : AndroidViewModel(application) {
    private val settingsRepository = AppSettingsRepository(application)
    private val uploadRepository = UploadRepository()

    private val _uiState = MutableStateFlow(UploadUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            settingsRepository.settings.collect { settings ->
                _uiState.update { current ->
                    current.copy(settings = settings)
                }
            }
        }
    }

    fun onImageSelected(
        uri: String,
        displayName: String,
        mimeType: String?,
    ) {
        _uiState.update {
            it.copy(
                selectedImage = SelectedImage(
                    uri = uri,
                    displayName = displayName,
                    mimeType = mimeType,
                ),
                submitState = UploadSubmitState.Ready,
                autoOpenToken = null,
            )
        }
    }

    fun clearSelectedImage() {
        _uiState.update {
            it.copy(
                selectedImage = null,
                submitState = UploadSubmitState.Empty,
                autoOpenToken = null,
            )
        }
    }

    fun consumeAutoOpenRequest() {
        _uiState.update { current ->
            current.copy(autoOpenToken = null)
        }
    }

    fun analyzeImage(contentResolver: ContentResolver) {
        val snapshot = _uiState.value
        val selectedImage = snapshot.selectedImage ?: return
        if (snapshot.submitState is UploadSubmitState.Loading) {
            return
        }

        viewModelScope.launch {
            _uiState.update { current ->
                current.copy(submitState = UploadSubmitState.Loading)
            }

            Log.i(
                LOG_TAG,
                "Analyze image tapped. " +
                    "inputLanguage=${snapshot.settings.inputLanguage} outputLanguage=${snapshot.settings.outputLanguage} " +
                    "endpoint=${snapshot.settings.analyzeImageEndpoint}",
            )

            runCatching {
                uploadRepository.analyzeImage(
                    selectedImage = selectedImage,
                    contentResolver = contentResolver,
                    settings = snapshot.settings,
                )
            }.onSuccess { response ->
                Log.i(
                    LOG_TAG,
                    "Analyze image completed successfully sentences=${response.sentences.size} glossary=${response.glossary.size}",
                )
                _uiState.update { current ->
                    current.copy(
                        submitState = UploadSubmitState.Success(response),
                        autoOpenToken = System.currentTimeMillis(),
                    )
                }
            }.onFailure { error ->
                Log.e(
                    LOG_TAG,
                    "Analyze image failed with userMessage='${error.toUserMessage()}'",
                    error,
                )
                _uiState.update { current ->
                    current.copy(
                        submitState = UploadSubmitState.Error(error.toUserMessage()),
                        autoOpenToken = null,
                    )
                }
            }
        }
    }
}

private fun Throwable.toUserMessage(): String {
    return when (this) {
        is IllegalStateException -> message ?: "Settings are incomplete for live analysis."
        is MalformedURLException -> "The backend base URL is invalid. Include http:// or https://."
        is UnknownHostException -> "The backend host could not be found. Double-check the base URL."
        is ConnectException -> "The app could not connect to the backend. Make sure the server is running."
        is SocketTimeoutException -> if (message?.contains("failed to connect", ignoreCase = true) == true) {
            "The app could not reach the backend. Check the backend URL and make sure your device can reach your laptop."
        } else {
            "The backend took too long to respond."
        }
        else -> message ?: "We couldn't analyze that image yet."
    }
}
