package com.example.effectivemobile

import android.app.Application
import com.example.effectivemobile.di.appModule
import com.example.effectivemobile.di.dataModule
import com.example.effectivemobile.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(dataModule, domainModule, appModule)
        }
    }
}