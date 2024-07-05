package com.example.fecthandroidexercise.data

import com.example.fecthandroidexercise.network.FetchApi
import com.example.fecthandroidexercise.network.FetchItem

interface FetchItemRepository {
    suspend fun getFetchItems(): List<FetchItem>
}

class NetworkFetchItemsRepository() : FetchItemRepository {
    override suspend fun getFetchItems(): List<FetchItem> {
        return FetchApi.retrofitService.getFetchData()
    }
}