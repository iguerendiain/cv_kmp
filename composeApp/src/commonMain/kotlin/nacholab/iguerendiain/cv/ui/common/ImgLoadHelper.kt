package nacholab.iguerendiain.cv.ui.common

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import coil3.compose.SubcomposeAsyncImage

@Composable
fun ImgLoadHelper(url: String, modifier: Modifier?=null, colorFilter: ColorFilter? = null){
    SubcomposeAsyncImage(
        modifier = Modifier.then(modifier?:Modifier),
        contentScale = ContentScale.Crop,
        model = url,
        contentDescription = null,
        loading = { CircularProgressIndicator() },
        colorFilter = colorFilter
    )
}