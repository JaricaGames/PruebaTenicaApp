package com.jarica.pruebatecnicaapp.presentation.screens.characterOfTheDayScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CharacterOfTheDayScreen() {

    val characterOfTheDayViewModel = koinViewModel<CharacterOftheDayViewModel>()
    val state by characterOfTheDayViewModel.state.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        state.characterOfTheDay?.let {
            Text(it.name)
        }

        Button(onClick = { characterOfTheDayViewModel.OnCharacterOfTheDayClick() }) {
            Text("Character of the day")
        }
    }




}


