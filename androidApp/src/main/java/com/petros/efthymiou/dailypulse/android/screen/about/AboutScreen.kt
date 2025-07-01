package com.petros.efthymiou.dailypulse.android.screen.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.petros.efthymiou.dailypulse.android.PlatformInfo

@Composable
fun AboutScreen(
    toolbarTitle: String,
    pairList : List<Pair<String,String>> = PlatformInfo.platformItems(),
    upButtonClick: () -> Unit,
){
    Column {
        Toolbar(
            title = toolbarTitle,
            upButtonClick = upButtonClick
        )
        ContentView(
            pairList = pairList
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    title: String,
    upButtonClick: () -> Unit,
){
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = upButtonClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack  ,
                    contentDescription = "Up Button"
                )
            }
        }
    )
}

@Composable
fun ContentView(
    pairList : List<Pair<String,String>> = PlatformInfo.platformItems()
){
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(pairList){ row ->
           RowView(
               title = row.first,
               subtitle = row.second,
               modifier =  Modifier.padding(8.dp)
           )
        }
    }
}

@Composable
fun RowView(
    title:String,
    subtitle:String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.DarkGray

        )
    }
    Divider(modifier = Modifier.padding(horizontal = 4.dp))
}

@Composable
@Preview
fun AboutScreenPreview(){
    AboutScreen(
        toolbarTitle = "About",
        upButtonClick = {}
    )
}

@Composable
@Preview
fun RowViewPreview(){
    RowView(
        title = "Row View Title",
        subtitle = "Row View SubTitle",
    )
}

@Composable
@Preview
fun RowViewInDeviceWidthPreview(){
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        RowView(
            title = "Row View Title",
            subtitle = "Row View SubTitle",
        )
    }
}

@Composable
@Preview
fun ToolbarPreview(){
    Toolbar(
        title = "Toolbar Preview \nTitle",
        upButtonClick = {}
    )
}
