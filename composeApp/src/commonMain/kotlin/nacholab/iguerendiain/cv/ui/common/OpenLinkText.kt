package nacholab.iguerendiain.cv.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun OpenLinkText(
    text: String,
    fontSize: TextUnit? = null,
    fontWeight: FontWeight? = null,
    unhoveredColor: Color,
    hoveredColor: Color,
    modifier: Modifier? = null,
    url: String?,
) {
    val uriHandler = LocalUriHandler.current

    val onClickEvent = { uriHandler.openUri(url!!) }

    ClickableText(
        text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        unhoveredColor = unhoveredColor,
        hoveredColor = hoveredColor,
        modifier = modifier,
        onClick = if (url?.isNotBlank() == true) onClickEvent else null
    )
}