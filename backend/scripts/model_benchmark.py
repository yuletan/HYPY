import argparse
import concurrent.futures
import json
import logging
import mimetypes
import re
import statistics
import time
from pathlib import Path
from typing import Any

from fastapi.testclient import TestClient

from app.clients.openrouter import OpenRouterClient
from app.config import Settings, get_settings
from app.main import create_app

DEFAULT_VISION_MODELS = [
    "nvidia/nemotron-nano-12b-v2-vl:free",
    "qwen/qwen3-vl-30b-a3b-instruct",
    "baidu/qianfan-ocr-fast:free",
]

DEFAULT_TEXT_MODELS = [
    "inclusionai/ling-2.6-flash:free",
    "nvidia/nemotron-3-nano-30b-a3b:free",
]

REPO_ROOT = Path(__file__).resolve().parents[2]
IMGTEST_DIR = REPO_ROOT / "imgtest"
DEFAULT_OUTPUT_PATH = REPO_ROOT / "modeltest.md"
STUDY_TEXT_RE = re.compile(r"[\u3040-\u30ff\uff66-\uff9f\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff]")


def _parse_csv(value: str | None) -> list[str]:
    if not value:
        return []
    return [item.strip() for item in value.split(",") if item.strip()]


def _round(value: float | None, digits: int = 2) -> str:
    if value is None:
        return "n/a"
    return f"{value:.{digits}f}"


def _sum_optional(values: list[int | None]) -> int | None:
    usable = [value for value in values if value is not None]
    if not usable:
        return None
    return sum(usable)


def _json_block(payload: Any) -> str:
    return "```json\n" + json.dumps(payload, ensure_ascii=False, indent=2) + "\n```"


def _pick_first_number(*values: Any) -> int | None:
    for value in values:
        if isinstance(value, bool):
            continue
        if isinstance(value, int):
            return value
        if isinstance(value, float):
            return int(value)
        if isinstance(value, str):
            stripped = value.strip()
            if stripped.isdigit():
                return int(stripped)
    return None


def _serialize_model(value: Any) -> Any:
    if value is None:
        return None
    if hasattr(value, "model_dump"):
        return value.model_dump(mode="json", by_alias=True)
    if isinstance(value, dict):
        return {key: _serialize_model(item) for key, item in value.items()}
    if isinstance(value, list):
        return [_serialize_model(item) for item in value]
    return value


def _expected_input_language(image_path: Path) -> str:
    return "ja" if "jp" in image_path.stem.lower() else "zh"


def _media_type_for(image_path: Path) -> str:
    guessed_type, _ = mimetypes.guess_type(image_path.name)
    return guessed_type or "application/octet-stream"


def _contains_study_text(value: str | None) -> bool:
    return bool(value and STUDY_TEXT_RE.search(value))


def _selection_payload(analyze_payload: dict[str, Any]) -> dict[str, Any] | None:
    sentences = analyze_payload.get("sentences") or []
    glossary = analyze_payload.get("glossary") or []

    sentence_context = None
    if sentences and isinstance(sentences[0], dict):
        sentence_context = sentences[0].get("hanzi")

    if glossary and isinstance(glossary[0], dict):
        entry = glossary[0]
        text = entry.get("hanzi")
        if isinstance(text, str) and text.strip():
            return {
                "text": text.strip(),
                "scope": "phrase" if len(text.strip()) > 1 else "word",
                "sentenceContext": sentence_context,
            }

    for sentence in sentences:
        if not isinstance(sentence, dict):
            continue
        for token in sentence.get("tokens") or []:
            if not isinstance(token, dict):
                continue
            hanzi = token.get("hanzi")
            if isinstance(hanzi, str) and hanzi.strip() and _contains_study_text(hanzi):
                kind = token.get("kind") or "word"
                scope = "phrase" if kind == "phrase" or len(hanzi.strip()) > 1 else "word"
                return {
                    "text": hanzi.strip(),
                    "scope": scope,
                    "sentenceContext": sentence.get("hanzi") or sentence_context,
                }

    if sentence_context and _contains_study_text(sentence_context):
        return {
            "text": sentence_context,
            "scope": "sentence",
            "sentenceContext": sentence_context,
        }

    return None


