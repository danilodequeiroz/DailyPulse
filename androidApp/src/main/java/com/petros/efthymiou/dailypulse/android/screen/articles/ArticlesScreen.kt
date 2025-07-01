package com.petros.efthymiou.dailypulse.android.screen.articles

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.petros.efthymiou.dailypulse.articles.ArticlesState
import com.petros.efthymiou.dailypulse.articles.ArticlesViewModel

@Composable
fun ArticlesScreen(
    articlesViewModel: ArticlesViewModel,
    onAboutButtonClick: () -> Unit,
) {
    val articlesState: State<ArticlesState> = articlesViewModel.articlesState.collectAsState()
    ArticlesScreenContent(
        articlesState = articlesState.value,
        onAboutButtonClick = onAboutButtonClick
    )
}

@Composable
fun ArticlesScreenContent(
    articlesState: ArticlesState,
    onAboutButtonClick: () -> Unit,
) {
    Column {
        AppBar(onAboutButtonClick = { onAboutButtonClick.invoke() })
        if (articlesState.loading) {
            Loader()
        }
        if (articlesState.error != null) {
            ErrorMessage(
                message = articlesState.error ?: "Something went wrong...",
            )
        }
        if (articlesState.articles.isNotEmpty()) {
            ArticlesListView(
                articles = articlesState.articles
            )
        }
    }
}

@Preview(name = "Articles Screen - Loading", showBackground = true)
@Composable
fun ArticlesScreenPreviewLoading() {
    ArticlesScreenContent(
        articlesState = ArticlesState(
            loading = true,
            articles = emptyList(),
            error = null,
        ),
        onAboutButtonClick = {}
    )
}

@Preview(name = "Articles Screen - Error", showBackground = true)
@Composable
fun ArticlesScreenPreviewError() {
    ArticlesScreenContent(
        articlesState = ArticlesState(loading = false,
            articles = emptyList(),
            error = "Something went wrong..."
        ),
        onAboutButtonClick = {}
    )
}
