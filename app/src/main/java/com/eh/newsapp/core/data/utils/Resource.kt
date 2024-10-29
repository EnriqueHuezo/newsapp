package com.eh.newsapp.core.data.utils

import android.net.http.UrlRequest.Status

class Resource<out T> private constructor(
    val status: Status<T>
) {
    sealed class Status<out T> {
        data class Loading<out T>(
            val msg: String = "", val data: T?
        ) : Status<T>()

        data class Success<out T>(
            val data: T
        ): Status<T>()

        data class Error<out T>(
            val errorCode: Int,
            val failureReason: Pair<String, String>,
            val data: T?
        ) : Status<T>()

        data object EmptySuccess: Status<Nothing>()
    }

    companion object {
        fun <T> loading(
            msg: String,
            data: T? = null
        ) : Resource<T> {
            return Resource(
                status = Status.Loading(msg, data)
            )
        }

        fun <T> success(
            data: T
        ) : Resource<T> {
            return Resource(
                status = Status.Success(data)
            )
        }

        fun <T> error(
            errorCode: Int,
            failureReason: Pair<String, String>?,
            data: T?
        ): Resource<T> {
            return Resource(
                status = Status.Error(
                    errorCode = errorCode,
                    failureReason = failureReason ?: Pair("", ""),
                    data = data
                )
            )
        }

        fun emptySuccess() : Resource<Nothing> {
            return Resource(Status.EmptySuccess)
        }
    }
}