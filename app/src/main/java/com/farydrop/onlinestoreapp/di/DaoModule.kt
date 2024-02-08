package com.farydrop.onlinestoreapp.di

import android.app.Application
import androidx.room.Room
import com.farydrop.onlinestoreapp.data.dao.CatalogDao
import com.farydrop.onlinestoreapp.data.dao.CatalogDataBase
import org.koin.dsl.module

val daoModule = module {
    single { createDataBase(get()) }
    single { createCatalogDao(get()) }
}

private fun createDataBase(app: Application): CatalogDataBase =
    Room
        .databaseBuilder(app, CatalogDataBase::class.java, "CatalogDataBase")
        .build()

private fun createCatalogDao(database: CatalogDataBase): CatalogDao =
    database.catalogDao()
