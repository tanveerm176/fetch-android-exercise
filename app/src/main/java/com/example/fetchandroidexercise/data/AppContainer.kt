package com.example.fetchandroidexercise.data

import com.example.fetchandroidexercise.network.FetchApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
* Dependency interface for providing application level dependencies
 */
interface AppContainer {
    val fetchItemsRepository: FetchItemsRepository
}

/**
* Default implementation of [AppContainer] that provides dependencies using Retrofit
 * */
class DefaultAppContainer : AppContainer {

    //Base URL for the API call
    private val baseUrl = "https://fetch-hiring.s3.amazonaws.com"

    //Retrofit instance configured with GsonConverterFactory
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    //Lazy-init Retrofit service instance for FetchApiService
    val retrofitService: FetchApiService by lazy{
        retrofit.create(FetchApiService::class.java)
    }

    //Repository instance providing access to fetch items from the network
    override val fetchItemsRepository: FetchItemsRepository by lazy {
        NetworkFetchItemsRepository(retrofitService)
    }
}