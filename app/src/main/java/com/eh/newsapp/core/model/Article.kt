package com.eh.newsapp.core.model

import com.eh.newsapp.core.database.entity.ArticleEntity

data class Article(
    val source: Source,
    val author: String = "",
    val title: String = "",
    val description: String = "",
    val url: String = "",
    val urlToImage: String = "",
    val publishedAt: String = "",
    val content: String = "",
)

fun Article.toEntity() = ArticleEntity(
    name = source.name,
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content,
    sourceId = source.id
)
