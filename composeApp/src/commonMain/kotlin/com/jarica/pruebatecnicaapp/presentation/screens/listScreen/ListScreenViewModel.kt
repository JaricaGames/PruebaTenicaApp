package com.jarica.pruebatecnicaapp.presentation.screens.listScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jarica.pruebatecnicaapp.domain.Repository
import com.jarica.pruebatecnicaapp.domain.useCases.GetRandomCharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListScreenViewModel(
    private val repository: Repository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<ListScreenState>(ListScreenState.Loading)
    val uiState: StateFlow<ListScreenState> = _uiState

     init {
        getAllCharacters()
    }

    fun getAllCharacters() {
        viewModelScope.launch {

            try {
                val result = withContext(Dispatchers.IO) {
                    repository.getCharactersList()
                }
                _uiState.value = ListScreenState.Success(result)
            } catch (e: Exception) {
                _uiState.value = ListScreenState.Error(e)
            }
        }
    }



}