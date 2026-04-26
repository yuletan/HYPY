system
1/2
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

user
2/2
{
  "task": "segment_for_study",
  "documentText": "いっけいけ！\n百科事典娘\n描いた人／カスガ\n係船柱！\n！\nみんな知ってるけど\n名前は知らない\nものってよくある\n港に生えてる\n鉄のキノコ\n物休とか\nあれって\n船みたに係留する\n柱みたいな\nものでしょ？\nだから係船柱\nあれ？",
  "sourceLanguage": "Japanese",
  "outputLanguage": "English",
  "existingPronunciationHints": [
    {
      "phrase": "係船柱",
      "preferredPinyin": "kai-sen-chu",
      "toneNumberPinyin": "kai1-sen2-chu3",
      "reason": null,
      "confidence": 0.0
    }
  ],
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
    "Return valid JSON matching the schema exactly."
  ]
}

Completion
642 tokens

Completion
1/1
{
  "glossary": [
    {
      "meaning": "ship post",
      "text": "係船柱"
    },
    {
      "meaning": "name unknown",
      "text": "名前は知らない"
    },
    {
      "meaning": "common thing",
      "text": "ものってよくある"
    },
    {
      "meaning": "found in port",
      "text": "港に生えてる"
    },
    {
      "meaning": "iron fungus",
      "text": "鉄のキノコ"
    },
    {
      "meaning": "things left as is",
      "text": "物休とか"
    },
    {
      "meaning": "anchor post",
      "text": "船みたに係留する"
    }
  ],
  "sentences": [
    {
      "hanzi": "いっけいけ！",
      "translation": "Hey! Let's go! "
    },
    {
      "hanzi": "百科事典娘",
      "translation": "Dictionary lady"
    },
    {
      "hanzi": "描いた人",
      "translation": "the person described"
    },
    {
      "hanzi": "カスガ",
      "translation": "Kasuga"
    },
    {
      "hanzi": "係船柱",
      "translation": "ship post"
    },
    {
      "hanzi": "！",
      "translation": "!"
    },
    {
      "hanzi": "みんな知ってるけど",
      "translation": "Everyone knows this"
    },
    {
      "hanzi": "名前は知らない",
      "translation": "I don't know the name"
    },
    {
      "hanzi": "ものってよくある",
      "translation": "Things are common"
    },
    {
      "hanzi": "港に生えてる",
      "translation": "Growing in the port"
    },
    {
      "hanzi": "鉄のキノコ",
      "translation": "Iron fungus"
    },
    {
      "hanzi": "物休とか",
      "translation": "Like things left as is"
    },
    {
      "hanzi": "あれって",
      "translation": "Well, that's it"
    },
    {
      "hanzi": "船みたに係留する",
      "translation": "Anchoring a post"
    },
    {
      "hanzi": "柱みたいな",
      "translation": "Like a post"
    },
    {
      "hanzi": "ものでしょ？",
      "translation": "So?"
    },
    {
      "hanzi": "だから係船柱",
      "translation": "Therefore a ship post"
    },
    {
      "hanzi": "あれ？",
      "translation": "What?"
    }
  ]
}

system
1/2
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

user
2/2
{
  "task": "enrich_glossary",
  "documentText": "いっけいけ！\n百科事典娘\n描いた人／カスガ\n係船柱！\n！\nみんな知ってるけど\n名前は知らない\nものってよくある\n港に生えてる\n鉄のキノコ\n物休とか\nあれって\n船みたに係留する\n柱みたいな\nものでしょ？\nだから係船柱\nあれ？",
  "sourceLanguage": "Japanese",
  "outputLanguage": "English",
  "glossaryTerms": [
    "いっけいけ",
    "ものでしょ",
    "あれ",
    "係船柱",
    "名前は知らない",
    "ものってよくある",
    "港に生えてる",
    "鉄のキノコ",
    "物休とか",
    "船みたに係留する"
  ],
  "outputChecklist": [
    "Populate entries for the requested glossary terms only.",
    "Keep each entry.text identical to the requested term.",
    "Populate literalMeaning with a concise literal meaning in the requested output language.",
    "Every returned entry must include literalMeaning; omit terms if unsure.",
    "Populate exampleSentence with a short natural sentence in the source language using the exact term.",
    "If sourceLanguage is Japanese, keep Japanese script and never convert to Chinese variants.",
    "Return valid JSON matching the schema exactly."
  ]
}

