package com.farydrop.onlinestoreapp.data.repository

import androidx.annotation.MainThread
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.data.entity.Details
import com.farydrop.onlinestoreapp.data.entity.Person

interface CatalogDataBaseRepository {

    @MainThread
    suspend fun insertCatalog(catalog:Catalog)

    @MainThread
    suspend fun insertPerson(person: Person)

    @MainThread
    suspend fun deleteCatalog(catalog: Catalog)

    @MainThread
    suspend fun getAll(): List<Catalog>

    @MainThread
    suspend fun getDetails(): Details

    @MainThread
    suspend fun getPerson(): Person

    @MainThread
    suspend fun insertDetails(details: Details)

    @MainThread
    suspend fun deleteDetails(details: Details)

    @MainThread
    suspend fun deletePerson(person: Person)
}