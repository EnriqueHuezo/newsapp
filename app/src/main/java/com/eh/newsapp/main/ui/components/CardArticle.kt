package com.eh.newsapp.main.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import com.eh.newsapp.R
import com.eh.newsapp.main.ui.theme.NewsappTheme
import com.eh.newsapp.main.ui.theme.Typography

@Composable
fun CardArticleHome(
    nameSource: String,
    title: String,
    urlToImage: String,
    onClick: () -> Unit
) {
    val painter = rememberAsyncImagePainter(R.drawable.oops)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp)
                    .fillMaxHeight()
                    .weight(1.5f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    style = Typography.bodySmall

                )
            }

            AsyncImage(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(8.dp)),
                model = urlToImage,
                contentScale = ContentScale.Inside,
                contentDescription = "$nameSource Image",
                error = painter
            )
        }
    }
}

@Composable
@Preview(name = "lightmode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "darkmode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun CardArticlePreview() {
    NewsappTheme {
        CardArticleHome(
            nameSource = "Times",
            title = "Ceasefire hopes fade as Israel bombards Gaza, Lebanon - Reuters",
            urlToImage = "https://imagen.jpg",
            onClick = {}
        )
    }
}