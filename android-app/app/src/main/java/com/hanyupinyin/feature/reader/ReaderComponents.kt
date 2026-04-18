package com.hanyupinyin.feature.reader

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hanyupinyin.core.model.AnalyzeImageResponse
import com.hanyupinyin.core.model.StudySentence
import com.hanyupinyin.core.model.StudyToken

@Composable
internal fun ReaderSummaryCard(
    response: AnalyzeImageResponse,
    notice: String?,
    errorMessage: String?,
    onSaveStudy: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val readerPreview = response.sentences.joinToString(separator = "\n") { it.hanzi }
        .ifBlank { response.documentText }

    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "Study Reader",
                style = MaterialTheme.typography.headlineSmall,
            )
            Text(
                text = "${response.sentences.size} sentences in reading order | ${response.glossary.size} glossary terms",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            notice?.let { message ->
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
            errorMessage?.let { message ->
                Text(
                    text = message,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.error,
                )
            }
            Text(
                text = readerPreview,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 4,
                overflow = TextOverflow.Ellipsis,
            )
            Button(onClick = onSaveStudy) {
                Text("Save study")
            }
            if (response.warnings.isEmpty()) {
                Text(
                    text = "Tap any token or glossary term to explore pronunciation and meaning details.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            } else {
                WarningSummary(warnings = response.warnings)
            }
        }
    }
}

@Composable
internal fun ReaderEmptyState(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = "No study content yet",
                style = MaterialTheme.typography.headlineSmall,
            )
            Text(
                text = "Analyze an image to start reading.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
internal fun SentenceCard(
    sentence: StudySentence,
    sentenceNumber: Int,
    onTokenClick: (StudyToken) -> Unit,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            Text(
                text = "Sentence $sentenceNumber",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = sentence.hanzi,
                style = MaterialTheme.typography.headlineSmall,
            )
            if (sentence.pinyin.isNotBlank()) {
                Text(
                    text = sentence.pinyin,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            TokenFlow(
                tokens = sentence.tokens,
                onTokenClick = onTokenClick,
            )
            Text(
                text = "Translation",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Text(
                text = sentence.translation?.takeIf { it.isNotBlank() } ?: "Translation unavailable.",
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun TokenFlow(
    tokens: List<StudyToken>,
    onTokenClick: (StudyToken) -> Unit,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        tokens.forEach { token ->
            TokenPinyinChip(
                token = token,
                onClick = { onTokenClick(token) },
            )
        }
    }
}

@Composable
private fun TokenPinyinChip(
    token: StudyToken,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(20.dp)
    val containerColor = when (token.pinyinSource) {
        "vision_hint" -> MaterialTheme.colorScheme.tertiaryContainer
        "text_model_hint" -> MaterialTheme.colorScheme.secondaryContainer
        else -> MaterialTheme.colorScheme.surfaceVariant
    }

    Column(
        modifier = modifier
            .widthIn(min = 68.dp)
            .clip(shape)
            .background(containerColor)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = shape,
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = token.pinyin,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            lineHeight = 14.sp,
        )
        Text(
            text = token.hanzi,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun WarningSummary(
    warnings: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.errorContainer)
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Text(
            text = "Warnings",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onErrorContainer,
        )
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            warnings.forEach { warning ->
                Text(
                    text = "- $warning",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onErrorContainer,
                )
            }
        }
    }
}
