package com.jarica.pruebatecnicaapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform