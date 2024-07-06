package com.petros.efthymiou.dailypulse.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.petros.efthymiou.dailypulse.articles.application.Article
import com.petros.efthymiou.dailypulse.articles.presentation.ArticlesViewModel
import com.petros.efthymiou.dailypulse.ui.screens.elements.ErrorMessage
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.ktor.http.Url
import org.koin.compose.koinInject

@Composable
fun ArticlesScreen(
    articlesViewModel: ArticlesViewModel = koinInject(),
) {
    val articlesState = articlesViewModel.articlesState.collectAsState()
    val onAboutButtonClick: () -> Unit = {}
    val onSourcesButtonClick: () -> Unit = {}
    Column {
        AppBar(onAboutButtonClick, onSourcesButtonClick)
        if (articlesState.value.error != null){
            ErrorMessage(articlesState.value.error!!)
        }
        if (articlesState.value.articles.isNotEmpty()){
            ArticlesListView(articlesViewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
    onAboutButtonClick: () -> Unit,
    onSourcesButtonClick: () -> Unit,
) {
    TopAppBar(
        title = { Text(text = "Articles") },
        actions = {
            IconButton(onClick = onSourcesButtonClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.List,
                    contentDescription = "Sources Button",
                )
            }
            IconButton(onClick = onAboutButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About Device Button",
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArticlesListView(viewModel: ArticlesViewModel) {
    val refreshState = rememberPullRefreshState(
        refreshing = viewModel.articlesState.value.loading,
        onRefresh = { viewModel.getArticles(forceFetch = true) }
    )

    Box(
        modifier = Modifier.pullRefresh(state = refreshState)
    ) {
        LazyColumn {
            items(viewModel.articlesState.value.articles) { article ->
                ArticleItemView(article = article)
            }
        }
        PullRefreshIndicator(
            refreshing = viewModel.articlesState.value.loading,
            state = refreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}

@Composable
fun ArticleItemView(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        KamelImage(
            resource = asyncPainterResource(data = Url(urlString = article.imageUrl)),
            contentDescription = "article images",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(200.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.desc)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}