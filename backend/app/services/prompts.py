import json

from app.schemas.contracts import PronunciationHint

TEXT_ANALYSIS_SYSTEM_PROMPT = """
You are enriching OCR-extracted text for language learners.
Return JSON only, with no markdown fences or explanatory prose.
The response must match the provided schema exactly.
Do not repeat the instructions, checklist, or source text inside translations.
Do not include reasoning, notes to self, or extra top-level keys.

Rules:
- The user prompt will specify the source language and required output language. Follow both exactly.
- Preserve the original reading order.
- Split the text into study-friendly sentences.
- Tokenize each sentence into useful words, short phrases, punctuation, or other mixed-content chunks.
- Every non-empty sentence must include at least one token. If unsure, use one token containing the full sentence text.
- Every non-punctuation token must include a concise learner-friendly meaning in the requested output language. Omit low-confidence tokens instead of leaving meaning empty.
- Provide sentence translations when possible in the requested output language.
- Every study sentence should include a translation in the requested output language unless the line is mostly symbols, numbers, or metadata.
- If the source and output languages match, use a simple learner-friendly paraphrase instead of repeating the source text.
- Keep each translation to one short sentence or phrase, ideally under 18 words.
- Do not include romanization, source-language glosses, tags, IDs, timestamps, prices from other lines, or study notes inside translations.
- If a line is already mostly English, numbers, or symbols, translation may be omitted.
- Keep glossary terms deduplicated and readable.
- Every glossary term should include a concise meaning in the requested output language. Omit the term if meaning is unknown.
- For Chinese source text, only include pronunciationHints for exact phrases that genuinely need context-aware correction.
- For Japanese source text, keep Japanese script exactly as extracted and include pronunciationHints with romaji readings for kanji-containing terms, because kanji readings are context-dependent.
- For Japanese source text, do not rewrite source text into Chinese variants.
- For Japanese source text, kana-only tokens such as particles and okurigana are meaningful text, not punctuation or placeholders.
- Never generate Chinese pinyin or Japanese romaji inside translations or meanings.
- If you are unsure about a pronunciation hint, omit it.
- Return empty arrays instead of null values.
""".strip()

GLOSSARY_ENRICHMENT_SYSTEM_PROMPT = """
You are enriching glossary terms for language learners.
Return JSON only, with no markdown fences or explanatory prose.
The response must match the provided schema exactly.
Do not include reasoning, notes to self, or extra top-level keys.

Rules:
- The user prompt will specify the source language and required output language. Follow both exactly.
- Each entry must match one requested glossary term exactly.
- literalMeaning must be concise, literal where possible, and written in the requested output language.
- Every returned entry must include literalMeaning. If unsure about a term, omit that term instead of returning empty meaning.
- Do not pad meanings with study notes, grammar essays, romanization, or unrelated context.
- exampleSentence must be a short natural source-language sentence that uses the exact glossary term.
- Keep exampleSentence in the source language only.
- Never rewrite Japanese source text into Chinese variants.
- If you are unsure, keep fields short rather than verbose.
- Return empty arrays instead of null arrays.
""".strip()


def build_text_analysis_messages(
    document_text: str,
    pronunciation_hints: list[PronunciationHint],
    input_language_name: str,
    output_language_name: str,
) -> list[dict[str, str]]:
    return [
        {"role": "system", "content": TEXT_ANALYSIS_SYSTEM_PROMPT},
        {
            "role": "user",
            "content": build_text_analysis_user_prompt(
                document_text = document_text,
                pronunciation_hints = pronunciation_hints,
                input_language_name = input_language_name,
                output_language_name = output_language_name,
            ),
        },
    ]


def build_glossary_enrichment_messages(
    document_text: str,
    glossary_terms: list[str],
    input_language_name: str,
    output_language_name: str,
) -> list[dict[str, str]]:
    return [
        {"role": "system", "content": GLOSSARY_ENRICHMENT_SYSTEM_PROMPT},
        {
            "role": "user",
            "content": build_glossary_enrichment_user_prompt(
                document_text = document_text,
                glossary_terms = glossary_terms,
                input_language_name = input_language_name,
                output_language_name = output_language_name,
            ),
        },
    ]


def build_text_analysis_user_prompt(
    document_text: str,
    pronunciation_hints: list[PronunciationHint],
    input_language_name: str,
    output_language_name: str,
) -> str:
    payload = {
        "task": "segment_for_study",
        "documentText": document_text,
        "sourceLanguage": input_language_name,
        "outputLanguage": output_language_name,
        "existingPronunciationHints": [_serialize_hint(hint) for hint in pronunciation_hints],
        "outputChecklist": [
            "Populate sentences in reading order.",
            "Populate each sentence with hanzi, translation, and tokens.",
            "Write sentence translations and token meanings in the requested output language.",
            "Every non-punctuation token must include meaning, or be omitted if uncertain.",
            "Every study sentence should include translation unless the line is mostly symbols or numbers.",
            "Use token.kind values only from: word, phrase, punctuation, other.",
            "Populate glossary with deduplicated study terms only.",
            "Include a concise meaning for every glossary term, or omit the term if meaning is unknown.",
            "For Japanese kanji terms, populate pronunciationHints with exact-match Hepburn-style romaji readings.",
            "When sourceLanguage is Japanese, preserve Japanese script exactly and never convert it into Chinese variants.",
            "Do not label kana-only Japanese tokens as punctuation or placeholders.",
            "For Chinese terms, populate pronunciationHints only for exact-match corrections that need context.",
            "Return valid JSON matching the schema exactly.",
        ],
    }
    return json.dumps(payload, ensure_ascii=False, indent=2)


def build_glossary_enrichment_user_prompt(
    document_text: str,
    glossary_terms: list[str],
    input_language_name: str,
    output_language_name: str,
) -> str:
    payload = {
        "task": "enrich_glossary",
        "documentText": document_text,
        "sourceLanguage": input_language_name,
        "outputLanguage": output_language_name,
        "glossaryTerms": glossary_terms,
        "outputChecklist": [
            "Populate entries for the requested glossary terms only.",
            "Keep each entry.text identical to the requested term.",
            "Populate literalMeaning with a concise literal meaning in the requested output language.",
            "Every returned entry must include literalMeaning; omit terms if unsure.",
            "Populate exampleSentence with a short natural sentence in the source language using the exact term.",
            "If sourceLanguage is Japanese, keep Japanese script and never convert to Chinese variants.",
            "Return valid JSON matching the schema exactly.",
        ],
    }
    return json.dumps(payload, ensure_ascii=False, indent=2)


def _serialize_hint(hint: PronunciationHint) -> dict[str, str | float | None]:
    return {
        "phrase": hint.phrase,
        "preferredPinyin": hint.preferred_pinyin,
        "toneNumberPinyin": hint.tone_number_pinyin,
        "reason": hint.reason,
        "confidence": hint.confidence,
    }
