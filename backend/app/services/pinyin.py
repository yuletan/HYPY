import re
import unicodedata
from dataclasses import dataclass

from pypinyin import Style, lazy_pinyin

from app.schemas.contracts import PinyinSource, PronunciationHint

_CJK_RE = re.compile(r"[\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff]")


@dataclass(frozen=True)
class ResolvedPinyin:
    text: str
    pinyin: str
    source: PinyinSource


def resolve_phrase_pinyin(text: str, hints: list[PronunciationHint]) -> ResolvedPinyin:
    normalized = text.strip()
    if not normalized:
        return ResolvedPinyin(text=text, pinyin="", source="library")

    for hint in hints:
        if hint.phrase.strip() == normalized:
            formatted_hint = _format_hint_pinyin(hint)
            if formatted_hint:
                source: PinyinSource = "text_model_hint" if _is_text_model_reason(hint.reason) else "vision_hint"
                return ResolvedPinyin(text=text, pinyin=formatted_hint, source=source)

    if _is_punctuation_or_space(normalized):
        return ResolvedPinyin(text=text, pinyin="", source="library")

    syllables = lazy_pinyin(
        normalized,
        style=Style.TONE,
        neutral_tone_with_five=True,
        tone_sandhi=True,
        v_to_u=True,
        errors=lambda value: [value],
    )
    return ResolvedPinyin(text=text, pinyin=_normalize_spacing(" ".join(syllables)), source="library")


def compose_sentence_pinyin(parts: list[ResolvedPinyin]) -> str:
    output: list[str] = []
    for part in parts:
        if not part.pinyin:
            punctuation = part.text.strip()
            if output and punctuation:
                output[-1] = f"{output[-1]}{punctuation}"
            elif punctuation:
                output.append(punctuation)
            continue
        output.append(part.pinyin)
    return " ".join(chunk for chunk in output if chunk).strip()


def _format_hint_pinyin(hint: PronunciationHint) -> str:
    preferred = hint.tone_number_pinyin or hint.preferred_pinyin
    return _tone_numbers_to_marks(_normalize_spacing(preferred))


def _normalize_spacing(value: str) -> str:
    return " ".join(value.split())


def _tone_numbers_to_marks(value: str) -> str:
    return re.sub(r"([A-Za-züÜvV:]+)([1-5])", _mark_tone_match, value)


def _mark_tone_match(match: re.Match[str]) -> str:
    syllable = match.group(1).replace("u:", "ü").replace("U:", "Ü").replace("v", "ü").replace("V", "Ü")
    tone = int(match.group(2))
    if tone == 5:
        return syllable

    tone_vowels = {
        "a": "āáǎà",
        "e": "ēéěè",
        "i": "īíǐì",
        "o": "ōóǒò",
        "u": "ūúǔù",
        "ü": "ǖǘǚǜ",
        "A": "ĀÁǍÀ",
        "E": "ĒÉĚÈ",
        "I": "ĪÍǏÌ",
        "O": "ŌÓǑÒ",
        "U": "ŪÚǓÙ",
        "Ü": "ǕǗǙǛ",
    }
    mark_index = _tone_mark_index(syllable)
    if mark_index is None:
        return syllable

    vowel = syllable[mark_index]
    marked_vowel = tone_vowels.get(vowel, vowel)[tone - 1]
    return f"{syllable[:mark_index]}{marked_vowel}{syllable[mark_index + 1:]}"


def _tone_mark_index(syllable: str) -> int | None:
    for preferred in ("a", "A", "e", "E"):
        index = syllable.find(preferred)
        if index >= 0:
            return index

    lowered = syllable.lower()
    ou_index = lowered.find("ou")
    if ou_index >= 0:
        return ou_index

    for index in range(len(syllable) - 1, -1, -1):
        if syllable[index] in "aeiouüAEIOUÜ":
            return index
    return None


def _is_text_model_reason(reason: str | None) -> bool:
    if not reason:
        return False
    return bool(re.search(r"\btext\b", reason.lower()))


def _is_punctuation_or_space(text: str) -> bool:
    if not text:
        return False
    return all(_is_punctuation_or_space_char(char) for char in text)


def _is_punctuation_or_space_char(char: str) -> bool:
    if char.isspace():
        return True
    if _CJK_RE.search(char):
        return False
    category = unicodedata.category(char)
    return category.startswith("P") or category.startswith("S")
