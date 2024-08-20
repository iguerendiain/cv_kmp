package nacholab.iguerendiain.cv.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import nacholab.iguerendiain.cv.model.MainCV
import nacholab.iguerendiain.cv.ui.common.BASE_URL
import org.jetbrains.compose.ui.tooling.preview.Preview

private val json = Json { ignoreUnknownKeys = true }

@Composable
@Preview
fun App() {
    val screenSize = remember { mutableStateOf(arrayOf(0.dp, 0.dp)) }
    val density = LocalDensity.current

    val client = HttpClient()

    var mainCVData by remember { mutableStateOf<MainCV?>(null) }

    GlobalScope.launch {
        val response = client.get("$BASE_URL/assets/db.json")
        mainCVData = json.decodeFromString<MainCV>(response.bodyAsText())
    }

    val initialLanguage = mainCVData
        ?.languages
        ?.find { it.code == Locale.current.language }
        ?.code
        ?:"en"

    Layout(
        content = {
            mainCVData
                ?.let { CV(it, initialLanguage, screenSize.value[0])}
                ?:Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(300.dp)
                            .height(300.dp)
                    )
                }
        },
        modifier = Modifier.fillMaxSize(),
        measurePolicy = { measurables, constraints ->
            with (density) {
                val width = constraints.maxWidth
                val height = constraints.maxHeight

                screenSize.value = arrayOf(width.toDp(), height.toDp())

                val placeables = measurables.map { measurable ->
                    measurable.measure(constraints)
                }

                layout(width, height) {
                    var yPosition = 0
                    placeables.forEach { placeable ->
                        placeable.placeRelative(x = 0, y = yPosition)
                        yPosition += placeable.height
                    }
                }
            }

        }
    )
}
