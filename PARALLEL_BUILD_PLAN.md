# Han Yu Pin Yin Parallel Build Plan

## Right way to start

Do **not** send 4 agents into an empty folder at the same time. That creates build-file conflicts immediately.

Do this short sequential bootstrap first, then let the 4 agents code in parallel:

1. Create the repo skeleton:
   - `android-app/`
   - `backend/`
   - `docs/`
2. Lock the API contract in `docs/api-contract.md` before feature work starts.
3. Pre-create Android and backend dependency files so the 4 agents do **not** edit Gradle or Python project wiring in parallel.
4. Add placeholder DTOs, route registration, and screen navigation stubs so every agent can code against stable interfaces.

After that, run the 4 agents at the same time.

## Default architecture for v1

- Android app: native `Kotlin + Jetpack Compose`
- Backend: `Python + FastAPI`
- Secrets: keep `OPENROUTER_API_KEY` only in backend `.env`
- OpenRouter usage:
  - 1 vision model for OCR-style extraction from the image
  - the vision model can emit phrase-level pronunciation hints for ambiguous/polyphonic words
  - 1 text model for segmentation, meanings, and sentence explanations
- Chinese only for v1
- Text-first study UI for v1
- Defer image overlay, Japanese/romaji, and audio to v2

## Why this architecture

- Android apps should not ship raw API keys inside the APK. The backend should own the OpenRouter key.
- FastAPI is a simple place to keep `.env`, model selection, OCR prompts, and language enrichment logic.
- Chinese pinyin accuracy is better handled in the backend with `pypinyin` than by asking the model to invent pinyin.
- The VL model can still help by flagging context-sensitive phrases where the default pinyin might be wrong.
- A text-first reader UI is much safer than drawing annotations directly over arbitrary image coordinates.

## Required config

Create `backend/.env.example` like this:

```env
OPENROUTER_API_KEY=
OPENROUTER_BASE_URL=https://openrouter.ai/api/v1
OPENROUTER_VISION_MODEL=nvidia/nemotron-nano-12b-v2-vl:free
OPENROUTER_TEXT_MODEL=replace-with-your-fast-text-model
REQUEST_TIMEOUT_SECONDS=45
MAX_IMAGE_MB=10
```

Recommended Android local config:

- Keep only the backend base URL in Android local config
- Do **not** put the OpenRouter key in the Android app

## Shared API contract to lock before parallel work

Create these two endpoints first:

### `POST /api/v1/analyze-image`

Input:

- multipart image upload

Output shape:

```json
{
  "documentText": "full extracted text",
  "language": "zh-Hans",
  "sentences": [
    {
      "id": "s1",
      "hanzi": "sample Chinese sentence",
      "pinyin": "sample tone-mark pinyin",
      "translation": "Hello, I am a student.",
      "tokens": [
        {
          "id": "t1",
          "hanzi": "sample word",
          "pinyin": "sample pinyin",
          "meaning": "hello",
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
      "meaning": "student",
      "pinyinSource": "vision_hint"
    }
  ],
  "warnings": []
}
```

### `POST /api/v1/explain-selection`

Input:

```json
{
  "text": "sample word",
  "scope": "word"
}
```

Output:

```json
{
  "text": "sample word",
  "pinyin": "sample pinyin",
  "meaning": "student",
  "notes": "Used for a person who studies.",
  "examples": ["sample example sentence"],
  "pinyinSource": "library"
}
```

## OCR and enrichment pipeline

1. Android uploads the image to the backend.
2. Backend calls OpenRouter vision model with image input.
3. Vision model returns extracted text, reading order, and only high-confidence pronunciation hints for ambiguous phrases.
4. Backend sends extracted text to a text model using structured JSON output.
5. Backend enriches each returned token with `pypinyin`, applying exact-match phrase hints first.
6. Android renders:
   - full reader view
   - sentence cards
   - token-level pinyin above Hanzi
   - glossary/details bottom sheet on tap

## Out of scope for v1

- In-image pinyin overlay
- Japanese and romaji
- TTS/audio playback
- OCR bounding box rendering
- user accounts or sync

## Bootstrap checklist before parallel work

One lead engineer should do this first:

