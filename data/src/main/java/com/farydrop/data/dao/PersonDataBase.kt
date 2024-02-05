package com.farydrop.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farydrop.data.dao.Person
import com.farydrop.data.dao.PersonDao

@Database(entities = [Person::class], version = 1)
abstract class PersonDataBase: RoomDatabase() {
    abstract fun personDao(): PersonDao
}