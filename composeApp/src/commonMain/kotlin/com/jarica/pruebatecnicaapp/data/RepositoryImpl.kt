package com.jarica.pruebatecnicaapp.data

import com.jarica.pruebatecnicaapp.data.remote.ApiService
import com.jarica.pruebatecnicaapp.data.remote.response.CharactersListResponse
import com.jarica.pruebatecnicaapp.domain.Repository
import com.jarica.pruebatecnicaapp.domain.models.CharacterModel


class RepositoryImpl(val api: ApiService):Repository {

    override suspend fun getCharacterById(id: String): CharacterModel {
        return api.getCharacterById(id).toDomain()
    }

    override suspend fun getCharactersList(): List<CharacterModel> {
        return api.getCharactersList().characterList.map {
            it.toDomain()
        }
    }



}


