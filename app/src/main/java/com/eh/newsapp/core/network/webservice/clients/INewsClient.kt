package com.eh.newsapp.core.network.webservice.clients

import io.ktor.client.HttpClient

interface INewsClient {
    fun client(): HttpClient
}