package com.hanyupinyin.app.data

data class LanguageOption(
    val code: String,
    val label: String,
    val description: String,
)

object StudyPreferences {
    const val INPUT_LANGUAGE_AUTO = "auto"
    const val INPUT_LANGUAGE_CHINESE = "zh"
    const val INPUT_LANGUAGE_JAPANESE = "ja"
    const val INPUT_LANGUAGE_ENGLISH = "en"

    const val OUTPUT_LANGUAGE_ENGLISH = "en"
    const val OUTPUT_LANGUAGE_CHINESE = "zh-Hans"
    const val OUTPUT_LANGUAGE_MALAY = "ms"
    const val OUTPUT_LANGUAGE_INDONESIAN = "id"
    const val OUTPUT_LANGUAGE_JAPANESE = "ja"
    const val OUTPUT_LANGUAGE_KOREAN = "ko"
    const val OUTPUT_LANGUAGE_SPANISH = "es"
    const val OUTPUT_LANGUAGE_FRENCH = "fr"
    const val OUTPUT_LANGUAGE_GERMAN = "de"
    const val OUTPUT_LANGUAGE_VIETNAMESE = "vi"

    val inputLanguageOptions = listOf(
        LanguageOption(
            code = INPUT_LANGUAGE_AUTO,
            label = "Auto detect",
            description = "Best for mixed screenshots and uncertain OCR.",
        ),
        LanguageOption(
            code = INPUT_LANGUAGE_CHINESE,
            label = "Chinese",
            description = "Use when the photo is mainly Chinese text.",
        ),
        LanguageOption(
            code = INPUT_LANGUAGE_JAPANESE,
            label = "Japanese",
            description = "Use when the photo is mainly Japanese text.",
        ),
        LanguageOption(
            code = INPUT_LANGUAGE_ENGLISH,
            label = "English",
            description = "Use when the photo is mainly English text.",
        ),
    )

    val outputLanguageOptions = listOf(
        LanguageOption(OUTPUT_LANGUAGE_ENGLISH, "English", "Clear default for most learners."),
        LanguageOption(OUTPUT_LANGUAGE_CHINESE, "Chinese", "Simplified Chinese explanations."),
        LanguageOption(OUTPUT_LANGUAGE_MALAY, "Malay", "Bahasa Melayu explanations."),
        LanguageOption(OUTPUT_LANGUAGE_INDONESIAN, "Indonesian", "Bahasa Indonesia explanations."),
        LanguageOption(OUTPUT_LANGUAGE_JAPANESE, "Japanese", "Japanese explanations."),
        LanguageOption(OUTPUT_LANGUAGE_KOREAN, "Korean", "Korean explanations."),
        LanguageOption(OUTPUT_LANGUAGE_SPANISH, "Spanish", "Spanish explanations."),
        LanguageOption(OUTPUT_LANGUAGE_FRENCH, "French", "French explanations."),
        LanguageOption(OUTPUT_LANGUAGE_GERMAN, "German", "German explanations."),
        LanguageOption(OUTPUT_LANGUAGE_VIETNAMESE, "Vietnamese", "Vietnamese explanations."),
    )

    fun inputLanguageLabel(code: String): String {
        return inputLanguageOptions.firstOrNull { it.code == code }?.label ?: "Auto detect"
    }

    fun outputLanguageLabel(code: String): String {
        return outputLanguageOptions.firstOrNull { it.code == code }?.label ?: "English"
    }
}
