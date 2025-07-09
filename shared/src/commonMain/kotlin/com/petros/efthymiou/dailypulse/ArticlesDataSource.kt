package com.petros.efthymiou.dailypulse

import com.petros.efthymiou.dailypulse.articles.data.network.model.ArticleRaw
import petros.efthymiou.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(
    private val database: DailyPulseDatabase
) {

    fun clearArticles() {
        database.dailyPulseDatabaseQueries.removeAllArticles()
    }

    fun getAllArticlesUsingExplicitLambda(): List<ArticleRaw> {
        return database.dailyPulseDatabaseQueries.selectAllArticles(
            mapper = { title, description, date, url ->
                mapToArticlesRaw(
                    title = title,
                    desc = description,
                    date = date,
                    url = url
                )
            }
        ).executeAsList()
    }

    fun getAllArticlesUsingTrailingLambda(): List<ArticleRaw> {
        return database.dailyPulseDatabaseQueries.selectAllArticles { title, desc, date, imageUrl ->
            mapToArticlesRaw(
                title = title,
                desc = desc,
                date = date,
                url = imageUrl
            )
        }.executeAsList()
    }

    fun getAllArticlesUsingCallableReference(): List<ArticleRaw> {
        return database.dailyPulseDatabaseQueries.selectAllArticles(
            ::mapToArticlesRaw
        ).executeAsList()
    }

    fun insertArticles(articles: List<ArticleRaw>) {
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(article = articleRaw)
            }
        }
    }

    private fun insertArticle(article: ArticleRaw) {
        database.dailyPulseDatabaseQueries.insertArticle(
            title = article.title,
            desc = article.description,
            date = article.date,
            imageUrl = article.imageUrl
        )
    }

    private fun mapToArticlesRaw(
        title: String,
        desc: String?,
        date: String,
        url: String?,
    ): ArticleRaw {
        return ArticleRaw(
            title = title,
            description = desc,
            imageUrl = url,
            date = date,
        )
    }
}