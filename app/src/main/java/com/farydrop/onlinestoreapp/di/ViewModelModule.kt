package com.farydrop.onlinestoreapp.di

import com.farydrop.onlinestoreapp.viewmodel.CatalogFragmentViewModel
import com.farydrop.onlinestoreapp.viewmodel.FavoritesFragmentViewModel
import com.farydrop.onlinestoreapp.viewmodel.ProductPageFragmentViewModel
import com.farydrop.onlinestoreapp.viewmodel.SignInViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
   viewModel { SignInViewModel(get()) }
   viewModel { CatalogFragmentViewModel(get()) }
   viewModel { FavoritesFragmentViewModel(get()) }
   viewModel { ProductPageFragmentViewModel(get()) }
}