package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val SpinDarkColorScheme =
    darkColorScheme(
        primary = NeonGold,
        onPrimary = DarkBackground,
        secondary = CyberCyan,
        onSecondary = DarkBackground,
        tertiary = ElectricViolet,
        background = DarkBackground,
        surface = DarkSurface,
        onSurface = TextPrimary,
        onBackground = TextPrimary,
        error = ErrorRed
    )

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = SpinDarkColorScheme,
        typography = Typography,
        content = content
    )
}
