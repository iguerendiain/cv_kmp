package nacholab.iguerendiain.cv.model

import kotlinx.serialization.Serializable

@Serializable
data class NavBarMenuData(
    val portfolio: HashMap<String, HashMap<String, String?>>,
    val cv: HashMap<String, HashMap<String, String?>>,
    val contact: HashMap<String, HashMap<String, String?>>
)