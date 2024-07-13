package com.example.fetchandroidexercise.network

import com.example.fetchandroidexercise.data.FetchItem
import retrofit2.http.GET

/**
Retrofit service interface for fetching data from the API
*/
interface FetchApiService{
    /**
    * Makes a GET request to retrieve a list of FetchItems from the API endpoint /hiring.json
    *
    * @return List of FetchItem objects received from API*/
    @GET("hiring.json")
    suspend fun getFetchData(): List<FetchItem>
}
