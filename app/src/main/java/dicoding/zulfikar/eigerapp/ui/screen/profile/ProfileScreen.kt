package dicoding.zulfikar.eigerapp.ui.screen.profile

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dicoding.zulfikar.eigerapp.R

@Composable
fun ProfileScreen(current: Context) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 50.dp, start = 10.dp, end = 10.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.zulfikar),
                contentDescription = null,
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape), contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.name),
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = stringResource(id = R.string.email), color = Color.Gray)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterHorizontally), // Menggunakan align hanya untuk horizontal
                verticalAlignment = Alignment.CenterVertically
            ) {
                SocialMediaLink(
                    icon = R.drawable.ic_instagram,
                    link = "https://www.instagram.com/strippeddd_/", current = current
                )
                Spacer(modifier = Modifier.width(8.dp)) // Mengganti height menjadi width pada Spacer
                SocialMediaLink(
                    icon = R.drawable.ic_linkedin,
                    link = "https://www.linkedin.com/in/zoelfikars/", current = current
                )
                Spacer(modifier = Modifier.width(8.dp)) // Mengganti height menjadi width pada Spacer
                SocialMediaLink(
                    icon = R.drawable.ic_github,
                    link = "https://github.com/zoelfikars",
                    current = current
                )
            }

        }
    }
}

@Composable
fun SocialMediaLink(icon: Int, link: String, current: Context) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.clickable {
            current.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
        }
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
        )
    }
}
