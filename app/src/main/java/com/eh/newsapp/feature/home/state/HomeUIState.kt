package com.eh.newsapp.feature.home.state

data class HomeUIState(
    val articles: List<ArticleCardUIState> = emptyList()
)

data class ArticleCardUIState(
    val id: String,
    val nameSource: String,
    val title: String,
    val author: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)