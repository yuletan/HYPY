import json

from app.schemas.contracts import PronunciationHint
from app.services.prompts import (
    GLOSSARY_ENRICHMENT_SYSTEM_PROMPT,
    TEXT_ANALYSIS_SYSTEM_PROMPT,
    build_glossary_enrichment_messages,
    build_text_analysis_messages,
)


def test_text_analysis_prompt_builder_returns_stable_json_messages() -> None:
    hints = [
        PronunciationHint(
            phrase="\u957f\u5927",
            preferredPinyin="zhang3 da4",
            toneNumberPinyin="zhang3 da4",
            reason="vision context hint",
            confidence=0.95,
        )
    ]

    messages = build_text_analysis_messages(
        document_text="\u957f\u5927\u4ee5\u540e\uff0c\u6211\u60f3\u53bb\u91cd\u5e86\u3002",
        pronunciation_hints=hints,
        input_language_name="Chinese",
        output_language_name="English",
    )

    assert len(messages) == 2
    assert messages[0]["role"] == "system"
    assert "Return JSON only" in TEXT_ANALYSIS_SYSTEM_PROMPT
    assert messages[1]["role"] == "user"

    payload = json.loads(messages[1]["content"])
    assert payload["task"] == "segment_for_study"
    assert payload["documentText"] == "\u957f\u5927\u4ee5\u540e\uff0c\u6211\u60f3\u53bb\u91cd\u5e86\u3002"
    assert payload["sourceLanguage"] == "Chinese"
    assert payload["outputLanguage"] == "English"
    assert payload["existingPronunciationHints"][0]["phrase"] == "\u957f\u5927"
    assert any("Return valid JSON matching the schema exactly." == item for item in payload["outputChecklist"])


def test_glossary_enrichment_prompt_builder_returns_stable_json_messages() -> None:
    messages = build_glossary_enrichment_messages(
        document_text="\u7279\u8272\u70e4\u9c7c\n1x \u738b\u8001\u5409",
        glossary_terms=["\u7279\u8272\u70e4\u9c7c", "\u738b\u8001\u5409"],
        input_language_name="Japanese",
        output_language_name="Malay",
    )

    assert len(messages) == 2
    assert messages[0]["role"] == "system"
    assert "literalMeaning" in GLOSSARY_ENRICHMENT_SYSTEM_PROMPT
    assert messages[1]["role"] == "user"

    payload = json.loads(messages[1]["content"])
    assert payload["task"] == "enrich_glossary"
    assert payload["sourceLanguage"] == "Japanese"
    assert payload["outputLanguage"] == "Malay"
    assert payload["glossaryTerms"] == ["\u7279\u8272\u70e4\u9c7c", "\u738b\u8001\u5409"]
    assert any(
        "Populate literalMeaning with a concise literal meaning in the requested output language." == item
        for item in payload["outputChecklist"]
    )
