package nacholab.iguerendiain.cv.ui.resume

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ignacioguerendiaincv.composeapp.generated.resources.Res
import ignacioguerendiaincv.composeapp.generated.resources.listBullet
import nacholab.iguerendiain.cv.model.WorkExperienceDataItem
import nacholab.iguerendiain.cv.tools.toMonth
import nacholab.iguerendiain.cv.tools.toYear
import nacholab.iguerendiain.cv.ui.common.OpenLinkText
import nacholab.iguerendiain.cv.ui.common.RESPONSIVE_WIDTH_THRESHOLD
import org.jetbrains.compose.resources.painterResource

@Composable
fun WorkExperience(
    workData: List<WorkExperienceDataItem>,
    language: String,
    months: Array<String>,
    screenWidth: Dp
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp)
    ){
        workData.map { job ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top=12.dp)
            ){
                Text(
                    text = "> ",
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.secondaryVariant,
                    fontWeight = FontWeight.Bold
                )
                job.title[language]?.let { OpenLinkText(
                    text = it,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    unhoveredColor = MaterialTheme.colors.secondaryVariant,
                    hoveredColor = MaterialTheme.colors.primaryVariant,
                    url = job.url
                ) }
                if (screenWidth > RESPONSIVE_WIDTH_THRESHOLD) {
                    Text(
                        text = " // ${job.from.toMonth(months)} ${job.from.toYear()}",
                        fontSize = 14.sp,
                        color = MaterialTheme.colors.secondaryVariant,
                        fontWeight = FontWeight.Bold
                    )

                    job.to?.let {
                        Text(
                            text = " ~ ${job.to.toMonth(months)} ${job.to.toYear()}",
                            fontSize = 14.sp,
                            color = MaterialTheme.colors.secondaryVariant,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            if (screenWidth <= RESPONSIVE_WIDTH_THRESHOLD){
                Row {
                    Text(
                        text = "${job.from.toMonth(months)} ${job.from.toYear()}",
                        fontSize = 14.sp,
                        color = MaterialTheme.colors.secondaryVariant,
                        fontWeight = FontWeight.Bold
                    )

                    job.to?.let {
                        Text(
                            text = " ~ ${job.to.toMonth(months)} ${job.to.toYear()}",
                            fontSize = 14.sp,
                            color = MaterialTheme.colors.secondaryVariant,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, bottom = 24.dp)
            ){
                Image(
                    painter = painterResource(Res.drawable.listBullet),
                    modifier = Modifier
                        .padding(top = 6.dp)
                        .width(9.dp)
                        .height(10.dp),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary)
                )
                job.description[language]?.let { Text(
                    text = it,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Justify,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp)
                ) }
            }

        }
    }
}