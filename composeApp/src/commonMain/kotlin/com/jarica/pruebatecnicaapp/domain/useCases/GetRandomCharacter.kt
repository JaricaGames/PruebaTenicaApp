package com.jarica.pruebatecnicaapp.domain.useCases

import com.jarica.pruebatecnicaapp.core.NUMERO_MAXIMO_CHARACTER_API
import com.jarica.pruebatecnicaapp.domain.Repository
import com.jarica.pruebatecnicaapp.domain.models.CharacterModel

class GetRandomCharacter(val repository: Repository) {

    suspend operator fun invoke(): CharacterModel {
        val randomNumber = (1..NUMERO_MAXIMO_CHARACTER_API).random() // Calculamos un numero aletorio de entre las 826 personajes de la API
        return repository.getCharacterById(randomNumber.toString())
    }

}