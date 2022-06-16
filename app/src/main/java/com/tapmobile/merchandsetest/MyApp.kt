package com.tapmobile.myapplication

import android.app.Application
import android.os.Bundle
import com.tapmobile.myapplication.networking.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(
                listOf(
                    networkModule,
                    useCaseModule,
                    presentationModule
                )
            )
        }
    }
}