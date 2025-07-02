package com.petros.efthymiou.dailypulse.articles

import com.petros.efthymiou.dailypulse.articles.domain.model.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null,
)
