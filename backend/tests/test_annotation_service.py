from pathlib import Path

from app.schemas.contracts import (
    ExplainSelectionRequest,
    ExplainSelectionResult,
    GlossaryDraft,
    GlossaryEnrichmentEntry,
    GlossaryEnrichmentResult,
    PronunciationHint,
    TextAnalysisResult,
    TextSentence,
    TextToken,
    VisionExtractionResult,
)
from app.services.annotation import apply_glossary_enrichment, build_analyze_response, build_explain_response
from app.services.language_options import normalize_input_language
from app.services.pinyin import ResolvedPinyin, compose_sentence_pinyin, resolve_phrase_pinyin

OCR_TEXT_FIXTURE = (Path(__file__).parent / "fixtures" / "ocr_text.txt").read_text(encoding="utf-8")


def test_vision_hint_overrides_polyphonic_phrase() -> None:
    vision = VisionExtractionResult(
        documentText="\u957f\u5927\u4ee5\u540e",
        language="zh-Hans",
        readingLines=["\u957f\u5927\u4ee5\u540e"],
        pronunciationHints=[
            PronunciationHint(
                phrase="\u957f\u5927",
                preferredPinyin="zhang3 da4",
                toneNumberPinyin="zhang3 da4",
                reason="vision context hint",
                confidence=0.95,
            )
        ],
        warnings=[],
    )
    text = TextAnalysisResult(
        sentences=[
            TextSentence(
                hanzi="\u957f\u5927\u4ee5\u540e",
                translation="After growing up",
                tokens=[
                    TextToken(text="\u957f\u5927", kind="phrase", meaning="grow up"),
                    TextToken(text="\u4ee5\u540e", kind="word", meaning="afterwards"),
                ],
            )
        ],
        glossary=[],
        pronunciationHints=[],
    )

    response = build_analyze_response(vision_result=vision, text_result=text)

    assert response.sentences[0].tokens[0].pinyin == "zhǎng dà"
    assert response.sentences[0].tokens[0].pinyin_source == "vision_hint"
    assert response.sentences[0].pinyin.startswith("zhǎng dà")


def test_text_model_hint_takes_precedence_in_selection_explanation() -> None:
    payload = ExplainSelectionRequest(text="\u94f6\u884c\u884c\u957f", scope="phrase")
    result = ExplainSelectionResult(
        text="\u94f6\u884c\u884c\u957f",
        meaning="bank president",
        notes="The last character should be read as zhang3 in this title.",
        examples=["\u4ed6\u662f\u94f6\u884c\u884c\u957f\u3002"],
        pronunciationHints=[
            PronunciationHint(
                phrase="\u94f6\u884c\u884c\u957f",
                preferredPinyin="yin2 hang2 hang2 zhang3",
                toneNumberPinyin="yin2 hang2 hang2 zhang3",
                reason="text model hint",
                confidence=0.9,
            )
        ],
    )

    response = build_explain_response(payload=payload, explanation=result)

    assert response.pinyin == "yín háng háng zhǎng"
    assert response.pinyin_source == "text_model_hint"


def test_kana_romanizes_to_romaji_without_model_hint() -> None:
    assert resolve_phrase_pinyin("\u3042\u308a\u304c\u3068\u3046", [], language="ja").pinyin == "arigatou"
    assert resolve_phrase_pinyin("\u30ab\u30bf\u30ab\u30ca", [], language="ja").pinyin == "katakana"
    assert resolve_phrase_pinyin("\u304d\u3063\u3066", [], language="ja").pinyin == "kitte"


