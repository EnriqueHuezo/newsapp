package com.eh.newsapp.core.data.utils

sealed class UIStateStatus<out T> {
    data class Loading<T>(val message: String = "") : UIStateStatus<T>()
    data class Success<out T>(val data: T) : UIStateStatus<T>()
    data class Error<out T>(
        val exception: Throwable,
    ) : UIStateStatus<T>()
    data class Empty<out T>(val emptyData: T) : UIStateStatus<T>()

}