1. Create `android-app/` with a working Jetpack Compose app.
2. Create `backend/` with FastAPI, `pyproject.toml`, and `.env.example`.
3. Add Android dependencies up front:
   - Navigation Compose
   - Coil
   - Retrofit or Ktor client
   - Kotlin serialization
   - DataStore
4. Add backend dependencies up front:
   - `fastapi`
   - `uvicorn`
   - `httpx`
   - `python-multipart`
   - `pydantic-settings`
   - `pypinyin`
   - `pytest`
5. Create `docs/api-contract.md` with the exact request and response shapes.
6. Create empty placeholder files for all 4 agent-owned areas.
7. Commit or checkpoint the bootstrap before parallel work starts.

## Agent ownership map

### Agent 1: Android shell, upload flow, settings

Owns:

- `android-app/app/**`
- `android-app/feature/upload/**`
- `android-app/feature/settings/**`

Must not edit:

- `backend/**`
- `android-app/feature/reader/**`
- `docs/api-contract.md`

### Agent 2: Android reader and study UI

Owns:

- `android-app/feature/reader/**`
- `android-app/feature/glossary/**`

Must not edit:

- `backend/**`
- `android-app/feature/upload/**`
- `android-app/feature/settings/**`
- `docs/api-contract.md`

### Agent 3: Backend OpenRouter gateway and API layer

Owns:

- `backend/app/main.py`
- `backend/app/config.py`
- `backend/app/routes/**`
- `backend/app/clients/**`
- `backend/app/schemas/**`
- `backend/.env.example`

Must not edit:

- `android-app/**`
- `backend/app/services/**`
- `docs/api-contract.md`

### Agent 4: Backend Chinese enrichment and backend tests

Owns:

- `backend/app/services/**`
- `backend/tests/**`

Must not edit:

- `android-app/**`
- `backend/app/routes/**`
- `backend/app/clients/**`
- `docs/api-contract.md`

## Agent prompts

### Prompt for Agent 1

```text
You are Agent 1 working in the Han Yu Pin Yin repo. You are not alone in the codebase. Other agents are editing in parallel. Do not revert their changes. Stay inside your owned paths only.

Your ownership:
- android-app/app/**
- android-app/feature/upload/**
- android-app/feature/settings/**

Do not touch:
- backend/**
- android-app/feature/reader/**
- android-app/feature/glossary/**
- docs/api-contract.md

Goal:
Build the Android shell, image upload flow, and settings screen for a Chinese OCR study app.

Requirements:
- Use Kotlin + Jetpack Compose.
- Build a clean app shell with navigation.
- Add an upload screen that lets the user pick an image from the device.
- Add loading, empty, success, and error states.
- Add a settings screen for backend base URL and simple debug toggles only.
- Wire the upload flow to the shared API contract from docs/api-contract.md.
- Pass the parsed result into the reader route without implementing the reader UI itself.

Deliverables:
- App entry point and navigation
- Upload screen and state handling
- Settings screen
- Any repository or viewmodel code needed for your owned areas

Acceptance:
- App launches
- User can select an image
- User can submit the image
- User can reach the reader route with either fixture data or a real backend response

When finished, report exactly which files you changed.
```

### Prompt for Agent 2

```text
You are Agent 2 working in the Han Yu Pin Yin repo. You are not alone in the codebase. Other agents are editing in parallel. Do not revert their changes. Stay inside your owned paths only.

Your ownership:
- android-app/feature/reader/**
- android-app/feature/glossary/**

Do not touch:
- backend/**
- android-app/app/**
- android-app/feature/upload/**
- android-app/feature/settings/**
- docs/api-contract.md

Goal:
Build the study UI that displays extracted Chinese text with pinyin above the words and makes meanings easy to explore.

Requirements:
- Use Kotlin + Jetpack Compose.
- Consume the shared response DTO shape from docs/api-contract.md.
- Build a reader screen that shows sentences in reading order.
- Render token-level pinyin above Hanzi in a clean, readable layout.
- Add a glossary/details bottom sheet or panel for tapped words and phrases.
- Show sentence translation under each sentence card.
- Handle long text gracefully with scrolling and spacing.
- Use fixture JSON so the screen can be developed without the live backend.

Deliverables:
- Reader screen
- Sentence card UI
- Token/pinyin composables
- Glossary/details interaction
- Reader previews or UI tests if practical

Acceptance:
- A fixture response can fully render in the reader UI
- Tokens are readable on phone screens
- Tapping a token surfaces its meaning/details

When finished, report exactly which files you changed.
```

