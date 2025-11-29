package com.jarica.pruebatecnicaapp.presentation.screens.detailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarica.pruebatecnicaapp.domain.useCases.GetCharacterByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailScreenViewModel(
    val getCharacterByIdUseCase: GetCharacterByIdUseCase): ViewModel() {

    private val _state = MutableStateFlow<DetailsScreenState>(DetailsScreenState())
    val uiState: StateFlow<DetailsScreenState> = _state

    fun getCharacterById(idCharacter: Int){

        viewModelScope.launch {
            val result = withContext(Dispatchers.IO){
                getCharacterByIdUseCase(idCharacter)
            }
            _state.update { it.copy(characterSelected = result) } // ACtualizamos el estado con el nuevo personaje
        }
    }

}