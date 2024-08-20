package nacholab.iguerendiain.cv.ui.resume

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nacholab.iguerendiain.cv.model.LanguageDataItem

@Composable
fun Languages(languages: List<LanguageDataItem>, language: String) {
    Column{
        languages.map { lang ->
            Text(
                text = "> ${lang.title[language]}",
                fontSize = 14.sp,
                color = MaterialTheme.colors.secondaryVariant,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top=12.dp)
            )

            lang.description[language]?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top=6.dp, start = 12.dp)
                )
            }
        }
    }
}