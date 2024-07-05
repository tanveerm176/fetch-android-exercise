package com.example.fecthandroidexercise.data

import com.example.fecthandroidexercise.network.FetchApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val fetchItemsRepository: FetchItemRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://fetch-hiring.s3.amazonaws.com"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    val retrofitService: FetchApiService by lazy{
        retrofit.create(FetchApiService::class.java)
    }

    override val fetchItemsRepository: FetchItemRepository by lazy {
        NetworkFetchItemsRepository(retrofitService)
    }
}