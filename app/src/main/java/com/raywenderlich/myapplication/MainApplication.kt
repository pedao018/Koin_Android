package com.raywenderlich.myapplication

import android.app.Application
import com.raywenderlich.myapplication.koin_anotation.KoinAnotationModule
import com.raywenderlich.myapplication.koin_normal.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(appModule ,KoinAnotationModule().module)
        }
    }
}