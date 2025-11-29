package com.jarica.pruebatecnicaapp.presentation.screens.characterOfTheDayScreen

import com.jarica.pruebatecnicaapp.domain.models.CharacterModel

data class CharacterOfTheDayScreenState(
    val randomCharacter: CharacterModel? = null,
    val savedIdCharacter: String = "",
    val error: String? = null
)
