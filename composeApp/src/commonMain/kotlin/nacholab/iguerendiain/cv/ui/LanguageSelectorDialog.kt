package nacholab.iguerendiain.cv.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nacholab.iguerendiain.cv.model.Language
import nacholab.iguerendiain.cv.ui.common.ClickableText

@Composable
fun LanguageSelectorDialog(
    modifier: Modifier,
    currentLanguage: String,
    languages: List<Language>,
    onSelectedLanguage: (language: String)-> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background.copy(alpha = .8f))
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colors.background)
                .border(
                    BorderStroke(1.dp, MaterialTheme.colors.secondary),
                    RoundedCornerShape(16.dp)
                )
                .then(modifier)
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 24.dp)
            ){
                languages.mapIndexed { index, language ->
                    ClickableText(
                        text = language.name[currentLanguage]?:"",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        unhoveredColor = MaterialTheme.colors.primary,
                        hoveredColor = MaterialTheme.colors.primaryVariant,
                        modifier = Modifier
                            .fillMaxWidth(.8f)
                            .padding(all = 4.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colors.secondaryVariant)
                    ){
                        onSelectedLanguage(language.code)
                    }
                    if (index < languages.size-1 ) Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}