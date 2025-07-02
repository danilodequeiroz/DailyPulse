package com.petros.efthymiou.dailypulse.articles.domain.usecase

import com.petros.efthymiou.dailypulse.articles.data.network.ArticlesService
import com.petros.efthymiou.dailypulse.articles.data.network.model.ArticleRaw
import com.petros.efthymiou.dailypulse.articles.domain.model.Article
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

private const val DESC_FALLBACK = "Click to find out more."
private const val IMAGE_FALLBACK =
    "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6ehhp.jpeg?v=1698758587&w=1920&h=1080"

class ArticleUseCase(private val service: ArticlesService) {

    suspend fun getArticles(): List<Article> {
        val articleRaw = service.fetchArticles()
        return mapArticles(articleRaw)
    }

    private fun mapArticles(articleRaw: List<ArticleRaw>): List<Article> {
        return articleRaw.map { raw ->
            Article(
                title = raw.title,
                desc = raw.description ?: DESC_FALLBACK,
                date = getDaysAgoString(raw.publishedAt),
                imageUri = raw.urlToImage ?: IMAGE_FALLBACK,
            )
        }
    }

    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }

        return result
    }
}