# Backend

FastAPI starter for:

- image upload
- OpenRouter VL OCR extraction
- context-aware pronunciation hints
- text enrichment
- library-backed pinyin annotation

## Local setup

1. Copy `.env.example` to `.env`
2. Fill in your OpenRouter credentials and model IDs
3. Install dependencies from `pyproject.toml`
4. Run `uvicorn app.main:app --reload`
