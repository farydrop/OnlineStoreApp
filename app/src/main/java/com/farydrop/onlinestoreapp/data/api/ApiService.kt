package com.farydrop.onlinestoreapp.data.api

import com.farydrop.onlinestoreapp.data.entity.Item
import com.farydrop.onlinestoreapp.data.entity.ItemEntity
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET("97e721a7-0a66-4cae-b445-83cc0bcf9010")
    suspend fun getStore(): Response<ItemEntity>
}