package com.farydrop.onlinestoreapp.di

import com.farydrop.domain.interactors.SignInInteractor
import com.farydrop.domain.usecase.SignInUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory<SignInUseCase> { SignInInteractor(get()) }
}