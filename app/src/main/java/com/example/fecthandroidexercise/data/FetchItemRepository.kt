package com.example.fecthandroidexercise.data

import com.example.fecthandroidexercise.network.FetchApiService
import com.example.fecthandroidexercise.network.FetchItem

interface FetchItemRepository {
    suspend fun getFetchItems(): List<FetchItem>
}

class NetworkFetchItemsRepository(
    private val fetchApiService: FetchApiService
) : FetchItemRepository {
    override suspend fun getFetchItems(): List<FetchItem> =
        fetchApiService.getFetchData()
}