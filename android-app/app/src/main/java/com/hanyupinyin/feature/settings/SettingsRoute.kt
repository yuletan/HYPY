package com.hanyupinyin.feature.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import com.hanyupinyin.app.theme.AppCard
import com.hanyupinyin.app.theme.SectionLabel
import com.hanyupinyin.app.theme.appColors

@Composable
fun SettingsRoute(viewModel: SettingsViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val colors = MaterialTheme.appColors

    if (uiState.isLoading) {
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
        return
    }

    val settings = uiState.settings

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.bg),
        contentPadding = PaddingValues(start = 20.dp, top = 24.dp, end = 20.dp, bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.headlineSmall,
                color = colors.textPrimary,
            )
        }

        item {
            SettingsGroup(label = "Appearance") {
                SettingToggleRow(
                    iconText = "A",
                    title = "Dark mode",
                    subtitle = "Switch between light and dark",
                    checked = settings.useDarkTheme,
                    onCheckedChange = viewModel::onDarkThemeChanged,
                )
            }
        }

        item {
            SettingsGroup(label = "Languages") {
                LanguageDropdownRow(
                    iconText = "In",
                    title = "Input language",
                    options = StudyPreferences.inputLanguageOptions,
                    selectedCode = settings.inputLanguage,
                    onSelected = viewModel::onInputLanguageChanged,
                )
                LanguageDropdownRow(
                    iconText = "Out",
                    title = "Output language",
                    options = StudyPreferences.outputLanguageOptions,
                    selectedCode = settings.outputLanguage,
                    onSelected = viewModel::onOutputLanguageChanged,
                )
            }
        }

        item {
            SettingsGroup(label = "Reader & Upload") {
                SettingToggleRow(
                    iconText = "R",
                    title = "Auto-open reader",
                    subtitle = "Jump straight to reader after scan",
                    checked = settings.autoOpenReader,
                    onCheckedChange = viewModel::onAutoOpenReaderChanged,
                )
                SettingToggleRow(
                    iconText = "OCR",
                    title = "OCR preview",
                    subtitle = "Show parsed text on the upload success card",
                    checked = settings.showParsedTextPreview,
                    onCheckedChange = viewModel::onShowParsedTextPreviewChanged,
                )
            }
        }

        item {
            SettingsGroup(label = "Diagnostics") {
                SettingToggleRow(
                    iconText = "D",
                    title = "Simulate slower responses",
                    subtitle = "Add a short pause so loading states are easier to review",
                    checked = settings.simulateSlowResponses,
                    onCheckedChange = viewModel::onSimulateSlowResponsesChanged,
                )
            }
        }

        uiState.errorMessage?.let { errorMessage ->
            item {
                AppCard(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Could not update settings",
                        style = MaterialTheme.typography.titleLarge,
                        color = colors.danger,
                    )
                    Text(
                        text = errorMessage,
                        style = MaterialTheme.typography.bodyLarge,
                        color = colors.textSecondary,
                    )
                }
            }
        }
    }
}

@Composable
private fun SettingsGroup(
    label: String,
    content: @Composable ColumnScope.() -> Unit,
) {
    AppCard(
        modifier = Modifier.fillMaxWidth(),
        padding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        SectionLabel(text = label)
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LanguageDropdownRow(
    iconText: String,
    title: String,
    options: List<LanguageOption>,
    selectedCode: String,
    onSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    val selectedOption = options.firstOrNull { it.code == selectedCode } ?: options.first()

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier.fillMaxWidth(),
    ) {
        SettingsRow(
            iconText = iconText,
            title = title,
            subtitle = selectedOption.label,
            trailing = {
                Text(
                    text = ">",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.appColors.textMuted,
                )
            },
            modifier = Modifier
                .menuAnchor(MenuAnchorType.PrimaryNotEditable)
                .clickable { expanded = true },
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            containerColor = MaterialTheme.appColors.surface,
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                            Text(
                                text = option.label,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.appColors.textPrimary,
                            )
                            Text(
                                text = option.description,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.appColors.textSecondary,
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
    iconText: String,
    title: String,
    subtitle: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    val colors = MaterialTheme.appColors

    SettingsRow(
        iconText = iconText,
        title = title,
        subtitle = subtitle,
        trailing = {
            Switch(
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors = SwitchDefaults.colors(
                    checkedThumbColor = colors.accentBtnText,
                    checkedTrackColor = colors.accentBg,
                    checkedBorderColor = colors.accentBg,
                    uncheckedThumbColor = colors.textMuted,
                    uncheckedTrackColor = colors.surfaceRaised,
                    uncheckedBorderColor = colors.border,
                ),
            )
        },
    )
}

@Composable
private fun SettingsRow(
    iconText: String,
    title: String,
    subtitle: String,
    trailing: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MaterialTheme.appColors

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(34.dp)
                .background(colors.surfaceRaised, RoundedCornerShape(9.dp))
                .border(1.dp, colors.border, RoundedCornerShape(9.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = iconText,
                style = MaterialTheme.typography.labelSmall,
                color = colors.textSecondary,
            )
        }
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = colors.textPrimary,
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = colors.textSecondary,
            )
        }
        trailing()
    }
}
