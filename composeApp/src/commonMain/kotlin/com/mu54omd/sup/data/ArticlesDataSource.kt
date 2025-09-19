package com.mu54omd.sup.data

import mu54omd.sup.db.SupDatabase

class ArticlesDataSource(private val database: SupDatabase) {
    fun getAllArticles(): List<ArticleRaw> = database.supDatabaseQueries.selectAll(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database.supDatabaseQueries.transaction {
            articles.forEach { articleRaw ->
                insertArticle(articleRaw)
            }
        }
    }

    fun removeAllArticles() = database.supDatabaseQueries.removeAll()


    private fun mapToArticleRaw(title: String, description: String?, date: String, imageUrl: String?): ArticleRaw =
        ArticleRaw(
            title = title,
            description = description,
            publishedAt = date,
            urlToImage = imageUrl
        )
    private fun insertArticle(article: ArticleRaw){
        database.supDatabaseQueries.insertArticles(article.title, article.description, article.publishedAt, article.urlToImage)
    }
}