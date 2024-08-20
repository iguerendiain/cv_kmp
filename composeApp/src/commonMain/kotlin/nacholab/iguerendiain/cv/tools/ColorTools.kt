package nacholab.iguerendiain.cv.tools

import androidx.compose.ui.graphics.Color

fun Color.invert() = Color(
    red = 1f - red,
    green = 1f - green,
    blue = 1f - blue,
    alpha = alpha
)
