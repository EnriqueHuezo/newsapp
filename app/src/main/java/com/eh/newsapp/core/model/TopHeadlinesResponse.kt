package com.eh.newsapp.core.model

data class TopHeadlinesResponse(
    val articles: List<Article> = emptyList()
)
