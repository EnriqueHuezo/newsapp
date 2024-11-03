package com.eh.newsapp.core.model

import com.eh.newsapp.core.database.entity.SourceEntity

data class Source(
    val id: String = "",
    val name: String = ""
)

fun Source.toEntity() = SourceEntity(
    sourceId = id,
    name = name
)
