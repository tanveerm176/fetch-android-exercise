package com.example.fetchandroidexercise.fake

import com.example.fetchandroidexercise.network.FetchApiService
import com.example.fetchandroidexercise.network.FetchItem

class FakeFetchApiService: FetchApiService {
    override suspend fun getFetchData(): List<FetchItem> {
        return FakeDataSource.itemList
    }
}