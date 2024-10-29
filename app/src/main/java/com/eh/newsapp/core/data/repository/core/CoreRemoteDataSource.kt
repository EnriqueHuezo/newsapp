package com.eh.newsapp.core.data.repository.core

import com.eh.newsapp.core.network.webservice.api.INewsAPI
import com.eh.newsapp.core.network.webservice.dto.request.TopHeadlinesRequestDTO
import com.eh.newsapp.core.network.webservice.dto.response.TopHeadlinesResponseDTO

class CoreRemoteDataSource(
    private val newsAPI: INewsAPI
) : ICoreDataSource.Remote {
    override suspend fun getTopHeadlines(request: TopHeadlinesRequestDTO): TopHeadlinesResponseDTO {
        TODO("Not yet implemented")
    }
}