package com.eh.newsapp.core.data.utils

import android.content.Context
import androidx.annotation.StringRes
import com.eh.newsapp.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

inline fun <DB, REMOTE> dbBoundResource(
    @StringRes loadingMessage: Int = R.string.local_default_loading_message,
    @StringRes savingMessage: Int = R.string.local_default_saving_message,
    crossinline fetchFromLocal: suspend () -> Flow<DB?>,
    crossinline shouldMakeNetworkRequest: suspend (DB?) -> Boolean = { true },
    crossinline makeNetworkRequest: suspend () -> REMOTE,
    crossinline processNetworkResponse: (response: REMOTE) -> Unit = { },
    crossinline isRemoteDataEmpty: suspend (REMOTE) -> Boolean,
    crossinline saveResponseData: suspend (REMOTE) -> Unit = { },
) = flow<Resource<DB>> {
    val context = getKoinInstance<Context>()

    emit(Resource.loading(msg = context.getString(loadingMessage), data = null))

    fetchFromLocal().collect { localData ->
        if (shouldMakeNetworkRequest(localData)) {
            val response = makeNetworkRequest()
            processNetworkResponse(response)

            if (isRemoteDataEmpty(response)) {
                emit(Resource.emptySuccess())
            } else {
                emit(Resource.loading(msg = context.getString(savingMessage)))
                saveResponseData(response)
            }
        } else {
            emit(
                localData?.let { Resource.success(data = it) } ?: Resource.emptySuccess()
            )
        }
    }
}

inline fun <DB> dbResource(
    @StringRes loadingMessage: Int = R.string.local_default_loading_message,
    crossinline fetchFromLocal: suspend () -> Flow<DB?>,
    crossinline processLocalData: (DB) -> Unit = { },
) = flow<Resource<DB>> {
    val context = getKoinInstance<Context>()

    emit(Resource.loading(msg = context.getString(loadingMessage), data = null))

    fetchFromLocal().map { localData ->
        if (localData != null) {
            processLocalData(localData)
            emit(
                localData.let { Resource.success(data = it) }
            )
        } else {
            emit(Resource.emptySuccess())
        }
    }.collect()
}.catch {
    throw LocalDataSourceException()
}

class LocalDataSourceException : Exception()

inline fun <reified T> getKoinInstance(): T {
    return object : KoinComponent {
        val value: T by inject()
    }.value
}