package com.farydrop.onlinestoreapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.data.entity.Person
import com.farydrop.onlinestoreapp.data.repository.CatalogDataBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignInViewModel(private val catalogDao: CatalogDataBaseRepository): ViewModel() {

    val personState = MutableLiveData<Person>()

    fun insertPerson(person: Person) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                catalogDao.insertPerson(person)
            }
        }
    }

}