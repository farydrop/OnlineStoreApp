package com.farydrop.onlinestoreapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farydrop.onlinestoreapp.data.entity.Item
import com.farydrop.onlinestoreapp.data.entity.ItemEntity
import com.farydrop.onlinestoreapp.data.repository.GetStoreListRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.awaitResponse

class CatalogFragmentViewModel: ViewModel() {

    var repo = GetStoreListRepository()
    val catalog: MutableLiveData<Response<ItemEntity>> = MutableLiveData()
    private val allItems = mutableListOf<Any>()

    init {
        getCatalog()
    }

    fun getCatalog() {
        viewModelScope.launch {
            //catalogList()?.let { allItems.addAll(it) }
            catalog.value = repo.getStoreItem()
        }
    }

    /*private suspend fun catalogList(url: String = "https://run.mocky.io/v3/97e721a7-0a66-4cae-b445-83cc0bcf9010"): List<Item>? {
        val catalogResponse = repo.getStoreItem(url).awaitResponse()
        val characterData = catalogResponse.body()
        return characterData
    }*/


}

