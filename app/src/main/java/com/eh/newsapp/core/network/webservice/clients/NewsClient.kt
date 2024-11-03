package com.eh.newsapp.core.network.webservice.clients

import android.content.Context
import android.util.Log
import com.eh.newsapp.R
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.parameters
import io.ktor.http.parametersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NewsClient(
    private val json: Json,
    private val context: Context
): INewsClient {
    override fun client(): HttpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(json)
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v("API NEWS LOG", message)
                }
            }
            level = LogLevel.ALL
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            url(context.getString(R.string.news_api_base_url))
        }
    }
}