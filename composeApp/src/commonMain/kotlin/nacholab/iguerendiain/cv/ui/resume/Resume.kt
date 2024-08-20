package nacholab.iguerendiain.cv.ui.resume

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import nacholab.iguerendiain.cv.model.ResumeData

@Composable
fun Resume(cv: ResumeData, language: String, months: Array<String>, screenWidth: Dp) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
    ){
        ResumeSection(cv.work.title[language]){
            WorkExperience(cv.work.content, language, months, screenWidth)
        }
        ResumeSection(cv.tech.title[language]){
            TechSkills(cv.tech.content, language, screenWidth)
        }
        ResumeSection(cv.languages.title[language]){
            Languages(cv.languages.content, language)
        }
    }
}