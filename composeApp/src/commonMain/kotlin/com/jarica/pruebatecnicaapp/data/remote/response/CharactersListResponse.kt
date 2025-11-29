package com.jarica.pruebatecnicaapp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersListResponse (
    @SerialName("results") val characterList : List<CharacterResponse>,
    @SerialName("info") val info : InfoResponse
)


