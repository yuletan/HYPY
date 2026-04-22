import re
import unicodedata
from dataclasses import dataclass

from pypinyin import Style, lazy_pinyin

from app.schemas.contracts import PinyinSource, PronunciationHint

_CJK_RE = re.compile(r"[\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff]")
_KANA_RE = re.compile(r"[\u3040-\u30ff\uff66-\uff9f]")
_JAPANESE_RE = re.compile(r"[\u3040-\u30ff\uff66-\uff9f\u3400-\u4dbf\u4e00-\u9fff\uf900-\ufaff]")

_BASIC_KANA_ROMAJI = {
    "あ": "a",
    "い": "i",
    "う": "u",
    "え": "e",
    "お": "o",
    "か": "ka",
    "き": "ki",
    "く": "ku",
    "け": "ke",
    "こ": "ko",
    "さ": "sa",
    "し": "shi",
    "す": "su",
    "せ": "se",
    "そ": "so",
    "た": "ta",
    "ち": "chi",
    "つ": "tsu",
    "て": "te",
    "と": "to",
    "な": "na",
    "に": "ni",
    "ぬ": "nu",
    "ね": "ne",
    "の": "no",
    "は": "ha",
    "ひ": "hi",
    "ふ": "fu",
    "へ": "he",
    "ほ": "ho",
    "ま": "ma",
    "み": "mi",
    "む": "mu",
    "め": "me",
    "も": "mo",
    "や": "ya",
    "ゆ": "yu",
    "よ": "yo",
    "ら": "ra",
    "り": "ri",
    "る": "ru",
    "れ": "re",
    "ろ": "ro",
    "わ": "wa",
    "を": "wo",
    "ん": "n",
    "が": "ga",
    "ぎ": "gi",
    "ぐ": "gu",
    "げ": "ge",
    "ご": "go",
    "ざ": "za",
    "じ": "ji",
    "ず": "zu",
    "ぜ": "ze",
    "ぞ": "zo",
    "だ": "da",
    "ぢ": "ji",
    "づ": "zu",
    "で": "de",
    "ど": "do",
    "ば": "ba",
    "び": "bi",
    "ぶ": "bu",
    "べ": "be",
    "ぼ": "bo",
    "ぱ": "pa",
    "ぴ": "pi",
    "ぷ": "pu",
    "ぺ": "pe",
    "ぽ": "po",
    "ぁ": "a",
    "ぃ": "i",
    "ぅ": "u",
    "ぇ": "e",
    "ぉ": "o",
    "ゎ": "wa",
}

_DIGRAPH_KANA_ROMAJI = {
    "きゃ": "kya",
    "きゅ": "kyu",
    "きょ": "kyo",
    "しゃ": "sha",
    "しゅ": "shu",
    "しょ": "sho",
    "ちゃ": "cha",
    "ちゅ": "chu",
    "ちょ": "cho",
    "にゃ": "nya",
    "にゅ": "nyu",
    "にょ": "nyo",
    "ひゃ": "hya",
    "ひゅ": "hyu",
    "ひょ": "hyo",
    "みゃ": "mya",
    "みゅ": "myu",
    "みょ": "myo",
    "りゃ": "rya",
    "りゅ": "ryu",
    "りょ": "ryo",
    "ぎゃ": "gya",
    "ぎゅ": "gyu",
    "ぎょ": "gyo",
    "じゃ": "ja",
    "じゅ": "ju",
    "じょ": "jo",
    "ぢゃ": "ja",
    "ぢゅ": "ju",
    "ぢょ": "jo",
    "びゃ": "bya",
    "びゅ": "byu",
    "びょ": "byo",
    "ぴゃ": "pya",
    "ぴゅ": "pyu",
    "ぴょ": "pyo",
    "ふぁ": "fa",
    "ふぃ": "fi",
    "ふぇ": "fe",
    "ふぉ": "fo",
    "うぃ": "wi",
    "うぇ": "we",
    "ゔぁ": "va",
    "ゔぃ": "vi",
    "ゔ": "vu",
    "ゔぇ": "ve",
    "ゔぉ": "vo",
    "てぃ": "ti",
    "でぃ": "di",
    "とぅ": "tu",
    "どぅ": "du",
}


@dataclass(frozen=True)
class ResolvedPinyin:
    text: str
    pinyin: str
    source: PinyinSource


