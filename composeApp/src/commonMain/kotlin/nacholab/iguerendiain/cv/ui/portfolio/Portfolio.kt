package nacholab.iguerendiain.cv.ui.portfolio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import nacholab.iguerendiain.cv.model.ProjectData
import nacholab.iguerendiain.cv.ui.common.RESPONSIVE_WIDTH_THRESHOLD
import kotlin.math.ceil

@Composable
fun Portfolio(
    projects: List<ProjectData>,
    language: String,
    screenWidth: Dp
){
    val projectCount = projects.size
    val projectItemWidth: Dp
    val columnCount: Int
    val rowCount: Int

    if (screenWidth <= RESPONSIVE_WIDTH_THRESHOLD) {
        projectItemWidth = screenWidth * .8f
        columnCount = 1
        rowCount = projectCount
    }else {
        projectItemWidth = (screenWidth * .8f) / 3
        columnCount = 3
        rowCount = ceil(projectCount / columnCount.toDouble()).toInt()
    }

    for (row in 0 until rowCount){
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ){
            for (column in 0 until columnCount) {
                val projectIndex = column + row * columnCount

                if (projectIndex < projectCount) PortfolioItem(
                    project = projects[projectIndex],
                    language = language,
                    modifier = Modifier
                        .width(projectItemWidth)
                        .aspectRatio(1f)
                        .padding(all = 10.dp)
                )
            }
        }
    }
}