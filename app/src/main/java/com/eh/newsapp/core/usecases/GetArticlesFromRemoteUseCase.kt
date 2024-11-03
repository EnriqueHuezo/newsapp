package com.eh.newsapp.core.usecases

import android.util.Log
import com.eh.newsapp.core.data.repository.core.CoreRepository
import com.eh.newsapp.core.data.utils.Resource
import com.eh.newsapp.core.data.utils.dbBoundResource
import com.eh.newsapp.core.database.entity.ArticleWithSource
import com.eh.newsapp.core.model.toEntity
import kotlinx.coroutines.flow.Flow

interface IGetArticlesFromRemoteUseCase {
    suspend fun execute(): Flow<Resource<List<ArticleWithSource>>>
}

class GetArticlesFromRemoteUseCase(
    private val coreRepository: CoreRepository
) : IGetArticlesFromRemoteUseCase {
    override suspend fun execute(): Flow<Resource<List<ArticleWithSource>>> =
        dbBoundResource(
            fetchFromLocal = { coreRepository.getTopHeadlinesLocal() },
            shouldMakeNetworkRequest = { it?.isEmpty() ?: true },
            makeNetworkRequest = { coreRepository.getTopHeadlinesAsync() },
            isRemoteDataEmpty = { it.articles.isEmpty() },
            saveResponseData = { it ->
                val articles = it.articles.map {  article ->
                    article.toEntity()
                }

                val sources = it.articles.map { source ->
                    source.source.toEntity()
                }.distinctBy { id -> id.sourceId }

                coreRepository.saveArticlesLocal(articles, sources)
            }
        )
}