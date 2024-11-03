package com.eh.newsapp.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.eh.newsapp.core.database.DatabaseInfo
import com.eh.newsapp.core.database.entity.ArticleEntity
import com.eh.newsapp.core.database.entity.ArticleWithSource
import com.eh.newsapp.core.database.entity.SourceEntity
import com.eh.newsapp.core.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface IArticleDAO {
    @Transaction
    @Query("SELECT * FROM ${DatabaseInfo.ARTICLES_TABLE}")
    fun getArticles(): Flow<List<ArticleWithSource>>

    @Transaction
    @Query("SELECT * FROM ${DatabaseInfo.ARTICLES_TABLE} WHERE title is :title")
    fun getArticle(title: String): Flow<ArticleWithSource>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(articleEntity: ArticleEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articlesEntity: List<ArticleEntity>)
}