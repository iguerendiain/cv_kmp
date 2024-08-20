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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ignacioguerendiaincv.composeapp.generated.resources.Res
import ignacioguerendiaincv.composeapp.generated.resources.listBullet
import nacholab.iguerendiain.cv.model.TechDataItem
import nacholab.iguerendiain.cv.ui.common.RESPONSIVE_WIDTH_THRESHOLD
import org.jetbrains.compose.resources.painterResource
import kotlin.math.ceil

@Composable
fun TechSkills(workData: List<TechDataItem>, language: String, screenWidth: Dp) {
    Column{
        workData.map { tech ->
            Text(
                text = "> ${tech.title[language]}",
                fontSize = 14.sp,
                color = MaterialTheme.colors.secondaryVariant,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top=12.dp)
            )

            val columnCount = if (screenWidth < RESPONSIVE_WIDTH_THRESHOLD) 2 else 3
            val itemCount = tech.content.size
            val rowCount = ceil(itemCount / columnCount.toDouble()).toInt()

            for (row in 0 until rowCount) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                ) {
                    for (column in 0 until columnCount) {
                        val itemIndex = column + row * columnCount
                        if (itemIndex < itemCount){
                            Row(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp),
                            ){
                                Image(
                                    painter = painterResource(Res.drawable.listBullet),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary),
                                    modifier = Modifier
                                        .padding(top = 8.dp, end = 4.dp)
                                        .width(9.dp)
                                        .height(10.dp)
                                )
                                Text(
                                    text = tech.content[itemIndex],
                                    color = MaterialTheme.colors.primary
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}