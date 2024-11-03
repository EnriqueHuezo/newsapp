package com.eh.newsapp.di

import com.eh.newsapp.core.usecases.GetArticleFromLocalUseCase
import com.eh.newsapp.core.usecases.IGetArticlesFromRemoteUseCase
import com.eh.newsapp.core.usecases.GetArticlesFromRemoteUseCase
import com.eh.newsapp.core.usecases.IGetArticleFromLocalUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object UseCasesModule {
    val module = module {
        singleOf(::GetArticlesFromRemoteUseCase).bind(IGetArticlesFromRemoteUseCase::class)
        singleOf(::GetArticleFromLocalUseCase).bind(IGetArticleFromLocalUseCase::class)
    }
}