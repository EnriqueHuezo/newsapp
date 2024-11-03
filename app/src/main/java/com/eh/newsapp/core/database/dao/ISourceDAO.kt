package com.eh.newsapp.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.eh.newsapp.core.database.entity.SourceEntity

@Dao
interface ISourceDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSource(sourceEntity: SourceEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSources(sourcesEntity: List<SourceEntity>)
}