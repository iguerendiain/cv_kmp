package nacholab.iguerendiain.cv.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun ClickableText(
    text: String,
    fontSize: TextUnit? = null,
    fontWeight: FontWeight? = null,
    unhoveredColor: Color,
    hoveredColor: Color,
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

    Text(
        text = text,
        fontSize = fontSize?:14.sp,
        fontWeight = fontWeight,
        color = if (isHovered.value) hoveredColor else unhoveredColor,
        modifier = hoverModifier.then(modifier?:Modifier)
    )
}