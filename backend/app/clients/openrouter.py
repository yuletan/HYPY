import base64
import asyncio
import copy
import json
import logging
import re
from typing import Any, Protocol, TypeVar

import httpx
from pydantic import BaseModel, ValidationError

from app.config import Settings
from app.schemas.contracts import (
    ExplainSelectionRequest,
    ExplainSelectionResult,
    GlossaryEnrichmentResult,
    PronunciationHint,
    TextAnalysisResult,
    VisionExtractionResult,
)
from app.services.language_options import input_language_name, output_language_name
from app.services.prompts import build_glossary_enrichment_messages, build_text_analysis_messages

StructuredModelT = TypeVar("StructuredModelT", bound=BaseModel)
logger = logging.getLogger(__name__)
MAX_STRUCTURED_OUTPUT_ATTEMPTS = 3
ERROR_PREVIEW_LIMIT = 600
MAX_ALLOWED_COMPLETION_TOKENS = 5_000
MAX_STAGE_RESPONSE_SECONDS = 30.0
_OCR_REASONING_MARKERS = (
    "okay, let's",
    "let's tackle",
    "the user provided",
    "looking at the image",
    "i need to",
    "i can see",
    "first, i",
    "translates to",
    "which translates",
    "the main body",
    "there's a part",
    "might be a",
)


class StudyAnalysisClient(Protocol):
    async def extract_text_from_image(
        self,
        image_bytes: bytes,
        media_type: str,
        input_language: str = "auto",
    ) -> VisionExtractionResult: ...

    async def analyze_text_for_study(
        self,
        document_text: str,
        pronunciation_hints: list[PronunciationHint],
        input_language: str = "auto",
        output_language: str = "en",
    ) -> TextAnalysisResult: ...

    async def enrich_glossary_terms(
        self,
        document_text: str,
        glossary_terms: list[str],
        source_language: str = "auto",
        output_language: str = "en",
    ) -> GlossaryEnrichmentResult: ...

    async def explain_selection(self, payload: ExplainSelectionRequest) -> ExplainSelectionResult: ...


class OpenRouterClientError(Exception):
    """Base exception for OpenRouter integration failures."""


class OpenRouterUpstreamError(OpenRouterClientError):
    """Raised when the upstream request fails."""


class OpenRouterResponseError(OpenRouterClientError):
    """Raised when the upstream response cannot be validated."""


