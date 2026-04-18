package com.hanyupinyin.feature.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hanyupinyin.app.data.LanguageOption
import com.hanyupinyin.app.data.StudyPreferences

@Composable
fun SettingsRoute(viewModel: SettingsViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
        return
    }

    val settings = uiState.settings

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            ElevatedCard {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Text(
                        text = "Make the app feel like yours.",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                    Text(
                        text = "Tune the theme, reading language, and a few reader shortcuts. Backend wiring stays automatic in the background now.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
        }

        item {
            SettingsSectionCard(
                title = "Appearance",
                subtitle = "The top-right button switches modes instantly, and the same preference lives here too.",
            ) {
                SettingToggleRow(
                    title = "Dark mode",
                    subtitle = if (settings.useDarkTheme) {
                        "Use the darker palette across the whole app."
                    } else {
                        "Use the brighter study-friendly palette."
                    },
                    checked = settings.useDarkTheme,
                    onCheckedChange = viewModel::onDarkThemeChanged,
                )
            }
        }

        item {
            SettingsSectionCard(
                title = "Study languages",
                subtitle = "Choose what language is in the photo, then choose the language you want the translations and meanings to use.",
            ) {
                LanguageDropdown(
                    label = "Input language",
                    options = StudyPreferences.inputLanguageOptions,
                    selectedCode = settings.inputLanguage,
                    onSelected = viewModel::onInputLanguageChanged,
                )

                LanguageDropdown(
                    label = "Output language",
                    options = StudyPreferences.outputLanguageOptions,
                    selectedCode = settings.outputLanguage,
                    onSelected = viewModel::onOutputLanguageChanged,
                    modifier = Modifier.padding(top = 8.dp),
                )

                Text(
                    text = if (settings.inputLanguage == settings.outputLanguage) {
                        "When source and output match, the app will fall back to simpler learner-friendly paraphrases."
                    } else {
                        "Sentence translations, token meanings, and glossary meanings will follow the output language."
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        }

        item {
            SettingsSectionCard(
                title = "Reader & upload",
                subtitle = "A few quality-of-life touches for how the app behaves after each scan.",
            ) {
                SettingToggleRow(
                    title = "Open reader automatically",
                    subtitle = "Jump straight into the reader after a successful analysis.",
                    checked = settings.autoOpenReader,
                    onCheckedChange = viewModel::onAutoOpenReaderChanged,
                )
                SettingToggleRow(
                    title = "Show OCR preview on success card",
                    subtitle = "Keep a short parsed-text preview on the upload result card.",
                    checked = settings.showParsedTextPreview,
                    onCheckedChange = viewModel::onShowParsedTextPreviewChanged,
                )
            }
        }

        item {
            SettingsSectionCard(
                title = "Diagnostics",
                subtitle = "A small helper for checking loading states without changing the data source.",
            ) {
                SettingToggleRow(
                    title = "Simulate slower responses",
                    subtitle = "Add a short pause so loading states are easier to review.",
                    checked = settings.simulateSlowResponses,
                    onCheckedChange = viewModel::onSimulateSlowResponsesChanged,
                )
            }
        }

        uiState.errorMessage?.let { errorMessage ->
            item {
                ElevatedCard {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Text(
                            text = "Could not update settings",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.error,
                        )
                        Text(
                            text = errorMessage,
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SettingsSectionCard(
    title: String,
    subtitle: String,
    content: @Composable ColumnScope.() -> Unit,
) {
    ElevatedCard {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            content = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                content()
            },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LanguageDropdown(
    label: String,
    options: List<LanguageOption>,
    selectedCode: String,
    onSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }
    val selectedOption = options.firstOrNull { it.code == selectedCode } ?: options.first()

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier.fillMaxWidth(),
    ) {
        OutlinedTextField(
            value = selectedOption.label,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            label = { Text(label) },
            supportingText = { Text(selectedOption.description) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            Text(
                                text = option.label,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold,
                            )
                            Text(
                                text = option.description,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        }
                    },
                    onClick = {
                        onSelected(option.code)
                        expanded = false
                    },
                )
            }
        }
    }
}

@Composable
private fun SettingToggleRow(
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
        )
    }
}
