package com.farydrop.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface PersonDao {
    @Insert
    fun insert(person: Person): Completable

    @Query("SELECT * FROM person WHERE person.id = :id")
    fun get(id: Int): Single<Person>
}