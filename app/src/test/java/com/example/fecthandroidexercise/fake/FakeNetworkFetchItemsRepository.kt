package com.example.fecthandroidexercise.fake

import com.example.fecthandroidexercise.data.FetchItemsRepository
import com.example.fecthandroidexercise.network.FetchItem

class FakeNetworkFetchItemsRepository : FetchItemsRepository {
    override suspend fun getFetchItems(): List<FetchItem> {
        return FakeDataSource.itemList
    }
}