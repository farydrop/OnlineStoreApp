package com.farydrop.onlinestoreapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.data.entity.Details
import com.farydrop.onlinestoreapp.data.repository.CatalogDataBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductPageFragmentViewModel(private val catalogDao: CatalogDataBaseRepository):ViewModel() {

    val catalogListState = MutableLiveData<Details>()

    fun getCatalog() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val item = catalogDao.getDetails()
                withContext(Dispatchers.Main) {
                    //val list = mutableListOf<Catalog>()
                    catalogListState.value = item
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    //catalogListState.value = emptyList()
                }
            }
        }
    }

    fun deleteDetails(details: Details) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                catalogDao.deleteDetails(details)
                // После удаления обновляем список избранных элементов
                getCatalog()
            } catch (e: Exception) {
                // Обработка ошибок удаления
            }
        }
    }
}