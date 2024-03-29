package com.farydrop.onlinestoreapp.data.api

import com.farydrop.onlinestoreapp.data.entity.Item
import com.farydrop.onlinestoreapp.data.entity.ItemEntity
import com.google.gson.GsonBuilder
import com.google.gson.InstanceCreator
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {

    const val BASE_URL = "https://run.mocky.io/v3/"

    var client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .build()


    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}