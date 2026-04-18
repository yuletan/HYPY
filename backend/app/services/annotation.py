import re

from app.schemas.contracts import (
    AnalyzeImageResponse,
    AnalyzeSentence,
    AnalyzeToken,
    ExplainSelectionRequest,
    ExplainSelectionResponse,
    ExplainSelectionResult,
    GlossaryDraft,
    GlossaryEnrichmentResult,
    GlossaryEntry,
    PronunciationHint,
    TextAnalysisResult,
    TextSentence,
    TextToken,
    VisionExtractionResult,
)
from app.services.pinyin import ResolvedPinyin, compose_sentence_pinyin, resolve_phrase_pinyin

MIN_HINT_CONFIDENCE = 0.6
_CJK_RE = re.compile(r"[\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff]")
_SENTENCE_SPLIT_RE = re.compile(r"(?<=[\u3002\uff01\uff1f!?])\s*")
_FALLBACK_TOKEN_RE = re.compile(
    r"[A-Za-z0-9]+(?:\s+[A-Za-z0-9]+)*|[\u3400-\u4dbf\u4e00-\u9fff]+|[^\w\s]",
    re.UNICODE,
)


def build_analyze_response(
    vision_result: VisionExtractionResult,
    text_result: TextAnalysisResult,
    glossary_enrichment: GlossaryEnrichmentResult | None = None,
) -> AnalyzeImageResponse:
    return annotate_document(
        vision_result=vision_result,
        text_result=text_result,
        glossary_enrichment=glossary_enrichment,
    )


def annotate_document(
    vision_result: VisionExtractionResult,
    text_result: TextAnalysisResult,
    glossary_enrichment: GlossaryEnrichmentResult | None = None,
) -> AnalyzeImageResponse:
    important_context_phrases = {hint.phrase.strip() for hint in vision_result.pronunciation_hints if hint.phrase.strip()}
    combined_hints = prepare_pronunciation_hints(
        document_text=vision_result.document_text,
        text_hints=text_result.pronunciation_hints,
        vision_hints=vision_result.pronunciation_hints,
        extra_source_texts=[sentence.hanzi for sentence in text_result.sentences],
    )

    glossary_index: dict[str, GlossaryEntry] = {}
    sentences: list[AnalyzeSentence] = []
    sentence_inputs = _select_sentence_inputs(
        vision_result=vision_result,
        text_result=text_result,
        important_context_phrases=important_context_phrases,
    )

    for sentence_index, sentence in enumerate(sentence_inputs, start=1):
        annotated_sentence = annotate_sentence(
            sentence=sentence,
            sentence_index=sentence_index,
            hints=combined_hints,
            glossary_index=glossary_index,
            important_context_phrases=important_context_phrases,
        )
        sentences.append(annotated_sentence)

    for draft in text_result.glossary:
        resolved = resolve_phrase_pinyin(draft.text, combined_hints)
        _add_glossary_entry(
            glossary_index=glossary_index,
            draft=draft,
            resolved=resolved,
            important_context_phrases=important_context_phrases,
        )

    response = AnalyzeImageResponse(
        documentText=vision_result.document_text,
        language=vision_result.language,
        sentences=sentences,
        glossary=list(glossary_index.values()),
        warnings=vision_result.warnings,
    )
    return apply_glossary_enrichment(response, glossary_enrichment)


