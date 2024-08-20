package nacholab.iguerendiain.cv.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon

@Composable
fun ClickableIcon(
    image: ImageVector,
    unhoveredColor: Color,
    hoveredColor: Color,
    modifier: Modifier? = null,
    onClick: (() -> Unit)?,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered = interactionSource.collectIsHoveredAsState()

    val hoverModifier = if (onClick != null) Modifier
        .clickable{ onClick.invoke() }
        .hoverable(interactionSource, true)
        .pointerHoverIcon(PointerIcon.Hand)
    else Modifier

    Icon(
        imageVector = image,
        tint = if (isHovered.value) hoveredColor else unhoveredColor,
        contentDescription = null,
        modifier = hoverModifier.then(modifier?:Modifier)
    )
}