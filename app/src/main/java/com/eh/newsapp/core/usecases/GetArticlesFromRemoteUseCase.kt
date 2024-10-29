package com.eh.newsapp.core.usecases

import com.eh.newsapp.core.data.repository.core.CoreRepository
import com.eh.newsapp.core.data.utils.Resource
import com.eh.newsapp.core.data.utils.dbBoundResource
import com.eh.newsapp.core.model.Article
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface IGetArticlesFromRemoteUseCase {
    suspend fun execute(): Flow<Resource<List<Article>>>
}

class GetArticlesFromRemoteUseCase(
    private val coreRepository: CoreRepository
) : IGetArticlesFromRemoteUseCase {
    override suspend fun execute(): Flow<Resource<List<Article>>> {
        /*TODO*/
    }
}