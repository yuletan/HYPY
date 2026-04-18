package com.hanyupinyin.feature.reader

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hanyupinyin.app.theme.HanYuPinYinTheme
import com.hanyupinyin.core.model.AnalyzeImageResponse
import com.hanyupinyin.core.model.GlossaryEntry
import com.hanyupinyin.core.model.StudySentence
import com.hanyupinyin.core.model.StudyToken
import com.hanyupinyin.core.model.sampleAnalyzeImageResponse
import com.hanyupinyin.feature.glossary.GlossaryDetails
import com.hanyupinyin.feature.glossary.GlossaryDetailsSheet
import com.hanyupinyin.feature.glossary.GlossaryPanel
import com.hanyupinyin.feature.saved.SavedStudiesViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderRoute(
    response: AnalyzeImageResponse?,
    savedStudiesViewModel: SavedStudiesViewModel = viewModel(),
) {
    val savedUiState by savedStudiesViewModel.uiState.collectAsStateWithLifecycle()
    var selectedDetails by remember(response?.documentText) {
        mutableStateOf<GlossaryDetails?>(null)
    }

    Scaffold(containerColor = MaterialTheme.colorScheme.surface) { innerPadding ->
        if (response == null || response.sentences.isEmpty()) {
            ReaderEmptyState(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    ReaderSummaryCard(
                        response = response,
                        notice = savedUiState.notice,
                        errorMessage = savedUiState.errorMessage,
                        onSaveStudy = {
                            savedStudiesViewModel.clearMessages()
                            savedStudiesViewModel.saveStudy(response)
                        },
                    )
                }
                itemsIndexed(
                    items = response.sentences,
                    key = { _, sentence -> sentence.id },
                ) { index, sentence ->
                    SentenceCard(
                        sentence = sentence,
                        sentenceNumber = index + 1,
                            onTokenClick = { token ->
                                selectedDetails = token.toGlossaryDetails(
                                    sentence = sentence,
                                    glossary = response.glossary,
                                )
                            },
                        )
                    }
                if (response.glossary.isNotEmpty()) {
                    item {
                        GlossaryPanel(
                            entries = response.glossary,
                            onEntryClick = { entry ->
                                selectedDetails = entry.toGlossaryDetails()
                            },
                        )
                    }
                }
            }
        }
    }

    selectedDetails?.let { details ->
        ModalBottomSheet(onDismissRequest = { selectedDetails = null }) {
            GlossaryDetailsSheet(
                details = details,
                modifier = Modifier.navigationBarsPadding(),
            )
        }
    }
}

private fun StudyToken.toGlossaryDetails(
    sentence: StudySentence,
    glossary: List<GlossaryEntry>,
): GlossaryDetails {
    val glossaryMatch = glossary.firstOrNull { entry -> entry.hanzi == hanzi }
    return GlossaryDetails(
        hanzi = glossaryMatch?.hanzi ?: hanzi,
        pinyin = glossaryMatch?.pinyin ?: pinyin,
        meaning = glossaryMatch?.meaning ?: meaning,
        exampleSentence = glossaryMatch?.exampleSentence,
        exampleSentencePinyin = glossaryMatch?.exampleSentencePinyin,
        kindLabel = kind.toDisplayLabel(),
        pinyinSource = glossaryMatch?.pinyinSource ?: pinyinSource,
        sentenceContext = sentence.hanzi,
        sentenceTranslation = sentence.translation,
    )
}

private fun GlossaryEntry.toGlossaryDetails(): GlossaryDetails {
    return GlossaryDetails(
        hanzi = hanzi,
        pinyin = pinyin,
        meaning = meaning,
        exampleSentence = exampleSentence,
        exampleSentencePinyin = exampleSentencePinyin,
        kindLabel = "Glossary term",
        pinyinSource = pinyinSource,
    )
}

private fun String.toDisplayLabel(): String {
    return replace('_', ' ').replaceFirstChar { first ->
        if (first.isLowerCase()) {
            first.titlecase()
        } else {
            first.toString()
        }
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 915)
@Composable
private fun ReaderRoutePreview() {
    HanYuPinYinTheme {
        ReaderRoute(response = sampleAnalyzeImageResponse())
    }
}
