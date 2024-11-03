package com.eh.newsapp.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.eh.newsapp.feature.home.state.HomeScreenViewStateHolder
import com.eh.newsapp.feature.home.state.HomeUIState
import com.eh.newsapp.main.ui.components.CardArticleHome

@Composable
fun HomeScreen(
    uiState: HomeUIState,
    viewState: HomeScreenViewStateHolder
) {
    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Top headlines 2024",
            fontWeight = FontWeight.Bold
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(uiState.articles) { article ->
                CardArticleHome(
                    nameSource = article.nameSource,
                    title = article.title,
                    urlToImage = article.urlToImage,
                    onClick = { viewState.onArticleClick(article.title) }
                )
            }
        }
    }
}