def annotate_sentence(
    sentence: TextSentence,
    sentence_index: int,
    hints: list[PronunciationHint],
    glossary_index: dict[str, GlossaryEntry] | None = None,
    important_context_phrases: set[str] | None = None,
) -> AnalyzeSentence:
    tokens = sentence.tokens or _fallback_tokens(sentence.hanzi)
    resolved_tokens: list[AnalyzeToken] = []
    resolved_parts: list[ResolvedPinyin] = []

    for token_index, token in enumerate(tokens, start=1):
        annotated_token, resolved = annotate_token(
            token=token,
            sentence_index=sentence_index,
            token_index=token_index,
            hints=hints,
        )
        resolved_tokens.append(annotated_token)
        resolved_parts.append(resolved)

        if glossary_index is not None:
            _add_glossary_entry(
                glossary_index=glossary_index,
                draft=GlossaryDraft(text=token.text, meaning=token.meaning),
                resolved=resolved,
                kind=token.kind,
                important_context_phrases=important_context_phrases or set(),
            )

    return AnalyzeSentence(
        id=f"s{sentence_index}",
        hanzi=sentence.hanzi,
        pinyin=compose_sentence_pinyin(resolved_parts),
        translation=_clean_translation(sentence.translation, sentence.hanzi),
        tokens=resolved_tokens,
    )


def annotate_token(
    token: TextToken,
    sentence_index: int,
    token_index: int,
    hints: list[PronunciationHint],
) -> tuple[AnalyzeToken, ResolvedPinyin]:
    resolved = resolve_phrase_pinyin(token.text, hints)
    return (
        AnalyzeToken(
            id=f"s{sentence_index}-t{token_index}",
            hanzi=token.text,
            pinyin=resolved.pinyin,
            meaning=token.meaning,
            kind=token.kind,
            pinyinSource=resolved.source,
        ),
        resolved,
    )


def build_explain_response(
    payload: ExplainSelectionRequest,
    explanation: ExplainSelectionResult,
) -> ExplainSelectionResponse:
    combined_hints = prepare_pronunciation_hints(
        document_text=payload.text,
        text_hints=explanation.pronunciation_hints,
        vision_hints=[],
    )
    resolved = resolve_phrase_pinyin(payload.text, combined_hints)
    return ExplainSelectionResponse(
        text=payload.text,
        pinyin=resolved.pinyin,
        meaning=explanation.meaning,
        notes=explanation.notes,
        examples=explanation.examples,
        pinyinSource=resolved.source,
    )


def apply_glossary_enrichment(
    response: AnalyzeImageResponse,
    glossary_enrichment: GlossaryEnrichmentResult | None,
) -> AnalyzeImageResponse:
    if glossary_enrichment is None or not glossary_enrichment.entries:
        return response

    enrichment_by_text = {entry.text.strip(): entry for entry in glossary_enrichment.entries if entry.text.strip()}
    if not enrichment_by_text:
        return response

    enriched_glossary: list[GlossaryEntry] = []
    for entry in response.glossary:
        enrichment = enrichment_by_text.get(entry.hanzi.strip())
        if enrichment is None:
            enriched_glossary.append(entry)
            continue

        example_sentence = _clean_example_sentence(enrichment.example_sentence, entry.hanzi)
        enriched_glossary.append(
            entry.model_copy(
                update={
                    "meaning": enrichment.literal_meaning or entry.meaning,
                    "example_sentence": example_sentence,
                    "example_sentence_pinyin": _compose_example_sentence_pinyin(
                        example_sentence=example_sentence,
                        glossary_hanzi=entry.hanzi,
                        glossary_pinyin=entry.pinyin,
                    ),
                }
            )
        )

    return response.model_copy(update={"glossary": enriched_glossary})


def prepare_pronunciation_hints(
    document_text: str,
    text_hints: list[PronunciationHint],
    vision_hints: list[PronunciationHint],
    extra_source_texts: list[str] | None = None,
) -> list[PronunciationHint]:
    source_texts = [document_text, *(extra_source_texts or [])]
    merged: dict[str, PronunciationHint] = {}

    for hint in _validated_hints(vision_hints, source_texts, "vision hint"):
        merged[hint.phrase] = hint

    for hint in _validated_hints(text_hints, source_texts, "text model hint"):
        merged[hint.phrase] = hint

    return list(merged.values())


