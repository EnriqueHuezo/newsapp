package com.eh.newsapp.feature.articleDetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.eh.newsapp.feature.articleDetail.state.ArticleDetailUIState

@Composable
fun ArticleDetailScreen(
    uiState: ArticleDetailUIState
) {
    Text(uiState.title)
}