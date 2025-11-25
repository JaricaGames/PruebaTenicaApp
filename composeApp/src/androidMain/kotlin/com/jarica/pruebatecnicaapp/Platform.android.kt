package com.jarica.pruebatecnicaapp

import android.os.Build
import com.jarica.pruebatecnicaapp.presentation.Platform

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

//actual fun getPlatform(): Platform = AndroidPlatform()