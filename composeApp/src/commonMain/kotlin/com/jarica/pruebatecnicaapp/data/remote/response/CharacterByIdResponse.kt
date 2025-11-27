package com.jarica.pruebatecnicaapp.data.remote.response

import com.jarica.pruebatecnicaapp.domain.models.CharacterModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterByIdResponse (
    @SerialName("id") val id: Int,
    @SerialName("status") val status: String,
    @SerialName("image") val image: String,
    @SerialName("name") val name: String,

) {

    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id.toString(),
            status = status,
            image = image,
            name = name
        )
    }

}

