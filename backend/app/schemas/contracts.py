from typing import Literal

from pydantic import BaseModel, ConfigDict, Field


PinyinSource = Literal["library", "vision_hint", "text_model_hint"]
TokenKind = Literal["word", "phrase", "punctuation", "other"]
SelectionScope = Literal["word", "phrase", "sentence"]

ALIASED_MODEL_CONFIG = ConfigDict(populate_by_name=True, extra="forbid", str_strip_whitespace=True)
STRICT_MODEL_CONFIG = ConfigDict(extra="forbid", str_strip_whitespace=True)


class PronunciationHint(BaseModel):
    model_config = ALIASED_MODEL_CONFIG

    phrase: str = Field(min_length=1)
    preferred_pinyin: str = Field(alias="preferredPinyin", min_length=1)
    tone_number_pinyin: str | None = Field(default=None, alias="toneNumberPinyin")
    reason: str | None = None
    confidence: float = Field(default=0.0, ge=0.0, le=1.0)

    def applies_to(self, source_text: str) -> bool:
        return bool(source_text and self.phrase in source_text)


class VisionExtractionResult(BaseModel):
    model_config = ALIASED_MODEL_CONFIG

    document_text: str = Field(alias="documentText")
    language: str
    reading_lines: list[str] = Field(default_factory=list, alias="readingLines")
    pronunciation_hints: list[PronunciationHint] = Field(default_factory=list, alias="pronunciationHints")
    warnings: list[str] = Field(default_factory=list)


class TextToken(BaseModel):
    model_config = STRICT_MODEL_CONFIG

    text: str = Field(min_length=1)
    kind: TokenKind = "word"
    meaning: str | None = None


class TextSentence(BaseModel):
    model_config = STRICT_MODEL_CONFIG

    hanzi: str = Field(min_length=1)
    translation: str | None = None
    tokens: list[TextToken] = Field(default_factory=list)


class GlossaryDraft(BaseModel):
    model_config = STRICT_MODEL_CONFIG

    text: str = Field(min_length=1)
    meaning: str | None = None


class TextAnalysisResult(BaseModel):
    model_config = ALIASED_MODEL_CONFIG

    sentences: list[TextSentence] = Field(default_factory=list)
    glossary: list[GlossaryDraft] = Field(default_factory=list)
    pronunciation_hints: list[PronunciationHint] = Field(default_factory=list, alias="pronunciationHints")


class GlossaryEnrichmentEntry(BaseModel):
    model_config = ALIASED_MODEL_CONFIG

    text: str = Field(min_length=1)
    literal_meaning: str | None = Field(default=None, alias="literalMeaning")
    example_sentence: str | None = Field(default=None, alias="exampleSentence")


class GlossaryEnrichmentResult(BaseModel):
    model_config = ALIASED_MODEL_CONFIG

    entries: list[GlossaryEnrichmentEntry] = Field(default_factory=list)


class AnalyzeToken(BaseModel):
    model_config = ALIASED_MODEL_CONFIG

    id: str
    hanzi: str
    pinyin: str
    meaning: str | None = None
    kind: TokenKind = "word"
    pinyin_source: PinyinSource = Field(alias="pinyinSource")


class AnalyzeSentence(BaseModel):
    model_config = STRICT_MODEL_CONFIG

    id: str
    hanzi: str
    pinyin: str
    translation: str | None = None
    tokens: list[AnalyzeToken] = Field(default_factory=list)


class GlossaryEntry(BaseModel):
    model_config = ALIASED_MODEL_CONFIG

    hanzi: str
    pinyin: str
    meaning: str | None = None
    example_sentence: str | None = Field(default=None, alias="exampleSentence")
    example_sentence_pinyin: str | None = Field(default=None, alias="exampleSentencePinyin")
    pinyin_source: PinyinSource = Field(alias="pinyinSource")


class AnalyzeImageResponse(BaseModel):
    model_config = ALIASED_MODEL_CONFIG

    document_text: str = Field(alias="documentText")
    language: str
    sentences: list[AnalyzeSentence] = Field(default_factory=list)
    glossary: list[GlossaryEntry] = Field(default_factory=list)
    warnings: list[str] = Field(default_factory=list)


class ExplainSelectionRequest(BaseModel):
    model_config = ALIASED_MODEL_CONFIG

    text: str = Field(min_length=1)
    scope: SelectionScope = "word"
    sentence_context: str | None = Field(default=None, alias="sentenceContext")


class ExplainSelectionResult(BaseModel):
    model_config = ALIASED_MODEL_CONFIG

    text: str | None = None
    meaning: str | None = None
    notes: str | None = None
    examples: list[str] = Field(default_factory=list)
    pronunciation_hints: list[PronunciationHint] = Field(default_factory=list, alias="pronunciationHints")


class ExplainSelectionResponse(BaseModel):
    model_config = ALIASED_MODEL_CONFIG

    text: str
    pinyin: str
    meaning: str | None = None
    notes: str | None = None
    examples: list[str] = Field(default_factory=list)
    pinyin_source: PinyinSource = Field(alias="pinyinSource")
