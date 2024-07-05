package com.example.fetchandroidexercise.data

import com.example.fetchandroidexercise.network.FetchApiService
import com.example.fetchandroidexercise.network.FetchItem

interface FetchItemsRepository {
    suspend fun getFetchItems(): List<FetchItem>
}

class NetworkFetchItemsRepository(
    private val fetchApiService: FetchApiService
) : FetchItemsRepository {
    override suspend fun getFetchItems(): List<FetchItem> =
        fetchApiService.getFetchData()
}