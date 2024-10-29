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
import kotlinx.coroutines.flow.Flow

@Dao
interface IArticleDAO {
    @Query("SELECT * FROM ${DatabaseInfo.ARTICLES_TABLE}")
    fun getArticlesWithSource(): Flow<List<ArticleWithSource>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSource(sourceEntity: SourceEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(articleEntity: ArticleEntity)

    @Transaction
    suspend fun insertArticleWithSource(
        sourceEntity: SourceEntity,
        articleEntity: ArticleEntity
    ) {
        insertArticle(articleEntity)
        insertSource(sourceEntity)
    }
}