package com.jarica.pruebatecnicaapp

import androidx.compose.ui.window.ComposeUIViewController
import com.jarica.pruebatecnicaapp.core.di.initKoin
import com.jarica.pruebatecnicaapp.presentation.App

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }