package com.jarica.pruebatecnicaapp.presentation.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jarica.pruebatecnicaapp.presentation.screens.components.CustomButton
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    onCharacterOfTheDayClick: () -> Unit,
    onCharacterListClick: () -> Unit) {

    val viewModel = koinViewModel<HomeScreenViewModel>()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        CustomButton(
            modifier = Modifier,
            text = "Personaje Random",
            onClick = { onCharacterOfTheDayClick() }
        )
 /*       Button(
            onClick = { onCharacterOfTheDayClick() }){
            Text("Character of the day")
        }*/
        Spacer(modifier = Modifier.height(20.dp))
        CustomButton(
            modifier = Modifier,
            text = "Lista de Personajes",
            onClick = { onCharacterListClick() }
        )
        /*Button(
            onClick = { onCharacterListClick() }){
            Text("Character List")
        }
*/
    }



}