class BenchmarkOpenRouterClient(OpenRouterClient):
    def __init__(self, settings: Settings) -> None:
        super().__init__(settings)
        self._active_stage: str | None = None
        self._upstream_calls: list[dict[str, Any]] = []
        self._stage_runs: list[dict[str, Any]] = []

    def clear_traces(self) -> None:
        self._upstream_calls.clear()
        self._stage_runs.clear()

    def snapshot_stage_runs(self) -> list[dict[str, Any]]:
        return json.loads(json.dumps(self._stage_runs, ensure_ascii=False))

    @staticmethod
    def _extract_usage(response_payload: dict[str, Any] | None) -> dict[str, int | None]:
        usage = (response_payload or {}).get("usage") or {}
        prompt_tokens = _pick_first_number(
            usage.get("prompt_tokens"),
            usage.get("promptTokens"),
            usage.get("input_tokens"),
            usage.get("inputTokens"),
        )
        completion_tokens = _pick_first_number(
            usage.get("completion_tokens"),
            usage.get("completionTokens"),
            usage.get("output_tokens"),
            usage.get("outputTokens"),
        )
        total_tokens = _pick_first_number(
            usage.get("total_tokens"),
            usage.get("totalTokens"),
        )
        if total_tokens is None and prompt_tokens is not None and completion_tokens is not None:
            total_tokens = prompt_tokens + completion_tokens

        return {
            "prompt_tokens": prompt_tokens,
            "completion_tokens": completion_tokens,
            "total_tokens": total_tokens,
        }

    async def _post_chat_completion(self, payload: dict[str, Any]) -> dict[str, Any]:
        stage_name = self._active_stage or "unknown"
        model_name = str(payload.get("model", ""))
        started_at = time.perf_counter()
        response_payload: dict[str, Any] | None = None
        error_message: str | None = None

        try:
            response_payload = await super()._post_chat_completion(payload)
            return response_payload
        except Exception as exc:
            error_message = str(exc)
            raise
        finally:
            elapsed = time.perf_counter() - started_at
            usage = self._extract_usage(response_payload)
            self._upstream_calls.append(
                {
                    "stage": stage_name,
                    "model": model_name,
                    "latency_seconds": elapsed,
                    "prompt_tokens": usage["prompt_tokens"],
                    "completion_tokens": usage["completion_tokens"],
                    "total_tokens": usage["total_tokens"],
                    "tokens_per_second": (
                        usage["completion_tokens"] / elapsed
                        if usage["completion_tokens"] is not None and elapsed > 0
                        else None
                    ),
                    "ok": error_message is None,
                    "error": error_message,
                    "response_id": (response_payload or {}).get("id"),
                }
            )

    async def _run_stage(self, stage_name: str, model_name: str, coroutine) -> Any:
        started_at = time.perf_counter()
        previous_stage = self._active_stage
        start_index = len(self._upstream_calls)
        self._active_stage = stage_name
        result: Any = None
        error_message: str | None = None

        try:
            result = await coroutine
            return result
        except Exception as exc:
            error_message = str(exc)
            raise
        finally:
            self._active_stage = previous_stage
            elapsed = time.perf_counter() - started_at
            new_calls = self._upstream_calls[start_index:]
            prompt_tokens = _sum_optional([call.get("prompt_tokens") for call in new_calls])
            completion_tokens = _sum_optional([call.get("completion_tokens") for call in new_calls])
            total_tokens = _sum_optional([call.get("total_tokens") for call in new_calls])
            self._stage_runs.append(
                {
                    "stage": stage_name,
                    "model": model_name,
                    "ok": error_message is None,
                    "error": error_message,
                    "latency_seconds": elapsed,
                    "prompt_tokens": prompt_tokens,
                    "completion_tokens": completion_tokens,
                    "total_tokens": total_tokens,
                    "tokens_per_second": (
                        completion_tokens / elapsed
                        if completion_tokens is not None and elapsed > 0
                        else None
                    ),
                    "upstream_attempts": len(new_calls),
                    "calls": new_calls,
                    "output": _serialize_model(result) if error_message is None else None,
                }
            )

    async def extract_text_from_image(
        self,
        image_bytes: bytes,
        media_type: str,
        input_language: str = "auto",
    ):
        return await self._run_stage(
            stage_name="vision extraction",
            model_name=self._settings.openrouter_vision_model,
            coroutine=super().extract_text_from_image(
                image_bytes=image_bytes,
                media_type=media_type,
                input_language=input_language,
            ),
        )

    async def analyze_text_for_study(
        self,
        document_text: str,
        pronunciation_hints: list[Any],
        input_language: str = "auto",
        output_language: str = "en",
    ):
        return await self._run_stage(
            stage_name="text analysis",
            model_name=self._settings.openrouter_text_model,
            coroutine=super().analyze_text_for_study(
                document_text=document_text,
                pronunciation_hints=pronunciation_hints,
                input_language=input_language,
                output_language=output_language,
            ),
        )

    async def enrich_glossary_terms(
        self,
        document_text: str,
        glossary_terms: list[str],
        source_language: str = "auto",
        output_language: str = "en",
    ):
        return await self._run_stage(
            stage_name="glossary enrichment",
            model_name=self._settings.openrouter_text_model,
            coroutine=super().enrich_glossary_terms(
                document_text=document_text,
                glossary_terms=glossary_terms,
                source_language=source_language,
                output_language=output_language,
            ),
        )

    async def explain_selection(self, payload):
        return await self._run_stage(
            stage_name="selection explanation",
            model_name=self._settings.openrouter_text_model,
            coroutine=super().explain_selection(payload),
        )


