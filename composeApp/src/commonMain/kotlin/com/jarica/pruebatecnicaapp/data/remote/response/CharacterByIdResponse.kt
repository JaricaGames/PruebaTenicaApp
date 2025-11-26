package com.jarica.pruebatecnicaapp.data.remote.response

import com.jarica.pruebatecnicaapp.domain.models.CharacterModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterByIdResponse (
    @SerialName("id") val id: String,
    @SerialName("status") val status: String,
    @SerialName("image") val image: String,
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id,
            status = status,
            image = image,
        )
    }
}

