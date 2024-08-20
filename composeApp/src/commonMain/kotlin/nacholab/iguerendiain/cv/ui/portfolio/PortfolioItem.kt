package nacholab.iguerendiain.cv.ui.portfolio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ignacioguerendiaincv.composeapp.generated.resources.Res
import ignacioguerendiaincv.composeapp.generated.resources.listBullet
import nacholab.iguerendiain.cv.model.ProjectData
import nacholab.iguerendiain.cv.ui.common.BASE_URL
import nacholab.iguerendiain.cv.ui.common.ImgLoadHelper
import nacholab.iguerendiain.cv.ui.common.KEY_TITLE
import nacholab.iguerendiain.cv.ui.common.OpenLinkLoadableImage
import org.jetbrains.compose.resources.painterResource
import kotlin.math.ceil
import kotlin.math.floor

@Composable
fun PortfolioItem(
    project: ProjectData,
    language: String,
    modifier: Modifier
){
    Box(
        modifier = Modifier
            .then(modifier)
            .background(MaterialTheme.colors.background)
    ){
        ImgLoadHelper(
            url = BASE_URL +project.icon,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .blur(10.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(MaterialTheme.colors.background.copy(alpha = .5f))
        )
        Column {
            Row{
                ImgLoadHelper(
                    url = BASE_URL +project.icon,
                    modifier = Modifier
                        .padding(all = 8.dp)
                        .height(48.dp)
                        .width(48.dp)
                )
                Text(
                    text = project.title[language]?:"",
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.primary,
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.h4.copy(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(4f, 4f),
                            blurRadius = 8f
                        )
                    ),
                    modifier = Modifier
                        .padding(top = 14.dp)
                )
            }

            val columnCount = 2
            val projectItemCount = project.items.size
            val rowCount = ceil(projectItemCount / columnCount.toDouble()).toInt()

            for (row in 0 until rowCount){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                ){
                    for (column in 0 until columnCount){
                        val projectItemIndex = column + row * columnCount
                        if (projectItemIndex < projectItemCount)
                            Row(
                                modifier = Modifier.weight(1f).fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                Image(
                                    painter = painterResource(Res.drawable.listBullet),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary),
                                    modifier = Modifier
                                        .width(9.dp)
                                        .height(10.dp)
                                )
                                Text(
                                    modifier = Modifier.padding(start = 4.dp),
                                    text = project.items[projectItemIndex][KEY_TITLE]?.get(language)?:"",
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colors.primary
                                )
                            }
                    }
                }
            }

            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.BottomCenter
            ){
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(1.dp)
                                .background(MaterialTheme.colors.secondary)
                        )

                        Text(
                            text = "///",
                            color = MaterialTheme.colors.secondary,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light,
                            modifier = Modifier
                                .padding(start = 8.dp, end = 8.dp)
                        )

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .height(1.dp)
                                .background(MaterialTheme.colors.secondary)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 12.dp)
                            .height(32.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        project.urls?.map { projectUrl ->
                            OpenLinkLoadableImage(
                                imageUrl = BASE_URL + projectUrl.icon,
                                modifier = Modifier.padding(all = 4.dp).size(24.dp),
                                url = projectUrl.url
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp)
                            .background(MaterialTheme.colors.secondary)
                    )
                }
            }

        }
    }
}