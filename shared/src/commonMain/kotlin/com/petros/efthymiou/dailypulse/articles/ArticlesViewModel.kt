package com.petros.efthymiou.dailypulse.articles

import com.petros.efthymiou.dailypulse.BaseViewModel
import com.petros.efthymiou.dailypulse.articles.mock.ArticlesMock
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel : BaseViewModel() {
    private val _articlesState : MutableStateFlow<ArticlesState> = MutableStateFlow(
        ArticlesState(loading = true)
    )
    val articlesState : StateFlow<ArticlesState> get() = _articlesState

    init{
        getArticles()
    }

    private fun getArticles(){
        scope.launch {
            delay(2000)

            _articlesState.emit(ArticlesState(
                error = "Ops, something went wrong.",
            ))

            delay(2000)

            _articlesState.emit(ArticlesState(
                loading = true,
            ))

            delay(5000)

            val fetchedArticles = fetchArticles()
            _articlesState.emit(ArticlesState(
                articles = fetchedArticles
            ))
        }
    }

    suspend fun fetchArticles() : List<Article>{
        return ArticlesMock().mockArticles
    }


}