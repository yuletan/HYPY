from contextlib import asynccontextmanager

from fastapi import FastAPI

from app.clients.openrouter import OpenRouterClient, StudyAnalysisClient
from app.config import Settings, get_settings
from app.routes.analyze import router as analyze_router


def create_app(
    *,
    settings: Settings | None = None,
    openrouter_client: StudyAnalysisClient | None = None,
) -> FastAPI:
    @asynccontextmanager
    async def lifespan(app: FastAPI):
        resolved_settings = settings or get_settings()
        resolved_client = openrouter_client or OpenRouterClient(resolved_settings)

        app.state.settings = resolved_settings
        app.state.openrouter_client = resolved_client

        try:
            yield
        finally:
            if openrouter_client is None and isinstance(resolved_client, OpenRouterClient):
                await resolved_client.close()

    app = FastAPI(
        title="Han Yu Pin Yin Backend",
        version="0.1.0",
        lifespan=lifespan,
    )

    app.include_router(analyze_router)

    @app.get("/health")
    async def healthcheck() -> dict[str, str]:
        return {"status": "ok"}

    return app


app = create_app()
