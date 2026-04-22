package com.hanyupinyin.feature.upload

import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CloudUpload
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.hanyupinyin.app.data.AppSettings
import com.hanyupinyin.app.data.StudyPreferences
import com.hanyupinyin.app.theme.AppCard
import com.hanyupinyin.app.theme.AppCjkFontFamily
import com.hanyupinyin.app.theme.AppPill
import com.hanyupinyin.app.theme.PrimaryPillButton
import com.hanyupinyin.app.theme.SecondaryPillButton
import com.hanyupinyin.app.theme.SectionLabel
import com.hanyupinyin.app.theme.appColors
import com.hanyupinyin.app.theme.monochromeDashedBorder
import com.hanyupinyin.core.model.AnalyzeImageResponse
import com.hanyupinyin.core.model.SavedStudyItem
import com.hanyupinyin.feature.saved.SavedStudiesViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UploadRoute(
    onOpenReader: (AnalyzeImageResponse) -> Unit,
    viewModel: UploadViewModel = viewModel(),
    savedStudiesViewModel: SavedStudiesViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val savedUiState by savedStudiesViewModel.uiState.collectAsStateWithLifecycle()
    val colors = MaterialTheme.appColors
    val context = LocalContext.current
    val selectedImage = uiState.selectedImage
    val pickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) { uri ->
        uri ?: return@rememberLauncherForActivityResult
        viewModel.onImageSelected(
            uri = uri.toString(),
            displayName = context.contentResolver.displayNameFor(uri),
            mimeType = context.contentResolver.getType(uri),
        )
    }
    val successResponse = (uiState.submitState as? UploadSubmitState.Success)?.response
    if (successResponse != null && uiState.settings.autoOpenReader && uiState.autoOpenToken != null) {
        LaunchedEffect(uiState.autoOpenToken) {
            onOpenReader(successResponse)
            viewModel.consumeAutoOpenRequest()
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.bg),
        contentPadding = PaddingValues(start = 20.dp, top = 24.dp, end = 20.dp, bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        item {
            UploadHeader(settings = uiState.settings)
        }

        item {
            UploadPickerCard(
                selectedImage = selectedImage,
                canAnalyze = uiState.canAnalyze,
                onPickImage = { pickerLauncher.launch("image/*") },
                onClear = viewModel::clearSelectedImage,
                onAnalyze = { viewModel.analyzeImage(context.contentResolver) },
            )
        }

        item {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                AppPill(
                    label = "Input",
                    value = StudyPreferences.inputLanguageLabel(uiState.settings.inputLanguage),
                )
                AppPill(
                    label = "Output",
                    value = StudyPreferences.outputLanguageLabel(uiState.settings.outputLanguage),
                )
            }
        }

        if (savedUiState.items.isNotEmpty()) {
            item {
                RecentStudiesRow(
                    items = savedUiState.items.take(2),
                    onOpenReader = { item -> onOpenReader(item.response) },
                )
            }
        }

        if (uiState.submitState !is UploadSubmitState.Empty) {
            item {
                when (val submitState = uiState.submitState) {
                    UploadSubmitState.Empty -> Unit
                    UploadSubmitState.Ready -> StateCard(
                        title = "Ready",
                        body = "The image is selected and ready to submit.",
                    )

                    UploadSubmitState.Loading -> LoadingStateCard()

                    is UploadSubmitState.Error -> ErrorStateCard(
                        message = submitState.message,
                        canRetry = selectedImage != null,
                        onRetry = { viewModel.analyzeImage(context.contentResolver) },
                    )

                    is UploadSubmitState.Success -> SuccessStateCard(
                        response = submitState.response,
                        settings = uiState.settings,
                        onOpenReader = { onOpenReader(submitState.response) },
                    )
                }
            }
        }
    }
}

@Composable
private fun UploadHeader(settings: AppSettings) {
    val colors = MaterialTheme.appColors

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = "Scan & Study",
                style = MaterialTheme.typography.headlineSmall,
                color = colors.textPrimary,
            )
            Text(
                text = "Photo -> reader, glossary, flashcards",
                style = MaterialTheme.typography.bodyMedium,
                color = colors.textSecondary,
            )
        }
        AppPill(
            label = if (settings.simulateSlowResponses) "Slow" else "Live",
            selected = true,
        )
    }
}

