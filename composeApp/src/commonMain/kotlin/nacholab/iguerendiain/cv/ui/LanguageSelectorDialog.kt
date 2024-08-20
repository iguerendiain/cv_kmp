package nacholab.iguerendiain.cv.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import nacholab.iguerendiain.cv.model.Language

@Composable
fun LanguageSelectorDialog(
    modifier: Modifier,
    currentLanguage: String,
    languages: List<Language>,
    onSelectedLanguage: (language: String)-> Unit
) {
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp)
            .background(Color.Red)
            .then(modifier)
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ){
            languages.map {
                Text(
                    text = it.name[currentLanguage]?:"",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .clickable { onSelectedLanguage(it.code) }
                        .background(Color.Blue)
                        .padding(all = 4.dp)
                )
            }
        }
    }
}