package com.jarica.pruebatecnicaapp.core.di

import androidx.datastore.core.DataStore
import com.jarica.pruebatecnicaapp.core.BASE_URL
import com.jarica.pruebatecnicaapp.data.RepositoryImpl
import com.jarica.pruebatecnicaapp.data.remote.ApiService
import com.jarica.pruebatecnicaapp.domain.Repository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {

    //Creamos un singleton para la inyeccion de Ktor
    single {
        HttpClient{
            install(ContentNegotiation){
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any) // Builder, si algun valor lo desconoce lo ignora, y podemos recibir cualquier tipo de dato
            }
            install(DefaultRequest){
                url{
                    protocol = URLProtocol.HTTPS
                    host = BASE_URL // constante deficinada en Constants
                }
            }

        }
    }

    // Inyeccion del ApiService
    factoryOf(::ApiService)

    //Inyecccion del repository
    factory<Repository> { RepositoryImpl(get()) }

}
