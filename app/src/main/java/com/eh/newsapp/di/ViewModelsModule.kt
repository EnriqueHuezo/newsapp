package com.eh.newsapp.di

import com.eh.newsapp.feature.articleDetail.ArticleDetailViewmodel
import com.eh.newsapp.feature.home.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

object ViewModelsModule {
    val module = module {
        viewModelOf(::HomeViewModel)
        viewModelOf(::ArticleDetailViewmodel)
    }
}