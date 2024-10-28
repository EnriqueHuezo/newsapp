package com.eh.newsapp.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.eh.newsapp.core.database.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IArticleDAO {
    @Upsert
    suspend fun upsert(article: ArticleEntity)

    @Upsert
    suspend fun upsert(articles: List<ArticleEntity>)

    @Query("SELECT * FROM articles")
    fun getArticles(): Flow<List<ArticleEntity>>

    @Delete
    suspend fun delete(article: ArticleEntity)

    @Query("DELETE FROM articles")
    suspend fun deleteAll()
}