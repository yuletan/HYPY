package com.hanyupinyin.core.model

private val ToneNumberSyllablePattern = Regex("([A-Za-züÜvV:]+)([1-5])")

fun String.toToneMarkedPinyin(): String {
    return ToneNumberSyllablePattern.replace(this) { match ->
        val syllable = match.groupValues[1]
            .replace("u:", "ü")
            .replace("U:", "Ü")
            .replace("v", "ü")
            .replace("V", "Ü")
        val tone = match.groupValues[2].toIntOrNull() ?: return@replace syllable

        if (tone == 5) {
            syllable
        } else {
            syllable.withToneMark(tone)
        }
    }
}

private fun String.withToneMark(tone: Int): String {
    val markIndex = toneMarkIndex() ?: return this
    val markedVowel = toneMarkedVowel(this[markIndex], tone) ?: return this
    return replaceRange(markIndex, markIndex + 1, markedVowel.toString())
}

private fun String.toneMarkIndex(): Int? {
    listOf('a', 'A', 'e', 'E').forEach { preferred ->
        val index = indexOf(preferred)
        if (index >= 0) {
            return index
        }
    }

    val ouIndex = lowercase().indexOf("ou")
    if (ouIndex >= 0) {
        return ouIndex
    }

    for (index in indices.reversed()) {
        if (this[index] in "aeiouüAEIOUÜ") {
            return index
        }
    }
    return null
}

private fun toneMarkedVowel(vowel: Char, tone: Int): Char? {
    val marks = when (vowel) {
        'a' -> "āáǎà"
        'e' -> "ēéěè"
        'i' -> "īíǐì"
        'o' -> "ōóǒò"
        'u' -> "ūúǔù"
        'ü' -> "ǖǘǚǜ"
        'A' -> "ĀÁǍÀ"
        'E' -> "ĒÉĚÈ"
        'I' -> "ĪÍǏÌ"
        'O' -> "ŌÓǑÒ"
        'U' -> "ŪÚǓÙ"
        'Ü' -> "ǕǗǙǛ"
        else -> return null
    }
    return marks.getOrNull(tone - 1)
}