def _validated_hints(
    hints: list[PronunciationHint],
    source_texts: list[str],
    fallback_reason: str,
) -> list[PronunciationHint]:
    prepared: list[PronunciationHint] = []

    for hint in hints:
        phrase = hint.phrase.strip()
        if not phrase:
            continue
        if not _has_usable_confidence(hint):
            continue
        if not _phrase_appears_in_sources(phrase, source_texts):
            continue
        prepared.append(
            hint.model_copy(
                update={
                    "phrase": phrase,
                    "reason": hint.reason or fallback_reason,
                }
            )
        )

    return prepared


def _select_sentence_inputs(
    vision_result: VisionExtractionResult,
    text_result: TextAnalysisResult,
    important_context_phrases: set[str],
) -> list[TextSentence]:
    fallback = _fallback_sentences(vision_result)
    raw_candidate_sentences = text_result.sentences or fallback
    candidate_sentences = [
        prepared
        for sentence in raw_candidate_sentences
        for prepared in [_prepare_sentence_for_study(sentence, important_context_phrases)]
        if prepared is not None
    ]
    fallback_sanitized = [
        prepared
        for sentence in fallback
        for prepared in [_prepare_sentence_for_study(sentence, important_context_phrases)]
        if prepared is not None
    ]

    if _contains_cjk(vision_result.document_text):
        chinese_focused = [sentence for sentence in candidate_sentences if _is_chinese_study_sentence(sentence)]
        if chinese_focused:
            return chinese_focused

        fallback_chinese = [sentence for sentence in fallback_sanitized if _is_chinese_study_sentence(sentence)]
        if fallback_chinese:
            return fallback_chinese

    return candidate_sentences


def _is_chinese_study_sentence(sentence: TextSentence) -> bool:
    if _contains_cjk(sentence.hanzi):
        return True
    return any(_contains_cjk(token.text) for token in sentence.tokens)


def _prepare_sentence_for_study(
    sentence: TextSentence,
    important_context_phrases: set[str],
) -> TextSentence | None:
    source_tokens = sentence.tokens or _fallback_tokens(sentence.hanzi)
    filtered_tokens: list[TextToken] = []
    for token in source_tokens:
        filtered_tokens.extend(_sanitize_token_for_study(token, important_context_phrases))

    filtered_tokens = _trim_study_tokens(filtered_tokens)
    if not filtered_tokens:
        return None

    rebuilt_hanzi = _rebuild_sentence_text(filtered_tokens)
    if not rebuilt_hanzi:
        return None

    return TextSentence(
        hanzi=rebuilt_hanzi,
        translation=sentence.translation,
        tokens=filtered_tokens,
    )


def _should_keep_token_for_study(
    token: TextToken,
    important_context_phrases: set[str],
) -> bool:
    text = token.text.strip()
    if not text:
        return False
    if token.kind == "punctuation":
        return True
    if _contains_cjk(text):
        return True
    return any(
        phrase == text or phrase in text or text in phrase
        for phrase in important_context_phrases
    )


def _sanitize_token_for_study(
    token: TextToken,
    important_context_phrases: set[str],
) -> list[TextToken]:
    text = token.text.strip()
    if not text:
        return []

    if token.kind == "punctuation" or _is_punctuation_token(text):
        return [token] if _is_study_punctuation_token(text) else []

    if _is_explicit_context_phrase(text, important_context_phrases):
        return [token]

    split_tokens = _fallback_tokens(text)
    if len(split_tokens) == 1 and split_tokens[0].text == text and _is_clean_study_text(text):
        return [token]

    if not _contains_cjk(text):
        return []

    sanitized: list[TextToken] = []
    for split_token in split_tokens:
        split_text = split_token.text.strip()
        if not split_text:
            continue
        if split_token.kind == "punctuation":
            if _is_study_punctuation_token(split_text):
                sanitized.append(split_token)
            continue
        if _contains_cjk(split_text) or _is_explicit_context_phrase(split_text, important_context_phrases):
            sanitized.append(
                TextToken(
                    text=split_text,
                    kind=split_token.kind,
                    meaning=token.meaning if split_text == text else None,
                )
            )

    return sanitized


