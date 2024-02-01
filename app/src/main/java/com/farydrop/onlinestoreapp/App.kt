package com.farydrop.onlinestoreapp

import android.app.Application
import com.farydrop.onlinestoreapp.di.daoModule
import com.farydrop.onlinestoreapp.di.repositoryModule
import com.farydrop.onlinestoreapp.di.useCasesModule
import com.farydrop.onlinestoreapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@App)
            // Load modules
            modules(repositoryModule, useCasesModule, viewModelModule, daoModule)
        }
    }
}