@Composable
private fun UploadPickerCard(
    selectedImage: SelectedImage?,
    canAnalyze: Boolean,
    onPickImage: () -> Unit,
    onClear: () -> Unit,
    onAnalyze: () -> Unit,
) {
    val colors = MaterialTheme.appColors
    val uploadShape = RoundedCornerShape(18.dp)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(uploadShape)
            .background(colors.surface, uploadShape)
            .monochromeDashedBorder(colors.border, cornerRadius = 18.dp)
            .clickable(onClick = onPickImage)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp),
    ) {
        if (selectedImage == null) {
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(colors.accentBgAlpha, RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Outlined.CloudUpload,
                    contentDescription = null,
                    tint = colors.accentFg,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "Choose a photo",
                    style = MaterialTheme.typography.titleLarge,
                    color = colors.textPrimary,
                )
                Text(
                    text = "Screenshots, signs, menus - any text",
                    style = MaterialTheme.typography.bodyMedium,
                    color = colors.textSecondary,
                )
            }
            PrimaryPillButton(
                text = "Pick Image",
                onClick = onPickImage,
            )
        } else {
            AsyncImage(
                model = Uri.parse(selectedImage.uri),
                contentDescription = "Selected study image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .border(1.dp, colors.border, RoundedCornerShape(14.dp)),
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = selectedImage.displayName,
                    style = MaterialTheme.typography.titleMedium,
                    color = colors.textPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = selectedImage.mimeType ?: "image/*",
                    style = MaterialTheme.typography.bodySmall,
                    color = colors.textSecondary,
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                PrimaryPillButton(
                    text = "Analyze Image",
                    onClick = onAnalyze,
                    enabled = canAnalyze,
                    modifier = Modifier.weight(2f),
                )
                SecondaryPillButton(
                    text = "Change",
                    onClick = onPickImage,
                    modifier = Modifier.weight(1f),
                )
            }
            SecondaryPillButton(
                text = "Clear image",
                onClick = onClear,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun RecentStudiesRow(
    items: List<SavedStudyItem>,
    onOpenReader: (SavedStudyItem) -> Unit,
) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        SectionLabel(text = "Recent")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items.forEach { item ->
                AppCard(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onOpenReader(item) },
                    padding = PaddingValues(horizontal = 14.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(3.dp),
                ) {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontFamily = AppCjkFontFamily,
                            fontWeight = FontWeight.Bold,
                        ),
                        color = MaterialTheme.appColors.textPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Text(
                        text = "Open reader ->",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.appColors.textSecondary,
                    )
                }
            }
        }
    }
}

@Composable
private fun StateCard(
    title: String,
    body: String,
) {
    AppCard(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.appColors.textPrimary,
        )
        Text(
            text = body,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.appColors.textSecondary,
        )
    }
}

@Composable
private fun LoadingStateCard() {
    AppCard(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.appColors.accentFg,
                trackColor = MaterialTheme.appColors.surfaceRaised,
            )
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = "Loading",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.appColors.textPrimary,
                )
                Text(
                    text = "Uploading the image and waiting for the study response.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.appColors.textSecondary,
                )
            }
        }
    }
}

@Composable
private fun ErrorStateCard(
    message: String,
    canRetry: Boolean,
    onRetry: () -> Unit,
) {
    AppCard(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Error",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.appColors.danger,
        )
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.appColors.textPrimary,
        )
        if (canRetry) {
            SecondaryPillButton(
                text = "Retry upload",
                onClick = onRetry,
            )
        }
    }
}

@Composable
private fun SuccessStateCard(
    response: AnalyzeImageResponse,
    settings: AppSettings,
    onOpenReader: () -> Unit,
) {
    AppCard(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Success",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.appColors.textPrimary,
        )
        Text(
            text = "Parsed ${response.sentences.size} sentence(s), ${response.glossary.size} glossary item(s), and ${response.warnings.size} warning(s).",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.appColors.textSecondary,
        )
        Text(
            text = "Translations and meanings are set to ${StudyPreferences.outputLanguageLabel(settings.outputLanguage)}.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.appColors.textSecondary,
        )
        if (settings.showParsedTextPreview) {
            Text(
                text = response.documentText.take(240).let { preview ->
                    if (response.documentText.length > preview.length) "$preview..." else preview
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.appColors.textSecondary,
            )
        }
        if (!settings.autoOpenReader) {
            PrimaryPillButton(
                text = "Open reader",
                onClick = onOpenReader,
            )
        }
    }
}

private fun ContentResolver.displayNameFor(uri: Uri): String {
    query(uri, arrayOf(OpenableColumns.DISPLAY_NAME), null, null, null)?.use { cursor ->
        val columnIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        if (columnIndex >= 0 && cursor.moveToFirst()) {
            return cursor.getString(columnIndex)
        }
    }
    return uri.lastPathSegment ?: "selected-image"
}
