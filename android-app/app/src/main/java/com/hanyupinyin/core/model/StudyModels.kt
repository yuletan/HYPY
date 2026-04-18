package com.hanyupinyin.core.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnalyzeImageResponse(
    @SerialName("documentText") val documentText: String,
    val language: String,
    val sentences: List<StudySentence>,
    val glossary: List<GlossaryEntry>,
    val warnings: List<String>,
)

@Serializable
data class StudySentence(
    val id: String,
    val hanzi: String,
    val pinyin: String,
    val translation: String? = null,
    val tokens: List<StudyToken>,
)

@Serializable
data class StudyToken(
    val id: String,
    val hanzi: String,
    val pinyin: String,
    val meaning: String? = null,
    val kind: String,
    @SerialName("pinyinSource") val pinyinSource: String,
)

@Serializable
data class GlossaryEntry(
    val hanzi: String,
    val pinyin: String,
    val meaning: String? = null,
    @SerialName("exampleSentence") val exampleSentence: String? = null,
    @SerialName("exampleSentencePinyin") val exampleSentencePinyin: String? = null,
    @SerialName("pinyinSource") val pinyinSource: String,
)

@Serializable
data class SavedStudyItem(
    val id: String,
    val savedAtEpochMillis: Long,
    val title: String,
    val response: AnalyzeImageResponse,
)
