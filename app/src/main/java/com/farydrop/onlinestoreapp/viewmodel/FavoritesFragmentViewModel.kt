package com.farydrop.onlinestoreapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.data.repository.CatalogDataBaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesFragmentViewModel(private val catalogDao: CatalogDataBaseRepository):ViewModel() {
    val catalogListState = MutableLiveData<List<Catalog>>()

    fun getCatalog() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val item = catalogDao.getAll()
                withContext(Dispatchers.Main) {
                    //val list = mutableListOf<Catalog>()
                    catalogListState.value = item
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    catalogListState.value = emptyList()
                }
            }
        }
    }

    fun deleteItem(catalog: Catalog) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                catalogDao.deleteCatalog(catalog)
                // После удаления обновляем список избранных элементов
                getCatalog()
            } catch (e: Exception) {
                // Обработка ошибок удаления
            }
        }
    }
}