def _scenario_rows(results: list[dict[str, Any]]) -> str:
    lines = [
        "| Image | Expected | Toggle | Vision | Text | Analyze | Explain | Detected | Sentences | Glossary | Analyze s | Explain s | Stage tokens | t/s |",
        "| --- | --- | --- | --- | --- | --- | --- | --- | ---: | ---: | ---: | ---: | ---: | ---: |",
    ]

    for result in results:
        analyze_payload = result.get("analyze", {}).get("payload")
        explain_result = result.get("explain")
        analyze_stage_runs = result.get("analyze", {}).get("stage_runs") or []
        total_tokens = _sum_optional([stage.get("total_tokens") for stage in analyze_stage_runs])
        total_completion_tokens = _sum_optional([stage.get("completion_tokens") for stage in analyze_stage_runs])
        total_stage_latency = sum((stage.get("latency_seconds") or 0.0) for stage in analyze_stage_runs)
        tokens_per_second = (
            total_completion_tokens / total_stage_latency
            if total_completion_tokens is not None and total_stage_latency > 0
            else None
        )
        lines.append(
            "| {image} | {expected} | `{toggle}` | `{vision}` | `{text}` | {analyze_status} | {explain_status} | `{detected}` | {sentences} | {glossary} | {analyze_latency} | {explain_latency} | {tokens} | {tps} |".format(
                image=result["image_name"],
                expected=result["expected_language"],
                toggle=result["input_language"],
                vision=result["vision_model"],
                text=result["text_model"],
                analyze_status=result["analyze"]["status_code"],
                explain_status=explain_result["status_code"] if explain_result else "n/a",
                detected=(analyze_payload or {}).get("language", "n/a") if isinstance(analyze_payload, dict) else "n/a",
                sentences=len((analyze_payload or {}).get("sentences") or []) if isinstance(analyze_payload, dict) else 0,
                glossary=len((analyze_payload or {}).get("glossary") or []) if isinstance(analyze_payload, dict) else 0,
                analyze_latency=_round(result["analyze"]["latency_seconds"]),
                explain_latency=_round(explain_result["latency_seconds"]) if explain_result else "n/a",
                tokens=total_tokens if total_tokens is not None else "n/a",
                tps=_round(tokens_per_second),
            )
        )

    return "\n".join(lines)


