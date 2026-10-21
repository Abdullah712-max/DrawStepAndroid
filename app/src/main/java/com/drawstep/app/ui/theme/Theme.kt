package com.drawstep.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColorScheme(
    primary = Violet,
    onPrimary = Color.White,
    secondary = Coral,
    onSecondary = Color(0xFF2B0A14),
    tertiary = ElectricPurple,
    background = Midnight,
    onBackground = Color(0xFFEDEBFF),
    surface = Graphite,
    onSurface = Color(0xFFEDEBFF),
    surfaceVariant = GraphiteLight,
    onSurfaceVariant = Color(0xFFB9B6D6)
)

private val LightColors = lightColorScheme(
    primary = DeepViolet,
    onPrimary = Color.White,
    secondary = Color(0xFFC2325A),
    onSecondary = Color.White,
    tertiary = Color(0xFF8E24D6),
    background = Paper,
    onBackground = Color(0xFF14172B),
    surface = Color.White,
    onSurface = Color(0xFF14172B),
    surfaceVariant = PaperVariant,
    onSurfaceVariant = Color(0xFF4A4766)
)

@Composable
fun DrawStepTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = DrawStepTypography,
        content = content
    )
}
