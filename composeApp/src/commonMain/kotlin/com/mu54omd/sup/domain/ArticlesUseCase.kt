package com.mu54omd.sup.domain

import com.mu54omd.sup.data.ArticleRaw
import com.mu54omd.sup.data.ArticlesRepository
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

class ArticlesUseCase(private val repo: ArticlesRepository) {
    suspend fun getArticles(forceFetch: Boolean): List<Article>{
        val articlesRaw = repo.getArticles(forceFetch)
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map {
        Article(
            title = it.title,
            description = it.description ?: "Click to find out more.",
            date = getDaysAgoString(it.publishedAt),
            imageUrl = it.urlToImage ?: ""
        )
    }

    @OptIn(ExperimentalTime::class)
    private fun getDaysAgoString(date: String): String {
        val today = Clock.System.todayIn(TimeZone.Companion.currentSystemDefault())
        val days = today.daysUntil(
            Instant.Companion.parse(date).toLocalDateTime(TimeZone.Companion.currentSystemDefault()).date
        )
        val result = when {
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }
        return result
    }
}