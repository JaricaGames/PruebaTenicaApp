package com.jarica.pruebatecnicaapp.core.di

import com.jarica.pruebatecnicaapp.presentation.screens.characterOfTheDayScreen.CharacterOftheDayViewModel
import com.jarica.pruebatecnicaapp.presentation.screens.detailScreen.DetailScreenViewModel
import com.jarica.pruebatecnicaapp.presentation.screens.homeScreen.HomeScreenViewModel
import com.jarica.pruebatecnicaapp.presentation.screens.listScreen.ListScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {

    //Inyectamos los ViewModel
    viewModelOf(::HomeScreenViewModel)
    viewModelOf(::CharacterOftheDayViewModel)
    viewModelOf(::ListScreenViewModel)
    viewModelOf(::DetailScreenViewModel)

}