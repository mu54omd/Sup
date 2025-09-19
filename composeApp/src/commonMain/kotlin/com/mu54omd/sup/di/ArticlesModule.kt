package com.mu54omd.sup.di

import com.mu54omd.sup.data.ArticleService
import com.mu54omd.sup.data.ArticlesDataSource
import com.mu54omd.sup.data.ArticlesRepository
import com.mu54omd.sup.domain.ArticlesUseCase
import com.mu54omd.sup.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticleService> { ArticleService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}