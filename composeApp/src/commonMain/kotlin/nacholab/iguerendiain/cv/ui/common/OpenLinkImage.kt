package nacholab.iguerendiain.cv.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalUriHandler

@Composable
fun OpenLinkImage(
    painter: Painter,
    hoveredColor: Color? = null,
    unhoveredColor: Color? = null,
    modifier: Modifier? = null,
    url: String?,
) {
    val uriHandler = LocalUriHandler.current

    val onClickEvent = { uriHandler.openUri(url!!) }

    ClickableImage(
        painter = painter,
        modifier = modifier,
        hoveredColor = hoveredColor,
        unhoveredColor = unhoveredColor,
        onClick = if (url?.isNotBlank() == true) onClickEvent else null
    )
}