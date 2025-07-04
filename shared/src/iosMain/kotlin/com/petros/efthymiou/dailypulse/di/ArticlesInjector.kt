package com.petros.efthymiou.dailypulse.di

import com.petros.efthymiou.dailypulse.articles.ArticlesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ArticlesInjector : KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}