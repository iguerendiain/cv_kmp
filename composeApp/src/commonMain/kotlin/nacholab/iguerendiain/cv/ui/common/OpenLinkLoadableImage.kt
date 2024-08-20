package nacholab.iguerendiain.cv.ui.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler

@Composable
fun OpenLinkLoadableImage(
    imageUrl: String,
    modifier: Modifier? = null,
    url: String?,
) {
    val uriHandler = LocalUriHandler.current

    val onClickEvent = { uriHandler.openUri(url!!) }

    ClickableLoadableImage(
        url = imageUrl,
        modifier = modifier,
        onClick = if (url?.isNotBlank() == true) onClickEvent else null
    )
}