def _aggregate_by_combo(results: list[dict[str, Any]]) -> list[dict[str, Any]]:
    grouped: dict[tuple[str, str], list[dict[str, Any]]] = {}
    for result in results:
        grouped.setdefault((result["vision_model"], result["text_model"]), []).append(result)

    summary_rows: list[dict[str, Any]] = []
    for (vision_model, text_model), grouped_results in grouped.items():
        analyze_successes = [result for result in grouped_results if result["analyze"]["status_code"] == 200]
        explain_successes = [
            result
            for result in grouped_results
            if result.get("explain") and result["explain"]["status_code"] == 200
        ]
        auto_runs = [result for result in grouped_results if result["input_language"] == "auto"]
        auto_lang_hits = 0
        for result in auto_runs:
            payload = result["analyze"].get("payload")
            if isinstance(payload, dict) and payload.get("language") == result["expected_language"]:
                auto_lang_hits += 1

        sentenceful = 0
        glossaryful = 0
        latencies = []
        tokens = []
        completion_tokens = []
        for result in analyze_successes:
            payload = result["analyze"].get("payload")
            if isinstance(payload, dict):
                if payload.get("sentences"):
                    sentenceful += 1
                if payload.get("glossary"):
                    glossaryful += 1
            latencies.append(result["analyze"]["latency_seconds"])
            for stage in result["analyze"].get("stage_runs") or []:
                if stage.get("total_tokens") is not None:
                    tokens.append(stage["total_tokens"])
                if stage.get("completion_tokens") is not None:
                    completion_tokens.append(stage["completion_tokens"])

        avg_latency = statistics.mean(latencies) if latencies else None
        total_stage_tokens = sum(tokens) if tokens else None
        total_completion = sum(completion_tokens) if completion_tokens else None
        total_stage_latency = sum(latencies) if latencies else None

        summary_rows.append(
            {
                "vision_model": vision_model,
                "text_model": text_model,
                "scenario_count": len(grouped_results),
                "analyze_success_rate": len(analyze_successes) / len(grouped_results) if grouped_results else 0.0,
                "explain_success_rate": len(explain_successes) / len(grouped_results) if grouped_results else 0.0,
                "auto_lang_accuracy": auto_lang_hits / len(auto_runs) if auto_runs else None,
                "sentence_coverage": sentenceful / len(analyze_successes) if analyze_successes else 0.0,
                "glossary_coverage": glossaryful / len(analyze_successes) if analyze_successes else 0.0,
                "avg_analyze_latency_seconds": avg_latency,
                "avg_stage_tokens_per_run": (total_stage_tokens / len(analyze_successes)) if analyze_successes and total_stage_tokens is not None else None,
                "avg_completion_tokens_per_run": (total_completion / len(analyze_successes)) if analyze_successes and total_completion is not None else None,
                "avg_completion_tokens_per_second": (
                    total_completion / total_stage_latency
                    if total_completion is not None and total_stage_latency and total_stage_latency > 0
                    else None
                ),
            }
        )

    summary_rows.sort(
        key=lambda row: (
            row["analyze_success_rate"],
            row["auto_lang_accuracy"] if row["auto_lang_accuracy"] is not None else -1,
            row["sentence_coverage"],
            row["glossary_coverage"],
            -999999 if row["avg_analyze_latency_seconds"] is None else -row["avg_analyze_latency_seconds"],
        ),
        reverse=True,
    )
    return summary_rows


def _summary_table(summary_rows: list[dict[str, Any]]) -> str:
    lines = [
        "| Vision | Text | Runs | Analyze % | Explain % | Auto Lang % | Sentence % | Glossary % | Avg analyze s | Avg stage tokens | Avg t/s |",
        "| --- | --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |",
    ]
    for row in summary_rows:
        lines.append(
            "| `{vision}` | `{text}` | {runs} | {analyze} | {explain} | {auto_lang} | {sentence} | {glossary} | {latency} | {tokens} | {tps} |".format(
                vision=row["vision_model"],
                text=row["text_model"],
                runs=row["scenario_count"],
                analyze=_round(row["analyze_success_rate"] * 100 if row["analyze_success_rate"] is not None else None),
                explain=_round(row["explain_success_rate"] * 100 if row["explain_success_rate"] is not None else None),
                auto_lang=_round(row["auto_lang_accuracy"] * 100 if row["auto_lang_accuracy"] is not None else None),
                sentence=_round(row["sentence_coverage"] * 100 if row["sentence_coverage"] is not None else None),
                glossary=_round(row["glossary_coverage"] * 100 if row["glossary_coverage"] is not None else None),
                latency=_round(row["avg_analyze_latency_seconds"]),
                tokens=_round(row["avg_stage_tokens_per_run"]),
                tps=_round(row["avg_completion_tokens_per_second"]),
            )
        )
    return "\n".join(lines)


