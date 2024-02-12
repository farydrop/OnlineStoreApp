package com.farydrop.onlinestoreapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "firstName")val firstName: String,
    @ColumnInfo(name = "lastName")val lastName: String,
    @ColumnInfo(name = "phone")val phone: String
)