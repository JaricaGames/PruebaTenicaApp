package com.jarica.pruebatecnicaapp.presentation.screens.listScreen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.jarica.pruebatecnicaapp.domain.models.CharacterModel
import com.jarica.pruebatecnicaapp.presentation.Blue
import com.jarica.pruebatecnicaapp.presentation.Grey
import com.jarica.pruebatecnicaapp.presentation.Red
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ListScreen(onCharacterClick: (Int) -> Unit, onBackPress: () -> Boolean) {
    val listScreenViewModel = koinViewModel<ListScreenViewModel>()
    val uiState by listScreenViewModel.uiState.collectAsState()

    when (uiState) {
        is ListScreenState.Loading -> { // Screen cuando esta cargando
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is ListScreenState.Error -> { // Screen cuando hay un error
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    (uiState as ListScreenState.Error).throwable.message ?: "Error desconocido"
                )
            }
        }

        is ListScreenState.Success -> { // Screen cuando se cargan los datos

            val characters = (uiState as ListScreenState.Success).characters
            Scaffold(
                topBar = { TopBar(onBackPress) },
            ) { innerPadding ->

                ListOfCharacters(characters, onCharacterClick, innerPadding)
            }
        }
    }
}


@Composable
fun ListOfCharacters(
    characters: List<CharacterModel>,
    onCharacterClick: (Int) -> Unit,
    innerPadding: PaddingValues,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(
                top = innerPadding.calculateTopPadding(),
                start = 16.dp,
                end = 16.dp,
                bottom = 0.dp
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(characters) { character ->
            ItemCharacter(character, onCharacterClick)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onBackPress: () -> Boolean) {
    TopAppBar(
        title = { "" },
        navigationIcon = {
            Text(
                "Atras",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clickable { onBackPress() },
                color = Red
            )
        }
    )

}

@Composable
fun ItemCharacter(
    character: CharacterModel,
    onCharacterClick: (Int) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .border(
                width = 2.dp,
                color = Red,
                shape = RoundedCornerShape(20)
            )
            .clickable {
                onCharacterClick(character.id.toInt()) },
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
