package com.eh.newsapp.core.network.webservice.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopHeadlinesRequestDTO(
    @SerialName("country") val country: String = "us"
)
