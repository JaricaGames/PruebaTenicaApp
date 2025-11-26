package com.jarica.pruebatecnicaapp.data.remote

import com.jarica.pruebatecnicaapp.core.BASE_URL
import com.jarica.pruebatecnicaapp.data.remote.response.CharacterByIdResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ApiService(private val client: HttpClient) {

    suspend fun getCharactersList(): String {

        return client.get("api/character").body()
    }

    suspend fun getCharacterById(id: String): CharacterByIdResponse {

        return client.get("api/character/$id").body()
    }
}



