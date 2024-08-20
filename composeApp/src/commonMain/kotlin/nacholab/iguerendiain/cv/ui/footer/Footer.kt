package nacholab.iguerendiain.cv.ui.footer

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import nacholab.iguerendiain.cv.ui.common.ClickableIcon

@Composable
fun Footer(mainContentScrollState: ScrollState) {
    Column{
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
                .height(56.dp)
        ){
            ClickableIcon(
                image = Icons.Default.KeyboardArrowUp,
                hoveredColor = MaterialTheme.colors.primaryVariant,
                unhoveredColor = MaterialTheme.colors.primary,
                modifier = Modifier.size(48.dp)
            ){ GlobalScope.launch { mainContentScrollState.scrollTo(0) } }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondaryVariant)
                .height(8.dp)
        )
    }
}