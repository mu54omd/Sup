package com.mu54omd.sup.data

import app.cash.sqldelight.async.coroutines.awaitAsList
import com.mu54omd.sup.db.SharedDatabase

class ArticlesDataSource(private val sharedDatabase: SharedDatabase) {
    suspend fun getAllArticles(): List<ArticleRaw> {
        return sharedDatabase { database ->
            database.supDatabaseQueries.selectAll(::mapToArticleRaw).awaitAsList()
        }
    }

    suspend fun insertArticles(articles: List<ArticleRaw>) {
        sharedDatabase { database ->
            database.supDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
        }
    }

    suspend fun removeAllArticles() = sharedDatabase { database ->
        database.supDatabaseQueries.removeAll()
    }


    private fun mapToArticleRaw(title: String, description: String?, date: String, imageUrl: String?): ArticleRaw =
        ArticleRaw(
            title = title,
            description = description,
            publishedAt = date,
            urlToImage = imageUrl
        )
    private suspend fun insertArticle(article: ArticleRaw){
        sharedDatabase{ database ->
            database.supDatabaseQueries
                .insertArticles(
                    title = article.title,
                    description = article.description,
                    date = article.publishedAt,
                    imageUrl = article.urlToImage)
        }
    }
}