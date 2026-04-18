package com.hanyupinyin.app.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.appSettingsDataStore by preferencesDataStore(name = "app_settings")

data class AppSettings(
    val backendBaseUrl: String = BackendBaseUrlResolver.defaultBaseUrl(),
    val simulateSlowResponses: Boolean = false,
    val useDarkTheme: Boolean = false,
    val inputLanguage: String = StudyPreferences.INPUT_LANGUAGE_AUTO,
    val outputLanguage: String = StudyPreferences.OUTPUT_LANGUAGE_ENGLISH,
    val autoOpenReader: Boolean = true,
    val showParsedTextPreview: Boolean = false,
) {
    val normalizedBaseUrl: String
        get() = backendBaseUrl.trim().trimEnd('/')

    val analyzeImageEndpoint: String
        get() = if (normalizedBaseUrl.isBlank()) {
            "/api/v1/analyze-image"
        } else {
            "$normalizedBaseUrl/api/v1/analyze-image"
        }

    companion object {
        const val LEGACY_EMULATOR_BACKEND_BASE_URL = "http://10.0.2.2:8000"
    }
}

class AppSettingsRepository(private val context: Context) {
    val settings: Flow<AppSettings> = context.appSettingsDataStore.data.map { preferences ->
        val savedBaseUrl = preferences[BACKEND_BASE_URL_KEY]
        val resolvedBaseUrl = when {
            savedBaseUrl.isNullOrBlank() -> BackendBaseUrlResolver.defaultBaseUrl()
            BackendBaseUrlResolver.shouldUpgradeLegacyEmulatorUrl(savedBaseUrl) -> {
                BackendBaseUrlResolver.defaultBaseUrl()
            }

            else -> savedBaseUrl
        }

        AppSettings(
            backendBaseUrl = resolvedBaseUrl,
            simulateSlowResponses = preferences[SIMULATE_SLOW_RESPONSES_KEY] ?: false,
            useDarkTheme = preferences[USE_DARK_THEME_KEY] ?: false,
            inputLanguage = preferences[INPUT_LANGUAGE_KEY]
                ?.takeIf { saved -> StudyPreferences.inputLanguageOptions.any { it.code == saved } }
                ?: StudyPreferences.INPUT_LANGUAGE_AUTO,
            outputLanguage = preferences[OUTPUT_LANGUAGE_KEY]
                ?.takeIf { saved -> StudyPreferences.outputLanguageOptions.any { it.code == saved } }
                ?: StudyPreferences.OUTPUT_LANGUAGE_ENGLISH,
            autoOpenReader = preferences[AUTO_OPEN_READER_KEY] ?: true,
            showParsedTextPreview = preferences[SHOW_PARSED_TEXT_PREVIEW_KEY] ?: false,
        )
    }

    suspend fun update(settings: AppSettings) {
        context.appSettingsDataStore.edit { preferences ->
            preferences[BACKEND_BASE_URL_KEY] = settings.normalizedBaseUrl
            preferences[SIMULATE_SLOW_RESPONSES_KEY] = settings.simulateSlowResponses
            preferences[USE_DARK_THEME_KEY] = settings.useDarkTheme
            preferences[INPUT_LANGUAGE_KEY] = settings.inputLanguage
            preferences[OUTPUT_LANGUAGE_KEY] = settings.outputLanguage
            preferences[AUTO_OPEN_READER_KEY] = settings.autoOpenReader
            preferences[SHOW_PARSED_TEXT_PREVIEW_KEY] = settings.showParsedTextPreview
        }
    }

    private companion object {
        val BACKEND_BASE_URL_KEY = stringPreferencesKey("backend_base_url")
        val SIMULATE_SLOW_RESPONSES_KEY = booleanPreferencesKey("simulate_slow_responses")
        val USE_DARK_THEME_KEY = booleanPreferencesKey("use_dark_theme")
        val INPUT_LANGUAGE_KEY = stringPreferencesKey("input_language")
        val OUTPUT_LANGUAGE_KEY = stringPreferencesKey("output_language")
        val AUTO_OPEN_READER_KEY = booleanPreferencesKey("auto_open_reader")
        val SHOW_PARSED_TEXT_PREVIEW_KEY = booleanPreferencesKey("show_parsed_text_preview")
    }
}
