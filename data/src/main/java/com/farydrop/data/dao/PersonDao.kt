package com.farydrop.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.farydrop.data.api.ApiService
import com.farydrop.data.dao.Person
import com.farydrop.domain.entity.PersonEntity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface PersonDao {
    @Insert
    fun insert(person:Person)

    @Query("SELECT * FROM person WHERE person.id = :id")
    fun get(id: Int): Single<Person>
}