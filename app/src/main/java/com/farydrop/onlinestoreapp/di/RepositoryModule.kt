package com.farydrop.onlinestoreapp.di

import com.farydrop.onlinestoreapp.data.repository.CatalogDataBaseRepository
import com.farydrop.onlinestoreapp.data.repository.CatalogDataBaseRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single <CatalogDataBaseRepository> { CatalogDataBaseRepositoryImpl(get()) }
}
