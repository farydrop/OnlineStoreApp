package com.farydrop.onlinestoreapp.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.data.entity.Details
import com.farydrop.onlinestoreapp.data.entity.FeedbackConverter
import com.farydrop.onlinestoreapp.data.entity.InfoListConverter
import com.farydrop.onlinestoreapp.data.entity.PriceConverter
import com.farydrop.onlinestoreapp.data.entity.StringListConverter

@Database(entities = [Catalog::class, Details::class], version = 1)
@TypeConverters(StringListConverter::class, InfoListConverter::class, FeedbackConverter::class, PriceConverter::class)
abstract class CatalogDataBase : RoomDatabase() {
    abstract fun catalogDao(): CatalogDao
}