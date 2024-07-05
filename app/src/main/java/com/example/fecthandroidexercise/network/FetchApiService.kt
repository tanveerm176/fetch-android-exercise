package com.example.fecthandroidexercise.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
interface FetchApiService{
    @GET("hiring.json")
    suspend fun getFetchData(): List<FetchItem>
}
