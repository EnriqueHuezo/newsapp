package com.eh.newsapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eh.newsapp.core.database.dao.IArticleDAO
import com.eh.newsapp.core.database.entity.ArticleEntity

@Database(
    entities = [ArticleEntity::class],
    version = 1
)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun articleDao(): IArticleDAO
}