package com.hanyupinyin.feature.saved

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.hanyupinyin.app.data.SavedStudyRepository
import com.hanyupinyin.core.model.AnalyzeImageResponse
import com.hanyupinyin.core.model.SavedStudyItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class SavedStudiesUiState(
    val isLoading: Boolean = true,
    val items: List<SavedStudyItem> = emptyList(),
    val notice: String? = null,
    val errorMessage: String? = null,
)

class SavedStudiesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = SavedStudyRepository(application)

    private val _uiState = MutableStateFlow(SavedStudiesUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.savedStudies.collect { savedStudies ->
                _uiState.update { current ->
                    current.copy(
                        isLoading = false,
                        items = savedStudies,
                    )
                }
            }
        }
    }

    fun saveStudy(response: AnalyzeImageResponse) {
        viewModelScope.launch {
            runCatching {
                repository.save(response)
            }.onSuccess {
                _uiState.update { current ->
                    current.copy(
                        notice = "Saved locally for later review.",
                        errorMessage = null,
                    )
                }
            }.onFailure { error ->
                _uiState.update { current ->
                    current.copy(
                        errorMessage = error.message ?: "Could not save this study item.",
                        notice = null,
                    )
                }
            }
        }
    }

    fun deleteStudy(savedStudyId: String) {
        viewModelScope.launch {
            runCatching {
                repository.delete(savedStudyId)
            }.onSuccess {
                _uiState.update { current ->
                    current.copy(
                        notice = "Deleted saved flashcards.",
                        errorMessage = null,
                    )
                }
            }.onFailure { error ->
                _uiState.update { current ->
                    current.copy(
                        errorMessage = error.message ?: "Could not delete this saved study item.",
                        notice = null,
                    )
                }
            }
        }
    }

    fun clearMessages() {
        _uiState.update { current ->
            current.copy(
                notice = null,
                errorMessage = null,
            )
        }
    }
}
