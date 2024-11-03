package com.eh.newsapp.core.commons

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class CoroutineContextProvider: ICoroutineContextProvider {
    override fun getMainContext(): CoroutineContext = Dispatchers.Main
    override fun getIoContext(): CoroutineContext = Dispatchers.IO
    override fun getDefaultContext(): CoroutineContext = Dispatchers.Default
}