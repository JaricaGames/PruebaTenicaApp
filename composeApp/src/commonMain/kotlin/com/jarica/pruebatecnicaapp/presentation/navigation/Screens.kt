package com.jarica.pruebatecnicaapp.presentation.navigation

import kotlinx.serialization.Serializable


@Serializable
data object HomeScreenObject

@Serializable
data class DetailScreenObject(
    val idCharacter: Int,
)

@Serializable
data object ListScreenObject

@Serializable
data object CharacterOfTheDayScreenObject
