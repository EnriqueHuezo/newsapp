package com.eh.newsapp.core.data.repository.core

import com.eh.newsapp.core.database.NewsDatabase
import com.eh.newsapp.core.database.entity.ArticleEntity
import com.eh.newsapp.core.database.entity.ArticleWithSource
import com.eh.newsapp.core.database.entity.SourceEntity
import kotlinx.coroutines.flow.Flow

class CoreLocalDataSource(
    private val database: NewsDatabase
): ICoreDataSource.Local {
    override suspend fun getArticlesWithSource(): Flow<List<ArticleWithSource>> =
        database.articleDao().getArticlesWithSource()

    override suspend fun insertSource(sourceEntity: SourceEntity) =
        database.articleDao().insertSource(sourceEntity)

    override suspend fun insertArticle(articleEntity: ArticleEntity) =
        database.articleDao().insertArticle(articleEntity)

    override suspend fun insertArticleWithSource(sourceEntity: SourceEntity, articleEntity: ArticleEntity) =
        database.articleDao().insertArticleWithSource(sourceEntity, articleEntity)


}