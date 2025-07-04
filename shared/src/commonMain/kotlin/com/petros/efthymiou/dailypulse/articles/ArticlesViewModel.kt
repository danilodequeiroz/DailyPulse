package com.petros.efthymiou.dailypulse.articles

import com.petros.efthymiou.dailypulse.BaseViewModel
import com.petros.efthymiou.dailypulse.articles.domain.usecase.ArticleUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    val useCase: ArticleUseCase
) : BaseViewModel() {
    private val _articlesState : MutableStateFlow<ArticlesState> = MutableStateFlow(
        ArticlesState(loading = true)
    )
    val articlesState : StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles(){
        scope.launch {
           val fetchedArticles = useCase.getArticles()
            _articlesState.emit(ArticlesState(
                articles = fetchedArticles
            ))
        }
    }
}