def _render_stage_section(stage_runs: list[dict[str, Any]]) -> str:
    if not stage_runs:
        return "_No stage data captured._"

    parts: list[str] = []
    for stage in stage_runs:
        parts.append(
            "- `{stage}` via `{model}`: ok={ok}, attempts={attempts}, latency={latency}s, prompt_tokens={prompt}, completion_tokens={completion}, total_tokens={total}, t/s={tps}".format(
                stage=stage["stage"],
                model=stage["model"],
                ok=stage["ok"],
                attempts=stage["upstream_attempts"],
                latency=_round(stage["latency_seconds"]),
                prompt=stage["prompt_tokens"] if stage["prompt_tokens"] is not None else "n/a",
                completion=stage["completion_tokens"] if stage["completion_tokens"] is not None else "n/a",
                total=stage["total_tokens"] if stage["total_tokens"] is not None else "n/a",
                tps=_round(stage["tokens_per_second"]),
            )
        )
        if stage.get("error"):
            parts.append(f"  error: {stage['error']}")
    return "\n".join(parts)


def _render_detail_sections(results: list[dict[str, Any]]) -> str:
    sections: list[str] = []
    for index, result in enumerate(results, start=1):
        analyze = result["analyze"]
        explain = result.get("explain")
        sections.append(
            "\n".join(
                [
                    f"## {index}. {result['image_name']} | {result['input_language']} | {result['vision_model']} + {result['text_model']}",
                    "",
                    f"- Expected primary language: `{result['expected_language']}`",
                    f"- Analyze endpoint: status={analyze['status_code']}, latency={_round(analyze['latency_seconds'])}s",
                    f"- Explain endpoint: status={explain['status_code'] if explain else 'n/a'}, latency={(_round(explain['latency_seconds']) + 's') if explain else 'n/a'}",
                    "",
                    "### Stages",
                    _render_stage_section(analyze.get("stage_runs") or []),
                    "",
                    "### Vision Output",
                    _json_block(next((stage["output"] for stage in analyze.get("stage_runs") or [] if stage["stage"] == "vision extraction"), None)),
                    "",
                    "### Text Output",
                    _json_block(next((stage["output"] for stage in analyze.get("stage_runs") or [] if stage["stage"] == "text analysis"), None)),
                    "",
                    "### Glossary Enrichment Output",
                    _json_block(next((stage["output"] for stage in analyze.get("stage_runs") or [] if stage["stage"] == "glossary enrichment"), None)),
                    "",
                    "### Analyze Endpoint Output",
                    _json_block(analyze.get("payload")),
                    "",
                    "### Explain Endpoint Output",
                    _json_block(explain.get("payload") if explain else None),
                ]
            )
        )
    return "\n\n".join(sections)


def _recommendation(summary_rows: list[dict[str, Any]]) -> str:
    if not summary_rows:
        return "No successful benchmark rows were produced."

    best = summary_rows[0]
    if best["analyze_success_rate"] <= 0:
        return (
            "No combo completed a successful analyze-image run during this benchmark. "
            "The current evidence points to upstream model-access or quota failures, so there is not enough live data yet "
            "to recommend a reliable winner."
        )
    return (
        "Most consistent combo based on analyze success rate, auto-detect accuracy, sentence coverage, glossary coverage, "
        f"and latency was `{best['vision_model']}` + `{best['text_model']}`. "
        f"It reached analyze success {_round(best['analyze_success_rate'] * 100)}%, "
        f"auto language accuracy {_round(best['auto_lang_accuracy'] * 100 if best['auto_lang_accuracy'] is not None else None)}%, "
        f"and average analyze latency {_round(best['avg_analyze_latency_seconds'])}s."
    )


