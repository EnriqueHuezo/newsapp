package com.eh.newsapp.core.commons

import kotlin.coroutines.CoroutineContext

interface ICoroutineContextProvider {
    fun getMainContext(): CoroutineContext
    fun getIoContext(): CoroutineContext
    fun getDefaultContext(): CoroutineContext
}