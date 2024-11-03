package com.eh.newsapp.feature.home.state

import androidx.compose.runtime.Stable

@Stable
class HomeScreenViewStateHolder(
    val onArticleClick: (articleTitle: String) -> Unit
)
