package com.petros.efthymiou.dailypulse.articles.data.network

import com.petros.efthymiou.dailypulse.Config
import com.petros.efthymiou.dailypulse.articles.data.network.model.ArticleRaw
import com.petros.efthymiou.dailypulse.articles.data.network.model.ArticlesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

private const val COUNTRY = "us"
private const val BUSINESS = "business"
private const val API_KEY = Config.API_KEY

class ArticlesService(private val httpClient : HttpClient) {

    private val country = COUNTRY
    private val business = BUSINESS
    private val apiKey = API_KEY

    suspend fun fetchArticles() : List<ArticleRaw> {
        val response : ArticlesResponse = httpClient.get(
            urlString = "https://newsapi.org/v2/top-headlines?country=$country&category=$business&apiKey=$apiKey"
        ).body()
        return response.articles
    }
}