package com.example.fecthandroidexercise.data

import com.example.fecthandroidexercise.network.FetchApiService
import com.example.fecthandroidexercise.network.FetchItem

interface FetchItemsRepository {
    suspend fun getFetchItems(): List<FetchItem>
}

class NetworkFetchItemsRepository(
    private val fetchApiService: FetchApiService
) : FetchItemsRepository {
    override suspend fun getFetchItems(): List<FetchItem> =
        fetchApiService.getFetchData()
}