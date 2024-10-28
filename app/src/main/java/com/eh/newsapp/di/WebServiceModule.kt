package com.eh.newsapp.di

import com.eh.newsapp.core.network.webservice.api.INewsAPI
import com.eh.newsapp.core.network.webservice.api.NewsAPI
import com.eh.newsapp.core.network.webservice.clients.INewsClient
import com.eh.newsapp.core.network.webservice.clients.NewsClient
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.koin.dsl.bind

object WebServiceModule {
    val module = module {
        single {
            Json {
                ignoreUnknownKeys = true
                encodeDefaults = true
                explicitNulls = false
            }
        }

        singleOf(::NewsClient).bind(INewsClient::class)
        singleOf(::NewsAPI).bind(INewsAPI::class)
    }
}