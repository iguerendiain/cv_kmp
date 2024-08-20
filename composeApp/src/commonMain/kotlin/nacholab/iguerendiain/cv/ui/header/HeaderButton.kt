package nacholab.iguerendiain.cv.ui.header

import androidx.compose.foundation.ScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import nacholab.iguerendiain.cv.ui.common.ClickableText

@Composable
fun HeaderButton(text: String, mainContentScrollState: ScrollState, scrollValue: Int) {
    ClickableText(
        text = text.uppercase(),
        unhoveredColor = MaterialTheme.colors.primary,
        hoveredColor = MaterialTheme.colors.primaryVariant,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
    ) {
        GlobalScope.launch {
            mainContentScrollState.scrollTo(scrollValue)
        }
    }
}