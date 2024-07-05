package com.example.fetchandroidexercise.fake

import com.example.fecthandroidexercise.network.FetchApiService
import com.example.fecthandroidexercise.network.FetchItem

class FakeFetchApiService: FetchApiService {
    override suspend fun getFetchData(): List<FetchItem> {
        return FakeDataSource.itemList
    }
}