### Prompt for Agent 3

```text
You are Agent 3 working in the Han Yu Pin Yin repo. You are not alone in the codebase. Other agents are editing in parallel. Do not revert their changes. Stay inside your owned paths only.

Your ownership:
- backend/app/main.py
- backend/app/config.py
- backend/app/routes/**
- backend/app/clients/**
- backend/app/schemas/**
- backend/.env.example

Do not touch:
- android-app/**
- backend/app/services/**
- docs/api-contract.md

Goal:
Build the backend API layer and the OpenRouter integration for image analysis and explanation.

Requirements:
- Use FastAPI.
- Load API key and model IDs from backend .env.
- Expose POST /api/v1/analyze-image and POST /api/v1/explain-selection.
- Validate upload size and content type.
- Call OpenRouter chat completions for both the vision and text stages.
- Make the vision prompt request phrase-level pronunciation hints only for context-sensitive readings.
- Use structured JSON outputs for the model responses.
- Keep OpenRouter-specific code inside backend/app/clients/**.
- Return response shapes that match docs/api-contract.md exactly.
- Depend on backend/app/services/** for Chinese enrichment but do not implement those services yourself.

Deliverables:
- FastAPI app wiring
- Config/env loader
- OpenRouter client
- Request/response schemas
- API routes
- Backend .env.example

Acceptance:
- Backend starts locally
- Endpoints validate input cleanly
- OpenRouter client can be mocked in tests
- Routes are ready to plug into the enrichment services from Agent 4

When finished, report exactly which files you changed.
```

### Prompt for Agent 4

```text
You are Agent 4 working in the Han Yu Pin Yin repo. You are not alone in the codebase. Other agents are editing in parallel. Do not revert their changes. Stay inside your owned paths only.

Your ownership:
- backend/app/services/**
- backend/tests/**

Do not touch:
- android-app/**
- backend/app/routes/**
- backend/app/clients/**
- docs/api-contract.md

Goal:
Build the Chinese enrichment layer that turns extracted text into study-friendly annotated output.

Requirements:
- Use pypinyin for pinyin generation.
- Create service code that takes extracted OCR text and returns sentences, tokens, glossary entries, and pinyin-rich output.
- Keep pinyin generation deterministic and library-based, not model-invented.
- Apply exact-match pronunciation hints from the VL and text stages before falling back to library pinyin.
- Build prompt-builder helpers for the text model so segmentation and meanings come back in stable JSON.
- Add unit tests for token annotation, pinyin formatting, and response assembly.
- Make the services easy for the API routes to call.

Deliverables:
- Annotation service
- Pinyin service
- Prompt builders for text-model analysis
- Backend tests with fixture OCR text

Acceptance:
- Sample Chinese text can be converted into sentence and token structures
- Pinyin is attached to each token
- Glossary items are deduplicated and readable
- Tests cover normal text, punctuation, and mixed Chinese/non-Chinese content

When finished, report exactly which files you changed.
```

## Recommended implementation order after bootstrap

Run all 4 in parallel after bootstrap, but merge in this order:

1. Agent 3
2. Agent 4
3. Agent 1
4. Agent 2

Reason:

- Backend API shape should settle before the final mobile integration
- Android shell can proceed while reader UI is built against fixture data
- Reader integration is the easiest final merge once the data shape is stable

## Acceptance criteria for the whole v1

- User picks an image from Android
- App sends it to the backend
- Backend extracts Chinese text through an OpenRouter vision model
- Backend returns structured sentences, tokens, pinyin, and meanings
- App shows a clean reading UI with pinyin above Hanzi
- User can tap a word or phrase to see more meaning details

## Nice v2 follow-ups

- Image overlay mode using OCR boxes
- Japanese pipeline with romaji
- TTS playback per sentence
- Saved vocabulary and spaced repetition
- Camera capture and multi-page document support

## Notes from official docs used for this plan

- OpenRouter multimodal image input goes through `/api/v1/chat/completions` with image content in `messages`
- OpenRouter structured outputs can enforce JSON schema responses
- Android security guidance warns against shipping sensitive API keys in the app
- `pypinyin` supports phrase-aware pinyin, tone styles, and polyphonic handling better than relying on an LLM for pinyin