def _trim_study_tokens(tokens: list[TextToken]) -> list[TextToken]:
    trimmed = list(tokens)
    leading_trim_chars = {"(", "（", ")", "）", ":", "：", ",", "，", "-", "/", "·"}
    trailing_trim_chars = {"(", "（", ":", "：", ",", "，", "-", "/", "·"}

    while trimmed and trimmed[0].kind == "punctuation" and trimmed[0].text in leading_trim_chars:
        trimmed.pop(0)
    while trimmed and trimmed[-1].kind == "punctuation" and trimmed[-1].text in trailing_trim_chars:
        trimmed.pop()
    return trimmed


def _is_explicit_context_phrase(text: str, important_context_phrases: set[str]) -> bool:
    return any(
        phrase == text or phrase in text or text in phrase
        for phrase in important_context_phrases
    )


def _is_study_punctuation_token(text: str) -> bool:
    allowed = {"(", ")", "（", "）", "/", "、", "，", "。", "！", "？", "!", "?", "：", ":", "·", "-"}
    return text in allowed


def _is_clean_study_text(text: str) -> bool:
    return _contains_cjk(text) and not re.search(r"[A-Za-z0-9$]", text)


def _rebuild_sentence_text(tokens: list[TextToken]) -> str:
    rebuilt = "".join(token.text for token in tokens).strip()
    rebuilt = rebuilt.strip(" :,-/|")
    return rebuilt


def _clean_translation(translation: str | None, sentence_text: str) -> str | None:
    if not translation:
        return None

    normalized = translation.strip()
    if not normalized:
        return None

    salvaged = _salvage_translation_prefix(normalized)
    if salvaged:
        normalized = salvaged

    lower = normalized.lower()
    suspicious_markers = (
        "return json",
        "output valid json",
        "reading order preserved",
        "target users",
        "glossary deduplicated",
        "tokens:",
        "pronunciation hints",
        "no extra explanatory text",
    )
    if any(marker in lower for marker in suspicious_markers):
        return None

    if len(normalized) > max(220, len(sentence_text) * 8):
        return None

    return normalized


def _clean_example_sentence(example_sentence: str | None, glossary_hanzi: str) -> str | None:
    if not example_sentence:
        return None

    normalized = example_sentence.strip()
    if not normalized or glossary_hanzi not in normalized:
        return None
    if len(normalized) > 120:
        return None
    if re.search(r"[A-Za-z]", normalized):
        return None

    return normalized


def _compose_example_sentence_pinyin(
    example_sentence: str | None,
    glossary_hanzi: str,
    glossary_pinyin: str,
) -> str | None:
    if not example_sentence:
        return None

    if glossary_hanzi not in example_sentence:
        return resolve_phrase_pinyin(example_sentence, []).pinyin or None

    parts: list[ResolvedPinyin] = []
    cursor = 0
    while cursor < len(example_sentence):
        next_match = example_sentence.find(glossary_hanzi, cursor)
        if next_match == -1:
            tail = example_sentence[cursor:]
            if tail:
                parts.append(resolve_phrase_pinyin(tail, []))
            break

        before = example_sentence[cursor:next_match]
        if before:
            parts.append(resolve_phrase_pinyin(before, []))
        parts.append(ResolvedPinyin(text=glossary_hanzi, pinyin=glossary_pinyin, source="text_model_hint"))
        cursor = next_match + len(glossary_hanzi)

    return compose_sentence_pinyin(parts) or None


def _salvage_translation_prefix(translation: str) -> str | None:
    first_line = translation.splitlines()[0].strip()
    if not first_line:
        return None

    # Keep the short useful English lead-in before the model starts appending
    # Chinese notes, pinyin, labels, or long receipt metadata.
    sentence_match = re.match(r"^(.{1,220}?[.!?])(?:\s|$)", first_line)
    if sentence_match:
        candidate = sentence_match.group(1).strip()
        if _looks_like_useful_translation(candidate):
            return candidate

    semicolon_split = re.split(r"\s+[A-Z][a-z]+：| [\u4e00-\u9fff].*", first_line, maxsplit=1)[0].strip()
    if _looks_like_useful_translation(semicolon_split):
        return semicolon_split

    return None


