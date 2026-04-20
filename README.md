# Han Yu Pin Yin

Chinese OCR study app for turning photographed text into a readable Chinese study flow with pinyin, meanings, and sentence-level explanations.

## What this repo contains

- `android-app/`: native Android starter using Kotlin and Jetpack Compose
- `backend/`: FastAPI starter for OpenRouter vision + text processing
- `docs/`: locked contracts and agent handoff notes

## Run It

The Android app and backend run separately. Open `android-app/` in Android Studio for the mobile app, and run the backend from `backend/` in PowerShell.

### 1. Start the backend

1. Open PowerShell in [`backend/`](backend/).
2. Copy [`backend/.env.example`](backend/.env.example) to [`backend/.env`](backend/.env).
3. Fill in `OPENROUTER_API_KEY`, `OPENROUTER_VISION_MODEL`, and `OPENROUTER_TEXT_MODEL`.
4. Activate the virtual environment:

```powershell
.\.venv\Scripts\Activate.ps1
```

5. Start the server:

```powershell
python -m uvicorn app.main:app --reload --host 0.0.0.0 --port 8000
```

6. Confirm it is running:

```text
http://localhost:8000/health
```

### 2. Start the Android app

1. Open Android Studio.
2. Open the `android-app/` folder, not the repo root.
3. Wait for Gradle sync to finish.
4. Connect an Android phone with USB debugging enabled, or launch an emulator.
5. Pick the device in the Run toolbar.
6. Click Run.

### 3. Point the app at the backend

- Emulator: use `http://10.0.2.2:8000`
- Physical phone on the same Wi-Fi: use your laptop's LAN IP, such as `http://192.168.1.20:8000`
- If you want to keep using `localhost` on a physical phone, run `adb reverse tcp:8000 tcp:8000` and use `http://127.0.0.1:8000`
- The Android app can auto-pick emulator vs physical-device defaults. Set `deviceBackendBaseUrl=http://<your-laptop-ip>:8000` in `android-app/local.properties` for the physical-device default.

### 4. What each part does

- Android app: image picker, upload flow, reader UI, and settings
- Backend: OCR request handling, OpenRouter calls, pinyin enrichment, and structured responses
- `.env` file: backend-only secrets and model IDs

### 5. Deploy the backend online

If you want the backend to stay online without running it on your laptop, Railway is a simple option for this FastAPI app.

1. Create a Railway project and connect this GitHub repo.
2. Set the service root directory to `backend/`.
3. Add these variables in Railway:
   - `OPENROUTER_API_KEY`
   - `OPENROUTER_VISION_MODEL`
   - `OPENROUTER_TEXT_MODEL`
   - optional: `OPENROUTER_BASE_URL`, `REQUEST_TIMEOUT_SECONDS`, `MAX_IMAGE_MB`, `ALLOWED_IMAGE_MEDIA_TYPES`
4. Use this start command:

```bash
uvicorn app.main:app --host 0.0.0.0 --port $PORT
```

5. Generate a public domain from the Railway service settings.

## Stack

- Android app: Kotlin, Jetpack Compose, Navigation Compose, Coil, DataStore
- Backend: Python, FastAPI, httpx, pydantic-settings, pypinyin
- Data format: Kotlin serialization and JSON-based API contracts
- AI provider: OpenRouter vision and text models
- Target device: Android phones and tablets

## Overview

The app lets a user pick or capture an image of Chinese text, send it to the backend for OCR and language enrichment, and then read the result in a study-friendly format. The backend extracts the text, adds pinyin and meanings, and returns structured sentences, tokens, and glossary entries for the Android UI to display.

## V1 approach

- Android uploads an image to the backend
- Backend calls an OpenRouter vision-language model to extract text
- The VL step can return **pronunciation hints** for polyphonic words when context clarifies their reading
- Backend runs pinyin generation with library-based fallback and hint-based overrides
- Backend calls a text model for segmentation, meanings, and sentence explanations
- Android renders a text-first study UI with pinyin above Hanzi

## Security

Do not ship the OpenRouter API key in the Android app.

Keep these only in `backend/.env`:

- `OPENROUTER_API_KEY`
- `OPENROUTER_VISION_MODEL`
- `OPENROUTER_TEXT_MODEL`

## Next step

Read [docs/api-contract.md](docs/api-contract.md) and [PARALLEL_BUILD_PLAN.md](PARALLEL_BUILD_PLAN.md) before parallel implementation.
