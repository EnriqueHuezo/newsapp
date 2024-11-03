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

    private val viewModelModule = listOf(
        ViewModelsModule.module
    )

    private val coroutineModule = listOf(
        CoroutinesModule.module
    )

    val modules = module + databaseModule + useCaseModule + viewModelModule + coroutineModule
}