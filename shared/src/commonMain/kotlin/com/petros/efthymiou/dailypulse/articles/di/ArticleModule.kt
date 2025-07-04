package com.petros.efthymiou.dailypulse.articles.di

import com.petros.efthymiou.dailypulse.articles.ArticlesViewModel
import com.petros.efthymiou.dailypulse.articles.data.network.ArticlesService
import com.petros.efthymiou.dailypulse.articles.domain.usecase.ArticleUseCase
import org.koin.dsl.module

val articleModule = module {

    single<ArticlesService> {
        ArticlesService(
            httpClient = get()
        )
    }

    single<ArticleUseCase> {
        ArticleUseCase(
            service = get()
        )
    }

    single<ArticlesViewModel> {
        ArticlesViewModel(
            useCase = get()
        )
    }
}