Completion
199 tokens

Completion
1/1
{"entries": [{"literalMeaning": "That's right!","text": "いっけいけ!"}, {"literalMeaning": "You're right!", "text": "係船柱!"}, {"literalMeaning": "I don't know the name", "text": "名前は知らない"}, {"literalMeaning": "Things are common", "text": "ものってよくある"}, {"literalMeaning": "It grows in the port", "text": "港に生えてる"}, {"literalMeaning": "Metallic mushroom", "text": "鉄のキノコ"}, {"literalMeaning": "It's like a dock post", "text": "物休とか"}, {"literalMeaning": "That's what you see when you see a ship being moored", "text": "船みたに係留する"}]
}




user
1/1
You are an OCR engine, not a narrator.
Extract only visible document text from this image in reading order.
documentText must contain copied OCR text only: no explanations, no translation, no guesses, no analysis, no descriptions of the image.
If a character or line is unclear, omit it or add one short warning; never invent filler.
Never repeat a line or phrase unless it visibly appears repeated in the image.
Detect the primary visible text language among zh-Hans, zh-Hant, ja, and en.
Use ja when Japanese kana are present, zh-Hans or zh-Hant when Chinese hanzi are the main study text, and en when the image is mainly English.
For mixed-language images, set language to the main language a learner would study from the image.
Preserve natural Japanese and Chinese text spacing. Do not insert spaces between kanji, kana, hanzi, or digits that form one word/number.
The source language is explicitly Japanese. Prioritize Japanese OCR. Preserve kana, kanji, and Japanese punctuation exactly as written. Do not convert Japanese text into Chinese variants.
Return exactly one JSON object and nothing else.
Do not include markdown fences, reasoning, commentary, or extra keys.
Do not begin with phrases like 'Okay', 'Looking at the image', or 'The user provided'.
Use empty arrays instead of null.
readingLines must be copied visible text lines, not a summary of your process.
pronunciationHints must stay phrase-level.
For Chinese, only include a pronunciation hint when a phrase has a context-sensitive reading, such as a polyphonic word, name, or proper noun that would be easy to misread without context.
For Japanese, include romaji pronunciation hints for useful phrases that contain kanji. Kana-only phrases do not need hints.
Each hinted phrase must appear exactly in documentText.
Do not put pronunciation text anywhere except pronunciationHints.
If you are not confident, return an empty pronunciationHints array.
[Image Redacted]

Completion
293 tokens

Completion
1/1
{
  "documentText": "いっけいけ！\n百科事典娘\n描いた人／カスガ\n係船柱！\n！\nみんな知ってるけど\n名前は知らない\nものってよくある\n港に生えてる\n鉄のキノコ\n物休とか\nあれって\n船みたに係留する\n柱みたいな\nものでしょ？\nだから係船柱\nあれ？",
  "language": "ja",
  "pronunciationHints": [
    {
      "phrase": "係船柱",
      "preferredPinyin": "kai-sen-chu",
      "toneNumberPinyin": "kai1-sen2-chu3"
    }
  ],
  "readingLines": [
    "いっけいけ！",
    "百科事典娘",
    "描いた人／カスガ",
    "係船柱！",
    "！",
    "みんな知ってるけど",
    "名前は知らない",
    "ものってよくある",
    "港に生えてる",
    "鉄のキノコ",
    "物休とか",
    "あれって",
    "船みたに係留する",
    "柱みたいな",
    "ものでしょ？",
    "だから係船柱",
    "あれ？"
  ],
  "warnings": []
}
## Findings

These findings are based on the captured vision prompt/response, text-model prompt/response, glossary prompt/response in this file, plus the current backend and Android code paths.

### What the screenshot is showing

The mixed forms such as `名前ha知らnai`, `港ni生eteru`, `鉄nokinoko`, `物体toka`, and `船mitani係留suru` are not normal romaji. They are hybrid strings where kana was romanized but kanji was left in Japanese script.

The highlighted `係船柱 -> kai-sén-chǔ` is a different failure mode. That is not Japanese romaji. It is Chinese-style pinyin being accepted for a Japanese phrase.

So there are two distinct problems in the same screen:

1. Japanese fallback romanization is incomplete and produces mixed-script output when a token contains kanji.
2. Model-provided pronunciation hints can be wrong, and the backend currently trusts them too much.

### What the captured model transcript proves

The transcript in this file confirms the failure path directly:

- The vision model correctly labeled the source language as Japanese: `"language": "ja"`.
- The same vision response still emitted a bad pronunciation hint for `係船柱`:
  - `"preferredPinyin": "kai-sen-chu"`
  - `"toneNumberPinyin": "kai1-sen2-chu3"`
- The text-model request then forwarded that same bad hint in `existingPronunciationHints`, so the text stage inherited the problem instead of correcting it.
- The text-model completion shown here does not add replacement `pronunciationHints`, so the bad vision hint remains the only trusted hint for that phrase.

This proves that `係船柱 -> kai-sén-chǔ` is not being invented by the Android UI and is not coming from the local Japanese fallback. It is a bad AI hint produced upstream and then accepted by the backend.

The transcript also shows two more concrete quality problems:

- The text-model completion shown here omits `tokens` and omits new `pronunciationHints`, even though the prompt and schema expect both.
- The glossary-enrichment completion does not keep `entry.text` identical to the requested term. It returns `いっけいけ!` and `係船柱!` even though the requested terms were `いっけいけ` and `係船柱`.

So the saved run shows multiple model compliance issues, not just one bad reading.

### Root cause classification

#### Primary issue: underlying backend Japanese romanization fallback

This is the main cause of the hybrid outputs.

In `backend/app/services/pinyin.py`, `resolve_phrase_pinyin()` decides whether to use Japanese romaji fallback or Chinese pinyin fallback. When the language is Japanese, it routes to `_romanize_japanese()`.

The problem is that `_romanize_japanese()` only romanizes kana runs. It does not resolve kanji readings. Non-kana characters are appended unchanged. That means:

- `名前は知らない` becomes `名前ha知らnai`
- `港に生えてる` becomes `港ni生eteru`
- `鉄のキノコ` becomes `鉄nokinoko`
- `物体とか` becomes `物体toka`

This is deterministic backend behavior, not random UI behavior.

There is also a pipeline detail that makes this worse: when the text model omits token arrays, the backend repairs the missing structure locally instead of rejecting the response. That keeps the app working, but it also means the backend proceeds without dependable Japanese reading data for kanji terms.

#### Secondary issue: AI/model pronunciation hints can be wrong

The `係船柱 -> kai-sén-chǔ` case is most likely coming from a model pronunciation hint, not from the fallback library.

In `resolve_phrase_pinyin()`, if a pronunciation hint exactly matches the phrase, that hint wins before any fallback logic runs. There is currently no validation that:

- a Japanese hint is actually romaji
- a Japanese hint avoids Chinese tone marks
- a Japanese hint avoids Chinese pinyin syllable style
- a Japanese hint looks like Hepburn-style output at all

There is also no effective confidence protection here for this case. In `backend/app/services/annotation.py`, `_has_usable_confidence()` treats `0.0` as usable, and your saved vision hint for `係船柱` has `confidence: 0.0`. So a no-confidence hint can still pass through the validation layer and override fallback behavior.

So if the vision model or text model emits a wrong exact-match hint for a Japanese kanji phrase, the backend accepts it and sends it straight to the app.

That explains why one chip shows Chinese-style pronunciation while neighboring chips show mixed kana/kanji fallback output.

The transcript also shows that this bad hint originated in the vision stage, not the text stage.

#### Not primarily an Android app rendering bug

The Android app is not generating these strings by itself.

In `android-app/app/src/main/java/com/hanyupinyin/feature/reader/ReaderComponents.kt`, the UI simply renders `token.pinyin`.

In `android-app/app/src/main/java/com/hanyupinyin/core/model/PinyinDisplay.kt`, `toToneMarkedPinyin()` only formats numbered pinyin into tone marks. It does not create hybrid Japanese strings and it does not convert Japanese text into Chinese pinyin.

So the bad data is already present before the UI displays it.

### Is this a prompt problem, an AI problem, or an app issue?

#### Prompt problem

Not primarily.

The prompts are already fairly explicit about the intended Japanese behavior.

In `backend/app/services/prompts.py`, the text-analysis prompt already says:

