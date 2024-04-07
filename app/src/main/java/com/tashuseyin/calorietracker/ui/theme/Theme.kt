package com.tashuseyin.calorietracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.tashuseyin.core_ui.BrightGreen
import com.tashuseyin.core_ui.DarkGray
import com.tashuseyin.core_ui.DarkGreen
import com.tashuseyin.core_ui.LightGray
import com.tashuseyin.core_ui.MediumGray
import com.tashuseyin.core_ui.Orange
import com.tashuseyin.core_ui.TextWhite


private val DarkColorScheme = darkColorScheme(
    primary = BrightGreen,
    primaryContainer = DarkGreen,
    secondary = Orange,
    background = MediumGray,
    onBackground = TextWhite,
    surface = LightGray,
    onSurface = TextWhite,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

private val LightColorScheme = lightColorScheme(
    primary = BrightGreen,
    primaryContainer = DarkGreen,
    secondary = Orange,
    background = Color.White,
    onBackground = DarkGray,
    surface = Color.White,
    onSurface = DarkGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
)


@Composable
fun CalorieTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}