def test_japanese_kanji_uses_romaji_pronunciation_hint() -> None:
    vision = VisionExtractionResult(
        documentText="\u65e5\u672c\u8a9e\u3092\u52c9\u5f37\u3057\u307e\u3059\u3002",
        language="ja",
        readingLines=["\u65e5\u672c\u8a9e\u3092\u52c9\u5f37\u3057\u307e\u3059\u3002"],
        pronunciationHints=[
            PronunciationHint(
                phrase="\u65e5\u672c\u8a9e",
                preferredPinyin="nihongo",
                reason="Japanese kanji reading",
                confidence=0.95,
            ),
            PronunciationHint(
                phrase="\u52c9\u5f37",
                preferredPinyin="benkyou",
                reason="Japanese kanji reading",
                confidence=0.95,
            ),
        ],
        warnings=[],
    )
    text = TextAnalysisResult(
        sentences=[
            TextSentence(
                hanzi="\u65e5\u672c\u8a9e\u3092\u52c9\u5f37\u3057\u307e\u3059\u3002",
                translation="I study Japanese.",
                tokens=[
                    TextToken(text="\u65e5\u672c\u8a9e", kind="word", meaning="Japanese language"),
                    TextToken(text="\u3092", kind="word"),
                    TextToken(text="\u52c9\u5f37", kind="word", meaning="study"),
                    TextToken(text="\u3057\u307e\u3059", kind="word"),
                    TextToken(text="\u3002", kind="punctuation"),
                ],
            )
        ],
        glossary=[],
        pronunciationHints=[],
    )

    response = build_analyze_response(vision_result=vision, text_result=text)

    assert [token.pinyin for token in response.sentences[0].tokens] == ["nihongo", "wo", "benkyou", "shimasu", ""]
    assert response.sentences[0].tokens[0].pinyin_source == "vision_hint"
    assert response.sentences[0].tokens[3].pinyin_source == "library"
    assert response.sentences[0].pinyin == "nihongo wo benkyou shimasu\u3002"


def test_japanese_kana_mislabeled_as_punctuation_is_preserved() -> None:
    vision = VisionExtractionResult(
        documentText="\u65e5\u672c\u8a9e\u3092\u52c9\u5f37\u3057\u307e\u3059\u3002",
        language="ja",
        readingLines=["\u65e5\u672c\u8a9e\u3092\u52c9\u5f37\u3057\u307e\u3059\u3002"],
        pronunciationHints=[
            PronunciationHint(
                phrase="\u65e5\u672c\u8a9e",
                preferredPinyin="nihongo",
                reason="Japanese kanji reading",
                confidence=0.95,
            ),
            PronunciationHint(
                phrase="\u52c9\u5f37",
                preferredPinyin="benkyou",
                reason="Japanese kanji reading",
                confidence=0.95,
            ),
        ],
        warnings=[],
    )
    text = TextAnalysisResult(
        sentences=[
            TextSentence(
                hanzi="\u65e5\u672c\u8a9e\u3092\u52c9\u5f37\u3057\u307e\u3059\u3002",
                translation="I study Japanese.",
                tokens=[
                    TextToken(text="\u65e5\u672c\u8a9e", kind="word", meaning="Japanese language"),
                    TextToken(text="\u3092", kind="punctuation", meaning="object marker"),
                    TextToken(text="\u52c9\u5f37", kind="word", meaning="study"),
                    TextToken(text="\u3057\u307e\u3059", kind="punctuation", meaning="to do"),
                    TextToken(text="\u3002", kind="punctuation"),
                ],
            )
        ],
        glossary=[],
        pronunciationHints=[],
    )

    response = build_analyze_response(vision_result=vision, text_result=text)

    assert [token.hanzi for token in response.sentences[0].tokens] == [
        "\u65e5\u672c\u8a9e",
        "\u3092",
        "\u52c9\u5f37",
        "\u3057\u307e\u3059",
        "\u3002",
    ]
    assert response.sentences[0].tokens[1].kind == "word"
    assert response.sentences[0].tokens[1].meaning == "object marker"
    assert response.sentences[0].tokens[3].kind == "phrase"
    assert response.sentences[0].tokens[3].meaning == "to do"


def test_japanese_input_language_is_supported() -> None:
    assert normalize_input_language("ja") == "ja"


def test_input_language_aliases_are_normalized() -> None:
    assert normalize_input_language("zh-Hans") == "zh"
    assert normalize_input_language("zh_hant") == "zh"
    assert normalize_input_language("Japanese") == "ja"


def test_low_confidence_and_non_matching_hints_fall_back_to_library_pinyin() -> None:
    vision = VisionExtractionResult(
        documentText="\u91cd\u5e86\u5f88\u70ed\u95f9\u3002",
        language="zh-Hans",
        readingLines=["\u91cd\u5e86\u5f88\u70ed\u95f9\u3002"],
        pronunciationHints=[
            PronunciationHint(
                phrase="\u4e0d\u5b58\u5728",
                preferredPinyin="bu4 cun2 zai4",
                toneNumberPinyin="bu4 cun2 zai4",
                reason="vision context hint",
                confidence=0.99,
            ),
            PronunciationHint(
                phrase="\u91cd\u5e86",
                preferredPinyin="zhong4 qing4",
                toneNumberPinyin="zhong4 qing4",
                reason="low confidence hint",
                confidence=0.4,
            ),
        ],
        warnings=[],
    )
    text = TextAnalysisResult(
        sentences=[
            TextSentence(
                hanzi="\u91cd\u5e86\u5f88\u70ed\u95f9\u3002",
                translation="Chongqing is lively.",
                tokens=[
                    TextToken(text="\u91cd\u5e86", kind="word", meaning="Chongqing"),
                    TextToken(text="\u3002", kind="punctuation"),
                ],
            )
        ],
        glossary=[],
        pronunciationHints=[],
    )

    response = build_analyze_response(vision_result=vision, text_result=text)

    assert response.sentences[0].tokens[0].pinyin_source == "library"
    assert response.sentences[0].tokens[0].pinyin


