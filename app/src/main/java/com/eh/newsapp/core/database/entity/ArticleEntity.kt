package com.eh.newsapp.core.database.entity

import androidx.room.Entity

@Entity(tableName = "articles")
data class ArticleEntity(
    val id: String,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: String,
    val title: String,
    val url: String,
    val urlToImage: String
)