package com.jarica.pruebatecnicaapp.core

import android.app.Application
import com.jarica.pruebatecnicaapp.core.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

//Clase Application
class PruebaTecnicaApp : Application() {

    override fun onCreate() {
        super.onCreate()
        //Inicializamos Koin
        initKoin {
            androidLogger()
            androidContext(this@PruebaTecnicaApp) // Para inyectar el contexto
        }
    }
}
