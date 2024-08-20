package nacholab.iguerendiain.cv.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon

@Composable
fun ClickableLoadableImage(
    url: String,
    modifier: Modifier? = null,
    onClick: (() -> Unit)?
) {
    val hoverModifier = if (onClick != null) Modifier
        .clickable{ onClick.invoke() }
        .pointerHoverIcon(PointerIcon.Hand)
    else Modifier

    ImgLoadHelper(url, hoverModifier.then(modifier?:Modifier))
}