package com.hanyupinyin.feature.glossary

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.hanyupinyin.app.theme.AppCard
import com.hanyupinyin.app.theme.AppCjkFontFamily
import com.hanyupinyin.app.theme.AppPill
import com.hanyupinyin.app.theme.SectionLabel
import com.hanyupinyin.app.theme.appColors
import com.hanyupinyin.core.model.GlossaryEntry
import com.hanyupinyin.core.model.toToneMarkedPinyin

data class GlossaryDetails(
    val hanzi: String,
    val pinyin: String,
    val meaning: String?,
    val exampleSentence: String? = null,
    val exampleSentencePinyin: String? = null,
    val kindLabel: String,
    val pinyinSource: String,
    val sentenceContext: String? = null,
    val sentenceTranslation: String? = null,
)

@Composable
fun GlossaryDetailsSheet(
    details: GlossaryDetails,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.appColors

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = details.hanzi,
                style = MaterialTheme.typography.headlineMedium.copy(fontFamily = AppCjkFontFamily),
                fontWeight = FontWeight.Bold,
                color = colors.textPrimary,
            )
            Text(
                text = details.pinyin.toToneMarkedPinyin(),
                style = MaterialTheme.typography.titleMedium.copy(fontFamily = AppCjkFontFamily),
                color = colors.textSecondary,
            )
        }

        GlossaryMetaRow(details = details)

        GlossarySection(
            title = "Literal meaning",
            body = details.meaning?.takeIf { it.isNotBlank() } ?: "Meaning not available yet.",
        )

        details.exampleSentence?.takeIf { it.isNotBlank() }?.let { exampleSentence ->
            GlossarySection(
                title = "Example sentence",
                body = exampleSentence,
                useCjkFont = true,
            )
        }

        details.exampleSentencePinyin?.takeIf { it.isNotBlank() }?.let { exampleSentencePinyin ->
            GlossarySection(
                title = "Example pinyin",
                body = exampleSentencePinyin.toToneMarkedPinyin(),
                useCjkFont = true,
            )
        }

        details.sentenceContext?.let { sentence ->
            GlossarySection(
                title = "In this sentence",
                body = sentence,
                useCjkFont = true,
            )
        }

        details.sentenceTranslation?.takeIf { it.isNotBlank() }?.let { translation ->
            GlossarySection(
                title = "Sentence translation",
                body = translation,
            )
        }
    }
}

@Composable
fun GlossaryPanel(
    entries: List<GlossaryEntry>,
    onEntryClick: (GlossaryEntry) -> Unit,
    modifier: Modifier = Modifier,
) {
    AppCard(
        modifier = modifier.fillMaxWidth(),
        containerColor = MaterialTheme.appColors.accentBgAlpha,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Glossary",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.appColors.textPrimary,
            )
            AppPill(label = "${entries.size} terms")
        }
        Text(
            text = "Tap a term to pin its meaning and pronunciation details in the bottom sheet.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.appColors.textSecondary,
        )
        GlossaryEntryGrid(
            entries = entries,
            onEntryClick = onEntryClick,
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun GlossaryEntryGrid(
    entries: List<GlossaryEntry>,
    onEntryClick: (GlossaryEntry) -> Unit,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        entries.forEach { entry ->
            GlossaryEntryCard(
                entry = entry,
                onClick = { onEntryClick(entry) },
            )
        }
    }
}

@Composable
private fun GlossaryEntryCard(
    entry: GlossaryEntry,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.appColors
    val shape = RoundedCornerShape(10.dp)
    val containerColor = if (entry.pinyinSource == "vision_hint") {
        colors.accentBgAlpha
    } else {
        colors.surfaceRaised
    }

    Column(
        modifier = modifier
            .widthIn(min = 92.dp, max = 172.dp)
            .clip(shape)
            .background(containerColor)
            .border(1.dp, colors.border, shape)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = entry.pinyin.toToneMarkedPinyin(),
            style = MaterialTheme.typography.labelMedium.copy(fontFamily = AppCjkFontFamily),
            color = colors.textSecondary,
        )
        Text(
            text = entry.hanzi,
            style = MaterialTheme.typography.titleMedium.copy(fontFamily = AppCjkFontFamily),
            fontWeight = FontWeight.Bold,
            color = colors.textPrimary,
        )
        entry.meaning?.takeIf { it.isNotBlank() }?.let { meaning ->
            Text(
                text = meaning,
                style = MaterialTheme.typography.bodySmall,
                color = colors.textSecondary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun GlossaryMetaRow(
    details: GlossaryDetails,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        AppPill(label = details.kindLabel)
        AppPill(label = details.pinyinSource.toDisplayLabel())
    }
}

@Composable
private fun GlossarySection(
    title: String,
    body: String,
    modifier: Modifier = Modifier,
    useCjkFont: Boolean = false,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        SectionLabel(text = title)
        Text(
            text = body,
            style = if (useCjkFont) {
                MaterialTheme.typography.bodyLarge.copy(fontFamily = AppCjkFontFamily)
            } else {
                MaterialTheme.typography.bodyLarge
            },
            color = MaterialTheme.appColors.textPrimary,
        )
    }
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
