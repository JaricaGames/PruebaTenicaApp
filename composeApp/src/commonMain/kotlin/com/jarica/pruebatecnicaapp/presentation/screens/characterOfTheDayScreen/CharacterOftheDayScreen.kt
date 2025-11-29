package com.jarica.pruebatecnicaapp.presentation.screens.characterOfTheDayScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.jarica.pruebatecnicaapp.domain.models.CharacterModel
import com.jarica.pruebatecnicaapp.presentation.Blue
import com.jarica.pruebatecnicaapp.presentation.Grey
import com.jarica.pruebatecnicaapp.presentation.Red
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

        CharacterOfTheDayCard(state.randomCharacter)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { characterOfTheDayViewModel.OnCharacterOfTheDayClick() }) {
            Text("Character of the day")
        }
    }

}

@Composable
fun CharacterOfTheDayCard(character: CharacterModel? = null) { // Inicializamos a null para que el componente compruebe si hay model de datos o no, y asi mostrar una cosa u otra

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(250.dp)
            .border(
                width = 2.dp,
                color = Red,
                shape = RoundedCornerShape(20)
            ),
        shape = RoundedCornerShape(20),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Grey
        ),
    ) {
        if (character == null) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = character.image,
                    modifier = Modifier.weight(0.4f),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Character image"
                )
                Spacer(modifier = Modifier.size(16.dp))
                Column(
                    modifier = Modifier.weight(0.6f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(character.name, color = Blue)
                    Text(character.status, color = Blue)
                }

            }

        }
    }
}

