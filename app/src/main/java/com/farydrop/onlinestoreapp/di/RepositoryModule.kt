package com.farydrop.onlinestoreapp.di

import com.farydrop.data.SignInRepositoryImpl
import com.farydrop.domain.repository.SignInRepository
import org.koin.dsl.module

val repositoryModule = module {
    single <SignInRepository> { SignInRepositoryImpl(get()) }
}