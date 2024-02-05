package com.farydrop.data.api

import com.farydrop.data.api.entity.ItemEntity
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("97e721a7-0a66-4cae-b445-83cc0bcf9010")
    suspend fun getHomeStore(): Response<ItemEntity>
}