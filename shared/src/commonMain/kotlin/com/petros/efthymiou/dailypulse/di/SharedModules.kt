package com.petros.efthymiou.dailypulse.di

import com.petros.efthymiou.dailypulse.articles.di.articleModule

val sharedModules = listOf(
    articleModule,
    networkModule,
)