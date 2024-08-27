package com.nyekilajos.composeappiumtest

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density

@Composable
fun MainTheme(
    content: @Composable () -> Unit
) {
    // providing the manipulated [Density] on top of the Composable hierarchy instead in [com.m.qr.core.ui.compose.component.QRText],
    // because of optimization reasons, to avoid applying [localDensity] every time a [QRText] is used, but to apply once in a composition hierarchy;
    // see [getSizeOfDpValueByCastingToSp]
    CompositionLocalProvider(LocalDensity provides getCustomDensity()) {
        MaterialTheme(
            colorScheme = lightColorScheme,
            shapes = Shapes(),
            content = content
        )
    }
}

@Composable
private fun getCustomDensity(): Density {
    val densityFactor = LocalContext.current.resources.displayMetrics.density

    return Density(
        density = densityFactor,
        fontScale = 1f
    )
}

private val lightColorScheme = ColorScheme(
    primary = Color(0xFF8E2157), // originally 0xFF6750A4 - PaletteTokens.Primary40
    onPrimary = Color(0xFFFFFFFF), // originally 0xFFFFFFFF - PaletteTokens.Primary100
    primaryContainer = Color(0xFFFFFFFF), // originally 0xFFEADDFF - PaletteTokens.Primary90
    onPrimaryContainer = Color(0xFF8E2157), // originally 0xFF21005D - PaletteTokens.Primary10
    inversePrimary = Color(0xFFFFFFFF), // originally 0xFFD0BCFF - PaletteTokens.Primary80

    secondary = Color(0xFF3A35AF), // originally 0xFF625B71 - PaletteTokens.Secondary40
    onSecondary = Color(0xFFFFFFFF), // originally 0xFFFFFFFF - PaletteTokens.Secondary100
    secondaryContainer = Color(0xFFFFFFFF), // originally 0xFFE8DEF8 - PaletteTokens.Secondary90
    onSecondaryContainer = Color(0xFF3A35AF), // originally 0xFF1D192B - PaletteTokens.Secondary10

    tertiary = Color(0xFF4A525D), // originally 0xFF7D5260 - PaletteTokens.Tertiary40
    onTertiary = Color(0xFFDBDEE8), // originally 0xFFFFFFFF - PaletteTokens.Tertiary100
    tertiaryContainer = Color(0xFFFFFFFF), // originally 0xFFFFD8E4 - PaletteTokens.Tertiary90
    onTertiaryContainer = Color(0xFF4A525D), // originally 0xFF31111D - PaletteTokens.Tertiary10

    background = Color(0xFFFFFFFF), // originally 0xFFFFFBFE - PaletteTokens.Neutral99
    onBackground = Color(0xFF1C1B1F), // originally 0xFF1C1B1F - PaletteTokens.Neutral10

    surface = Color(0xFFFFFBFE), // originally 0xFFFFFBFE - PaletteTokens.Neutral99
    onSurface = Color(0xFF1C1B1F), // originally 0xFF1C1B1F - PaletteTokens.Neutral10
    surfaceVariant = Color(0xFFDBDEE8), // originally 0xFFE7E0EC - PaletteTokens.NeutralVariant90
    onSurfaceVariant = Color(0xFF1C1B1F), // originally 0xFF49454F - PaletteTokens.NeutralVariant30
    surfaceTint = Color.Transparent, // originally 0xFF6750A4 - PaletteTokens.Primary40
    inverseSurface = Color(0xFF313033), // originally 0xFF313033 - PaletteTokens.Neutral20
    inverseOnSurface = Color(0xFFF4EFF4), // originally 0xFFF4EFF4 - PaletteTokens.Neutral95

    error = Color(0xFFCC4726), // originally 0xFFB3261E - PaletteTokens.Error40
    onError = Color(0xFFFFFFFF), // originally 0xFFFFFFFF - PaletteTokens.Error100
    errorContainer = Color(0xFFFFFFFF), // originally 0xFFF9DEDC - PaletteTokens.Error90
    onErrorContainer = Color(0xFFCC4726), // originally 0xFF410E0B - PaletteTokens.Error10

    outline = Color(0xFFFFFFFF), // originally 0xFF79747E - PaletteTokens.NeutralVariant50
    outlineVariant = Color(0xFFFFFFFF), // originally 0xFFCAC4D0 - PaletteTokens.NeutralVariant80

    scrim = Color(0xFF000000) // originally 0xFF000000 - PaletteTokens.Neutral0
)

