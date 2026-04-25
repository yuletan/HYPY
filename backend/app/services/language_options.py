SUPPORTED_INPUT_LANGUAGE_NAMES = {
    "auto": "auto-detect",
    "zh": "Chinese",
    "ja": "Japanese",
    "en": "English",
}

SUPPORTED_OUTPUT_LANGUAGE_NAMES = {
    "en": "English",
    "zh-Hans": "Simplified Chinese",
    "ms": "Malay",
    "id": "Indonesian",
    "ja": "Japanese",
    "ko": "Korean",
    "es": "Spanish",
    "fr": "French",
    "de": "German",
    "vi": "Vietnamese",
}


def normalize_input_language(code: str | None) -> str:
    raw = (code or "auto").strip()
    normalized = raw.lower()
    aliases = {
        "zh-hans": "zh",
        "zh_hans": "zh",
        "zh-hant": "zh",
        "zh_hant": "zh",
        "chinese": "zh",
        "japanese": "ja",
        "english": "en",
    }
    candidate = aliases.get(normalized, normalized)
    return candidate if candidate in SUPPORTED_INPUT_LANGUAGE_NAMES else "auto"


def normalize_output_language(code: str | None) -> str:
    normalized = (code or "en").strip()
    return normalized if normalized in SUPPORTED_OUTPUT_LANGUAGE_NAMES else "en"


def input_language_name(code: str | None) -> str:
    normalized = normalize_input_language(code)
    return SUPPORTED_INPUT_LANGUAGE_NAMES[normalized]


def output_language_name(code: str | None) -> str:
    normalized = normalize_output_language(code)
    return SUPPORTED_OUTPUT_LANGUAGE_NAMES[normalized]
