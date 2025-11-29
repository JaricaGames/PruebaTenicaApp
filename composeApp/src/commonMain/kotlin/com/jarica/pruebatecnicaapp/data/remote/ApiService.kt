package com.jarica.pruebatecnicaapp.data.remote

import com.jarica.pruebatecnicaapp.data.remote.response.CharacterResponse
import com.jarica.pruebatecnicaapp.data.remote.response.CharactersListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val client: HttpClient) {

    suspend fun getCharactersList(): CharactersListResponse {
        return client.get("api/character").body()
    }

    suspend fun getCharacterById(id: String): CharacterResponse {

        return client.get("api/character/$id").body()
    }
}



