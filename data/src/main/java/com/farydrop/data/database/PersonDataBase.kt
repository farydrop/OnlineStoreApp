package com.farydrop.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1)
abstract class PersonDataBase: RoomDatabase() {
    abstract fun personDao(): PersonDao
}