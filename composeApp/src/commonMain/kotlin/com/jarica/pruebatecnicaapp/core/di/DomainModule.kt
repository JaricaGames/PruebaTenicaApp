package com.jarica.pruebatecnicaapp.core.di

import com.jarica.pruebatecnicaapp.domain.useCases.GetRandomCharacter
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {

    //Inyectamos los casos de uso
    factoryOf(::GetRandomCharacter)
}