def test_compose_sentence_pinyin_attaches_punctuation_and_mixed_content() -> None:
    parts = [
        ResolvedPinyin(text="\u91cd\u5e86", pinyin="chóng qìng", source="library"),
        ResolvedPinyin(text="\uff0c", pinyin="", source="library"),
        ResolvedPinyin(text="Python 3", pinyin="Python 3", source="library"),
        ResolvedPinyin(text="\uff01", pinyin="", source="library"),
    ]

    assert compose_sentence_pinyin(parts) == "chóng qìng\uff0c Python 3\uff01"


def test_response_assembly_uses_fixture_ocr_text_when_text_model_returns_no_sentences() -> None:
    lines = OCR_TEXT_FIXTURE.splitlines()
    vision = VisionExtractionResult(
        documentText=OCR_TEXT_FIXTURE,
        language="zh-Hans",
        readingLines=lines,
        pronunciationHints=[
            PronunciationHint(
                phrase="\u957f\u5927",
                preferredPinyin="zhang3 da4",
                toneNumberPinyin="zhang3 da4",
                reason="vision context hint",
                confidence=0.92,
            )
        ],
        warnings=[],
    )
    text = TextAnalysisResult(sentences=[], glossary=[], pronunciationHints=[])

    response = build_analyze_response(vision_result=vision, text_result=text)

    assert [sentence.hanzi for sentence in response.sentences] == [
        "\u957f\u5927\u4ee5\u540e\uff0c\u6211\u60f3\u53bb\u91cd\u5e86\u770b\u591c\u666f\u3002",
        "\u5f88\u597d\u73a9\uff01",
    ]
    assert [token.hanzi for token in response.sentences[1].tokens] == ["\u5f88\u597d\u73a9", "\uff01"]
    assert response.sentences[1].tokens[0].pinyin
    assert response.sentences[1].tokens[1].pinyin == ""
    assert response.sentences[1].pinyin.endswith("\uff01")


def test_glossary_entries_are_deduplicated_and_prefer_readable_meaning() -> None:
    vision = VisionExtractionResult(
        documentText="\u957f\u5927\u4ee5\u540e\uff0c\u957f\u5927\u4ee5\u540e\u3002",
        language="zh-Hans",
        readingLines=["\u957f\u5927\u4ee5\u540e\uff0c\u957f\u5927\u4ee5\u540e\u3002"],
        pronunciationHints=[
            PronunciationHint(
                phrase="\u957f\u5927",
                preferredPinyin="zhang3 da4",
                toneNumberPinyin="zhang3 da4",
                reason="vision context hint",
                confidence=0.95,
            )
        ],
        warnings=[],
    )
    text = TextAnalysisResult(
        sentences=[
            TextSentence(
                hanzi="\u957f\u5927\u4ee5\u540e\uff0c\u957f\u5927\u4ee5\u540e\u3002",
                translation="After growing up, after growing up.",
                tokens=[
                    TextToken(text="\u957f\u5927", kind="phrase", meaning="grow"),
                    TextToken(text="\u4ee5\u540e", kind="word", meaning="afterwards"),
                    TextToken(text="\uff0c", kind="punctuation"),
                    TextToken(text="\u957f\u5927", kind="phrase"),
                    TextToken(text="Python 3", kind="other"),
                ],
            )
        ],
        glossary=[
            GlossaryDraft(text="\u957f\u5927", meaning="to grow up"),
            GlossaryDraft(text="\uff0c"),
            GlossaryDraft(text="Python 3"),
        ],
        pronunciationHints=[],
    )

    response = build_analyze_response(vision_result=vision, text_result=text)
    glossary = {entry.hanzi: entry for entry in response.glossary}

    assert glossary["\u957f\u5927"].meaning == "to grow up"
    assert glossary["\u957f\u5927"].pinyin == "zhǎng dà"
    assert "\uff0c" not in glossary
    assert "Python 3" not in glossary


