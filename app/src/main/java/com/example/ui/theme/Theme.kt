package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val MountainDarkColorScheme = darkColorScheme(
    primary = RiverCyanLight,
    onPrimary = FrostedGlassCanvas,
    primaryContainer = FrostedCardBgElevated,
    onPrimaryContainer = RiverGlacier,
    secondary = SafetyEmeraldLight,
    onSecondary = FrostedGlassCanvas,
    secondaryContainer = SafetyEmeraldBg.copy(alpha = 0.5f),
    onSecondaryContainer = SafetyEmeraldLight,
    tertiary = WarningAmberLight,
    onTertiary = FrostedGlassCanvas,
    tertiaryContainer = WarningAmberBg.copy(alpha = 0.5f),
    onTertiaryContainer = WarningAmberLight,
    error = HazardRedLight,
    onError = FrostedGlassCanvas,
    errorContainer = HazardRedBg.copy(alpha = 0.5f),
    onErrorContainer = HazardRedLight,
    background = FrostedGlassCanvas,
    onBackground = TextPrimary,
    surface = FrostedGlassSurface,
    onSurface = TextPrimary,
    surfaceVariant = FrostedCardBg,
    onSurfaceVariant = TextSecondary,
    outline = GlassBorderLight,
    outlineVariant = GlassBorderSubtle
)

@Composable
fun MyApplicationTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MountainDarkColorScheme,
        typography = Typography,
        content = content
    )
}
