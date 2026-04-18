import logging
from typing import Annotated

from fastapi import APIRouter, Depends, File, Form, HTTPException, Request, UploadFile
from starlette import status

from app.clients.openrouter import (
    OpenRouterClient,
    OpenRouterClientError,
    OpenRouterResponseError,
)
from app.config import Settings
from app.schemas.contracts import AnalyzeImageResponse, ExplainSelectionRequest, ExplainSelectionResponse
from app.services.language_options import normalize_input_language, normalize_output_language
from app.services.annotation import apply_glossary_enrichment, build_analyze_response, build_explain_response

router = APIRouter(prefix="/api/v1", tags=["analysis"])
logger = logging.getLogger(__name__)

_READ_CHUNK_SIZE = 1024 * 1024


def get_app_settings(request: Request) -> Settings:
    return request.app.state.settings


def get_analysis_client(request: Request) -> OpenRouterClient:
    return request.app.state.openrouter_client


@router.post("/analyze-image", response_model=AnalyzeImageResponse)
async def analyze_image(
    image: Annotated[UploadFile, File(...)],
    input_language: Annotated[str, Form()] = "auto",
    output_language: Annotated[str, Form()] = "en",
    settings: Annotated[Settings, Depends(get_app_settings)],
    client: Annotated[OpenRouterClient, Depends(get_analysis_client)],
) -> AnalyzeImageResponse:
    normalized_input_language = normalize_input_language(input_language)
    normalized_output_language = normalize_output_language(output_language)
    image_bytes, media_type = await _read_validated_image(image=image, settings=settings)

    try:
        vision_result = await client.extract_text_from_image(
            image_bytes=image_bytes,
            media_type=media_type,
            input_language=normalized_input_language,
        )
    except OpenRouterResponseError as exc:
        logger.exception("Vision extraction returned invalid structured output.")
        raise HTTPException(
            status_code=status.HTTP_502_BAD_GATEWAY,
            detail="Vision extraction returned an invalid structured response.",
        ) from exc
    except OpenRouterClientError as exc:
        logger.exception("Vision extraction request failed.")
        raise HTTPException(
            status_code=status.HTTP_502_BAD_GATEWAY,
            detail="Vision extraction service is currently unavailable.",
        ) from exc

    try:
        text_result = await client.analyze_text_for_study(
            document_text=vision_result.document_text,
            pronunciation_hints=vision_result.pronunciation_hints,
            input_language=normalized_input_language,
            output_language=normalized_output_language,
        )
    except OpenRouterResponseError as exc:
        logger.exception("Text analysis returned invalid structured output.")
        raise HTTPException(
            status_code=status.HTTP_502_BAD_GATEWAY,
            detail="Text analysis returned an invalid structured response.",
        ) from exc
    except OpenRouterClientError as exc:
        logger.exception("Text analysis request failed.")
        raise HTTPException(
            status_code=status.HTTP_502_BAD_GATEWAY,
            detail="Text analysis service is currently unavailable.",
        ) from exc

    response = build_analyze_response(vision_result=vision_result, text_result=text_result)
    if not response.glossary:
        return response

    try:
        glossary_enrichment = await client.enrich_glossary_terms(
            document_text=vision_result.document_text,
            glossary_terms=[entry.hanzi for entry in response.glossary],
            output_language=normalized_output_language,
        )
    except OpenRouterResponseError as exc:
        logger.exception("Glossary enrichment returned invalid structured output.")
        return response.model_copy(
            update={
                "warnings": [*response.warnings, "Glossary enrichment is temporarily unavailable."],
            }
        )
    except OpenRouterClientError as exc:
        logger.exception("Glossary enrichment request failed.")
        return response.model_copy(
            update={
                "warnings": [*response.warnings, "Glossary enrichment is temporarily unavailable."],
            }
        )

    return apply_glossary_enrichment(response=response, glossary_enrichment=glossary_enrichment)


@router.post("/explain-selection", response_model=ExplainSelectionResponse)
async def explain_selection(
    payload: ExplainSelectionRequest,
    client: Annotated[OpenRouterClient, Depends(get_analysis_client)],
) -> ExplainSelectionResponse:
    try:
        explanation = await client.explain_selection(payload)
    except OpenRouterResponseError as exc:
        logger.exception("Selection explanation returned invalid structured output.")
        raise HTTPException(
            status_code=status.HTTP_502_BAD_GATEWAY,
            detail="Selection explanation returned an invalid structured response.",
        ) from exc
    except OpenRouterClientError as exc:
        logger.exception("Selection explanation request failed.")
        raise HTTPException(
            status_code=status.HTTP_502_BAD_GATEWAY,
            detail="Selection explanation service is currently unavailable.",
        ) from exc

    return build_explain_response(payload=payload, explanation=explanation)


async def _read_validated_image(image: UploadFile, settings: Settings) -> tuple[bytes, str]:
    media_type = (image.content_type or "").strip().lower()
    if not media_type:
        raise HTTPException(
            status_code=status.HTTP_400_BAD_REQUEST,
            detail="Uploaded file must include an image content type.",
        )

    if media_type not in settings.allowed_image_media_types:
        raise HTTPException(
            status_code=status.HTTP_415_UNSUPPORTED_MEDIA_TYPE,
            detail=f"Unsupported media type: {media_type}",
        )

    chunks: list[bytes] = []
    total_size = 0

    try:
        while True:
            chunk = await image.read(_READ_CHUNK_SIZE)
            if not chunk:
                break

            total_size += len(chunk)
            if total_size > settings.max_image_bytes:
                raise HTTPException(
                    status_code=status.HTTP_413_REQUEST_ENTITY_TOO_LARGE,
                    detail=f"Image exceeds max size of {settings.max_image_mb} MB",
                )

            chunks.append(chunk)
    finally:
        await image.close()

    if total_size == 0:
        raise HTTPException(
            status_code=status.HTTP_400_BAD_REQUEST,
            detail="Uploaded image is empty.",
        )

    return b"".join(chunks), media_type
