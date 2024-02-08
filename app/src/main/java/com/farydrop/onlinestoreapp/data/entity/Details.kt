package com.farydrop.onlinestoreapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "details_table")
data class Details(
    @ColumnInfo(name = "imgOne")val imgOne: Int,
    @ColumnInfo(name = "imgTwo")val imgTwo: Int,
    @ColumnInfo(name = "isFavorites")var isFavorites: Boolean,
    @ColumnInfo(name = "available")val available: Int,
    @ColumnInfo(name = "description")val description: String,
    @ColumnInfo(name = "feedback")val feedback: Feedback,
    @PrimaryKey
    @ColumnInfo(name = "id")val id: String,
    @ColumnInfo(name = "info")val info: List<Info>,
    @ColumnInfo(name = "ingredients")val ingredients: String,
    @ColumnInfo(name = "price")val price: Price,
    @ColumnInfo(name = "subtitle")val subtitle: String,
    @ColumnInfo(name = "tags")val tags: List<String>,
    @ColumnInfo(name = "title")val title: String
)