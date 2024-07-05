package com.example.fetchandroidexercise.fake

import com.example.fetchandroidexercise.data.FetchItemsRepository
import com.example.fetchandroidexercise.network.FetchItem

class FakeNetworkFetchItemsRepository : FetchItemsRepository {
    override suspend fun getFetchItems(): List<FetchItem> {
        return FakeDataSource.itemList
    }
}