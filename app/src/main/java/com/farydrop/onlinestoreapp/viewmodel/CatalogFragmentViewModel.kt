package com.farydrop.onlinestoreapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farydrop.onlinestoreapp.R
import com.farydrop.onlinestoreapp.data.entity.Catalog
import com.farydrop.onlinestoreapp.data.entity.Item
import com.farydrop.onlinestoreapp.data.entity.ItemEntity
import com.farydrop.onlinestoreapp.data.repository.GetStoreListRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.awaitResponse

class CatalogFragmentViewModel : ViewModel() {

    var repo = GetStoreListRepository()
    val catalog: MutableLiveData<List<Catalog>> = MutableLiveData()
    private val allItems = mutableListOf<Catalog>()

    init {
        //getCatalog()
        catalog()
    }

    fun getCatalog() {
        viewModelScope.launch {
            //catalogList()?.let { allItems.addAll(it) }
            //catalog.value = repo.getStoreItem()
        }
    }

    /*private suspend fun catalogList(url: String = "https://run.mocky.io/v3/97e721a7-0a66-4cae-b445-83cc0bcf9010"): List<Item>? {
        val catalogResponse = repo.getStoreItem(url).awaitResponse()
        val characterData = catalogResponse.body()
        return characterData
    }*/

    fun catalog() {
        viewModelScope.launch {
            val itemsResponse: Response<ItemEntity> = repo.getStoreItem()
            if (itemsResponse.isSuccessful) {
                val items: List<Item>? = itemsResponse.body()?.items
                val idImageMap = mapOf(
                    "cbf0c984-7c6c-4ada-82da-e29dc698bb50" to Pair(R.drawable.six, R.drawable.five),
                    "54a876a5-2205-48ba-9498-cfecff4baa6e" to Pair(R.drawable.one, R.drawable.two),
                    "75c84407-52e1-4cce-a73a-ff2d3ac031b3" to Pair(R.drawable.five, R.drawable.six),
                    "16f88865-ae74-4b7c-9d85-b68334bb97db" to Pair(R.drawable.three, R.drawable.four),
                    "26f88856-ae74-4b7c-9d85-b68334bb97db" to Pair(R.drawable.two, R.drawable.three),
                    "15f88865-ae74-4b7c-9d81-b78334bb97db" to Pair(R.drawable.six, R.drawable.one),
                    "88f88865-ae74-4b7c-9d81-b78334bb97db" to Pair(R.drawable.four, R.drawable.three),
                    "55f58865-ae74-4b7c-9d81-b78334bb97db" to Pair(R.drawable.one, R.drawable.five)
                )

                val catalogItems = mutableListOf<Catalog>()

                idImageMap.forEach { (id, images) ->
                    val itemToCompare = items?.find { it.id == id }
                    itemToCompare?.let { item ->
                        val (imgOne, imgTwo) = images
                        val catalogItem = Catalog(
                            imgOne = imgOne,
                            imgTwo = imgTwo,
                            available = item.available,
                            description = item.description,
                            feedback = item.feedback,
                            id = item.id,
                            ingredients = item.ingredients,
                            isFavorites = false,
                            price = item.price,
                            subtitle = item.subtitle,
                            title = item.title
                        )
                        catalogItems.add(catalogItem)
                        catalog.value = catalogItems
                    }
                }
            } else {
                // Обработка ошибки, если запрос не удался
                Log.e("MyTag", "Failed to fetch items: ${itemsResponse.message()}")
            }
        }
    }

}

