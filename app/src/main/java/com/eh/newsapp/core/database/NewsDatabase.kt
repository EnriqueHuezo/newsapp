package com.eh.newsapp.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eh.newsapp.core.database.dao.IArticleDAO
import com.eh.newsapp.core.database.dao.ISourceDAO
import com.eh.newsapp.core.database.entity.ArticleEntity
import com.eh.newsapp.core.database.entity.SourceEntity

@Database(
    entities = [ArticleEntity::class, SourceEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun articleDao(): IArticleDAO
    abstract fun sourceDao(): ISourceDAO
}