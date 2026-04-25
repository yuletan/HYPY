import json

import pytest

from app.clients.openrouter import OpenRouterClient, OpenRouterResponseError, OpenRouterUpstreamError
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


def test_resolve_forced_source_language_honors_explicit_selection() -> None:
    assert OpenRouterClient._resolve_forced_source_language(input_language="ja", detected_language="zh-Hans") == "ja"
    assert OpenRouterClient._resolve_forced_source_language(input_language="en", detected_language="zh-Hans") == "en"
    assert OpenRouterClient._resolve_forced_source_language(input_language="zh", detected_language="ja") == "zh-Hans"
    assert OpenRouterClient._resolve_forced_source_language(input_language="auto", detected_language="ja") == "ja"


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
            retry_upstream_once=False,
            retry_timeout_once=False,
        )
    finally:
        await client.close()

    assert result.sentences == []
    assert len(calls) == 2
    retry_messages = calls[1]["messages"]
    assert isinstance(retry_messages, list)
    assert retry_messages[-1]["role"] == "user"
    assert "failed validation" in retry_messages[-1]["content"]


@pytest.mark.asyncio
async def test_request_structured_output_falls_back_when_json_mode_is_unsupported() -> None:
    client = OpenRouterClient(make_settings())
    calls: list[dict[str, object]] = []
    responses = iter(
        [
            OpenRouterUpstreamError(
                'OpenRouter returned an error response: {"error":{"message":"Provider returned error","code":400,"metadata":{"raw":"{\\"code\\":20024,\\"message\\":\\"Json mode is not supported for this model.\\",\\"data\\":null}"}}}'
            ),
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
        next_item = next(responses)
        if isinstance(next_item, Exception):
            raise next_item
        return next_item

    client._post_chat_completion = fake_post  # type: ignore[method-assign]

    try:
        result = await client._request_structured_output(
            payload={
                "messages": [{"role": "user", "content": "Return JSON"}],
                "response_format": {"type": "json_schema"},
                "plugins": [{"id": "response-healing"}],
            },
            model_type=TextAnalysisResult,
            stage_name="text analysis",
            model_name="tencent/hy3-preview:free",
            retry_upstream_once=False,
            retry_timeout_once=False,
        )
    finally:
        await client.close()

    assert result.sentences == []
    assert len(calls) == 2
    assert "response_format" in calls[0]
    assert "response_format" not in calls[1]
    assert "plugins" not in calls[1]


@pytest.mark.asyncio
async def test_request_structured_output_retries_text_stage_once_after_upstream_error() -> None:
    client = OpenRouterClient(make_settings())
    calls: list[dict[str, object]] = []
    responses = iter(
        [
            OpenRouterUpstreamError("Could not reach OpenRouter."),
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
        next_item = next(responses)
        if isinstance(next_item, Exception):
            raise next_item
        return next_item

    client._post_chat_completion = fake_post  # type: ignore[method-assign]

    try:
        result = await client._request_structured_output(
            payload={"messages": [{"role": "user", "content": "Return JSON"}]},
            model_type=TextAnalysisResult,
            stage_name="text analysis",
            model_name="test-text-model",
            retry_upstream_once=True,
            retry_timeout_once=True,
        )
    finally:
        await client.close()

    assert result.sentences == []
    assert len(calls) == 2


@pytest.mark.asyncio
async def test_request_structured_output_retries_when_completion_tokens_exceed_limit() -> None:
    client = OpenRouterClient(make_settings())
    calls: list[dict[str, object]] = []
    responses = iter(
        [
            {
                "usage": {"completion_tokens": 5001},
                "choices": [
                    {
                        "message": {
                            "content": '{"sentences":[],"glossary":[],"pronunciationHints":[]}',
                        }
                    }
                ],
            },
            {
                "usage": {"completion_tokens": 42},
                "choices": [
                    {
                        "message": {
                            "content": '{"sentences":[],"glossary":[],"pronunciationHints":[]}',
                        }
                    }
                ],
            },
        ]
    )

    async def fake_post(payload: dict[str, object]) -> dict[str, object]:
        calls.append(payload)
        return next(responses)

    client._post_chat_completion = fake_post  # type: ignore[method-assign]

    try:
        result = await client._request_structured_output(
            payload={"messages": [{"role": "user", "content": "Return JSON"}]},
            model_type=TextAnalysisResult,
            stage_name="text analysis",
            model_name="test-text-model",
            retry_upstream_once=False,
            retry_timeout_once=False,
        )
    finally:
        await client.close()

    assert result.sentences == []
    assert len(calls) == 2
    retry_messages = calls[1]["messages"]
    assert isinstance(retry_messages, list)
    assert "5000 completion tokens" in retry_messages[-1]["content"]


@pytest.mark.asyncio
async def test_request_structured_output_retries_once_after_timeout() -> None:
    import asyncio
    from app.clients import openrouter as openrouter_module

    client = OpenRouterClient(make_settings())
    calls: list[dict[str, object]] = []

    async def fake_post(payload: dict[str, object]) -> dict[str, object]:
        calls.append(payload)
        if len(calls) == 1:
            await asyncio.sleep(0.05)
        return {
            "choices": [
                {
                    "message": {
                        "content": '{"sentences":[],"glossary":[],"pronunciationHints":[]}',
                    }
                }
            ]
        }

    client._post_chat_completion = fake_post  # type: ignore[method-assign]

    original_timeout = openrouter_module.MAX_STAGE_RESPONSE_SECONDS
    try:
        openrouter_module.MAX_STAGE_RESPONSE_SECONDS = 0.01
        result = await client._request_structured_output(
            payload={"messages": [{"role": "user", "content": "Return JSON"}]},
            model_type=TextAnalysisResult,
            stage_name="text analysis",
            model_name="test-text-model",
            retry_upstream_once=False,
            retry_timeout_once=True,
        )
    finally:
        openrouter_module.MAX_STAGE_RESPONSE_SECONDS = original_timeout
        await client.close()

    assert result.sentences == []
    assert len(calls) == 2


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


def test_parse_structured_content_repairs_spaced_japanese_ocr_text() -> None:
    content = json.dumps(
        {
            "documentText": (
                "\u6551 \u63f4 \u60c5 \u5831 \u3092\n"
                "\u6771 \u65e5 \u672c \u5de8 \u5927 \u5730 \u9707 \u3067 \u3001 \u5927 \u304d \u306a\n"
                "\u3012 1 0 4 - 8 2 4 3\n"
                "\u30d5 \u30a1 \u30af \u30b9 0 3 \u30fb 5 2 0 0 \u30fb 1 8 3 6"
            ),
            "language": "ja",
            "readingLines": [
                "\u6551 \u63f4 \u60c5 \u5831 \u3092",
                "\u6771 \u65e5 \u672c \u5de8 \u5927 \u5730 \u9707 \u3067 \u3001 \u5927 \u304d \u306a",
                "\u3012 1 0 4 - 8 2 4 3",
                "\u30d5 \u30a1 \u30af \u30b9 0 3 \u30fb 5 2 0 0 \u30fb 1 8 3 6",
            ],
            "pronunciationHints": [
                {
                    "phrase": "\u6771 \u65e5 \u672c \u5de8 \u5927 \u5730 \u9707",
                    "preferredPinyin": "higashi nihon kyodai jishin",
                    "confidence": 0.95,
                }
            ],
            "warnings": [],
        },
        ensure_ascii=False,
    )
    payload = {"choices": [{"message": {"content": content}}]}

    result = OpenRouterClient._parse_structured_content(payload, VisionExtractionResult)

    assert result.document_text == (
        "\u6551\u63f4\u60c5\u5831\u3092\n"
        "\u6771\u65e5\u672c\u5de8\u5927\u5730\u9707\u3067\u3001\u5927\u304d\u306a\n"
        "\u3012104-8243\n"
        "\u30d5\u30a1\u30af\u30b903\u30fb5200\u30fb1836"
    )
    assert result.reading_lines == [
        "\u6551\u63f4\u60c5\u5831\u3092",
        "\u6771\u65e5\u672c\u5de8\u5927\u5730\u9707\u3067\u3001\u5927\u304d\u306a",
        "\u3012104-8243",
        "\u30d5\u30a1\u30af\u30b903\u30fb5200\u30fb1836",
    ]
    assert result.pronunciation_hints[0].phrase == "\u6771\u65e5\u672c\u5de8\u5927\u5730\u9707"


def test_parse_structured_content_rejects_reasoning_inside_vision_text() -> None:
    content = json.dumps(
        {
            "documentText": "Okay, let's tackle this OCR task. Looking at the image, 東日本巨大地震 appears.",
            "language": "ja",
            "readingLines": [],
            "pronunciationHints": [],
            "warnings": [],
        },
        ensure_ascii=False,
    )
    payload = {
        "choices": [
            {
                "message": {
                    "content": content,
                }
            }
        ]
    }

    with pytest.raises(OpenRouterResponseError) as exc_info:
        OpenRouterClient._parse_structured_content(payload, VisionExtractionResult)

    assert "reasoning/commentary" in str(exc_info.value)


def test_parse_structured_content_rejects_repeated_vision_hallucination() -> None:
    repeated = "東日本巨大地震\\n" + "、".join(["15 3 号機"] * 40)
    content = json.dumps(
        {
            "documentText": repeated,
            "language": "ja",
            "readingLines": [repeated],
            "pronunciationHints": [],
            "warnings": [],
        },
        ensure_ascii=False,
    )
    payload = {
        "choices": [
            {
                "message": {
                    "content": content,
                }
            }
        ]
    }

    with pytest.raises(OpenRouterResponseError) as exc_info:
        OpenRouterClient._parse_structured_content(payload, VisionExtractionResult)

    assert "repeated text" in str(exc_info.value)


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
