package com.farydrop.onlinestoreapp.data.repository

import com.farydrop.onlinestoreapp.data.api.RetrofitInstance
import com.farydrop.onlinestoreapp.data.entity.Item
import com.farydrop.onlinestoreapp.data.entity.ItemEntity
import retrofit2.Call
import retrofit2.Response

class GetStoreListRepository {
    suspend fun getStoreItem(): Response<ItemEntity> {
        return RetrofitInstance.api.getStore()
    }
}