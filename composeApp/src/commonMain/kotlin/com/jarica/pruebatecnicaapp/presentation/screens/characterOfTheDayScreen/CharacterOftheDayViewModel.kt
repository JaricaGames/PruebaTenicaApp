package com.jarica.pruebatecnicaapp.presentation.screens.characterOfTheDayScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarica.pruebatecnicaapp.domain.useCases.GetRandomCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterOftheDayViewModel(
    val getRandomCharacter: GetRandomCharacter
): ViewModel() {

    private val _state = MutableStateFlow<CharacterState>(CharacterState())
    val state: StateFlow<CharacterState> = _state

    fun OnCharacterOfTheDayClick(){

        viewModelScope.launch {

            val result = withContext(Dispatchers.IO){
                getRandomCharacter()
            }
            _state.update { it.copy(characterOfTheDay = result) } // ACtualizamos el estado con el nuevo personaje


        }

    }


}