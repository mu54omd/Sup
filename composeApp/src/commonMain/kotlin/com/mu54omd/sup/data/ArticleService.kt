package com.mu54omd.sup.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticleService(private val httpClient: HttpClient) {
    private val country: String = "us"
    private val category: String = "technology"
    private val apiKey: String = "24a4726e5784461f9419a8ccc074e804"

    suspend fun fetchArticles(): List<ArticleRaw>{
        val response: ArticleResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=${country}&category=${category}&apiKey=${apiKey}").body()
        return response.articles
    }
}