- for Japanese source text, include `pronunciationHints` with romaji readings for kanji-containing terms
- preserve Japanese script exactly
- do not convert Japanese into Chinese variants
- kana-only tokens are meaningful text

In `backend/app/clients/openrouter.py`, the vision prompt also says:

- for Japanese, include romaji pronunciation hints for useful phrases that contain kanji
- kana-only phrases do not need hints
- do not put pronunciation text anywhere except `pronunciationHints`
- if unsure, return an empty `pronunciationHints` array

So this is not a case where the system forgot to ask for romaji. It already asked.

Prompt wording could still be tightened, but the existing prompts are strong enough that the current failures point more to model non-compliance and missing backend validation than to a missing prompt requirement.

The transcript strengthens this conclusion, because the model violated an already-explicit prompt. The vision request clearly said the source language was explicitly Japanese and asked for romaji hints for Japanese kanji phrases, but the completion still returned `kai-sen-chu` with Chinese-style tone numbering.

There is one prompt-level weakness worth noting, but it is secondary: the prompts ask for romaji, but they do not explicitly say things like "never use pinyin tone numbers for Japanese" or "if uncertain, return no hint rather than Sino-style reading". That could help a little, but it would still not fix the backend trust problem by itself.

#### AI/model problem

Yes, partially.

If the model returned `kai-sén-chǔ` for `係船柱` while the source language was Japanese, that is a model quality/compliance failure. The prompts ask for Japanese romaji, not Chinese pinyin.

That said, the system currently has no guardrail to reject that bad hint, so the model error goes straight through.

#### Underlying app/backend romanization issue

Yes, definitely, and this is the larger systemic issue.

Even if the model behaved perfectly sometimes, any Japanese token with kanji and without a good pronunciation hint will still fall back to partial kana-only romanization and produce mixed-script garbage.

That means the system is currently dependent on the model to rescue Japanese kanji readings. When the model misses or is wrong, the fallback is not safe.

### Why the outputs look inconsistent

The screen is inconsistent because different tokens are taking different paths:

- kana-only tokens like `あれ` can be romanized correctly by the local fallback and look fine
- kanji-containing tokens with no hint fall back to mixed kana-romaji plus raw kanji
- kanji-containing tokens with a model hint display whatever the model provided, even if it is Chinese pinyin

So the inconsistency is expected from the current pipeline.

### Evidence from tests

The existing tests cover the happy paths, but not the failure you found.

There are tests for:

- kana-only Japanese fallback producing correct romaji
- Japanese kanji terms using romaji pronunciation hints when correct hints are provided

But I did not find tests that enforce:

- Japanese kanji without a hint must not degrade into mixed-script output
- Japanese hints containing Chinese-style pinyin should be rejected
- Japanese phrases should prefer blank pronunciation over clearly wrong Chinese pinyin

This testing gap likely allowed the issue to ship.

### Additional quality issues visible in the captured responses

The prompt/response dump also shows broader model-quality issues beyond pronunciation:

- The glossary enrichment completion does not reliably obey the instruction that `entry.text` must match one requested glossary term exactly.
- Some glossary meanings look shaky or semantically off, which suggests the model is guessing in places where the prompt asked it to omit uncertain output.
- The text analysis output is structurally usable, but it does not correct the inherited bad pronunciation hint and does not supply enough Japanese kanji readings to prevent fallback mixed-script output.
- The saved OCR/text transcript itself contains likely upstream recognition or generation errors such as `物休とか`, which will propagate into tokenization, glossary generation, meanings, and pronunciation no matter what the UI does later.

These are real AI quality problems, but they become much more visible because the backend currently has no strong validation layer for Japanese pronunciation output.

### Final diagnosis

This is not just one bug.

The main issue is an underlying backend design problem in the Japanese fallback romanization path. It only romanizes kana and leaves kanji untouched, which guarantees broken mixed output whenever a Japanese kanji token lacks a pronunciation hint.

There is also a real AI/model issue: the model can output Chinese-style pinyin for Japanese phrases even though the prompts ask for romaji.

The app UI is not the root cause. It is mostly a display surface for already-bad pronunciation strings.

### Best current conclusion

If I had to rank the causes:

