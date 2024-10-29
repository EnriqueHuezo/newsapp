package com.eh.newsapp.di

object AppModule {
    private val module = listOf(
        RepositoriesModule.module,
        WebServiceModule.module
    )

    private val databaseModule = listOf(
        DatabaseModule.module
    )

    private val useCaseModule = listOf(
        UseCasesModule.module
    )

    val modules = module + databaseModule + useCaseModule
}