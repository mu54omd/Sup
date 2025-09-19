package com.mu54omd.sup.data

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticleService
) {
    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw> {
        if(forceFetch){
            dataSource.removeAllArticles()
            fetchArticles()
        }
        val articlesDb = dataSource.getAllArticles()
        if(articlesDb.isEmpty()){
            return fetchArticles()
        }
        return articlesDb
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val fetched = service.fetchArticles()
        dataSource.insertArticles(fetched)
        return fetched
    }
}