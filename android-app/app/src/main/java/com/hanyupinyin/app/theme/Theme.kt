package com.hanyupinyin.app.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val LightColors = lightColorScheme(
    primary = Color(0xFF0A0A0A),
    onPrimary = Color(0xFFF7F7F7),
    primaryContainer = Color(0xFFEFEFEF),
    onPrimaryContainer = Color(0xFF0A0A0A),
    secondary = Color(0xFF666666),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFEFEFEF),
    onSecondaryContainer = Color(0xFF0A0A0A),
    tertiary = Color(0xFF444444),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFEFEFEF),
    onTertiaryContainer = Color(0xFF0A0A0A),
    background = Color(0xFFF7F7F7),
    onBackground = Color(0xFF0A0A0A),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF0A0A0A),
    surfaceVariant = Color(0xFFEFEFEF),
    onSurfaceVariant = Color(0xFF666666),
    outline = Color(0xFFE2E2E2),
    error = Color(0xFFD93030),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFE7E7),
    onErrorContainer = Color(0xFFD93030),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFFFFFFF),
    onPrimary = Color(0xFF0A0A0A),
    primaryContainer = Color(0xFF1C1C1C),
    onPrimaryContainer = Color(0xFFF5F5F5),
    secondary = Color(0xFF888888),
    onSecondary = Color(0xFF0A0A0A),
    secondaryContainer = Color(0xFF1C1C1C),
    onSecondaryContainer = Color(0xFFF5F5F5),
    tertiary = Color(0xFF444444),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFF1C1C1C),
    onTertiaryContainer = Color(0xFFF5F5F5),
    background = Color(0xFF0A0A0A),
    onBackground = Color(0xFFF5F5F5),
    surface = Color(0xFF141414),
    onSurface = Color(0xFFF5F5F5),
    surfaceVariant = Color(0xFF1C1C1C),
    onSurfaceVariant = Color(0xFF888888),
    outline = Color(0xFF262626),
    error = Color(0xFFFF4444),
    onError = Color(0xFF0A0A0A),
    errorContainer = Color(0xFF2A1515),
    onErrorContainer = Color(0xFFFF4444),
)

@Immutable
data class AppColorTokens(
    val bg: Color,
    val surface: Color,
    val surfaceRaised: Color,
    val border: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textMuted: Color,
    val accentFg: Color,
    val accentBg: Color,
    val accentBgAlpha: Color,
    val accentBtnText: Color,
    val danger: Color,
)

private val LightAppColors = AppColorTokens(
    bg = Color(0xFFF7F7F7),
    surface = Color(0xFFFFFFFF),
    surfaceRaised = Color(0xFFEFEFEF),
    border = Color(0xFFE2E2E2),
    textPrimary = Color(0xFF0A0A0A),
    textSecondary = Color(0xFF666666),
    textMuted = Color(0xFFBBBBBB),
    accentFg = Color(0xFF0A0A0A),
    accentBg = Color(0xFF0A0A0A),
    accentBgAlpha = Color(0x1A0A0A0A),
    accentBtnText = Color(0xFFF7F7F7),
    danger = Color(0xFFD93030),
)

private val DarkAppColors = AppColorTokens(
    bg = Color(0xFF0A0A0A),
    surface = Color(0xFF141414),
    surfaceRaised = Color(0xFF1C1C1C),
    border = Color(0xFF262626),
    textPrimary = Color(0xFFF5F5F5),
    textSecondary = Color(0xFF888888),
    textMuted = Color(0xFF444444),
    accentFg = Color(0xFFFFFFFF),
    accentBg = Color(0xFFFFFFFF),
    accentBgAlpha = Color(0x14FFFFFF),
    accentBtnText = Color(0xFF0A0A0A),
    danger = Color(0xFFFF4444),
)

private val LocalAppColorTokens = staticCompositionLocalOf { LightAppColors }

val MaterialTheme.appColors: AppColorTokens
    @Composable
    @ReadOnlyComposable
    get() = LocalAppColorTokens.current

val AppCjkFontFamily = FontFamily.Monospace

private val HeadingFontFamily = FontFamily.SansSerif
private val BodyFontFamily = FontFamily.SansSerif

private val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = HeadingFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 52.sp,
        lineHeight = 60.sp,
        letterSpacing = (-1.2).sp,
    ),
    displaySmall = TextStyle(
        fontFamily = HeadingFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 42.sp,
        letterSpacing = (-0.5).sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = HeadingFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 34.sp,
        letterSpacing = (-0.4).sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = HeadingFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        lineHeight = 31.sp,
        letterSpacing = (-0.3).sp,
    ),
    titleLarge = TextStyle(
        fontFamily = HeadingFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
        lineHeight = 21.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 22.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 19.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 17.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        lineHeight = 18.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = BodyFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.8.sp,
    ),
)

@Composable
fun HanYuPinYinTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    val appColors = if (darkTheme) DarkAppColors else LightAppColors

    CompositionLocalProvider(LocalAppColorTokens provides appColors) {
        MaterialTheme(
            colorScheme = if (darkTheme) DarkColors else LightColors,
            typography = AppTypography,
            content = content,
        )
    }
}
