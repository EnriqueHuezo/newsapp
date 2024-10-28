package com.eh.newsapp.core.network.webservice.api

import com.eh.newsapp.R
import com.eh.newsapp.core.network.webservice.clients.INewsClient
import com.eh.newsapp.core.network.webservice.dto.request.TopHeadlinesRequestDAO
import com.eh.newsapp.core.network.webservice.dto.response.TopHeadlinesResponseDAO
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.encodedPath

class NewsAPI(
    private val newsClient: INewsClient
): INewsAPI {
    override suspend fun getTopHeadlines(
        request: TopHeadlinesRequestDAO
    ): TopHeadlinesResponseDAO = newsClient.client().get {
        url {
            encodedPath += "top-headlines"
            parameter("country", request.country)
        }
    }.body()
}