def test_glossary_enrichment_replaces_meaning_and_adds_example_pinyin() -> None:
    vision = VisionExtractionResult(
        documentText="\u7279\u8272\u70e4\u9c7c",
        language="zh-Hans",
        readingLines=["\u7279\u8272\u70e4\u9c7c"],
        pronunciationHints=[],
        warnings=[],
    )
    text = TextAnalysisResult(
        sentences=[],
        glossary=[GlossaryDraft(text="\u7279\u8272\u70e4\u9c7c", meaning="signature fish")],
        pronunciationHints=[],
    )

    response = build_analyze_response(vision_result=vision, text_result=text)
    enriched = apply_glossary_enrichment(
        response=response,
        glossary_enrichment=GlossaryEnrichmentResult(
            entries=[
                GlossaryEnrichmentEntry(
                    text="\u7279\u8272\u70e4\u9c7c",
                    literalMeaning="signature grilled fish",
                    exampleSentence="\u6211\u60f3\u70b9\u7279\u8272\u70e4\u9c7c\u3002",
                )
            ]
        ),
    )

    assert enriched.glossary[0].meaning == "signature grilled fish"
    assert enriched.glossary[0].example_sentence == "\u6211\u60f3\u70b9\u7279\u8272\u70e4\u9c7c\u3002"
    assert enriched.glossary[0].example_sentence_pinyin == "wǒ xiǎng diǎn tè sè kǎo yú\u3002"


def test_mixed_document_prefers_chinese_sentences_for_reader() -> None:
    vision = VisionExtractionResult(
        documentText="Hong Fan Tian Mala hot pot\n\u7279\u8272\u70e4\u9c7c\n1x\u70e4\u7f8a\u6392/\u4efd\nSHOPBACK",
        language="zh-Hans",
        readingLines=["Hong Fan Tian Mala hot pot", "\u7279\u8272\u70e4\u9c7c", "1x\u70e4\u7f8a\u6392/\u4efd", "SHOPBACK"],
        pronunciationHints=[],
        warnings=[],
    )
    text = TextAnalysisResult(sentences=[], glossary=[], pronunciationHints=[])

    response = build_analyze_response(vision_result=vision, text_result=text)

    assert [sentence.hanzi for sentence in response.sentences] == ["\u7279\u8272\u70e4\u9c7c", "\u70e4\u7f8a\u6392/\u4efd"]
    assert response.document_text == "Hong Fan Tian Mala hot pot\n\u7279\u8272\u70e4\u9c7c\n1x\u70e4\u7f8a\u6392/\u4efd\nSHOPBACK"


def test_reader_strips_english_and_numbers_from_mixed_receipt_lines() -> None:
    vision = VisionExtractionResult(
        documentText=(
            "Hong Fan Tian Mala hot pot\n"
            "6\n"
            "TWT1-95941 17/04/2026, 13:32\n"
            "\u9500\u552e : staff\n"
            "\u4eba\u6570 : 1\n"
            "\u7279\u8272\u70e4\u9c7c\n"
            "1x \u70e4\u9c7c(\u9999\u8fa3\u5473)\n"
            "\u9001\u56db\u4e2a\u914d\u83dc\n"
            "\u4e2d\u8fa3Medium\n"
            "spicy\n"
            "\u7279\u8272\u70e4\u4e32\n"
            "1x \u70e4\u7f8a\u6392/\u4efd\n"
            "\u4e3b\u98df\n"
            "2x \u767d\u7c73\u996d\n"
            "\u996e\u6599\u9152\u6c34\n"
            "1x \u738b\u8001\u5409\n"
            "\u603b\u4ea7\u54c1\n"
            "\u5c0f\u8ba1\n"
            "\u603b\u5171\n"
            "SHOPBACK\n"
            "$ 23.80"
        ),
        language="zh-Hans",
        readingLines=[
            "Hong Fan Tian Mala hot pot",
            "6",
            "TWT1-95941 17/04/2026, 13:32",
            "\u9500\u552e : staff",
            "\u4eba\u6570 : 1",
            "\u7279\u8272\u70e4\u9c7c",
            "1x \u70e4\u9c7c(\u9999\u8fa3\u5473)",
            "\u9001\u56db\u4e2a\u914d\u83dc",
            "\u4e2d\u8fa3Medium",
            "spicy",
            "\u7279\u8272\u70e4\u4e32",
            "1x \u70e4\u7f8a\u6392/\u4efd",
            "\u4e3b\u98df",
            "2x \u767d\u7c73\u996d",
            "\u996e\u6599\u9152\u6c34",
            "1x \u738b\u8001\u5409",
            "\u603b\u4ea7\u54c1",
            "\u5c0f\u8ba1",
            "\u603b\u5171",
            "SHOPBACK",
            "$ 23.80",
        ],
        pronunciationHints=[
            PronunciationHint(
                phrase="SHOPBACK",
                preferredPinyin="SHOU BACK",
                toneNumberPinyin="SHOU BACK",
                reason="brand name",
                confidence=0.9,
            )
        ],
        warnings=[],
    )
    text = TextAnalysisResult(sentences=[], glossary=[], pronunciationHints=[])

    response = build_analyze_response(vision_result=vision, text_result=text)

    assert [sentence.hanzi for sentence in response.sentences] == [
        "\u9500\u552e",
        "\u4eba\u6570",
        "\u7279\u8272\u70e4\u9c7c",
        "\u70e4\u9c7c(\u9999\u8fa3\u5473)",
        "\u9001\u56db\u4e2a\u914d\u83dc",
        "\u4e2d\u8fa3",
        "\u7279\u8272\u70e4\u4e32",
        "\u70e4\u7f8a\u6392/\u4efd",
        "\u4e3b\u98df",
        "\u767d\u7c73\u996d",
        "\u996e\u6599\u9152\u6c34",
        "\u738b\u8001\u5409",
        "\u603b\u4ea7\u54c1",
        "\u5c0f\u8ba1",
        "\u603b\u5171",
    ]