1. Primary: backend fallback romanization design for Japanese is not robust enough.
2. Secondary: model pronunciation hints are sometimes wrong for Japanese and are accepted without validation.
3. Tertiary: the system silently repairs malformed model output instead of failing fast, which keeps the UI alive but hides how incomplete the Japanese analysis actually was.
4. Fourth: prompt wording is not perfect, but it is already good enough that prompt weakness does not look like the main root cause.

### Recommended fixes

1. Do not allow Japanese fallback to output mixed-script strings. If a Japanese token contains kanji and there is no trusted hint, prefer blank pronunciation or a dedicated Japanese reading library over partial kana-only romanization.
2. Validate Japanese pronunciation hints before accepting them. Reject hints that look like Chinese pinyin, contain tone marks or tone numbers, or otherwise fail a Japanese romaji sanity check.
3. Stop treating `confidence: 0.0` as automatically usable for Japanese pronunciation hints. Missing confidence should not be enough to trust a kanji reading.
4. Consider failing harder or at least surfacing warnings when the text model omits required `tokens` or `pronunciationHints`, instead of silently repairing everything.
5. Add tests for the exact failure modes seen here:
   - Japanese kanji token without hint
   - Japanese hint incorrectly returned as Chinese pinyin
   - Japanese hint with `confidence: 0.0`
   - text-model output missing `tokens`
   - Japanese phrase should not surface mixed kana-romaji-kanji fallback
6. Tighten prompts only as a secondary improvement. The backend should not rely on prompt compliance alone for Japanese pronunciation correctness.

## Model Comparison

These live comparisons were run on April 26, 2026 by replaying the exact same saved text-stage prompt and payload from the top of this file.

| Model | Status | Japanese preserved? | Corruption pattern | Schema quality | Verdict |
| --- | --- | --- | --- | --- | --- |
| `qwen/qwen3-next-80b-a3b-instruct:free` | Error `429` | N/A | No completion returned | N/A | Could not evaluate because the free route was rate-limited upstream |
| `meta-llama/llama-3.3-70b-instruct:free` | Error `429` | N/A | No completion returned | N/A | Could not evaluate because the free route was rate-limited upstream |
| `nousresearch/hermes-3-llama-3.1-405b:free` | Error `429` | N/A | No completion returned | N/A | Could not evaluate because the free route was rate-limited upstream |
| `nvidia/nemotron-3-nano-30b-a3b:free` | Success on 4/4 replays | No | Returned literal `?` characters instead of Japanese text on every replay | Poor: malformed or low-quality JSON shape varied across runs; often blank translations and broken glossary shape | Not reliable for this Japanese task on the tested free route |
| `openrouter/free` | Success | No | Returned `?`-filled content instead of Japanese text | Poor: wrong field choices like `text` instead of expected sentence shape; degraded content | Not reliable for this Japanese task on the tested free route |
| `tencent/hy3-preview:free` | Success | No | Returned `?`-filled content instead of Japanese text | Poor: schema drift such as `sourceText` and extra fields not matching expected contract | Not reliable for this Japanese task on the tested free route |

### Notes

- For the three Venice-backed free models above (`qwen`, `meta-llama`, `hermes`), the replay path itself worked, but the provider returned `429 Too Many Requests`, so there was no real content to compare.
- `nvidia/nemotron-3-nano-30b-a3b:free` was the only tested named model that consistently returned content, but it consistently corrupted Japanese into literal `?` characters across multiple replays.
- `openrouter/free` and `tencent/hy3-preview:free` also returned content, but both showed the same basic failure mode: Japanese text was lost and replaced with `?`, with noticeable schema drift.
- Based on these live tests, none of the tested free routes produced a trustworthy replacement for the saved transcript quality in this file.

### Short Conclusion

For this exact Japanese structured extraction prompt, the tested free routes fell into two groups:

1. Rate-limited before returning anything useful: `qwen/qwen3-next-80b-a3b-instruct:free`, `meta-llama/llama-3.3-70b-instruct:free`, `nousresearch/hermes-3-llama-3.1-405b:free`
2. Returned content, but corrupted the Japanese payload: `nvidia/nemotron-3-nano-30b-a3b:free`, `openrouter/free`, `tencent/hy3-preview:free`

So the comparison outcome here is not "which free model is best for this Japanese task". The stronger result is that the tested free routes were either unavailable or unreliable for this workload.
