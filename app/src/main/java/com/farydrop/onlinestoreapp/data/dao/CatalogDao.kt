package com.farydrop.onlinestoreapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.data.entity.Details

@Dao
interface CatalogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCatalog(catalog: Catalog)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetails(details: Details)

    @Delete
    fun deleteCatalog(catalog: Catalog)

    @Query("SELECT * FROM catalog_table")
    fun getAll(): List<Catalog>

    @Query("SELECT * FROM details_table WHERE details_table.id = id")
    fun getDetails(): Details

    @Delete
    fun deleteDetails(details: Details)

}