class OpenRouterClient:
    def __init__(self, settings: Settings, http_client: httpx.AsyncClient | None = None) -> None:
        self._settings = settings
        self._owns_client = http_client is None
        self._client = http_client or httpx.AsyncClient(
            base_url=settings.openrouter_base_url,
            timeout=settings.request_timeout_seconds,
            headers={
                "Accept": "application/json",
                "Authorization": f"Bearer {settings.openrouter_api_key}",
                "Content-Type": "application/json",
            },
        )

    async def close(self) -> None:
        if self._owns_client:
            await self._client.aclose()

    async def extract_text_from_image(
        self,
        image_bytes: bytes,
        media_type: str,
        input_language: str = "auto",
    ) -> VisionExtractionResult:
        image_data_url = self._to_data_url(image_bytes=image_bytes, media_type=media_type)
        source_language_name = input_language_name(input_language)
        prompt = (
            "You are an OCR engine, not a narrator.\n"
            "Extract only visible document text from this image in reading order.\n"
            "documentText must contain copied OCR text only: no explanations, no translation, no guesses, no analysis, no descriptions of the image.\n"
            "If a character or line is unclear, omit it or add one short warning; never invent filler.\n"
            "Never repeat a line or phrase unless it visibly appears repeated in the image.\n"
            "Detect the primary visible text language among zh-Hans, zh-Hant, ja, and en.\n"
            "Use ja when Japanese kana are present, zh-Hans or zh-Hant when Chinese hanzi are the main study text, and en when the image is mainly English.\n"
            "For mixed-language images, set language to the main language a learner would study from the image.\n"
            "Preserve natural Japanese and Chinese text spacing. Do not insert spaces between kanji, kana, hanzi, or digits that form one word/number.\n"
            f"{self._source_language_instruction(input_language=input_language, source_language_name=source_language_name)}\n"
            "Return exactly one JSON object and nothing else.\n"
            "Do not include markdown fences, reasoning, commentary, or extra keys.\n"
            "Do not begin with phrases like 'Okay', 'Looking at the image', or 'The user provided'.\n"
            "Use empty arrays instead of null.\n"
            "readingLines must be copied visible text lines, not a summary of your process.\n"
            "pronunciationHints must stay phrase-level.\n"
            "For Chinese, only include a pronunciation hint when a phrase has a context-sensitive reading, such as a polyphonic word, "
            "name, or proper noun that would be easy to misread without context.\n"
            "For Japanese, include romaji pronunciation hints for useful phrases that contain kanji. Kana-only phrases do not need hints.\n"
            "Each hinted phrase must appear exactly in documentText.\n"
            "Do not put pronunciation text anywhere except pronunciationHints.\n"
            "If you are not confident, return an empty pronunciationHints array."
        )
        payload = {
            "model": self._settings.openrouter_vision_model,
            "stream": False,
            "temperature": 0,
            "plugins": [{"id": "response-healing"}],
            "response_format": self._json_schema_payload(
                name="vision_extraction",
                schema=VisionExtractionResult.model_json_schema(),
            ),
            "messages": [
                {
                    "role": "user",
                    "content": [
                        {"type": "text", "text": prompt},
                        {"type": "image_url", "image_url": {"url": image_data_url}},
                    ],
                }
            ],
        }
        result = await self._request_structured_output(
            payload=payload,
            model_type=VisionExtractionResult,
            stage_name="vision extraction",
            model_name=self._settings.openrouter_vision_model,
            retry_upstream_once=False,
            retry_timeout_once=True,
        )
        resolved_language = self._resolve_forced_source_language(
            input_language=input_language,
            detected_language=result.language,
        )
        if resolved_language != result.language:
            logger.info(
                "Overriding vision language from %s to %s based on explicit input language selection=%s.",
                result.language,
                resolved_language,
                input_language,
            )
            result = result.model_copy(update={"language": resolved_language})
        return result.model_copy(
            update={
                "pronunciation_hints": self._filter_hints(
                    hints=result.pronunciation_hints,
                    source_text=result.document_text,
                )
            }
        )

    async def analyze_text_for_study(
        self,
        document_text: str,
        pronunciation_hints: list[PronunciationHint],
        input_language: str = "auto",
        output_language: str = "en",
    ) -> TextAnalysisResult:
        payload = {
            "model": self._settings.openrouter_text_model,
            "stream": False,
            "temperature": 0,
            "plugins": [{"id": "response-healing"}],
            "response_format": self._json_schema_payload(
                name="text_analysis",
                schema=TextAnalysisResult.model_json_schema(),
            ),
            "messages": build_text_analysis_messages(
                document_text=document_text,
                pronunciation_hints=pronunciation_hints,
                input_language_name=input_language_name(input_language),
                output_language_name=output_language_name(output_language),
            ),
        }
        result = await self._request_structured_output(
            payload=payload,
            model_type=TextAnalysisResult,
            stage_name="text analysis",
            model_name=self._settings.openrouter_text_model,
            retry_upstream_once=True,
            retry_timeout_once=True,
        )
        return result.model_copy(
            update={
                "pronunciation_hints": self._filter_hints(
                    hints=result.pronunciation_hints,
                    source_text=document_text,
                )
            }
        )

    async def explain_selection(self, payload: ExplainSelectionRequest) -> ExplainSelectionResult:
        prompt = (
            "Explain the selected Chinese or Japanese text for a learner.\n"
            "Return exactly one JSON object and nothing else.\n"
            "Do not include markdown fences, reasoning, or extra keys.\n"
            "Use empty arrays instead of null.\n"
            "Return concise meaning, learner-friendly notes, and one to three example sentences.\n"
            "Only include pronunciationHints when the selected text has a context-sensitive Chinese reading or Japanese kanji reading.\n"
            "Any pronunciation hint phrase must match the selected text exactly.\n"
            "Do not return standalone pinyin or romaji outside pronunciationHints."
        )
        user_message = {
            "text": payload.text,
            "scope": payload.scope,
            "sentenceContext": payload.sentence_context,
        }
        request_payload = {
            "model": self._settings.openrouter_text_model,
            "stream": False,
            "temperature": 0,
            "plugins": [{"id": "response-healing"}],
            "response_format": self._json_schema_payload(
                name="selection_explanation",
                schema=ExplainSelectionResult.model_json_schema(),
            ),
            "messages": [
                {"role": "system", "content": prompt},
                {"role": "user", "content": json.dumps(user_message, ensure_ascii=False)},
            ],
        }
        result = await self._request_structured_output(
            payload=request_payload,
            model_type=ExplainSelectionResult,
            stage_name="selection explanation",
            model_name=self._settings.openrouter_text_model,
            retry_upstream_once=True,
            retry_timeout_once=True,
        )
        return result.model_copy(
            update={
                "pronunciation_hints": self._filter_hints(
                    hints=result.pronunciation_hints,
                    source_text=payload.text,
                    exact_phrase=payload.text,
                )
            }
        )

    async def enrich_glossary_terms(
        self,
        document_text: str,
        glossary_terms: list[str],
        source_language: str = "auto",
        output_language: str = "en",
    ) -> GlossaryEnrichmentResult:
        normalized_terms = [term.strip() for term in glossary_terms if term.strip()]
        if not normalized_terms:
            return GlossaryEnrichmentResult(entries=[])

        payload = {
            "model": self._settings.openrouter_text_model,
            "stream": False,
            "temperature": 0,
            "plugins": [{"id": "response-healing"}],
            "response_format": self._json_schema_payload(
                name="glossary_enrichment",
                schema=GlossaryEnrichmentResult.model_json_schema(),
            ),
            "messages": build_glossary_enrichment_messages(
                document_text=document_text,
                glossary_terms=normalized_terms,
                input_language_name=input_language_name(source_language),
                output_language_name=output_language_name(output_language),
            ),
        }
        return await self._request_structured_output(
            payload=payload,
            model_type=GlossaryEnrichmentResult,
            stage_name="glossary enrichment",
            model_name=self._settings.openrouter_text_model,
            retry_upstream_once=True,
            retry_timeout_once=True,
        )

    async def _post_chat_completion(self, payload: dict[str, Any]) -> dict[str, Any]:
        try:
            response = await self._client.post("/chat/completions", json=payload)
            response.raise_for_status()
        except httpx.TimeoutException as exc:
            raise OpenRouterUpstreamError("Timed out while waiting for OpenRouter.") from exc
        except httpx.HTTPStatusError as exc:
            response_text = exc.response.text.strip()
            if response_text:
                raise OpenRouterUpstreamError(f"OpenRouter returned an error response: {response_text}") from exc
            raise OpenRouterUpstreamError("OpenRouter returned an error response.") from exc
        except httpx.RequestError as exc:
            raise OpenRouterUpstreamError("Could not reach OpenRouter.") from exc

        try:
            return response.json()
        except ValueError as exc:
            raise OpenRouterResponseError("OpenRouter returned a non-JSON response.") from exc

    async def _request_structured_output(
        self,
        *,
        payload: dict[str, Any],
        model_type: type[StructuredModelT],
        stage_name: str,
        model_name: str,
        retry_upstream_once: bool,
        retry_timeout_once: bool,
    ) -> StructuredModelT:
        last_error: OpenRouterResponseError | None = None
        working_payload = copy.deepcopy(payload)
        plain_text_mode = False
        upstream_retry_used = False
        oversize_retry_used = False
        timeout_retry_used = False

        for attempt in range(1, MAX_STRUCTURED_OUTPUT_ATTEMPTS + 1):
            try:
                response = await asyncio.wait_for(
                    self._post_chat_completion(working_payload),
                    timeout=MAX_STAGE_RESPONSE_SECONDS,
                )
            except TimeoutError as exc:
                timeout_error = OpenRouterUpstreamError(
                    f"Timed out after {MAX_STAGE_RESPONSE_SECONDS:.0f}s while waiting for OpenRouter."
                )
                if retry_timeout_once and not timeout_retry_used:
                    timeout_retry_used = True
                    logger.warning(
                        "OpenRouter %s timed out on attempt %s for model=%s; retrying stage once.",
                        stage_name,
                        attempt,
                        model_name,
                    )
                    continue
                raise timeout_error from exc
            except OpenRouterUpstreamError as exc:
                if not plain_text_mode and self._is_json_mode_unsupported_error(exc):
                    logger.info(
                        "OpenRouter %s model=%s does not support JSON schema mode; retrying without response_format.",
                        stage_name,
                        model_name,
                    )
                    working_payload = self._build_plain_text_payload(working_payload)
                    plain_text_mode = True
                    continue
                if retry_upstream_once and not upstream_retry_used:
                    upstream_retry_used = True
                    logger.warning(
                        "OpenRouter %s request failed on attempt %s for model=%s; retrying stage once: %s",
                        stage_name,
                        attempt,
                        model_name,
                        exc,
                    )
                    continue
                raise
            completion_tokens = self._extract_completion_tokens(response)
            if completion_tokens is not None and completion_tokens > MAX_ALLOWED_COMPLETION_TOKENS:
                last_error = OpenRouterResponseError(
                    f"OpenRouter {stage_name} output exceeded {MAX_ALLOWED_COMPLETION_TOKENS} completion tokens "
                    f"({completion_tokens}); retrying this stage."
                )
                logger.warning(
                    "OpenRouter %s returned %s completion tokens on attempt %s for model=%s.",
                    stage_name,
                    completion_tokens,
                    attempt,
                    model_name,
                )
                if oversize_retry_used or attempt == MAX_STRUCTURED_OUTPUT_ATTEMPTS:
                    break
                oversize_retry_used = True
                working_payload = self._build_retry_payload(
                    payload=working_payload,
                    model_type=model_type,
                    stage_name=stage_name,
                    error=last_error,
                    attempt=attempt + 1,
                )
                continue
            try:
                return self._parse_structured_content(response, model_type)
            except OpenRouterResponseError as exc:
                last_error = exc
                logger.warning(
                    "OpenRouter %s returned invalid structured output on attempt %s for model=%s: %s",
                    stage_name,
                    attempt,
                    model_name,
                    exc,
                )
                if attempt == MAX_STRUCTURED_OUTPUT_ATTEMPTS:
                    break
                working_payload = self._build_retry_payload(
                    payload=working_payload,
                    model_type=model_type,
                    stage_name=stage_name,
                    error=exc,
                    attempt=attempt + 1,
                )

        assert last_error is not None
        raise last_error

    @staticmethod
    def _build_retry_payload(
        *,
        payload: dict[str, Any],
        model_type: type[StructuredModelT],
        stage_name: str,
        error: OpenRouterResponseError,
        attempt: int,
    ) -> dict[str, Any]:
        retry_payload = copy.deepcopy(payload)
        messages = list(retry_payload.get("messages", []))
        schema_keys = ", ".join(model_type.model_json_schema().get("properties", {}).keys())
        messages.append(
            {
                "role": "user",
                "content": (
                    f"Retry attempt {attempt} for {stage_name}. "
                    "Your previous reply failed validation. "
                    "Return exactly one JSON object matching the required schema. "
                    "Do not include markdown, explanations, or reasoning. "
                    f"Top-level keys must stay within: {schema_keys}. "
                    "Use empty arrays instead of null. "
                    "If uncertain, keep values minimal but schema-valid. "
                    f"Validation error: {str(error)[:ERROR_PREVIEW_LIMIT]}"
                ),
            }
        )
        retry_payload["messages"] = messages
        return retry_payload

    @staticmethod
    def _build_plain_text_payload(payload: dict[str, Any]) -> dict[str, Any]:
        plain_payload = copy.deepcopy(payload)
        plain_payload.pop("response_format", None)
        plain_payload.pop("plugins", None)
        return plain_payload

    @staticmethod
    def _extract_completion_tokens(response_payload: dict[str, Any]) -> int | None:
        usage = response_payload.get("usage")
        if not isinstance(usage, dict):
            return None

        for key in ("completion_tokens", "completionTokens", "output_tokens", "outputTokens"):
            raw_value = usage.get(key)
            if isinstance(raw_value, bool):
                continue
            if isinstance(raw_value, int):
                return raw_value
            if isinstance(raw_value, float):
                return int(raw_value)
            if isinstance(raw_value, str):
                normalized = raw_value.strip()
                if normalized.isdigit():
                    return int(normalized)
        return None

    @staticmethod
    def _is_json_mode_unsupported_error(error: OpenRouterClientError) -> bool:
        message = str(error).lower()
        return "json mode is not supported" in message or "response_format" in message

    @staticmethod
    def _json_schema_payload(name: str, schema: dict[str, Any]) -> dict[str, Any]:
        return {
            "type": "json_schema",
            "json_schema": {
                "name": name,
                "strict": True,
                "schema": schema,
            },
        }

    @staticmethod
    def _parse_structured_content(
        response_payload: dict[str, Any],
        model_type: type[StructuredModelT],
    ) -> StructuredModelT:
        try:
            message = response_payload["choices"][0]["message"]
        except (KeyError, IndexError, TypeError) as exc:
            raise OpenRouterResponseError("OpenRouter response did not include a chat message.") from exc

        data = message.get("parsed")
        if data is None:
            content = message.get("content", "")
            if isinstance(content, list):
                text_blocks = [block.get("text", "") for block in content if isinstance(block, dict)]
                content = "".join(text_blocks)

            if isinstance(content, str):
                normalized_content = OpenRouterClient._extract_json_candidate(content)
                try:
                    data = json.loads(normalized_content)
                except json.JSONDecodeError as exc:
                    raise OpenRouterResponseError(
                        "OpenRouter response did not contain valid JSON. "
                        f"Preview: {normalized_content[:500]!r}"
                    ) from exc
            else:
                data = content

        data = OpenRouterClient._coerce_structured_data(data, model_type)

        try:
            parsed = model_type.model_validate(data)
        except ValidationError as exc:
            raise OpenRouterResponseError(
                "OpenRouter JSON did not match the expected schema. "
                f"Errors: {exc.errors(include_url=False)}. Preview: {str(data)[:500]!r}"
            ) from exc

        OpenRouterClient._validate_structured_quality(parsed)
        return parsed

    @staticmethod
    def _coerce_structured_data(
        data: Any,
        model_type: type[StructuredModelT],
    ) -> Any:
        if model_type is VisionExtractionResult:
            return OpenRouterClient._coerce_vision_extraction_data(data)
        if model_type is TextAnalysisResult:
            return OpenRouterClient._coerce_text_analysis_data(data)
        if model_type is GlossaryEnrichmentResult:
            return OpenRouterClient._coerce_glossary_enrichment_data(data)
        if model_type is ExplainSelectionResult:
            return OpenRouterClient._coerce_explain_selection_data(data)
        return data

    @staticmethod
    def _coerce_vision_extraction_data(data: Any) -> Any:
        if not isinstance(data, dict):
            return data

        document_text = OpenRouterClient._normalize_cjk_ocr_spacing(
            OpenRouterClient._first_string(
                data.get("documentText"),
                data.get("document_text"),
            )
        )
        reading_lines = [
            OpenRouterClient._normalize_cjk_ocr_spacing(line)
            for line in OpenRouterClient._coerce_string_list(
                data.get("readingLines"),
                fallback=document_text.splitlines() if document_text else [],
            )
        ]
        pronunciation_hints = OpenRouterClient._normalize_pronunciation_hint_phrases(
            OpenRouterClient._coerce_pronunciation_hints(data.get("pronunciationHints"))
        )

        return {
            "documentText": document_text,
            "language": OpenRouterClient._first_string(data.get("language")) or OpenRouterClient._infer_language(document_text),
            "readingLines": reading_lines,
            "pronunciationHints": pronunciation_hints,
            "warnings": OpenRouterClient._coerce_string_list(data.get("warnings")),
        }

    @staticmethod
    def _normalize_cjk_ocr_spacing(text: str) -> str:
        if not text:
            return text

        cjk = r"\u3040-\u30ff\uff66-\uff9f\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff"
        # OCR providers sometimes insert non-breaking/thin spaces between every CJK character.
        inline_space = r"[ \t\u00a0\u1680\u2000-\u200b\u202f\u205f\u3000]+"
        normalized = re.sub(fr"(?<=[{cjk}]){inline_space}(?=[{cjk}])", "", text)
        normalized = re.sub(fr"(?<=\d){inline_space}(?=\d)", "", normalized)
        normalized = re.sub(fr"(?<=[{cjk}]){inline_space}(?=\d)", "", normalized)
        normalized = re.sub(fr"(?<=\d){inline_space}(?=[{cjk}])", "", normalized)
        normalized = re.sub(fr"(?<=[{cjk}\d]){inline_space}(?=[、。，．・：；！？）」』】〉》])", "", normalized)
        normalized = re.sub(fr"(?<=[（「『【〈《〒]){inline_space}(?=[{cjk}\d])", "", normalized)
        normalized = re.sub(fr"(?<=[、。，．・：；！？（「『【〈《]){inline_space}(?=[{cjk}\d])", "", normalized)
        normalized = re.sub(fr"(?<=\d){inline_space}([\-~\u301c\u30fb\uff5e]){inline_space}(?=\d)", r"\1", normalized)
        normalized = re.sub(fr"(?<=\d){inline_space}([:\uff1a]){inline_space}(?=\d)", r"\1", normalized)
        return normalized

    @staticmethod
    def _normalize_pronunciation_hint_phrases(hints: list[dict[str, Any]]) -> list[dict[str, Any]]:
        normalized_hints: list[dict[str, Any]] = []
        for hint in hints:
            normalized = dict(hint)
            normalized["phrase"] = OpenRouterClient._normalize_cjk_ocr_spacing(str(normalized.get("phrase", "")))
            normalized_hints.append(normalized)
        return normalized_hints

    @staticmethod
    def _validate_structured_quality(parsed: BaseModel) -> None:
        if isinstance(parsed, VisionExtractionResult):
            OpenRouterClient._validate_vision_extraction_quality(parsed)

    @staticmethod
    def _validate_vision_extraction_quality(result: VisionExtractionResult) -> None:
        suspicious_fields = [result.document_text, *result.reading_lines]
        for field in suspicious_fields:
            if OpenRouterClient._contains_ocr_reasoning(field):
                raise OpenRouterResponseError(
                    "Vision extraction included reasoning/commentary inside OCR text. "
                    "Return only text visibly present in the image."
                )

        if OpenRouterClient._has_pathological_repetition(result.document_text):
            raise OpenRouterResponseError(
                "Vision extraction appears to contain hallucinated repeated text. "
                "Return each visible line only once unless it visibly repeats in the image."
            )

    @staticmethod
    def _contains_ocr_reasoning(text: str) -> bool:
        normalized = " ".join(text.lower().split())
        return any(marker in normalized for marker in _OCR_REASONING_MARKERS)

    @staticmethod
    def _has_pathological_repetition(text: str) -> bool:
        normalized = " ".join(text.split())
        if len(normalized) < 240:
            return False

        segments = [
            segment.strip()
            for segment in re.split(r"[、，,。.!?\n]+", normalized)
            if len(segment.strip()) >= 2
        ]
        segment_counts: dict[str, int] = {}
        for segment in segments:
            segment_counts[segment] = segment_counts.get(segment, 0) + 1
        if any(count >= 8 for count in segment_counts.values()):
            return True

        tokens = normalized.split()
        for width in range(2, 7):
            if len(tokens) < width * 8:
                continue
            ngram_counts: dict[tuple[str, ...], int] = {}
            for index in range(0, len(tokens) - width + 1):
                ngram = tuple(tokens[index : index + width])
                ngram_counts[ngram] = ngram_counts.get(ngram, 0) + 1
            if any(count >= 10 for count in ngram_counts.values()):
                return True

        return False

    @staticmethod
    def _coerce_text_analysis_data(data: Any) -> Any:
        if not isinstance(data, dict):
            return data

        sentences: list[dict[str, Any]] = []
        for raw_sentence in OpenRouterClient._coerce_list(data.get("sentences")):
            if not isinstance(raw_sentence, dict):
                continue
            hanzi = OpenRouterClient._first_string(raw_sentence.get("hanzi"), raw_sentence.get("text"))
            if not hanzi:
                continue
            translation = OpenRouterClient._first_string(
                raw_sentence.get("translation"),
                raw_sentence.get("literalTranslation"),
                raw_sentence.get("literal_translation"),
            )
            tokens = OpenRouterClient._coerce_text_tokens(raw_sentence.get("tokens"), fallback_text=hanzi)
            sentences.append(
                {
                    "hanzi": hanzi,
                    "translation": translation or None,
                    "tokens": tokens,
                }
            )

        glossary: list[dict[str, Any]] = []
        for raw_glossary in OpenRouterClient._coerce_list(data.get("glossary")):
            if isinstance(raw_glossary, str):
                text = raw_glossary.strip()
                if text:
                    glossary.append({"text": text})
                continue
            if not isinstance(raw_glossary, dict):
                continue
            text = OpenRouterClient._first_string(raw_glossary.get("text"), raw_glossary.get("hanzi"))
            if not text:
                continue
            glossary.append(
                {
                    "text": text,
                    "meaning": OpenRouterClient._first_string(
                        raw_glossary.get("meaning"),
                        raw_glossary.get("literalMeaning"),
                        raw_glossary.get("literal_meaning"),
                    )
                    or None,
                }
            )

        return {
            "sentences": sentences,
            "glossary": glossary,
            "pronunciationHints": OpenRouterClient._coerce_pronunciation_hints(data.get("pronunciationHints")),
        }

    @staticmethod
    def _coerce_glossary_enrichment_data(data: Any) -> Any:
        if not isinstance(data, dict):
            return data

        entries: list[dict[str, Any]] = []
        for raw_entry in OpenRouterClient._coerce_list(data.get("entries")):
            if not isinstance(raw_entry, dict):
                continue
            text = OpenRouterClient._first_string(raw_entry.get("text"), raw_entry.get("hanzi"))
            if not text:
                continue
            entries.append(
                {
                    "text": text,
                    "literalMeaning": OpenRouterClient._first_string(
                        raw_entry.get("literalMeaning"),
                        raw_entry.get("literal_meaning"),
                        raw_entry.get("meaning"),
                    )
                    or None,
                    "exampleSentence": OpenRouterClient._first_string(
                        raw_entry.get("exampleSentence"),
                        raw_entry.get("example_sentence"),
                    )
                    or None,
                }
            )

        return {"entries": entries}

    @staticmethod
    def _coerce_explain_selection_data(data: Any) -> Any:
        if not isinstance(data, dict):
            return data

        return {
            "text": OpenRouterClient._first_string(data.get("text")) or None,
            "meaning": OpenRouterClient._first_string(data.get("meaning")) or None,
            "notes": OpenRouterClient._first_string(data.get("notes")) or None,
            "examples": OpenRouterClient._coerce_string_list(data.get("examples")),
            "pronunciationHints": OpenRouterClient._coerce_pronunciation_hints(data.get("pronunciationHints")),
        }

    @staticmethod
    def _coerce_text_tokens(raw_tokens: Any, *, fallback_text: str) -> list[dict[str, Any]]:
        tokens: list[dict[str, Any]] = []
        for raw_token in OpenRouterClient._coerce_list(raw_tokens):
            if isinstance(raw_token, str):
                text = raw_token.strip()
                if text:
                    tokens.append({"text": text, "kind": "word"})
                continue
            if not isinstance(raw_token, dict):
                continue
            text = OpenRouterClient._first_string(raw_token.get("text"), raw_token.get("hanzi"))
            if not text:
                continue
            token_kind = OpenRouterClient._coerce_text_token_kind(
                text=text,
                raw_kind=OpenRouterClient._first_string(raw_token.get("kind")).lower() or "word",
            )
            tokens.append(
                {
                    "text": text,
                    "kind": token_kind,
                    "meaning": OpenRouterClient._first_string(
                        raw_token.get("meaning"),
                        raw_token.get("literalMeaning"),
                        raw_token.get("literal_meaning"),
                    )
                    or None,
                }
            )

        if tokens:
            return tokens
        if fallback_text.strip():
            return [{"text": fallback_text.strip(), "kind": "other"}]
        return []

    @staticmethod
    def _coerce_text_token_kind(*, text: str, raw_kind: str) -> str:
        token_kind = raw_kind if raw_kind in {"word", "phrase", "punctuation", "other"} else "other"
        if token_kind == "punctuation" and re.search(r"[\u3040-\u30ff\uff66-\uff9f\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff]", text):
            return "word" if len(text.strip()) <= 2 else "phrase"
        return token_kind

    @staticmethod
    def _coerce_pronunciation_hints(raw_hints: Any) -> list[dict[str, Any]]:
        hints: list[dict[str, Any]] = []
        for raw_hint in OpenRouterClient._coerce_list(raw_hints):
            if not isinstance(raw_hint, dict):
                continue
            phrase = OpenRouterClient._first_string(raw_hint.get("phrase"))
            preferred_pinyin = OpenRouterClient._first_string(
                raw_hint.get("preferredPinyin"),
                raw_hint.get("preferred_pinyin"),
            )
            if not phrase or not preferred_pinyin:
                continue
            hints.append(
                {
                    "phrase": phrase,
                    "preferredPinyin": preferred_pinyin,
                    "toneNumberPinyin": OpenRouterClient._first_string(
                        raw_hint.get("toneNumberPinyin"),
                        raw_hint.get("tone_number_pinyin"),
                    ) or None,
                    "reason": OpenRouterClient._first_string(raw_hint.get("reason")) or None,
                    "confidence": OpenRouterClient._coerce_confidence(raw_hint.get("confidence")),
                }
            )
        return hints

    @staticmethod
    def _coerce_confidence(raw_value: Any) -> float:
        try:
            value = float(raw_value)
        except (TypeError, ValueError):
            return 0.0
        return min(1.0, max(0.0, value))

    @staticmethod
    def _coerce_string_list(raw_value: Any, fallback: list[str] | None = None) -> list[str]:
        if isinstance(raw_value, list):
            return [str(item).strip() for item in raw_value if str(item).strip()]
        if isinstance(raw_value, str):
            normalized = raw_value.strip()
            if normalized:
                return [normalized]
        return list(fallback or [])

    @staticmethod
    def _coerce_list(raw_value: Any) -> list[Any]:
        return raw_value if isinstance(raw_value, list) else []

    @staticmethod
    def _first_string(*values: Any) -> str:
        for value in values:
            if isinstance(value, str):
                normalized = value.strip()
                if normalized:
                    return normalized
        return ""

    @staticmethod
    def _infer_language(document_text: str) -> str:
        if re.search(r"[\u3040-\u30ff]", document_text):
            return "ja"
        if re.search(r"[\u4e00-\u9fff]", document_text):
            return "zh-Hans"
        if re.search(r"[\uac00-\ud7af]", document_text):
            return "ko"
        if re.search(r"[A-Za-z]", document_text):
            return "en"
        return "und"

    @staticmethod
    def _filter_hints(
        hints: list[PronunciationHint],
        source_text: str,
        exact_phrase: str | None = None,
    ) -> list[PronunciationHint]:
        if not source_text:
            return []

        normalized_exact_phrase = exact_phrase.strip() if exact_phrase else None
        filtered: dict[str, PronunciationHint] = {}

        for hint in hints:
            if not hint.applies_to(source_text):
                continue
            if normalized_exact_phrase and hint.phrase != normalized_exact_phrase:
                continue

            current = filtered.get(hint.phrase)
            if current is None or hint.confidence >= current.confidence:
                filtered[hint.phrase] = hint

        return list(filtered.values())

    @staticmethod
    def _source_language_instruction(
        *,
        input_language: str,
        source_language_name: str,
    ) -> str:
        normalized = (input_language or "auto").strip().lower()
        if normalized == "ja":
            return (
                "The source language is explicitly Japanese. "
                "Prioritize Japanese OCR. Preserve kana, kanji, and Japanese punctuation exactly as written. "
                "Do not convert Japanese text into Chinese variants."
            )
        if normalized == "zh":
            return (
                "The source language is explicitly Chinese. "
                "Prioritize Chinese OCR and preserve simplified/traditional characters as shown."
            )
        if normalized == "en":
            return (
                "The source language is explicitly English. "
                "Prioritize English OCR and avoid transliterating to Chinese or Japanese."
            )
        return (
            f"The preferred source language is {source_language_name}; "
            "use that as a hint when OCR is ambiguous."
        )

    @staticmethod
    def _resolve_forced_source_language(
        *,
        input_language: str,
        detected_language: str,
    ) -> str:
        normalized = (input_language or "auto").strip().lower()
        if normalized == "ja":
            return "ja"
        if normalized == "zh":
            return detected_language if detected_language.startswith("zh") else "zh-Hans"
        if normalized == "en":
            return "en"
        return detected_language

    @staticmethod
    def _extract_json_candidate(content: str) -> str:
        normalized = OpenRouterClient._strip_json_code_fence(content.strip())
        if not normalized:
            return normalized

        decoder = json.JSONDecoder()
        for start_index, character in enumerate(normalized):
            if character not in "[{":
                continue
            try:
                parsed, end_index = decoder.raw_decode(normalized[start_index:])
                reparsed = json.dumps(parsed, ensure_ascii=False)
                trailing = normalized[start_index + end_index :].strip()
                if trailing:
                    logger.debug("Ignoring trailing non-JSON content after structured response: %r", trailing[:200])
                return reparsed
            except json.JSONDecodeError:
                continue

        return normalized

    @staticmethod
    def _strip_json_code_fence(content: str) -> str:
        if not content.startswith("```"):
            return content

        lines = content.splitlines()
        if len(lines) >= 2 and lines[-1].strip() == "```":
            return "\n".join(lines[1:-1]).strip()
        return content

    @staticmethod
    def _to_data_url(image_bytes: bytes, media_type: str) -> str:
        encoded = base64.b64encode(image_bytes).decode("ascii")
        return f"data:{media_type};base64,{encoded}"
