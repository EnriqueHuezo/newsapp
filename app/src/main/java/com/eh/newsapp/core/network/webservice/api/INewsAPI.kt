package com.eh.newsapp.core.network.webservice.api

import com.eh.newsapp.core.network.webservice.dto.request.TopHeadlinesRequestDTO
import com.eh.newsapp.core.network.webservice.dto.response.TopHeadlinesResponseDTO

interface INewsAPI {
    suspend fun getTopHeadlines(
        request: TopHeadlinesRequestDTO
    ): TopHeadlinesResponseDTO
}