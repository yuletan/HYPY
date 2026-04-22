package com.hanyupinyin.feature.saved

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hanyupinyin.core.model.AnalyzeImageResponse
import com.hanyupinyin.core.model.SavedStudyItem
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

private val SavedStudyTimeFormatter: DateTimeFormatter = DateTimeFormatter
    .ofPattern("dd MMM yyyy, HH:mm")
    .withZone(ZoneId.systemDefault())

@Composable
fun SavedRoute(
    onOpenReader: (AnalyzeImageResponse) -> Unit,
    viewModel: SavedStudiesViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when {
        uiState.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator()
            }
        }

        uiState.items.isEmpty() -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text(
                        text = "No saved studies yet",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                    Text(
                        text = "Open the reader after an analysis and save the glossary plus parsed text for later review.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
        }

        else -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                uiState.notice?.let { notice ->
                    item {
                        MessageCard(
                            title = "Saved",
                            body = notice,
                        )
                    }
                }
                uiState.errorMessage?.let { error ->
                    item {
                        MessageCard(
                            title = "Couldn't update saved studies",
                            body = error,
                            titleColor = MaterialTheme.colorScheme.error,
                        )
                    }
                }
                items(uiState.items, key = { item -> item.id }) { item ->
                    SavedStudyCard(
                        item = item,
                        onOpenReader = { onOpenReader(item.response) },
                        onDelete = {
                            viewModel.clearMessages()
                            viewModel.deleteStudy(item.id)
                        },
                    )
                }
            }
        }
    }
}

@Composable
private fun SavedStudyCard(
    item: SavedStudyItem,
    onOpenReader: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Text(
                    text = item.title,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                )
                FilledIconButton(
                    onClick = onDelete,
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer,
                        contentColor = MaterialTheme.colorScheme.onErrorContainer,
                    ),
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Delete saved study",
                    )
                }
            }
            Text(
                text = "Saved ${SavedStudyTimeFormatter.format(Instant.ofEpochMilli(item.savedAtEpochMillis))}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Text(
                text = "Parsed image text",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = item.response.documentText,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 8,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = "Glossary (${item.response.glossary.size})",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = item.response.glossary.joinToString(separator = ", ") { entry ->
                    buildString {
                        append(entry.hanzi)
                        entry.meaning?.takeIf { it.isNotBlank() }?.let { meaning ->
                            append(" ($meaning)")
                        }
                    }
                }.ifBlank { "No saved glossary terms." },
                style = MaterialTheme.typography.bodyMedium,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Button(
                    onClick = onOpenReader,
                    modifier = Modifier.widthIn(min = 180.dp),
                ) {
                    Text("Open reader")
                }
            }
        }
    }
}

@Composable
private fun MessageCard(
    title: String,
    body: String,
    titleColor: Color? = null,
) {
    ElevatedCard {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = titleColor ?: MaterialTheme.colorScheme.primary,
            )
            Text(
                text = body,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }
}
