package com.jarica.pruebatecnicaapp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoResponse (
    @SerialName("count") val count : Int
)