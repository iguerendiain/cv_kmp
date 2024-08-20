package nacholab.iguerendiain.cv.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import nacholab.iguerendiain.cv.tools.invert

private val darkModePalette = darkColors(
    primary = MainColors.WHITE,
    primaryVariant = MainColors.LIGHT_CYAN,
    secondary = MainColors.GREEN,
    secondaryVariant = MainColors.DARK_CYAN,
    background = MainColors.DARK_GRAY
)

private val lightModePalette = lightColors(
    primary = MainColors.WHITE.invert(),
    primaryVariant = MainColors.LIGHT_CYAN.invert(),
    secondary = MainColors.GREEN.invert(),
    secondaryVariant = MainColors.DARK_CYAN.invert(),
    background = MainColors.DARK_GRAY.invert()
)

@Composable
fun MainTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = when {
            darkTheme -> darkModePalette
            else -> lightModePalette
        },
        content = content
    )
}