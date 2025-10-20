package com.corytheboyd.loggs.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Color palette
data class ColorScheme(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val onPrimary: Color,
    val onBackground: Color,
    val onSurface: Color,
)

// Typography
data class Typography(
    val title: TextStyle,
    val body: TextStyle,
    val button: TextStyle,
)

// Light color scheme
private val LightColorScheme = ColorScheme(
    background = Color(0xFFF5F5F5),
    surface = Color.White,
    primary = Color(0xFF007AFF),
    onPrimary = Color.White,
    onBackground = Color(0xFF1C1C1E),
    onSurface = Color(0xFF1C1C1E),
)

// Dark color scheme
private val DarkColorScheme = ColorScheme(
    background = Color(0xFF1C1C1E),
    surface = Color(0xFF2C2C2E),
    primary = Color(0xFF0A84FF),
    onPrimary = Color.White,
    onBackground = Color(0xFFFFFFFF),
    onSurface = Color(0xFFFFFFFF),
)

// Default typography
private val DefaultTypography = Typography(
    title = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
    ),
    body = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    ),
)

// Composition locals
val LocalColorScheme = staticCompositionLocalOf { LightColorScheme }
val LocalTypography = staticCompositionLocalOf { DefaultTypography }

@Composable
fun AppTheme(
    isDark: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDark) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
        LocalTypography provides DefaultTypography,
    ) {
        content()
    }
}

// Convenience object for accessing theme values
object Theme {
    val colors: ColorScheme
        @Composable
        get() = LocalColorScheme.current

    val typography: Typography
        @Composable
        get() = LocalTypography.current
}