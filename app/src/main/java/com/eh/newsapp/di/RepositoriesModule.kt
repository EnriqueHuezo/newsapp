package com.eh.newsapp.di
import com.eh.newsapp.core.data.repository.core.ICoreDataSource
import com.eh.newsapp.core.data.repository.core.CoreLocalDataSource
import com.eh.newsapp.core.data.repository.core.CoreRemoteDataSource
import com.eh.newsapp.core.data.repository.core.CoreRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

object RepositoriesModule {
    val module = module {
        singleOf(::CoreLocalDataSource).bind(ICoreDataSource.Local::class)
        singleOf(::CoreRemoteDataSource).bind(ICoreDataSource.Remote::class)
        singleOf(::CoreRepository).bind(ICoreDataSource.Repository::class)
    }
}