import pytest

from app.clients.openrouter import OpenRouterClient, OpenRouterResponseError
from app.config import Settings
from app.schemas.contracts import GlossaryEnrichmentResult, TextAnalysisResult, VisionExtractionResult


def make_settings() -> Settings:
    return Settings(
        OPENROUTER_API_KEY="test-key",
        OPENROUTER_TEXT_MODEL="test-text-model",
        OPENROUTER_VISION_MODEL="test-vision-model",
    )


def test_extract_json_candidate_handles_wrapped_content() -> None:
    content = """
    Here is the result:
    ```json
    {"sentences":[],"glossary":[],"pronunciationHints":[]}
    ```
    Extra commentary that should be ignored.
    """.strip()

    candidate = OpenRouterClient._extract_json_candidate(content)

    assert candidate == '{"sentences": [], "glossary": [], "pronunciationHints": []}'


@pytest.mark.asyncio
async def test_request_structured_output_retries_after_invalid_response() -> None:
    client = OpenRouterClient(make_settings())
    calls: list[dict[str, object]] = []
    responses = iter(
        [
            {"choices": [{"message": {"content": "not valid json"}}]},
            {
                "choices": [
                    {
                        "message": {
                            "content": '{"sentences":[],"glossary":[],"pronunciationHints":[]}',
                        }
                    }
                ]
            },
        ]
    )

    async def fake_post(payload: dict[str, object]) -> dict[str, object]:
        calls.append(payload)
        return next(responses)

    client._post_chat_completion = fake_post  # type: ignore[method-assign]

    try:
        result = await client._request_structured_output(
            payload={
                "messages": [{"role": "user", "content": "Return JSON"}],
            },
            model_type=TextAnalysisResult,
            stage_name="text analysis",
            model_name="test-text-model",
        )
    finally:
        await client.close()

    assert result.sentences == []
    assert len(calls) == 2
    retry_messages = calls[1]["messages"]
    assert isinstance(retry_messages, list)
    assert retry_messages[-1]["role"] == "user"
    assert "failed validation" in retry_messages[-1]["content"]


def test_parse_structured_content_raises_helpful_error_for_invalid_schema() -> None:
    payload = {
        "choices": [
            {
                "message": {
                    "content": '["not an object"]',
                }
            }
        ]
    }

    with pytest.raises(OpenRouterResponseError) as exc_info:
        OpenRouterClient._parse_structured_content(payload, TextAnalysisResult)

    assert "expected schema" in str(exc_info.value)
    assert "Preview" in str(exc_info.value)


def test_parse_structured_content_repairs_partial_vision_payload() -> None:
    payload = {
        "choices": [
            {
                "message": {
                    "content": '{"documentText":"Hong Fan Tian Mala hot pot"}',
                }
            }
        ]
    }

    result = OpenRouterClient._parse_structured_content(payload, VisionExtractionResult)

    assert result.document_text == "Hong Fan Tian Mala hot pot"
    assert result.language == "en"
    assert result.reading_lines == ["Hong Fan Tian Mala hot pot"]
    assert result.pronunciation_hints == []
    assert result.warnings == []


def test_parse_structured_content_repairs_empty_token_list_with_full_sentence_fallback() -> None:
    payload = {
        "choices": [
            {
                "message": {
                    "content": '{"sentences":[{"hanzi":"测试","translation":"test"}],"glossary":[],"pronunciationHints":[]}',
                }
            }
        ]
    }

    result = OpenRouterClient._parse_structured_content(payload, TextAnalysisResult)

    assert len(result.sentences) == 1
    assert result.sentences[0].tokens[0].text == "测试"


def test_parse_structured_content_repairs_glossary_enrichment_payload() -> None:
    payload = {
        "choices": [
            {
                "message": {
                    "content": (
                        '{"entries":['
                        '{"hanzi":"特色烤鱼","meaning":"signature grilled fish","exampleSentence":"我想点特色烤鱼。"},'
                        '{"text":"王老吉","literalMeaning":"Wanglaoji herbal tea","exampleSentence":"我点了一罐王老吉。"}'
                        ']}'
                    ),
                }
            }
        ]
    }

    result = OpenRouterClient._parse_structured_content(payload, GlossaryEnrichmentResult)

    assert [entry.text for entry in result.entries] == ["特色烤鱼", "王老吉"]
    assert result.entries[0].literal_meaning == "signature grilled fish"
    assert result.entries[1].example_sentence == "我点了一罐王老吉。"
