package com.hanyupinyin.feature.reader

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.hanyupinyin.app.theme.AppCard
import com.hanyupinyin.app.theme.AppCjkFontFamily
import com.hanyupinyin.app.theme.AppPill
import com.hanyupinyin.app.theme.EmptyState
import com.hanyupinyin.app.theme.PrimaryPillButton
import com.hanyupinyin.app.theme.SectionLabel
import com.hanyupinyin.app.theme.appColors
import com.hanyupinyin.core.model.AnalyzeImageResponse
import com.hanyupinyin.core.model.StudySentence
import com.hanyupinyin.core.model.StudyToken
import com.hanyupinyin.core.model.toToneMarkedPinyin

@Composable
internal fun ReaderSummaryCard(
    response: AnalyzeImageResponse,
    notice: String?,
    errorMessage: String?,
    onSaveStudy: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.appColors
    val readerPreview = response.sentences.joinToString(separator = "\n") { it.hanzi }
        .ifBlank { response.documentText }

    AppCard(
        modifier = modifier.fillMaxWidth(),
        containerColor = colors.accentBgAlpha,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "Study Reader",
                    style = MaterialTheme.typography.headlineSmall,
                    color = colors.textPrimary,
                )
                Text(
                    text = "${response.sentences.size} sentences | ${response.glossary.size} terms",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colors.textSecondary,
                )
            }
            AppPill(label = response.language.uppercase())
        }
        notice?.let { message ->
            Text(
                text = message,
                style = MaterialTheme.typography.bodySmall,
                color = colors.accentFg,
            )
        }
        errorMessage?.let { message ->
            Text(
                text = message,
                style = MaterialTheme.typography.bodySmall,
                color = colors.danger,
            )
        }
        Text(
            text = readerPreview,
            style = MaterialTheme.typography.bodyLarge.copy(fontFamily = AppCjkFontFamily),
            color = colors.textPrimary,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
        )
        PrimaryPillButton(
            text = "Save study",
            onClick = onSaveStudy,
        )
        if (response.warnings.isEmpty()) {
            Text(
                text = "Tap any token or glossary term to explore pronunciation and meaning details.",
                style = MaterialTheme.typography.bodySmall,
                color = colors.textSecondary,
            )
        } else {
            WarningSummary(warnings = response.warnings)
        }
    }
}

@Composable
internal fun ReaderEmptyState(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        EmptyState(
            title = "No study content yet",
            body = "Analyze an image to start reading.",
        )
    }
}

@Composable
internal fun SentenceCard(
    sentence: StudySentence,
    sentenceNumber: Int,
    onTokenClick: (StudyToken) -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.appColors

    AppCard(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SectionLabel(text = "Sentence $sentenceNumber")
            AppPill(label = "${sentence.tokens.size} tokens")
        }
        Text(
            text = sentence.hanzi,
            style = MaterialTheme.typography.headlineSmall.copy(fontFamily = AppCjkFontFamily),
            color = colors.textPrimary,
        )
        if (sentence.pinyin.isNotBlank()) {
            Text(
                text = sentence.pinyin.toToneMarkedPinyin(),
                style = MaterialTheme.typography.bodyMedium.copy(fontFamily = AppCjkFontFamily),
                color = colors.textSecondary,
            )
        }
        TokenFlow(
            tokens = sentence.tokens,
            onTokenClick = onTokenClick,
        )
        SectionLabel(text = "Translation")
        Text(
            text = sentence.translation?.takeIf { it.isNotBlank() } ?: "Translation unavailable.",
            style = MaterialTheme.typography.bodyLarge,
            color = colors.textPrimary,
        )
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
    val colors = MaterialTheme.appColors
    val shape = RoundedCornerShape(10.dp)
    val containerColor = if (token.pinyinSource == "vision_hint") {
        colors.accentBgAlpha
    } else {
        colors.surfaceRaised
    }

    Column(
        modifier = modifier
            .widthIn(min = 68.dp)
            .clip(shape)
            .background(containerColor)
            .border(1.dp, colors.border, shape)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = token.pinyin.toToneMarkedPinyin(),
            style = MaterialTheme.typography.labelMedium.copy(fontFamily = AppCjkFontFamily),
            color = colors.textSecondary,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            lineHeight = 14.sp,
        )
        Text(
            text = token.hanzi,
            style = MaterialTheme.typography.titleLarge.copy(fontFamily = AppCjkFontFamily),
            fontWeight = FontWeight.Bold,
            color = colors.textPrimary,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun WarningSummary(
    warnings: List<String>,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.appColors

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(colors.surfaceRaised)
            .border(1.dp, colors.border, RoundedCornerShape(14.dp))
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Text(
            text = "Warnings",
            style = MaterialTheme.typography.labelLarge,
            color = colors.danger,
        )
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            warnings.forEach { warning ->
                Text(
                    text = "- $warning",
                    style = MaterialTheme.typography.bodySmall,
                    color = colors.textSecondary,
                )
            }
        }
    }
}
