from app.clients.openrouter import OpenRouterClientError
from app.config import Settings
from app.main import create_app
from app.schemas.contracts import (
    GlossaryDraft,
    GlossaryEnrichmentResult,
    PronunciationHint,
    TextAnalysisResult,
    TextSentence,
    TextToken,
    VisionExtractionResult,
)
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


class RecordingWorkflowClient:
    def __init__(self) -> None:
        self.calls: list[tuple[object, ...]] = []

    async def extract_text_from_image(
        self,
        image_bytes: bytes,
        media_type: str,
        input_language: str = "auto",
    ) -> VisionExtractionResult:
        self.calls.append(("vision", len(image_bytes), media_type, input_language))
        return VisionExtractionResult(
            documentText="\u94f6\u884c\u884c\u957f\u6b63\u5728\u8bb2\u8bdd\u3002",
            language="zh-Hans",
            readingLines=["\u94f6\u884c\u884c\u957f\u6b63\u5728\u8bb2\u8bdd\u3002"],
            pronunciationHints=[
                PronunciationHint(
                    phrase="\u884c\u957f",
                    preferredPinyin="hang2 zhang3",
                    confidence=0.95,
                )
            ],
            warnings=[],
        )

    async def analyze_text_for_study(
        self,
        document_text: str,
        pronunciation_hints: list[PronunciationHint],
        input_language: str = "auto",
        output_language: str = "en",
    ) -> TextAnalysisResult:
        self.calls.append(
            (
                "text",
                document_text,
                tuple(hint.phrase for hint in pronunciation_hints),
                input_language,
                output_language,
            )
        )
        return TextAnalysisResult(
            sentences=[
                TextSentence(
                    hanzi="\u94f6\u884c\u884c\u957f\u6b63\u5728\u8bb2\u8bdd\u3002",
                    translation="The bank president is speaking.",
                    tokens=[
                        TextToken(text="\u94f6\u884c\u884c\u957f\u6b63\u5728\u8bb2\u8bdd\u3002", kind="other"),
                    ],
                )
            ],
            glossary=[],
            pronunciationHints=[],
        )

    async def enrich_glossary_terms(self, *args: object, **kwargs: object) -> object:
        self.calls.append(("glossary",))
        raise AssertionError("glossary enrichment should not run in this workflow assertion")


class GlossaryRecordingClient:
    def __init__(self) -> None:
        self.calls: list[tuple[object, ...]] = []

    async def extract_text_from_image(
        self,
        image_bytes: bytes,
        media_type: str,
        input_language: str = "auto",
    ) -> VisionExtractionResult:
        self.calls.append(("vision", input_language))
        return VisionExtractionResult(
            documentText="\u65e5\u672c\u8a9e\u3092\u52c9\u5f37\u3057\u307e\u3059\u3002",
            language="ja",
            readingLines=["\u65e5\u672c\u8a9e\u3092\u52c9\u5f37\u3057\u307e\u3059\u3002"],
            pronunciationHints=[],
            warnings=[],
        )

    async def analyze_text_for_study(
        self,
        document_text: str,
        pronunciation_hints: list[PronunciationHint],
        input_language: str = "auto",
        output_language: str = "en",
    ) -> TextAnalysisResult:
        self.calls.append(("text", input_language, output_language))
        return TextAnalysisResult(
            sentences=[
                TextSentence(
                    hanzi=document_text,
                    translation="I study Japanese.",
                    tokens=[TextToken(text="\u65e5\u672c\u8a9e", kind="word", meaning="Japanese language")],
                )
            ],
            glossary=[GlossaryDraft(text="\u65e5\u672c\u8a9e", meaning="Japanese language")],
            pronunciationHints=[],
        )

    async def enrich_glossary_terms(
        self,
        document_text: str,
        glossary_terms: list[str],
        source_language: str = "auto",
        output_language: str = "en",
    ) -> GlossaryEnrichmentResult:
        self.calls.append(("glossary", tuple(glossary_terms), source_language, output_language))
        return GlossaryEnrichmentResult(entries=[])


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


def test_analyze_image_calls_text_analysis_after_vision() -> None:
    workflow_client = RecordingWorkflowClient()
    app = create_app(
        settings=make_settings(),
        openrouter_client=workflow_client,
    )

    with TestClient(app) as client:
        response = client.post(
            "/api/v1/analyze-image",
            files={"image": ("scan.png", b"fake-image-bytes", "image/png")},
            data={"input_language": "zh-Hans", "output_language": "en"},
        )

    assert response.status_code == 200
    payload = response.json()
    assert workflow_client.calls[:2] == [
        ("vision", len(b"fake-image-bytes"), "image/png", "zh"),
        (
            "text",
            "\u94f6\u884c\u884c\u957f\u6b63\u5728\u8bb2\u8bdd\u3002",
            ("\u884c\u957f",),
            "zh",
            "en",
        ),
    ]
    assert "glossary" not in [call[0] for call in workflow_client.calls]
    assert payload["documentText"] == "\u94f6\u884c\u884c\u957f\u6b63\u5728\u8bb2\u8bdd\u3002"
    assert payload["sentences"][0]["translation"] == "The bank president is speaking."
    assert payload["sentences"][0]["tokens"][0]["hanzi"] == "\u94f6\u884c\u884c\u957f\u6b63\u5728\u8bb2\u8bdd\u3002"


def test_analyze_image_honors_explicit_japanese_input_language() -> None:
    workflow_client = RecordingWorkflowClient()
    app = create_app(
        settings=make_settings(),
        openrouter_client=workflow_client,
    )

    with TestClient(app) as client:
        response = client.post(
            "/api/v1/analyze-image",
            files={"image": ("scan.png", b"fake-image-bytes", "image/png")},
            data={"input_language": "ja", "output_language": "en"},
        )

    assert response.status_code == 200
    payload = response.json()
    assert payload["language"] == "ja"
    assert workflow_client.calls[0] == ("vision", len(b"fake-image-bytes"), "image/png", "ja")
    assert workflow_client.calls[1][-2:] == ("ja", "en")


def test_analyze_image_passes_source_language_to_glossary_enrichment() -> None:
    workflow_client = GlossaryRecordingClient()
    app = create_app(
        settings=make_settings(),
        openrouter_client=workflow_client,
    )

    with TestClient(app) as client:
        response = client.post(
            "/api/v1/analyze-image",
            files={"image": ("scan.png", b"fake-image-bytes", "image/png")},
            data={"input_language": "ja", "output_language": "en"},
        )

    assert response.status_code == 200
    assert ("glossary", ("\u65e5\u672c\u8a9e",), "ja", "en") in workflow_client.calls
