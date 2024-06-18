package com.petros.efthymiou.dailypulse.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun App() {
    MaterialTheme {
        Scaffold {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Text("Hello world")
            }
        }
    }
}