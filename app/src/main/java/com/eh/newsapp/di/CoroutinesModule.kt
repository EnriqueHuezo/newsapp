package com.eh.newsapp.di

import com.eh.newsapp.core.commons.CoroutineContextProvider
import com.eh.newsapp.core.commons.ICoroutineContextProvider
import org.koin.dsl.module

object CoroutinesModule {
    val module = module {
        single<ICoroutineContextProvider> { CoroutineContextProvider() }
    }
}