package com.hanyupinyin.feature.upload

import androidx.compose.runtime.Immutable
import com.hanyupinyin.app.data.AppSettings
import com.hanyupinyin.core.model.AnalyzeImageResponse

@Immutable
data class SelectedImage(
    val uri: String,
    val displayName: String,
    val mimeType: String?,
)

@Immutable
data class UploadUiState(
    val selectedImage: SelectedImage? = null,
    val settings: AppSettings = AppSettings(),
    val submitState: UploadSubmitState = UploadSubmitState.Empty,
    val autoOpenToken: Long? = null,
) {
    val canAnalyze: Boolean
        get() = selectedImage != null && submitState !is UploadSubmitState.Loading
}

sealed interface UploadSubmitState {
    data object Empty : UploadSubmitState
    data object Ready : UploadSubmitState
    data class Loading(
        val stage: UploadLoadingStage = UploadLoadingStage.AskingVisionModel,
        val showRetryBadge: Boolean = false,
    ) : UploadSubmitState
    data class Success(val response: AnalyzeImageResponse) : UploadSubmitState
    data class Error(val message: String) : UploadSubmitState
}

enum class UploadLoadingStage(
    val title: String,
    val body: String,
) {
    AskingVisionModel(
        title = "Asking vision model",
        body = "Uploading the image and extracting visible text in reading order.",
    ),
    AskingTextModel(
        title = "Asking text model",
        body = "Turning the extracted text into reader lines, glossary items, and flashcards.",
    ),
}
