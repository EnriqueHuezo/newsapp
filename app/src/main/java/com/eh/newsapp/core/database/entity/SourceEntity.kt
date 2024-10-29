package com.eh.newsapp.core.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eh.newsapp.core.database.DatabaseInfo
import com.eh.newsapp.core.model.Source

@Entity(tableName = DatabaseInfo.SOURCE_TABLE)
data class SourceEntity(
    @PrimaryKey val sourceId: String,
    val name: String
)

fun SourceEntity.toModel() = Source(
    id = sourceId,
    name = name
)