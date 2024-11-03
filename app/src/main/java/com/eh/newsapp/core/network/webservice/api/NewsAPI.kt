package com.eh.newsapp.core.network.webservice.api

import com.eh.newsapp.core.network.webservice.clients.INewsClient
import com.eh.newsapp.core.network.webservice.dto.request.TopHeadlinesRequestDTO
import com.eh.newsapp.core.network.webservice.dto.response.TopHeadlinesResponseDTO
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.encodedPath

class NewsAPI(
    private val newsClient: INewsClient
): INewsAPI {
    override suspend fun getTopHeadlines(
        request: TopHeadlinesRequestDTO
    ): TopHeadlinesResponseDTO = newsClient.client().get {
        url {
            encodedPath += "top-headlines"
            parameter("country", request.country)
            parameter("apiKey", "89436e61578840179b4ab8c7e790db95")
        }
    }.body()
}