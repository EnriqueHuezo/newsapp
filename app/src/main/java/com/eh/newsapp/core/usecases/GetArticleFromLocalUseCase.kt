package com.eh.newsapp.core.usecases

import com.eh.newsapp.core.data.repository.core.CoreRepository
import com.eh.newsapp.core.data.utils.Resource
import com.eh.newsapp.core.data.utils.dbResource
import com.eh.newsapp.core.database.entity.ArticleWithSource
import kotlinx.coroutines.flow.Flow

interface IGetArticleFromLocalUseCase {
    suspend fun execute(articleTitle: String): Flow<Resource<ArticleWithSource>>
}

class GetArticleFromLocalUseCase(
    private val coreRepository: CoreRepository
): IGetArticleFromLocalUseCase {
    override suspend fun execute(articleTitle: String): Flow<Resource<ArticleWithSource>> =
        dbResource(fetchFromLocal = { coreRepository.getLocalArticleWithSource(articleTitle) })
}