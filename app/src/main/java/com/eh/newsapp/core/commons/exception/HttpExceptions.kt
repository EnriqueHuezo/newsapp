package com.eh.newsapp.core.commons.exception

import android.content.Context
import com.eh.newsapp.R
import io.ktor.client.plugins.ResponseException
import io.ktor.client.statement.HttpResponse
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HttpExceptions(
    response: HttpResponse,
    val failureReason: Pair<String, String>,
    cachedResponseText: String
): ResponseException(response, cachedResponseText), KoinComponent {
    private val context by inject<Context>()
    override val message: String =
        context.getString(R.string.network_generic_error, failureReason)
}