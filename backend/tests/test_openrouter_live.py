import base64
import os

import pytest

from app.clients.openrouter import OpenRouterClient
from app.config import get_settings

RUN_LIVE_TESTS = os.getenv("RUN_LIVE_OPENROUTER_TESTS") == "1"

pytestmark = [
    pytest.mark.skipif(
        not RUN_LIVE_TESTS,
        reason="Set RUN_LIVE_OPENROUTER_TESTS=1 to run live OpenRouter checks.",
    ),
    pytest.mark.asyncio,
]

# A tiny valid PNG. This checks that the configured vision model accepts image input
# and returns structured JSON without requiring an extra image fixture file.
BLANK_PNG_BYTES = base64.b64decode(
    "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mP8/x8AAusB9Wn4nWQAAAAASUVORK5CYII="
)


async def test_text_model_live_returns_structured_study_response() -> None:
    settings = get_settings()
    client = OpenRouterClient(settings)

    try:
        result = await client.analyze_text_for_study(
            document_text="银行行长正在讲话。",
            pronunciation_hints=[],
        )
    finally:
        await client.close()

    print(f"text model: {settings.openrouter_text_model}")
    print(f"sentences returned: {len(result.sentences)}")
    print(f"glossary returned: {len(result.glossary)}")

    assert isinstance(result.sentences, list)
    assert len(result.sentences) >= 1
    assert result.sentences[0].hanzi


async def test_vision_model_live_accepts_image_input() -> None:
    settings = get_settings()
    client = OpenRouterClient(settings)

    try:
        result = await client.extract_text_from_image(
            image_bytes=BLANK_PNG_BYTES,
            media_type="image/png",
        )
    finally:
        await client.close()

    print(f"vision model: {settings.openrouter_vision_model}")
    print(f"vision language: {result.language}")
    print(f"vision warnings: {len(result.warnings)}")
    print(f"vision document text length: {len(result.document_text)}")

    assert isinstance(result.document_text, str)
    assert isinstance(result.language, str)
    assert isinstance(result.warnings, list)
