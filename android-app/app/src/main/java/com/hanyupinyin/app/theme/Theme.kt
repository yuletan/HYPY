package com.hanyupinyin.app.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = Color(0xFF1D6E63),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFBFEDE2),
    onPrimaryContainer = Color(0xFF04211C),
    secondary = Color(0xFF8C5A34),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFF8DDC5),
    onSecondaryContainer = Color(0xFF2F1605),
    tertiary = Color(0xFF496D9A),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFD7E3FF),
    onTertiaryContainer = Color(0xFF031F3F),
    background = Color(0xFFF5F1E8),
    onBackground = Color(0xFF1C1B18),
    surface = Color(0xFFFFFBF4),
    onSurface = Color(0xFF1C1B18),
    surfaceVariant = Color(0xFFE7E1D4),
    onSurfaceVariant = Color(0xFF4D463D),
    outline = Color(0xFF7E766B),
    error = Color(0xFFB3261E),
    onError = Color(0xFFFFFFFF),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF8ED7C8),
    onPrimary = Color(0xFF003730),
    primaryContainer = Color(0xFF005047),
    onPrimaryContainer = Color(0xFFBFEDE2),
    secondary = Color(0xFFE2BE9E),
    onSecondary = Color(0xFF432B17),
    secondaryContainer = Color(0xFF5D412A),
    onSecondaryContainer = Color(0xFFF8DDC5),
    tertiary = Color(0xFFAFC8FB),
    onTertiary = Color(0xFF163255),
    tertiaryContainer = Color(0xFF304A71),
    onTertiaryContainer = Color(0xFFD7E3FF),
    background = Color(0xFF111412),
    onBackground = Color(0xFFE7E2DA),
    surface = Color(0xFF161917),
    onSurface = Color(0xFFE7E2DA),
    surfaceVariant = Color(0xFF373127),
    onSurfaceVariant = Color(0xFFD0C6B8),
    outline = Color(0xFF998F82),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
)

private val AppTypography = Typography()

@Composable
fun HanYuPinYinTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = AppTypography,
        content = content,
    )
}
