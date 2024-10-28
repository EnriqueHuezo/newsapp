package com.eh.newsapp.core.network.webservice.api

import com.eh.newsapp.core.network.webservice.dto.request.TopHeadlinesRequestDAO
import com.eh.newsapp.core.network.webservice.dto.response.TopHeadlinesResponseDAO

interface INewsAPI {
    suspend fun getTopHeadlines(
        request: TopHeadlinesRequestDAO
    ): TopHeadlinesResponseDAO
}