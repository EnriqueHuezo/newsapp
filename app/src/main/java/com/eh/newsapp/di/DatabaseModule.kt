package com.eh.newsapp.di

import androidx.room.Room
import com.eh.newsapp.core.database.NewsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

object DatabaseModule {
    val module = module {
        single<NewsDatabase> {
            Room.databaseBuilder(
                androidApplication(),
                NewsDatabase::class.java,
                "news-database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}