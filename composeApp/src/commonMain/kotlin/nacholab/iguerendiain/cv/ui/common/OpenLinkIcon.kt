package nacholab.iguerendiain.cv.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler

@Composable
fun OpenLinkIcon(
    image: ImageVector,
    unhoveredColor: Color,
    hoveredColor: Color,
    url: String?,
    modifier: Modifier? = null
) {
    val uriHandler = LocalUriHandler.current

    val onClickEvent = { uriHandler.openUri(url!!) }

    ClickableIcon(
        image = image,
        unhoveredColor = unhoveredColor,
        hoveredColor = hoveredColor,
        modifier = modifier,
        onClick = if (url?.isNotBlank() == true) onClickEvent else null
    )
}