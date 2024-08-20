package nacholab.iguerendiain.cv.ui.contact

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ignacioguerendiaincv.composeapp.generated.resources.Res
import ignacioguerendiaincv.composeapp.generated.resources.ic_email
import ignacioguerendiaincv.composeapp.generated.resources.ic_linkedin
import nacholab.iguerendiain.cv.model.ContactData
import nacholab.iguerendiain.cv.ui.common.ImgLoadHelper
import nacholab.iguerendiain.cv.ui.common.OpenLinkText
import nacholab.iguerendiain.cv.ui.common.BASE_URL
import org.jetbrains.compose.resources.painterResource

@Composable
fun Contact(contact: ContactData, language: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth(.8f)
                .height(36.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(MaterialTheme.colors.secondaryVariant)
        ) {

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ){
                Image(
                    painter = painterResource(Res.drawable.ic_email),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(24.dp)
                )
                OpenLinkText(
                    text = contact.email,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    unhoveredColor = MaterialTheme.colors.primary,
                    hoveredColor = MaterialTheme.colors.primaryVariant,
                    url = "mailto:{${contact.email}"
                )
            }

            Spacer(modifier = Modifier.width(200.dp).height(1.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ){
                Image(
                    painter = painterResource(Res.drawable.ic_linkedin),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(24.dp)
                )
                OpenLinkText(
                    text = "LinkedIn",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    unhoveredColor = MaterialTheme.colors.primary,
                    hoveredColor = MaterialTheme.colors.primaryVariant,
                    url = contact.linkedin
                )
            }

        }
        ImgLoadHelper(
            url = BASE_URL +contact.avatar,
            modifier = Modifier
                .size(200.dp)
                .border(
                    BorderStroke(10.dp, MaterialTheme.colors.secondaryVariant),
                    CircleShape
                )
                .clip(CircleShape)
        )
    }
}