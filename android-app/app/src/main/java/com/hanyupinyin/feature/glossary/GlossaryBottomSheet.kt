package com.hanyupinyin.feature.glossary

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.hanyupinyin.core.model.GlossaryEntry

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
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = details.pinyin,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
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
            )
        }

        details.exampleSentencePinyin?.takeIf { it.isNotBlank() }?.let { exampleSentencePinyin ->
            GlossarySection(
                title = "Example pinyin",
                body = exampleSentencePinyin,
            )
        }

        details.sentenceContext?.let { sentence ->
            GlossarySection(
                title = "In this sentence",
                body = sentence,
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
    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            Text(
                text = "Glossary",
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = "Tap a term to pin its meaning and pronunciation details in the bottom sheet.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            GlossaryEntryGrid(
                entries = entries,
                onEntryClick = onEntryClick,
            )
        }
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
    val shape = RoundedCornerShape(20.dp)
    val containerColor = when (entry.pinyinSource) {
        "vision_hint" -> MaterialTheme.colorScheme.tertiaryContainer
        "text_model_hint" -> MaterialTheme.colorScheme.secondaryContainer
        else -> MaterialTheme.colorScheme.surfaceVariant
    }

    Column(
        modifier = modifier
            .widthIn(min = 92.dp, max = 172.dp)
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
            text = entry.pinyin,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
        )
        Text(
            text = entry.hanzi,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
        )
        entry.meaning?.takeIf { it.isNotBlank() }?.let { meaning ->
            Text(
                text = meaning,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
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
        MetadataChip(text = details.kindLabel)
        MetadataChip(text = details.pinyinSource.toDisplayLabel())
    }
}

@Composable
private fun MetadataChip(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier
            .clip(RoundedCornerShape(999.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
    )
}

@Composable
private fun GlossarySection(
    title: String,
    body: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Text(
            text = body,
            style = MaterialTheme.typography.bodyLarge,
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
