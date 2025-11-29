package com.jarica.pruebatecnicaapp.presentation.screens.listScreen

import com.jarica.pruebatecnicaapp.domain.models.CharacterModel

sealed interface ListScreenState {
    data object Loading : ListScreenState
    data class Error(val throwable: Throwable) : ListScreenState
    data class Success(val characters: List<CharacterModel>) : ListScreenState
}
