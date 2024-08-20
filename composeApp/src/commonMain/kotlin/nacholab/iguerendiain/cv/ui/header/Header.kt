package nacholab.iguerendiain.cv.ui.header

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ignacioguerendiaincv.composeapp.generated.resources.Res
import ignacioguerendiaincv.composeapp.generated.resources.ic_download_pdf_dark
import ignacioguerendiaincv.composeapp.generated.resources.ic_download_pdf_light
import ignacioguerendiaincv.composeapp.generated.resources.ic_language
import nacholab.iguerendiain.cv.model.NavBarData
import nacholab.iguerendiain.cv.ui.common.BASE_URL
import nacholab.iguerendiain.cv.ui.common.ClickableImage
import nacholab.iguerendiain.cv.ui.common.KEY_TITLE
import nacholab.iguerendiain.cv.ui.common.OpenLinkImage
import nacholab.iguerendiain.cv.ui.common.RESPONSIVE_WIDTH_THRESHOLD
import org.jetbrains.compose.resources.painterResource

@Composable
fun Header(
    data: NavBarData,
    language: String,
    screenWidth: Dp,
    mainContentScrollState: ScrollState,
    cvPosition: Float,
    contactPosition: Float,
    onLanguageDialogToggle: ()-> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondaryVariant)
            .height(12.dp)
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .height(56.dp)
    ) {
        data.title[language]?.let { Text(
            text = it,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary
        ) }

        if (screenWidth > RESPONSIVE_WIDTH_THRESHOLD) {
            data.menu.let { menu ->
                menu.portfolio[KEY_TITLE]?.get(language)
                    ?.let { HeaderButton(it, mainContentScrollState, 0) }
                menu.cv[KEY_TITLE]?.get(language)
                    ?.let { HeaderButton(it, mainContentScrollState, cvPosition.toInt()) }
                menu.contact[KEY_TITLE]?.get(language)
                    ?.let { HeaderButton(it, mainContentScrollState, contactPosition.toInt()) }
            }
        }

        OpenLinkImage(
            painterResource(
                if (MaterialTheme.colors.isLight) Res.drawable.ic_download_pdf_light
                else Res.drawable.ic_download_pdf_dark
            ),
            modifier = Modifier.height(24.dp),
            url = "${BASE_URL}assets/iguerendiainCV.pdf"
        )

        ClickableImage(
            painter = painterResource(Res.drawable.ic_language),
            modifier = Modifier.height(24.dp),
            unhoveredColor = MaterialTheme.colors.primary,
            hoveredColor = MaterialTheme.colors.primaryVariant,
            onClick = onLanguageDialogToggle
        )
    }
}