package com.jarica.pruebatecnicaapp.domain.useCases

import com.jarica.pruebatecnicaapp.domain.Repository
import com.jarica.pruebatecnicaapp.domain.models.CharacterModel

class GetCharacterByIdUseCase(val repository: Repository) {

    suspend operator fun invoke(idCharacter: Int): CharacterModel {

        return repository.getCharacterById(idCharacter.toString())
    }
}