def resolve_phrase_pinyin(
    text: str,
    hints: list[PronunciationHint],
    language: str | None = None,
) -> ResolvedPinyin:
    normalized = text.strip()
    if not normalized:
        return ResolvedPinyin(text=text, pinyin="", source="library")

    for hint in hints:
        if hint.phrase.strip() == normalized:
            formatted_hint = _format_hint_pronunciation(hint)
            if formatted_hint:
                source: PinyinSource = "text_model_hint" if _is_text_model_reason(hint.reason) else "vision_hint"
                return ResolvedPinyin(text=text, pinyin=formatted_hint, source=source)

    if _is_punctuation_or_space(normalized):
        return ResolvedPinyin(text=text, pinyin="", source="library")

    if _should_use_japanese_romaji(normalized, language):
        return ResolvedPinyin(
            text=text,
            pinyin=_normalize_spacing(_romanize_japanese(normalized)),
            source="library",
        )

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


def is_japanese_study_text(text: str) -> bool:
    return bool(_JAPANESE_RE.search(text))


def contains_kana(text: str) -> bool:
    return bool(_KANA_RE.search(text))


def _format_hint_pronunciation(hint: PronunciationHint) -> str:
    preferred = hint.tone_number_pinyin or hint.preferred_pinyin
    normalized = _normalize_spacing(preferred)
    if _looks_like_tone_number_pinyin(normalized):
        return _tone_numbers_to_marks(normalized)
    return normalized


def _should_use_japanese_romaji(text: str, language: str | None) -> bool:
    if (language or "").lower().startswith("ja"):
        return is_japanese_study_text(text)
    return contains_kana(text)


def _romanize_japanese(text: str) -> str:
    normalized = unicodedata.normalize("NFKC", text)
    romaji_parts: list[str] = []
    current_run: list[str] = []

    def flush_run() -> None:
        if current_run:
            romaji_parts.append(_romanize_kana_run("".join(current_run)))
            current_run.clear()

    for char in normalized:
        if _is_kana_char(char):
            current_run.append(_katakana_to_hiragana(char))
        else:
            flush_run()
            romaji_parts.append(char)

    flush_run()
    return _join_romaji_parts(romaji_parts)


def _romanize_kana_run(text: str) -> str:
    output: list[str] = []
    geminate_next = False
    index = 0

    while index < len(text):
        char = text[index]

        if char == "っ":
            geminate_next = True
            index += 1
            continue

        if char == "ー":
            _extend_previous_vowel(output)
            index += 1
            continue

        romaji = ""
        if index + 1 < len(text):
            pair = text[index : index + 2]
            romaji = _DIGRAPH_KANA_ROMAJI.get(pair, "")
            if romaji:
                index += 2
            else:
                romaji = _BASIC_KANA_ROMAJI.get(char, char)
                index += 1
        else:
            romaji = _BASIC_KANA_ROMAJI.get(char, char)
            index += 1

        if geminate_next and romaji:
            romaji = f"{_geminate_prefix(romaji)}{romaji}"
            geminate_next = False

        output.append(romaji)

    if geminate_next:
        output.append("t")

    return "".join(output)


def _katakana_to_hiragana(char: str) -> str:
    codepoint = ord(char)
    if 0x30A1 <= codepoint <= 0x30F6:
        return chr(codepoint - 0x60)
    return char


def _is_kana_char(char: str) -> bool:
    return bool(_KANA_RE.fullmatch(char))


def _extend_previous_vowel(output: list[str]) -> None:
    if not output:
        return
    for char in reversed(output[-1]):
        if char in "aeiou":
            output[-1] += char
            return


def _geminate_prefix(romaji: str) -> str:
    if romaji.startswith("ch"):
        return "t"
    for char in romaji:
        if char.isalpha():
            return char
    return ""


def _join_romaji_parts(parts: list[str]) -> str:
    output: list[str] = []
    for part in parts:
        if not part:
            continue
        if not output:
            output.append(part)
            continue
        if _needs_space_between(output[-1], part):
            output.append(" ")
        output.append(part)
    return "".join(output)


def _needs_space_between(left: str, right: str) -> bool:
    return bool(left[-1:].isascii() and left[-1:].isalnum() and right[:1].isascii() and right[:1].isalnum())


def _normalize_spacing(value: str) -> str:
    return " ".join(value.split())


def _looks_like_tone_number_pinyin(value: str) -> bool:
    return bool(re.search(r"[A-Za-züÜvV:]+[1-5]\b", value))


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
    if _CJK_RE.search(char) or _KANA_RE.search(char):
        return False
    category = unicodedata.category(char)
    return category.startswith("P") or category.startswith("S")
