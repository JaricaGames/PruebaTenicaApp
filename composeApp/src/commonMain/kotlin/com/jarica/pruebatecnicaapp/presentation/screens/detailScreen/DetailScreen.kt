package com.jarica.pruebatecnicaapp.presentation.screens.detailScreen

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.jarica.pruebatecnicaapp.presentation.Blue
import com.jarica.pruebatecnicaapp.presentation.Grey
import com.jarica.pruebatecnicaapp.presentation.Red
import com.jarica.pruebatecnicaapp.presentation.screens.components.CustomButton
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DetailScreen(idCharacter: Int, onBackPress: () -> Boolean) {

    val detailScreenViewModel = koinViewModel<DetailScreenViewModel>()
    val uiState by detailScreenViewModel.uiState.collectAsState()

    LaunchedEffect(key1 = idCharacter) {
        detailScreenViewModel.getCharacterById(idCharacter)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .border(
                    width = 2.dp,
                    color = Red,
                    shape = RoundedCornerShape(20)
                ),
            shape = RoundedCornerShape(20),
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(
                containerColor = Grey // o el color que quieras
            ),

            ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = uiState.characterSelected?.image,
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
                    Text(uiState.characterSelected?.name ?: "", color = Blue)
                    Text(uiState.characterSelected?.status ?: "", color = Blue)
                }

            }


        }
        Spacer(modifier = Modifier.size(16.dp))
        CustomButton(
            modifier = Modifier,
            text = "Atras",
            onClick = {onBackPress()}
        )

    }

}

