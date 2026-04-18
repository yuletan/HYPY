package com.hanyupinyin.feature.settings

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.hanyupinyin.app.data.AppSettings
import com.hanyupinyin.app.data.AppSettingsRepository
import com.hanyupinyin.app.data.StudyPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class SettingsUiState(
    val isLoading: Boolean = true,
    val settings: AppSettings = AppSettings(),
    val errorMessage: String? = null,
)

class SettingsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = AppSettingsRepository(application)

    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.settings.collectLatest { settings ->
                _uiState.update { current ->
                    current.copy(
                        isLoading = false,
                        settings = settings,
                    )
                }
            }
        }
    }

    fun onDarkThemeChanged(value: Boolean) = persistUpdate { copy(useDarkTheme = value) }

    fun onInputLanguageChanged(value: String) {
        if (StudyPreferences.inputLanguageOptions.none { it.code == value }) {
            return
        }
        persistUpdate { copy(inputLanguage = value) }
    }

    fun onOutputLanguageChanged(value: String) {
        if (StudyPreferences.outputLanguageOptions.none { it.code == value }) {
            return
        }
        persistUpdate { copy(outputLanguage = value) }
    }

    fun onAutoOpenReaderChanged(value: Boolean) = persistUpdate { copy(autoOpenReader = value) }

    fun onShowParsedTextPreviewChanged(value: Boolean) = persistUpdate { copy(showParsedTextPreview = value) }

    fun onSimulateSlowResponsesChanged(value: Boolean) = persistUpdate { copy(simulateSlowResponses = value) }

    private fun persistUpdate(transform: AppSettings.() -> AppSettings) {
        val snapshot = _uiState.value.settings
        viewModelScope.launch {
            runCatching {
                repository.update(snapshot.transform())
            }.onSuccess {
                _uiState.update { current ->
                    current.copy(errorMessage = null)
                }
            }.onFailure { error ->
                _uiState.update { current ->
                    current.copy(errorMessage = error.message ?: "Settings could not be updated.")
                }
            }
        }
    }
}