def _build_markdown_report(
    *,
    results: list[dict[str, Any]],
    output_path: Path,
    vision_models: list[str],
    text_models: list[str],
    generated_at: str,
) -> str:
    summary_rows = _aggregate_by_combo(results)
    image_names = sorted({result["image_name"] for result in results})
    return "\n".join(
        [
            "# Model Test Report",
            "",
            f"- Generated at: `{generated_at}`",
            f"- Output file: `{output_path}`",
            f"- Images: {', '.join(f'`{name}`' for name in image_names)}",
            f"- Vision models: {', '.join(f'`{model}`' for model in vision_models)}",
            f"- Text models: {', '.join(f'`{model}`' for model in text_models)}",
            "- Input-language scenarios per image: `auto` plus the matching explicit hint (`zh` or `ja`)",
            "- Output language: `en`",
            "",
            "## Summary",
            "",
            _summary_table(summary_rows),
            "",
            "## Scenario Table",
            "",
            _scenario_rows(results),
            "",
            "## Recommendation",
            "",
            _recommendation(summary_rows),
            "",
            "## Detailed Runs",
            "",
            _render_detail_sections(results),
        ]
    )


def _write_report_snapshot(
    *,
    results: list[dict[str, Any]],
    output_path: Path,
    vision_models: list[str],
    text_models: list[str],
) -> None:
    report = _build_markdown_report(
        results=results,
        output_path=output_path,
        vision_models=vision_models,
        text_models=text_models,
        generated_at=time.strftime("%Y-%m-%d %H:%M:%S"),
    )
    output_path.write_text(report, encoding="utf-8")


def _iter_image_files(limit_images: int | None) -> list[Path]:
    image_files = sorted(path for path in IMGTEST_DIR.iterdir() if path.is_file())
    if limit_images is not None:
        return image_files[:limit_images]
    return image_files


def _result_sort_key(result: dict[str, Any]) -> tuple[int, str, str, str, str]:
    return (
        int(result.get("sort_index", 0)),
        result.get("vision_model", ""),
        result.get("text_model", ""),
        result.get("image_name", ""),
        result.get("input_language", ""),
    )


def _run_single_scenario(
    *,
    sort_index: int,
    image_path: Path,
    image_bytes: bytes,
    media_type: str,
    expected_language: str,
    input_language: str,
    vision_model: str,
    text_model: str,
    base_settings: Settings,
) -> dict[str, Any]:
    settings = base_settings.model_copy(
        update={
            "openrouter_vision_model": vision_model,
            "openrouter_text_model": text_model,
        }
    )
    benchmark_client = BenchmarkOpenRouterClient(settings)
    app = create_app(settings=settings, openrouter_client=benchmark_client)
    result_row: dict[str, Any] = {
        "sort_index": sort_index,
        "image_name": image_path.name,
        "image_path": str(image_path),
        "expected_language": expected_language,
        "input_language": input_language,
        "vision_model": vision_model,
        "text_model": text_model,
        "analyze": {
            "status_code": 0,
            "latency_seconds": 0.0,
            "payload": {"detail": "scenario did not run"},
            "stage_runs": [],
        },
        "explain": None,
    }

    try:
        with TestClient(app) as test_client:
            benchmark_client.clear_traces()
            analyze_started_at = time.perf_counter()
            analyze_response = test_client.post(
                "/api/v1/analyze-image",
                files={"image": (image_path.name, image_bytes, media_type)},
                data={"input_language": input_language, "output_language": "en"},
            )
            analyze_latency = time.perf_counter() - analyze_started_at
            try:
                analyze_payload: Any = analyze_response.json()
            except Exception:
                analyze_payload = {"raw_text": analyze_response.text}

            result_row["analyze"] = {
                "status_code": analyze_response.status_code,
                "latency_seconds": analyze_latency,
                "payload": analyze_payload,
                "stage_runs": benchmark_client.snapshot_stage_runs(),
            }

            explain_request_payload = (
                _selection_payload(analyze_payload)
                if analyze_response.status_code == 200 and isinstance(analyze_payload, dict)
                else None
            )
            if explain_request_payload is not None:
                benchmark_client.clear_traces()
                explain_started_at = time.perf_counter()
                explain_response = test_client.post(
                    "/api/v1/explain-selection",
                    json=explain_request_payload,
                )
                explain_latency = time.perf_counter() - explain_started_at
                try:
                    explain_payload = explain_response.json()
                except Exception:
                    explain_payload = {"raw_text": explain_response.text}

                result_row["explain"] = {
                    "request_payload": explain_request_payload,
                    "status_code": explain_response.status_code,
                    "latency_seconds": explain_latency,
                    "payload": explain_payload,
                    "stage_runs": benchmark_client.snapshot_stage_runs(),
                }
    except Exception as exc:
        result_row["analyze"] = {
            "status_code": 0,
            "latency_seconds": result_row["analyze"].get("latency_seconds", 0.0),
            "payload": {"fatal_error": str(exc)},
            "stage_runs": benchmark_client.snapshot_stage_runs(),
        }
    finally:
        try:
            import asyncio

            asyncio.run(benchmark_client.close())
        except RuntimeError:
            pass

    return result_row


