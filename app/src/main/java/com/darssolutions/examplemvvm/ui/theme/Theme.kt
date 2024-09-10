package com.darssolutions.examplemvvm.ui.theme
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.darssolutions.examplemvvm.ui.theme.backgroundDark
import com.darssolutions.examplemvvm.ui.theme.backgroundDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.backgroundDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.backgroundLight
import com.darssolutions.examplemvvm.ui.theme.backgroundLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.backgroundLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.errorContainerDark
import com.darssolutions.examplemvvm.ui.theme.errorContainerDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.errorContainerDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.errorContainerLight
import com.darssolutions.examplemvvm.ui.theme.errorContainerLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.errorContainerLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.errorDark
import com.darssolutions.examplemvvm.ui.theme.errorDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.errorDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.errorLight
import com.darssolutions.examplemvvm.ui.theme.errorLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.errorLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.inverseOnSurfaceDark
import com.darssolutions.examplemvvm.ui.theme.inverseOnSurfaceDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.inverseOnSurfaceLight
import com.darssolutions.examplemvvm.ui.theme.inverseOnSurfaceLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.inverseOnSurfaceLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.inversePrimaryDark
import com.darssolutions.examplemvvm.ui.theme.inversePrimaryDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.inversePrimaryDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.inversePrimaryLight
import com.darssolutions.examplemvvm.ui.theme.inversePrimaryLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.inversePrimaryLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.inverseSurfaceDark
import com.darssolutions.examplemvvm.ui.theme.inverseSurfaceDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.inverseSurfaceDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.inverseSurfaceLight
import com.darssolutions.examplemvvm.ui.theme.inverseSurfaceLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.inverseSurfaceLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onBackgroundDark
import com.darssolutions.examplemvvm.ui.theme.onBackgroundDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.onBackgroundDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onBackgroundLight
import com.darssolutions.examplemvvm.ui.theme.onBackgroundLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.onBackgroundLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onErrorContainerDark
import com.darssolutions.examplemvvm.ui.theme.onErrorContainerDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.onErrorContainerDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onErrorContainerLight
import com.darssolutions.examplemvvm.ui.theme.onErrorContainerLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.onErrorContainerLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onErrorDark
import com.darssolutions.examplemvvm.ui.theme.onErrorDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.onErrorDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onErrorLight
import com.darssolutions.examplemvvm.ui.theme.onErrorLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.onErrorLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onPrimaryContainerDark
import com.darssolutions.examplemvvm.ui.theme.onPrimaryContainerDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.onPrimaryContainerDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onPrimaryContainerLight
import com.darssolutions.examplemvvm.ui.theme.onPrimaryContainerLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.onPrimaryContainerLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onPrimaryDark
import com.darssolutions.examplemvvm.ui.theme.onPrimaryDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.onPrimaryDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onPrimaryLight
import com.darssolutions.examplemvvm.ui.theme.onPrimaryLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.onPrimaryLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onSecondaryContainerDark
import com.darssolutions.examplemvvm.ui.theme.onSecondaryContainerDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.onSecondaryContainerDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onSecondaryContainerLight
import com.darssolutions.examplemvvm.ui.theme.onSecondaryContainerLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.onSecondaryContainerLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onSecondaryDark
import com.darssolutions.examplemvvm.ui.theme.onSecondaryDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.onSecondaryDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onSecondaryLight
import com.darssolutions.examplemvvm.ui.theme.onSecondaryLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.onSecondaryLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onSurfaceDark
import com.darssolutions.examplemvvm.ui.theme.onSurfaceDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.onSurfaceDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onSurfaceLight
import com.darssolutions.examplemvvm.ui.theme.onSurfaceLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.onSurfaceLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onSurfaceVariantDark
import com.darssolutions.examplemvvm.ui.theme.onSurfaceVariantDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.onSurfaceVariantDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onSurfaceVariantLight
import com.darssolutions.examplemvvm.ui.theme.onSurfaceVariantLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.onSurfaceVariantLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onTertiaryContainerDark
import com.darssolutions.examplemvvm.ui.theme.onTertiaryContainerDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.onTertiaryContainerDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onTertiaryContainerLight
import com.darssolutions.examplemvvm.ui.theme.onTertiaryContainerLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.onTertiaryContainerLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onTertiaryDark
import com.darssolutions.examplemvvm.ui.theme.onTertiaryDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.onTertiaryDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.onTertiaryLight
import com.darssolutions.examplemvvm.ui.theme.onTertiaryLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.onTertiaryLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.outlineDark
import com.darssolutions.examplemvvm.ui.theme.outlineDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.outlineDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.outlineLight
import com.darssolutions.examplemvvm.ui.theme.outlineLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.outlineLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.outlineVariantDark
import com.darssolutions.examplemvvm.ui.theme.outlineVariantDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.outlineVariantDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.outlineVariantLight
import com.darssolutions.examplemvvm.ui.theme.outlineVariantLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.outlineVariantLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.primaryContainerDark
import com.darssolutions.examplemvvm.ui.theme.primaryContainerDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.primaryContainerDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.primaryContainerLight
import com.darssolutions.examplemvvm.ui.theme.primaryContainerLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.primaryContainerLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.primaryDark
import com.darssolutions.examplemvvm.ui.theme.primaryDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.primaryDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.primaryLight
import com.darssolutions.examplemvvm.ui.theme.primaryLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.primaryLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.scrimDark
import com.darssolutions.examplemvvm.ui.theme.scrimDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.scrimDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.scrimLight
import com.darssolutions.examplemvvm.ui.theme.scrimLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.scrimLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.secondaryContainerDark
import com.darssolutions.examplemvvm.ui.theme.secondaryContainerDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.secondaryContainerDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.secondaryContainerLight
import com.darssolutions.examplemvvm.ui.theme.secondaryContainerLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.secondaryContainerLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.secondaryDark
import com.darssolutions.examplemvvm.ui.theme.secondaryDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.secondaryDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.secondaryLight
import com.darssolutions.examplemvvm.ui.theme.secondaryLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.secondaryLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceBrightDark
import com.darssolutions.examplemvvm.ui.theme.surfaceBrightDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceBrightDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceBrightLight
import com.darssolutions.examplemvvm.ui.theme.surfaceBrightLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceBrightLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerDark
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerHighDark
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerHighDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerHighDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerHighLight
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerHighLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerHighLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerHighestDark
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerHighestDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerHighestLight
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerHighestLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerHighestLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLight
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLowDark
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLowDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLowDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLowLight
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLowLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLowLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLowestDark
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLowestDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLowestLight
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLowestLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceContainerLowestLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceDark
import com.darssolutions.examplemvvm.ui.theme.surfaceDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceDimDark
import com.darssolutions.examplemvvm.ui.theme.surfaceDimDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceDimDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceDimLight
import com.darssolutions.examplemvvm.ui.theme.surfaceDimLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceDimLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceLight
import com.darssolutions.examplemvvm.ui.theme.surfaceLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceVariantDark
import com.darssolutions.examplemvvm.ui.theme.surfaceVariantDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceVariantDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceVariantLight
import com.darssolutions.examplemvvm.ui.theme.surfaceVariantLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.surfaceVariantLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.tertiaryContainerDark
import com.darssolutions.examplemvvm.ui.theme.tertiaryContainerDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.tertiaryContainerDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.tertiaryContainerLight
import com.darssolutions.examplemvvm.ui.theme.tertiaryContainerLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.tertiaryContainerLightMediumContrast
import com.darssolutions.examplemvvm.ui.theme.tertiaryDark
import com.darssolutions.examplemvvm.ui.theme.tertiaryDarkHighContrast
import com.darssolutions.examplemvvm.ui.theme.tertiaryDarkMediumContrast
import com.darssolutions.examplemvvm.ui.theme.tertiaryLight
import com.darssolutions.examplemvvm.ui.theme.tertiaryLightHighContrast
import com.darssolutions.examplemvvm.ui.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      window.statusBarColor = colorScheme.primary.toArgb()
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    }
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}