def _looks_like_useful_translation(text: str) -> bool:
    if not text:
        return False
    if len(text) > 220:
        return False
    lower = text.lower()
    if any(marker in lower for marker in ("return json", "reading order preserved", "target users", "tokens:")):
        return False
    return bool(re.search(r"[A-Za-z]", text))


def _has_usable_confidence(hint: PronunciationHint) -> bool:
    return hint.confidence == 0.0 or hint.confidence >= MIN_HINT_CONFIDENCE


def _phrase_appears_in_sources(phrase: str, source_texts: list[str]) -> bool:
    return any(phrase in source_text for source_text in source_texts if source_text)


def _fallback_sentences(vision_result: VisionExtractionResult) -> list[TextSentence]:
    source_lines = vision_result.reading_lines or vision_result.document_text.splitlines()
    sentences: list[TextSentence] = []

    for line in source_lines:
        for sentence_text in _split_sentence_text(line):
            sentences.append(
                TextSentence(
                    hanzi=sentence_text,
                    tokens=_fallback_tokens(sentence_text),
                )
            )

    if not sentences and vision_result.document_text.strip():
        document_text = vision_result.document_text.strip()
        sentences.append(TextSentence(hanzi=document_text, tokens=_fallback_tokens(document_text)))

    return sentences


def _split_sentence_text(text: str) -> list[str]:
    normalized = text.strip()
    if not normalized:
        return []
    parts = [part.strip() for part in _SENTENCE_SPLIT_RE.split(normalized) if part.strip()]
    return parts or [normalized]


def _fallback_tokens(sentence_text: str) -> list[TextToken]:
    matches = _FALLBACK_TOKEN_RE.findall(sentence_text)
    if not matches:
        return [TextToken(text=sentence_text, kind="other")]
    return [TextToken(text=match, kind=_infer_token_kind(match)) for match in matches]


def _infer_token_kind(text: str) -> str:
    normalized = text.strip()
    if _is_punctuation_token(normalized):
        return "punctuation"
    if _contains_cjk(normalized):
        return "word" if len(normalized) <= 2 else "phrase"
    return "other"


def _add_glossary_entry(
    glossary_index: dict[str, GlossaryEntry],
    draft: GlossaryDraft,
    resolved: ResolvedPinyin,
    kind: str | None = None,
    important_context_phrases: set[str] | None = None,
) -> None:
    key = draft.text.strip()
    if not _should_include_glossary_entry(
        key,
        kind=kind,
        meaning=draft.meaning,
        important_context_phrases=important_context_phrases or set(),
    ):
        return

    existing = glossary_index.get(key)
    meaning = _prefer_meaning(existing.meaning if existing else None, draft.meaning)

    if (
        existing is None
        or meaning != existing.meaning
        or resolved.pinyin != existing.pinyin
        or resolved.source != existing.pinyin_source
    ):
        glossary_index[key] = GlossaryEntry(
            hanzi=draft.text,
            pinyin=resolved.pinyin,
            meaning=meaning,
            pinyinSource=resolved.source,
        )


def _should_include_glossary_entry(
    text: str,
    kind: str | None,
    meaning: str | None,
    important_context_phrases: set[str],
) -> bool:
    if not text or _is_punctuation_token(text):
        return False
    if kind == "punctuation":
        return False
    if not _contains_cjk(text):
        return False
    if kind == "other" and not meaning:
        return False
    if not _contains_cjk(text) and not meaning:
        return False
    return True


def _prefer_meaning(existing: str | None, candidate: str | None) -> str | None:
    if candidate and (not existing or len(candidate.strip()) > len(existing.strip())):
        return candidate
    return existing


def _contains_cjk(text: str) -> bool:
    return bool(_CJK_RE.search(text))


def _is_punctuation_token(text: str) -> bool:
    return bool(text) and not _contains_cjk(text) and all(not char.isalnum() for char in text)
