@file:Suppress("FunctionNaming")

package com.roblesdotdev.minicalculator.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme =
    darkColorScheme(
        primary = LightSlateBlue,
        background = Nero,
        primaryContainer = GovernorBay40,
        onPrimaryContainer = White,
        secondaryContainer = SlateGrey,
        tertiaryContainer = White2,
    )

private val LightColorScheme =
    lightColorScheme(
        primary = GovernorBay80,
        background = LavenderBlue,
        primaryContainer = GovernorBay80,
        onPrimaryContainer = White,
        secondaryContainer = ChetBlue,
        tertiaryContainer = GhostWhite,
    )

@Composable
fun MiniCalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content,
    )
}