def test_glossary_stays_chinese_only_even_when_vision_hints_include_english() -> None:
    vision = VisionExtractionResult(
        documentText="\u9500\u552e : staff\n1x \u738b\u8001\u5409\nSHOPBACK",
        language="zh-Hans",
        readingLines=["\u9500\u552e : staff", "1x \u738b\u8001\u5409", "SHOPBACK"],
        pronunciationHints=[
            PronunciationHint(
                phrase="SHOPBACK",
                preferredPinyin="SHOU BACK",
                toneNumberPinyin="SHOU BACK",
                reason="brand name",
                confidence=0.9,
            )
        ],
        warnings=[],
    )
    text = TextAnalysisResult(sentences=[], glossary=[], pronunciationHints=[])

    response = build_analyze_response(vision_result=vision, text_result=text)

    assert [entry.hanzi for entry in response.glossary] == ["\u9500\u552e", "\u738b\u8001\u5409"]


def test_noisy_translation_is_removed_from_reader_output() -> None:
    vision = VisionExtractionResult(
        documentText="\u7279\u8272\u70e4\u9c7c",
        language="zh-Hans",
        readingLines=["\u7279\u8272\u70e4\u9c7c"],
        pronunciationHints=[],
        warnings=[],
    )
    text = TextAnalysisResult(
        sentences=[
            TextSentence(
                hanzi="\u7279\u8272\u70e4\u9c7c",
                translation="Return JSON only. Reading order preserved. Tokens: word, phrase, punctuation.",
                tokens=[TextToken(text="\u7279\u8272\u70e4\u9c7c", kind="phrase", meaning="signature grilled fish")],
            )
        ],
        glossary=[],
        pronunciationHints=[],
    )

    response = build_analyze_response(vision_result=vision, text_result=text)

    assert response.sentences[0].translation is None


def test_noisy_translation_keeps_short_english_lead_in() -> None:
    vision = VisionExtractionResult(
        documentText="\u7279\u8272\u70e4\u9c7c",
        language="zh-Hans",
        readingLines=["\u7279\u8272\u70e4\u9c7c"],
        pronunciationHints=[],
        warnings=[],
    )
    text = TextAnalysisResult(
        sentences=[
            TextSentence(
                hanzi="\u7279\u8272\u70e4\u9c7c",
                translation=(
                    "Signature grilled fish. \u8425\u517b\u63d0\u793a\uff1a\u70e4\u9c7c\u86cb\u767d\u8d28\u4e30\u5bcc "
                    "(ying yang ti shi: grilled fish is rich in protein)."
                ),
                tokens=[TextToken(text="\u7279\u8272\u70e4\u9c7c", kind="phrase", meaning="signature grilled fish")],
            )
        ],
        glossary=[],
        pronunciationHints=[],
    )

    response = build_analyze_response(vision_result=vision, text_result=text)

    assert response.sentences[0].translation == "Signature grilled fish."
