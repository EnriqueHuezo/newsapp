package com.eh.newsapp.core.data.repository.core

import com.eh.newsapp.core.database.entity.ArticleEntity
import com.eh.newsapp.core.database.entity.ArticleWithSource
import com.eh.newsapp.core.database.entity.SourceEntity
import com.eh.newsapp.core.model.TopHeadlinesResponse
import com.eh.newsapp.core.network.webservice.dto.request.TopHeadlinesRequestDTO
import com.eh.newsapp.core.network.webservice.dto.response.TopHeadlinesResponseDTO
import kotlinx.coroutines.flow.Flow

interface ICoreDataSource {
    interface Remote {
        suspend fun getTopHeadlines(
            request: TopHeadlinesRequestDTO
        ) : TopHeadlinesResponseDTO
    }

    interface Local {
        suspend fun getArticlesWithSource(): Flow<List<ArticleWithSource>>
        suspend fun saveArticles(articles: List<ArticleEntity>, source: List<SourceEntity>)
        suspend fun getLocalArticleWithSource(articleTitle: String): Flow<ArticleWithSource>
    }

    interface Repository {
        suspend fun getTopHeadlinesAsync() : TopHeadlinesResponse
        suspend fun getTopHeadlinesLocal() : Flow<List<ArticleWithSource>>
        suspend fun saveArticlesLocal(articles: List<ArticleEntity>, source: List<SourceEntity>)
        suspend fun getLocalArticleWithSource(articleTitle: String): Flow<ArticleWithSource>
    }
}