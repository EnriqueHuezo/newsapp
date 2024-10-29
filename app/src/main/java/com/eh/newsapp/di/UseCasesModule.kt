package com.eh.newsapp.di

import com.eh.newsapp.core.usecases.IGetArticlesFromRemoteUseCase
import com.eh.newsapp.core.usecases.GetArticlesFromRemoteUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object UseCasesModule {
    val module = module {
        singleOf(::GetArticlesFromRemoteUseCase).bind(IGetArticlesFromRemoteUseCase::class)
    }
}