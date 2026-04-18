# API Contract

This file is the lock point for the 4-agent implementation.

## Design rules

- The public API returns study-friendly JSON for the Android app.
- The backend keeps the OpenRouter details private.
- The VL model may provide **context-aware pronunciation hints** only for ambiguous words or phrases.
- The backend remains the final owner of pinyin output.
- Pinyin must be library-backed first, with VL hints applied only when they exactly match a phrase in context.

## Why pronunciation hints exist

Some Chinese words are polyphonic, and a plain character-to-pinyin conversion may pick the wrong reading without context.

Examples:

- `长大` should be read as `zhang3 da4`
- `银行行长` contains both `hang2` and `zhang3`
- names and place names may need context-specific handling

The VL model should **not** generate pinyin for every token. It should only emit hints for phrases that are ambiguous or context-sensitive.

## Public endpoint: `POST /api/v1/analyze-image`

### Request

- Content type: `multipart/form-data`
- Field: `image`

### Response

```json
{
  "documentText": "full extracted text",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "sample Chinese sentence",
      "pinyin": "sample tone-mark pinyin",
      "translation": "sample sentence translation",
      "tokens": [
        {
          "id": "t1",
          "hanzi": "sample word",
          "pinyin": "sample pinyin",
          "meaning": "sample meaning",
          "kind": "word",
          "pinyinSource": "library"
        }
      ]
    }
  ],
  "glossary": [
    {
      "hanzi": "sample glossary word",
      "pinyin": "sample glossary pinyin",
      "meaning": "sample glossary meaning",
      "pinyinSource": "vision_hint"
    }
  ],
  "warnings": []
}
```

### Notes

- `pinyinSource` is one of:
  - `library`
  - `vision_hint`
  - `text_model_hint`
- The Android app should display the pinyin regardless of source.
- Warnings are non-fatal notes such as low-confidence OCR or unsupported characters.

## Public endpoint: `POST /api/v1/explain-selection`

### Request

```json
{
  "text": "sample word",
  "scope": "word",
  "sentenceContext": "optional full sentence containing the selection"
}
```

### Response

```json
{
  "text": "sample word",
  "pinyin": "sample pinyin",
  "meaning": "sample meaning",
  "notes": "sample explanation note",
  "examples": ["sample example sentence"],
  "pinyinSource": "library"
}
```

## Internal contract: vision extraction result

This is the structured response expected from the OpenRouter VL model.

```json
{
  "documentText": "full extracted text in reading order",
  "language": "zh-Hans",
  "readingLines": [
    "first line",
    "second line"
  ],
  "pronunciationHints": [
    {
      "phrase": "sample ambiguous phrase",
      "preferredPinyin": "sample tone-mark pinyin",
      "toneNumberPinyin": "sample numbered pinyin",
      "reason": "polyphonic disambiguation from sentence context",
      "confidence": 0.92
    }
  ],
  "warnings": []
}
```

### Rules for `pronunciationHints`

- Include hints only when context matters.
- Phrase text must exactly appear in `documentText`.
- Use phrase-level hints, not single-character guesses when the phrase is available.
- Keep the list small and high-confidence.
- If uncertain, omit the hint and let the backend library fallback handle it.

## Internal contract: text enrichment result

This is the structured response expected from the OpenRouter text model.

```json
{
  "sentences": [
    {
      "hanzi": "sample sentence",
      "translation": "sample translation",
      "tokens": [
        {
          "text": "sample token",
          "kind": "word",
          "meaning": "sample token meaning"
        }
      ]
    }
  ],
  "glossary": [
    {
      "text": "sample glossary term",
      "meaning": "sample glossary meaning"
    }
  ],
  "pronunciationHints": [
    {
      "phrase": "sample ambiguous phrase",
      "preferredPinyin": "sample pinyin",
      "toneNumberPinyin": "sample numbered pinyin",
      "reason": "disambiguated during text analysis",
      "confidence": 0.88
    }
  ]
}
```

## Hint precedence

Use this order when deciding pinyin:

1. Exact phrase hint from the text model
2. Exact phrase hint from the vision model
3. Library-generated pinyin

## Validation rules

- Uploads larger than configured max size must be rejected.
- Only image MIME types configured by the backend may be processed.
- `phrase` in a hint must be non-empty and appear in the relevant source text.
- Low-confidence hints may be ignored by the annotation service.
- Public response objects should never expose raw OpenRouter payloads.
