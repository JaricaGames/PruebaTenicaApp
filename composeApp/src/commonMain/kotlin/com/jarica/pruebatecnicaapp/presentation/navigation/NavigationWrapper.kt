package com.jarica.pruebatecnicaapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jarica.pruebatecnicaapp.presentation.screens.characterOfTheDayScreen.CharacterOfTheDayScreen
import com.jarica.pruebatecnicaapp.presentation.screens.detailScreen.DetailScreen
import com.jarica.pruebatecnicaapp.presentation.screens.homeScreen.HomeScreen
import com.jarica.pruebatecnicaapp.presentation.screens.listScreen.ListScreen

@Composable
fun NavigationWrapper() {
     val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreenObject){

        composable<ListScreenObject> {
            ListScreen(
                onCharacterClick = { idCharacter ->
                    navController.navigate(DetailScreenObject(idCharacter = idCharacter))
                    },
                onBackPress = { navController.popBackStack() }
            )

        }

        composable<DetailScreenObject> { backStackEntry ->

            val detailScreen: DetailScreenObject = backStackEntry.toRoute()
            DetailScreen(detailScreen.idCharacter, onBackPress = { navController.popBackStack() })
        }


        composable<HomeScreenObject> {
            HomeScreen(
                onCharacterOfTheDayClick = { navController.navigate(CharacterOfTheDayScreenObject) },
                onCharacterListClick = { navController.navigate(ListScreenObject) }
            )
        }

        composable<CharacterOfTheDayScreenObject> {
            CharacterOfTheDayScreen(
                onBackPress = { navController.popBackStack() }
            )
        }


    }

}