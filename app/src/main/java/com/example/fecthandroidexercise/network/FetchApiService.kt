package com.example.fecthandroidexercise.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface FetchApiService{
    @GET("hiring.json")
    suspend fun getFetchData(): List<FetchItem>
}

object FetchApi{
    val retrofitService: FetchApiService by lazy{
        retrofit.create(FetchApiService::class.java)
    }
}
