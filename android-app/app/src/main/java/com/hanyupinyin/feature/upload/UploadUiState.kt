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
    data object Loading : UploadSubmitState
    data class Success(val response: AnalyzeImageResponse) : UploadSubmitState
    data class Error(val message: String) : UploadSubmitState
}
