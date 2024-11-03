package com.eh.newsapp.core.data.repository.core

import com.eh.newsapp.core.database.entity.ArticleEntity
import com.eh.newsapp.core.database.entity.ArticleWithSource
import com.eh.newsapp.core.database.entity.SourceEntity
import com.eh.newsapp.core.model.TopHeadlinesResponse
import com.eh.newsapp.core.network.webservice.dto.request.TopHeadlinesRequestDTO
import com.eh.newsapp.core.network.webservice.dto.response.toDomain
import kotlinx.coroutines.flow.Flow

class CoreRepository(
    private val localDataSource: ICoreDataSource.Local,
    private val remoteDataSource: ICoreDataSource.Remote
): ICoreDataSource.Repository {
    override suspend fun getTopHeadlinesAsync(): TopHeadlinesResponse =
        remoteDataSource.getTopHeadlines(TopHeadlinesRequestDTO()).toDomain()

    override suspend fun getTopHeadlinesLocal(): Flow<List<ArticleWithSource>> =
        localDataSource.getArticlesWithSource()

    override suspend fun saveArticlesLocal(articles: List<ArticleEntity>, source: List<SourceEntity>) {
        localDataSource.saveArticles(articles, source)
    }

    override suspend fun getLocalArticleWithSource(articleTitle: String): Flow<ArticleWithSource> =
        localDataSource.getLocalArticleWithSource(articleTitle)
}