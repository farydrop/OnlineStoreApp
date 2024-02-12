package com.farydrop.onlinestoreapp.data.repository

import com.farydrop.onlinestoreapp.data.dao.CatalogDao
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.data.entity.Details
import com.farydrop.onlinestoreapp.data.entity.Person

class CatalogDataBaseRepositoryImpl(private val catalogDao: CatalogDao): CatalogDataBaseRepository {
    override suspend fun insertCatalog(catalog: Catalog) {
        catalogDao.insertCatalog(catalog)
    }

    override suspend fun insertPerson(person: Person) {
        catalogDao.insertPerson(person)
    }

    override suspend fun deleteCatalog(catalog: Catalog) {
        catalogDao.deleteCatalog(catalog)
    }

    override suspend fun getAll(): List<Catalog> {
        return  catalogDao.getAll()
    }

    override suspend fun getDetails(): Details {
        return catalogDao.getDetails()
    }

    override suspend fun getPerson(): Person {
        return catalogDao.getPerson()
    }

    override suspend fun insertDetails(details: Details) {
        catalogDao.insertDetails(details)
    }

    override suspend fun deleteDetails(details: Details) {
        catalogDao.deleteDetails(details)
    }

    override suspend fun deletePerson(person: Person) {
        catalogDao.deletePerson(person)
    }
}