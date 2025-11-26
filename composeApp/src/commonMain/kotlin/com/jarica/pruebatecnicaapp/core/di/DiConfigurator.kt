package com.jarica.pruebatecnicaapp.core.di

import androidx.compose.foundation.gestures.DraggableAnchorsConfig
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

//Para inyectar cosas especificas en Android y iOs, se crean los actual y platformModule
expect fun platformModule() : Module

fun initKoin(config: KoinAppDeclaration? = null){

    startKoin {
        config?.invoke(this)
        modules(
            presentationModule,
            domainModule,
            dataModule,
            platformModule()
        )

    }
}