def run_benchmark(
    *,
    vision_models: list[str],
    text_models: list[str],
    limit_images: int | None,
    output_path: Path,
    concurrency: int,
) -> list[dict[str, Any]]:
    logging.getLogger("app.routes.analyze").disabled = True
    base_settings = get_settings()
    image_files = _iter_image_files(limit_images=limit_images)
    all_results: list[dict[str, Any]] = []
    scenario_specs: list[dict[str, Any]] = []
    sort_index = 0
    for vision_model in vision_models:
        for text_model in text_models:
            for image_path in image_files:
                image_bytes = image_path.read_bytes()
                media_type = _media_type_for(image_path)
                expected_language = _expected_input_language(image_path)
                for input_language in ("auto", expected_language):
                    sort_index += 1
                    scenario_specs.append(
                        {
                            "sort_index": sort_index,
                            "image_path": image_path,
                            "image_bytes": image_bytes,
                            "media_type": media_type,
                            "expected_language": expected_language,
                            "input_language": input_language,
                            "vision_model": vision_model,
                            "text_model": text_model,
                            "base_settings": base_settings,
                        }
                    )

    with concurrent.futures.ThreadPoolExecutor(max_workers=max(1, concurrency)) as executor:
        futures = [executor.submit(_run_single_scenario, **scenario_spec) for scenario_spec in scenario_specs]
        for future in concurrent.futures.as_completed(futures):
            all_results.append(future.result())
            _write_report_snapshot(
                results=sorted(all_results, key=_result_sort_key),
                output_path=output_path,
                vision_models=vision_models,
                text_models=text_models,
            )

    _write_report_snapshot(
        results=sorted(all_results, key=_result_sort_key),
        output_path=output_path,
        vision_models=vision_models,
        text_models=text_models,
    )
    return all_results


def main() -> None:
    parser = argparse.ArgumentParser(description="Benchmark Han Yu Pin Yin OCR study pipeline models.")
    parser.add_argument(
        "--vision-models",
        default=",".join(DEFAULT_VISION_MODELS),
        help="Comma-separated list of vision models to benchmark.",
    )
    parser.add_argument(
        "--text-models",
        default=",".join(DEFAULT_TEXT_MODELS),
        help="Comma-separated list of text models to benchmark.",
    )
    parser.add_argument(
        "--limit-images",
        type=int,
        default=None,
        help="Limit the number of images from imgtest for a shorter dry run.",
    )
    parser.add_argument(
        "--output",
        default=str(DEFAULT_OUTPUT_PATH),
        help="Path for the generated markdown report.",
    )
    parser.add_argument(
        "--concurrency",
        type=int,
        default=8,
        help="Number of scenarios to run at the same time.",
    )
    args = parser.parse_args()

    vision_models = _parse_csv(args.vision_models)
    text_models = _parse_csv(args.text_models)
    output_path = Path(args.output).resolve()

    if not vision_models:
        raise SystemExit("At least one vision model is required.")
    if not text_models:
        raise SystemExit("At least one text model is required.")
    if not IMGTEST_DIR.exists():
        raise SystemExit(f"Image directory does not exist: {IMGTEST_DIR}")

    run_benchmark(
        vision_models=vision_models,
        text_models=text_models,
        limit_images=args.limit_images,
        output_path=output_path,
        concurrency=args.concurrency,
    )


if __name__ == "__main__":
    main()
