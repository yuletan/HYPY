package com.hanyupinyin.feature.upload

import android.content.ContentResolver
import android.net.Uri
import android.provider.OpenableColumns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.hanyupinyin.app.data.AppSettings
import com.hanyupinyin.app.data.StudyPreferences
import com.hanyupinyin.core.model.AnalyzeImageResponse

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UploadRoute(
    onOpenReader: (AnalyzeImageResponse) -> Unit,
    viewModel: UploadViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
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
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                Text(
                    text = "Turn a photo into something you can actually study.",
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    text = "Pick a photo or screenshot and the app will reshape it into a reader, glossary, and literal meanings.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    PreferenceChip(label = "Live analysis")
                    PreferenceChip(
                        label = "Input: ${StudyPreferences.inputLanguageLabel(uiState.settings.inputLanguage)}",
                    )
                    PreferenceChip(
                        label = "Output: ${StudyPreferences.outputLanguageLabel(uiState.settings.outputLanguage)}",
                    )
                }
            }
        }

        item {
            ElevatedCard(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Text(
                        text = "Image upload",
                        style = MaterialTheme.typography.titleLarge,
                    )

                    if (selectedImage == null) {
                        Text(
                            text = "Choose an image from your device to begin.",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    } else {
                        AsyncImage(
                            model = Uri.parse(selectedImage.uri),
                            contentDescription = "Selected study image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp)
                                .clip(RoundedCornerShape(20.dp)),
                            contentScale = ContentScale.Crop,
                        )
                        Text(
                            text = selectedImage.displayName,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold,
                        )
                        Text(
                            text = selectedImage.mimeType ?: "image/*",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Button(
                            onClick = { pickerLauncher.launch("image/*") },
                            modifier = Modifier.weight(1f),
                        ) {
                            Text(if (selectedImage == null) "Choose image" else "Choose another")
                        }

                        OutlinedButton(
                            onClick = viewModel::clearSelectedImage,
                            enabled = selectedImage != null,
                            modifier = Modifier.weight(1f),
                        ) {
                            Text("Clear")
                        }
                    }

                    Button(
                        onClick = { viewModel.analyzeImage(context.contentResolver) },
                        enabled = uiState.canAnalyze,
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text("Analyze image")
                    }
                }
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
private fun StateCard(
    title: String,
    body: String,
) {
    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = body,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}

@Composable
private fun LoadingStateCard() {
    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CircularProgressIndicator()
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text(
                    text = "Loading",
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = "Uploading the image and waiting for the study response.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
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
    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "Error",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.error,
            )
            Text(
                text = message,
                style = MaterialTheme.typography.bodyLarge,
            )
            if (canRetry) {
                Button(onClick = onRetry) {
                    Text("Retry upload")
                }
            }
        }
    }
}

@Composable
private fun SuccessStateCard(
    response: AnalyzeImageResponse,
    settings: AppSettings,
    onOpenReader: () -> Unit,
) {
    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "Success",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = "Parsed ${response.sentences.size} sentence(s), ${response.glossary.size} glossary item(s), and ${response.warnings.size} warning(s).",
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = "Translations and meanings are set to ${StudyPreferences.outputLanguageLabel(settings.outputLanguage)}.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            if (settings.showParsedTextPreview) {
                Text(
                    text = response.documentText.take(240).let { preview ->
                        if (response.documentText.length > preview.length) "$preview..." else preview
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
            if (!settings.autoOpenReader) {
                Button(onClick = onOpenReader) {
                    Text("Open reader")
                }
            }
        }
    }
}

@Composable
private fun PreferenceChip(label: String) {
    Surface(
        shape = RoundedCornerShape(999.dp),
        color = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            style = MaterialTheme.typography.labelLarge,
        )
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
