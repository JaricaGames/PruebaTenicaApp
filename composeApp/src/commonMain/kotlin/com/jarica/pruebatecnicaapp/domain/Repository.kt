package com.jarica.pruebatecnicaapp.domain

import com.jarica.pruebatecnicaapp.domain.models.CharacterModel

interface Repository {

    suspend fun getCharacterById(id:String): CharacterModel
    suspend fun getCharactersList(): List<CharacterModel>
}


