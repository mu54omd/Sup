package com.mu54omd.sup.presentation

import com.mu54omd.sup.domain.Article

data class ArticlesState(
    val articles: List<Article> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)