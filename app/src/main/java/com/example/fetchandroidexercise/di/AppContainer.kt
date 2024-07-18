package com.example.fetchandroidexercise.di

import com.example.fetchandroidexercise.data.FetchItemsRepository
import com.example.fetchandroidexercise.data.NetworkFetchItemsRepository
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
 *  implements the singleton pattern, which ensures only one instance of the object is  created
 *  and used across the entire application.
 * */
object DefaultAppContainer : AppContainer {

    //Base URL for the API call
    private const val baseUrl = "https://fetch-hiring.s3.amazonaws.com"

    //Retrofit instance configured with GsonConverterFactory
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    //Lazy-init Retrofit service instance for FetchApiService
    private val retrofitService: FetchApiService by lazy{
        retrofit.create(FetchApiService::class.java)
    }

    //Repository instance providing access to fetch items from the network
    override val fetchItemsRepository: FetchItemsRepository by lazy {
        NetworkFetchItemsRepository(retrofitService)
    }
}