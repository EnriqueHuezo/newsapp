package com.eh.newsapp.core.data.repository.core

import androidx.room.Transaction
import com.eh.newsapp.core.database.NewsDatabase
import com.eh.newsapp.core.database.entity.ArticleEntity
import com.eh.newsapp.core.database.entity.ArticleWithSource
import com.eh.newsapp.core.database.entity.SourceEntity
import kotlinx.coroutines.flow.Flow

class CoreLocalDataSource(
    private val database: NewsDatabase
): ICoreDataSource.Local {
    override suspend fun getArticlesWithSource(): Flow<List<ArticleWithSource>> =
        database.articleDao().getArticles()

    @Transaction
    override suspend fun saveArticles(
        articles: List<ArticleEntity>, source: List<SourceEntity>
    ) {
        database.sourceDao().insertSources(source)
        database.articleDao().insertArticles(articles)
    }

    override suspend fun getLocalArticleWithSource(articleTitle: String): Flow<ArticleWithSource> =
        database.articleDao().getArticle(articleTitle)
}