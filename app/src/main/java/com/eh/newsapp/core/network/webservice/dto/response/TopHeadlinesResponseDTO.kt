package com.eh.newsapp.core.network.webservice.dto.response

import com.eh.newsapp.core.model.Article
import com.eh.newsapp.core.model.TopHeadlinesResponse
import com.eh.newsapp.core.model.Source
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopHeadlinesResponseDTO(
    @SerialName("status") val status: String,
    @SerialName("totalResults") val totalResults: Int,
    @SerialName("articles") val articles: List<ArticleDTO>
)

@Serializable
data class ArticleDTO(
    @SerialName("source") val source: SourceDTO,
    @SerialName("author") val author: String?,
    @SerialName("title") val title: String?,
    @SerialName("description") val description: String?,
    @SerialName("url") val url: String?,
    @SerialName("urlToImage") val urlToImage: String?,
    @SerialName("publishedAt") val publishedAt: String?,
    @SerialName("content") val content: String?
)

@Serializable
data class SourceDTO(
    @SerialName("id") val id: String?,
    @SerialName("name") val name: String?
)

fun TopHeadlinesResponseDTO.toDomain() = TopHeadlinesResponse(
    articles = articles.map { it.toDomain() }
)

fun ArticleDTO.toDomain() = Article(
    source = source.toDomain(),
    author = author ?: "Desconocido",
    title = title ?: "Sin titulo",
    description = description ?: "Sin descripción",
    url = url ?: "Sin URL",
    urlToImage = urlToImage ?: "Sin imagen",
    publishedAt = publishedAt ?: "Sin fecha de publicación",
    content = content ?: "Sin conenido"
)

fun SourceDTO.toDomain() = Source(
    id = id.orEmpty(),
    name = name.orEmpty()
)