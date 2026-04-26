package com.hanyupinyin.feature.saved

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hanyupinyin.app.theme.AppCard
import com.hanyupinyin.app.theme.AppCjkFontFamily
import com.hanyupinyin.app.theme.AppPill
import com.hanyupinyin.app.theme.EmptyState
import com.hanyupinyin.app.theme.PrimaryPillButton
import com.hanyupinyin.app.theme.SectionLabel
import com.hanyupinyin.app.theme.SecondaryPillButton
import com.hanyupinyin.app.theme.appColors
import com.hanyupinyin.app.theme.topBorder
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
    onOpenStudy: (String?) -> Unit,
    viewModel: SavedStudiesViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val colors = MaterialTheme.appColors
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var newestFirst by rememberSaveable { mutableStateOf(true) }
    val visibleItems = remember(uiState.items, searchQuery, newestFirst) {
        val filtered = uiState.items.filter { item ->
            val query = searchQuery.trim()
            query.isBlank() ||
                item.title.contains(query, ignoreCase = true) ||
                item.response.documentText.contains(query, ignoreCase = true) ||
                item.response.glossary.any { entry ->
                    entry.hanzi.contains(query, ignoreCase = true) ||
                        entry.meaning.orEmpty().contains(query, ignoreCase = true)
                }
        }
        if (newestFirst) {
            filtered.sortedByDescending { it.savedAtEpochMillis }
        } else {
            filtered.sortedBy { it.savedAtEpochMillis }
        }
    }

    when {
        uiState.isLoading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colors.bg),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(
                    color = colors.accentFg,
                    trackColor = colors.surfaceRaised,
                )
            }
        }

        uiState.items.isEmpty() -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colors.bg),
                contentAlignment = Alignment.Center,
            ) {
                EmptyState(
                    title = "No saved studies yet",
                    body = "Open the reader after an analysis and save the glossary plus parsed text for later review.",
                )
            }
        }

        else -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colors.bg),
                contentPadding = PaddingValues(start = 20.dp, top = 24.dp, end = 20.dp, bottom = 28.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                item {
                    LibraryHeader(
                        newestFirst = newestFirst,
                        onToggleSort = { newestFirst = !newestFirst },
                    )
                }

                item {
                    SearchField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                    )
                }

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
                            title = "Couldn't update library",
                            body = error,
                            isDanger = true,
                        )
                    }
                }

                if (visibleItems.isEmpty()) {
                    item {
                        AppCard(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = "No matches",
                                style = MaterialTheme.typography.titleLarge,
                                color = colors.textPrimary,
                            )
                            Text(
                                text = "Try another saved scan, glossary term, or translation.",
                                style = MaterialTheme.typography.bodyLarge,
                                color = colors.textSecondary,
                            )
                        }
                    }
                }

                items(visibleItems, key = { item -> item.id }) { item ->
                    SavedStudyCard(
                        item = item,
                        onOpenReader = { onOpenReader(item.response) },
                        onOpenStudy = { onOpenStudy(item.id) },
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
private fun LibraryHeader(
    newestFirst: Boolean,
    onToggleSort: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Library",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.appColors.textPrimary,
        )
        Text(
            text = if (newestFirst) "Newest" else "Oldest",
            modifier = Modifier
                .clickable(onClick = onToggleSort)
                .padding(horizontal = 8.dp, vertical = 6.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.appColors.textSecondary,
        )
    }
}

@Composable
private fun SearchField(
    value: String,
    onValueChange: (String) -> Unit,
) {
    val colors = MaterialTheme.appColors

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        textStyle = MaterialTheme.typography.bodyLarge.copy(color = colors.textPrimary),
        cursorBrush = SolidColor(colors.accentFg),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colors.surface, RoundedCornerShape(10.dp))
                    .border(1.dp, colors.border, RoundedCornerShape(10.dp))
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    tint = colors.textMuted,
                )
                Box(modifier = Modifier.weight(1f)) {
                    if (value.isBlank()) {
                        Text(
                            text = "Search saved scans...",
                            style = MaterialTheme.typography.bodyLarge,
                            color = colors.textMuted,
                        )
                    }
                    innerTextField()
                }
            }
        },
    )
}

@Composable
private fun SavedStudyCard(
    item: SavedStudyItem,
    onOpenReader: () -> Unit,
    onOpenStudy: () -> Unit,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.appColors

    AppCard(
        modifier = modifier.fillMaxWidth(),
        padding = PaddingValues(0.dp),
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.Top,
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleLarge.copy(fontFamily = AppCjkFontFamily),
                        fontWeight = FontWeight.Bold,
                        color = colors.textPrimary,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        text = "Saved ${SavedStudyTimeFormatter.format(Instant.ofEpochMilli(item.savedAtEpochMillis))}",
                        style = MaterialTheme.typography.bodySmall,
                        color = colors.textMuted,
                    )
                }
                AppPill(
                    label = "${item.response.glossary.size} cards",
                    selected = true,
                )
                IconButton(onClick = onDelete) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Delete saved study",
                        tint = colors.danger,
                    )
                }
            }
            Text(
                text = item.response.documentText,
                style = MaterialTheme.typography.bodyMedium,
                color = colors.textSecondary,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            if (item.response.glossary.isNotEmpty()) {
                SectionLabel(text = "Glossary")
                Text(
                    text = item.response.glossary.take(5).joinToString(separator = ", ") { entry ->
                        buildString {
                            append(entry.hanzi)
                            entry.meaning?.takeIf { it.isNotBlank() }?.let { meaning ->
                                append(" ($meaning)")
                            }
                        }
                    },
                    style = MaterialTheme.typography.bodyMedium.copy(fontFamily = AppCjkFontFamily),
                    color = colors.textSecondary,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .topBorder(colors.border)
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            PrimaryPillButton(
                text = "Open Reader",
                onClick = onOpenReader,
                modifier = Modifier.weight(1f),
            )
            SecondaryPillButton(
                text = "Flashcards",
                onClick = onOpenStudy,
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
private fun MessageCard(
    title: String,
    body: String,
    isDanger: Boolean = false,
) {
    AppCard(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = if (isDanger) MaterialTheme.appColors.danger else MaterialTheme.appColors.textPrimary,
        )
        Text(
            text = body,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.appColors.textSecondary,
        )
    }
}
