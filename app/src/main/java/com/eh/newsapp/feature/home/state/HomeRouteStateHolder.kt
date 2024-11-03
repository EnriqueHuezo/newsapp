package com.eh.newsapp.feature.home.state

import androidx.compose.runtime.Stable

@Stable
data class HomeRouteStateHolder(
    val onArticleClick: (articleTitle: String) -> Unit
)
