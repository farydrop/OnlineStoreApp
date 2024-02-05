package com.farydrop.onlinestoreapp.di

import android.app.Application
import androidx.room.Room
import com.farydrop.data.dao.PersonDao
import com.farydrop.data.dao.PersonDataBase
import org.koin.dsl.module

val daoModule = module {
    single { createDataBase(get()) }
    single { createPersonDao(get()) }
}

private fun createDataBase(app: Application): PersonDataBase =
    Room
        .databaseBuilder(app, PersonDataBase::class.java, "PersonDatabase")
        .build()

private fun createPersonDao(database: PersonDataBase): PersonDao =
    database.personDao()