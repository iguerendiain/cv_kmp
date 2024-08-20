package nacholab.iguerendiain.cv.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ignacioguerendiaincv.composeapp.generated.resources.Res
import ignacioguerendiaincv.composeapp.generated.resources.bg
import nacholab.iguerendiain.cv.model.MainCV
import nacholab.iguerendiain.cv.theme.MainTheme
import nacholab.iguerendiain.cv.ui.common.SectionTitle
import nacholab.iguerendiain.cv.ui.contact.Contact
import nacholab.iguerendiain.cv.ui.footer.Footer
import nacholab.iguerendiain.cv.ui.header.Header
import nacholab.iguerendiain.cv.ui.portfolio.Portfolio
import nacholab.iguerendiain.cv.ui.resume.Resume
import org.jetbrains.compose.resources.imageResource

@Composable
fun CV(
    cvData: MainCV,
    initialLanguage: String,
    screenWidth: Dp
) {
    val mainContentScrollState = rememberScrollState()
    var cvSectionPosition by remember { mutableStateOf(0f)}
    var contactSectionPosition by remember { mutableStateOf(0f)}
    var language by remember { mutableStateOf(initialLanguage) }
    var languageDialogPresent by remember { mutableStateOf(false) }

    MainTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                Header(
                    data = cvData.navbar,
                    language = language,
                    screenWidth = screenWidth,
                    mainContentScrollState = mainContentScrollState,
                    cvPosition = cvSectionPosition,
                    contactPosition = contactSectionPosition
                ){ languageDialogPresent = !languageDialogPresent }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(mainContentScrollState)
                        .background(MaterialTheme.colors.background)
                ) {
                    val backgroundImage = imageResource(Res.drawable.bg)
                    val backgroundBrush = remember(backgroundImage) {
                        ShaderBrush(
                            ImageShader(
                                backgroundImage,
                                TileMode.Repeated,
                                TileMode.Repeated
                            )
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(backgroundBrush)
                    ) {
                        Spacer(modifier = Modifier.height(36.dp).fillMaxWidth())
                        cvData.portfolio.title[language]?.uppercase()?.let { SectionTitle(it) }
                        Spacer(modifier = Modifier.height(24.dp).fillMaxWidth())
                        Portfolio(cvData.portfolio.projects, language, screenWidth)
                        Spacer(modifier = Modifier.height(24.dp).fillMaxWidth())
                        cvData.cv.title[language]?.uppercase()?.let {
                            SectionTitle(
                                title = it,
                                modifier = Modifier
                                    .onGloballyPositioned { coords ->
                                        cvSectionPosition = coords.positionInParent().y
                                    }
                            )
                        }
                        Resume(cvData.cv, language, cvData.months[language]?: arrayOf(), screenWidth)
                        cvData.contact.title[language]?.uppercase()?.let {
                            SectionTitle(
                                title = it,
                                modifier = Modifier
                                    .onGloballyPositioned { coords ->
                                        contactSectionPosition = coords.positionInParent().y
                                    }
                            )
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                        Contact(cvData.contact, language)
                        Spacer(modifier = Modifier.height(24.dp))
                        Footer(mainContentScrollState)
                    }
                }
            }
            if (languageDialogPresent) LanguageSelectorDialog(
                currentLanguage = language,
                languages = cvData.languages,
                modifier = Modifier.align(Alignment.Center)
            ){
                language = it
                languageDialogPresent = false
            }
        }
    }
}