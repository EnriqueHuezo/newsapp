package com.eh.newsapp.feature.articleDetail.state

data class ArticleDetailUIState(
    val id: String = "",
    val nameSource: String = "",
    val title: String = "",
    val author: String = "",
    val description: String = "",
    val url: String = "",
    val urlToImage: String = "",
    val publishedAt: String = "",
    val content: String = ""
)