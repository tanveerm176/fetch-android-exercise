package com.example.fetchandroidexercise.network

import retrofit2.http.GET
interface FetchApiService{
    @GET("hiring.json")
    suspend fun getFetchData(): List<FetchItem>
}
