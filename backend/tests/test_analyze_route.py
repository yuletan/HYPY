from app.clients.openrouter import OpenRouterClientError
from app.config import Settings
from app.main import create_app
from app.schemas.contracts import PronunciationHint, VisionExtractionResult
from fastapi.testclient import TestClient


def make_settings() -> Settings:
    return Settings(
        OPENROUTER_API_KEY="test-key",
        OPENROUTER_TEXT_MODEL="test-text-model",
        OPENROUTER_VISION_MODEL="test-vision-model",
    )


class TextAnalysisUnavailableClient:
    async def extract_text_from_image(
        self,
        image_bytes: bytes,
        media_type: str,
        input_language: str = "auto",
    ) -> VisionExtractionResult:
        return VisionExtractionResult(
            documentText="\u957f\u5927\u4ee5\u540e\uff0c\u6211\u60f3\u53bb\u91cd\u5e86\u770b\u591c\u666f\u3002",
            language="zh-Hans",
            readingLines=["\u957f\u5927\u4ee5\u540e\uff0c\u6211\u60f3\u53bb\u91cd\u5e86\u770b\u591c\u666f\u3002"],
            pronunciationHints=[
                PronunciationHint(
                    phrase="\u957f\u5927",
                    preferredPinyin="zhang3 da4",
                    confidence=0.95,
                )
            ],
            warnings=[],
        )

    async def analyze_text_for_study(self, *args: object, **kwargs: object) -> object:
        raise OpenRouterClientError("text model is unavailable")

    async def enrich_glossary_terms(self, *args: object, **kwargs: object) -> object:
        raise AssertionError("glossary enrichment should not run when fallback response has no glossary")


def test_analyze_image_falls_back_when_text_analysis_is_unavailable() -> None:
    app = create_app(
        settings=make_settings(),
        openrouter_client=TextAnalysisUnavailableClient(),
    )

    with TestClient(app) as client:
        response = client.post(
            "/api/v1/analyze-image",
            files={"image": ("scan.png", b"fake-image-bytes", "image/png")},
            data={"input_language": "auto", "output_language": "en"},
        )

    assert response.status_code == 200
    payload = response.json()
    assert payload["documentText"] == "\u957f\u5927\u4ee5\u540e\uff0c\u6211\u60f3\u53bb\u91cd\u5e86\u770b\u591c\u666f\u3002"
    assert payload["sentences"]
    assert payload["warnings"] == [
        "Text analysis is temporarily unavailable; showing OCR text with local pronunciation."
    ]
