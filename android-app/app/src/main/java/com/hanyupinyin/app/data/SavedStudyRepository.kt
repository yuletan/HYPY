package com.hanyupinyin.app.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.hanyupinyin.core.model.AnalyzeImageResponse
import com.hanyupinyin.core.model.SavedStudyItem
import com.hanyupinyin.core.model.StudyJson
import java.util.UUID
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString

private val Context.savedStudyDataStore by preferencesDataStore(name = "saved_studies")

class SavedStudyRepository(private val context: Context) {
    val savedStudies: Flow<List<SavedStudyItem>> = context.savedStudyDataStore.data.map { preferences ->
        val serialized = preferences[SAVED_STUDIES_KEY] ?: return@map emptyList()
        runCatching {
            StudyJson.decodeFromString<List<SavedStudyItem>>(serialized)
        }.getOrDefault(emptyList())
    }

    suspend fun save(response: AnalyzeImageResponse) {
        context.savedStudyDataStore.edit { preferences ->
            val current = decodeSavedStudies(preferences[SAVED_STUDIES_KEY])
            val deduplicated = current.filterNot { it.response.documentText == response.documentText }
            val savedItem = SavedStudyItem(
                id = UUID.randomUUID().toString(),
                savedAtEpochMillis = System.currentTimeMillis(),
                title = deriveTitle(response),
                response = response,
            )
            preferences[SAVED_STUDIES_KEY] = StudyJson.encodeToString((listOf(savedItem) + deduplicated).take(MAX_SAVED_STUDIES))
        }
    }

    suspend fun delete(savedStudyId: String) {
        context.savedStudyDataStore.edit { preferences ->
            val current = decodeSavedStudies(preferences[SAVED_STUDIES_KEY])
            preferences[SAVED_STUDIES_KEY] = StudyJson.encodeToString(
                current.filterNot { it.id == savedStudyId },
            )
        }
    }

    private fun decodeSavedStudies(serialized: String?): List<SavedStudyItem> {
        if (serialized.isNullOrBlank()) {
            return emptyList()
        }
        return runCatching {
            StudyJson.decodeFromString<List<SavedStudyItem>>(serialized)
        }.getOrDefault(emptyList())
    }

    private fun deriveTitle(response: AnalyzeImageResponse): String {
        val firstChineseSentence = response.sentences.firstOrNull()?.hanzi?.trim().orEmpty()
        if (firstChineseSentence.isNotBlank()) {
            return firstChineseSentence
        }

        return response.documentText
            .lineSequence()
            .map { it.trim() }
            .firstOrNull { it.isNotBlank() }
            ?.take(60)
            ?: "Saved study"
    }

    private companion object {
        val SAVED_STUDIES_KEY = stringPreferencesKey("saved_studies_json")
        const val MAX_SAVED_STUDIES = 25
    }
}
