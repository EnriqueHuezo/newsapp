package com.eh.newsapp.core.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.eh.newsapp.core.database.DatabaseInfo
import com.eh.newsapp.core.model.Article
import com.eh.newsapp.feature.articleDetail.state.ArticleDetailUIState

@Entity(
    tableName = DatabaseInfo.ARTICLES_TABLE,
    foreignKeys = [ForeignKey(
        entity = SourceEntity::class,
        parentColumns = ["sourceId"],
        childColumns = ["sourceId"],
        onDelete = ForeignKey.CASCADE

    )],
    indices = [Index(
        value = ["sourceId"]
    )]
)
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
    val sourceId: String
)

data class ArticleWithSource(
    @Embedded val articleEntity: ArticleEntity,
    @Relation(
        parentColumn = "sourceId",
        entityColumn = "sourceId"
    ) val sourceEntity: SourceEntity
)

fun ArticleWithSource.toArticleDetailUIState() = ArticleDetailUIState(
    id = sourceEntity.sourceId,
    nameSource = sourceEntity.name,
    title = articleEntity.title,
    author = articleEntity.author,
    description = articleEntity.description,
    url = articleEntity.url,
    urlToImage = articleEntity.urlToImage,
    publishedAt = articleEntity.publishedAt,
    content = articleEntity.content
)
