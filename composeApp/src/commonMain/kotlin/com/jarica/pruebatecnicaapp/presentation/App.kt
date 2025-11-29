package com.jarica.pruebatecnicaapp.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.jarica.pruebatecnicaapp.presentation.navigation.NavigationWrapper
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}