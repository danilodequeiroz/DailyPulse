package com.petros.efthymiou.dailypulse.articles.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    @SerialName("status") var status: String,
    @SerialName("totalResults") var totalResults: Int,
    @SerialName("articles") var articles: List<ArticleRaw>,
)