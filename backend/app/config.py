from functools import lru_cache
from pathlib import Path
from typing import Annotated, Any

from pydantic import Field, field_validator
from pydantic_settings import BaseSettings, NoDecode, SettingsConfigDict

_BACKEND_ROOT = Path(__file__).resolve().parent.parent


class Settings(BaseSettings):
    model_config = SettingsConfigDict(
        env_file=_BACKEND_ROOT / ".env",
        env_file_encoding="utf-8",
        extra="ignore",
        case_sensitive=False,
    )

    openrouter_api_key: str = Field(..., alias="OPENROUTER_API_KEY")
    openrouter_base_url: str = Field("https://openrouter.ai/api/v1", alias="OPENROUTER_BASE_URL")
    openrouter_vision_model: str = Field(..., alias="OPENROUTER_VISION_MODEL")
    openrouter_text_model: str = Field(..., alias="OPENROUTER_TEXT_MODEL")
    request_timeout_seconds: float = Field(45.0, alias="REQUEST_TIMEOUT_SECONDS", gt=0)
    max_image_mb: int = Field(10, alias="MAX_IMAGE_MB", ge=1)
    allowed_image_media_types: Annotated[tuple[str, ...], NoDecode] = Field(
        default=("image/jpeg", "image/png", "image/webp"),
        alias="ALLOWED_IMAGE_MEDIA_TYPES",
    )

    @field_validator("openrouter_base_url", mode="before")
    @classmethod
    def normalize_openrouter_base_url(cls, value: Any) -> Any:
        if isinstance(value, str):
            return value.strip().rstrip("/")
        return value

    @field_validator("allowed_image_media_types", mode="before")
    @classmethod
    def parse_allowed_image_media_types(cls, value: Any) -> Any:
        if value is None or value == "":
            return ("image/jpeg", "image/png", "image/webp")

        if isinstance(value, str):
            parsed = tuple(item.strip().lower() for item in value.split(",") if item.strip())
            if not parsed:
                raise ValueError("ALLOWED_IMAGE_MEDIA_TYPES must contain at least one media type")
            return parsed

        if isinstance(value, (list, tuple, set)):
            parsed = tuple(str(item).strip().lower() for item in value if str(item).strip())
            if not parsed:
                raise ValueError("ALLOWED_IMAGE_MEDIA_TYPES must contain at least one media type")
            return parsed

        return value

    @property
    def max_image_bytes(self) -> int:
        return self.max_image_mb * 1024 * 1024


@lru_cache(maxsize=1)
def get_settings() -> Settings:
    return Settings()
