package nacholab.iguerendiain.cv.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon

@Composable
fun ClickableImage(
    painter: Painter,
    hoveredColor: Color? = null,
    unhoveredColor: Color? = null,
    modifier: Modifier? = null,
    onClick: (() -> Unit)?
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered = interactionSource.collectIsHoveredAsState()

    val hoverModifier = if (onClick != null) Modifier
        .clickable{ onClick.invoke() }
        .hoverable(interactionSource, true)
        .pointerHoverIcon(PointerIcon.Hand)
    else Modifier

    val colorFilter = if (hoveredColor!=null || unhoveredColor!=null){
        if (isHovered.value && hoveredColor!=null) ColorFilter.tint(hoveredColor)
        else if (!isHovered.value && unhoveredColor!=null) ColorFilter.tint(unhoveredColor)
        else null
    }else null

    Image(
        painter = painter,
        contentDescription = null,
        modifier = hoverModifier.then(modifier?:Modifier),
        colorFilter = colorFilter
    )
}