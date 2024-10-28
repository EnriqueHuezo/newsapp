package com.eh.newsapp.di

object AppModule {
    private val module = listOf(
        RepositoriesModule.module,
        WebServiceModule.module
    )

    val modules = module
}