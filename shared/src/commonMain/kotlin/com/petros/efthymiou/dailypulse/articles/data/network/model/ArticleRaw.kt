package com.petros.efthymiou.dailypulse.articles.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleRaw(
    @SerialName("title") var title: String,
    @SerialName("description") var description: String?,
    @SerialName("publishedAt") var date: String,
    @SerialName("urlToImage") var imageUrl: String?,
)