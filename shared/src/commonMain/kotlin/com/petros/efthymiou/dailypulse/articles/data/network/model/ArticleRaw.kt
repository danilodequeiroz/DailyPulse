package com.petros.efthymiou.dailypulse.articles.data.network.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class ArticleRaw(
    @SerialName("title") var title: String,
    @SerialName("description") var description: String?,
    @SerialName("urlToImage") var urlToImage: String?,
    @SerialName("publishedAt") var publishedAt: String,
)