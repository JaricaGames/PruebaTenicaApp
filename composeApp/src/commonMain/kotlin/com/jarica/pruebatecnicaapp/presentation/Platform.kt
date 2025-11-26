package com.jarica.pruebatecnicaapp.presentation

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform