package com.example.fetchandroidexercise.data

import com.example.fetchandroidexercise.network.FetchApiService
import com.example.fetchandroidexercise.network.FetchItem

/**
 * Repository interface for fetching items.
 */
interface FetchItemsRepository {
    /**
    * Suspend function to fetch items
    *
    * @return List of FetchItem objects*/
    suspend fun getFetchItems(): List<FetchItem>
}

/**
* Implementation of [FetchItemsRepository] that uses [FetchApiService] to fetch items
*
* @return fetchApiService - The Retrofit service instance for fetching data
*
* */
class NetworkFetchItemsRepository(
    private val fetchApiService: FetchApiService
) : FetchItemsRepository {

    /**
    * Suspend function to fetch items using Retrofit service
    *
    * @return List of FetchItem objects fetched from the API*/
    override suspend fun getFetchItems(): List<FetchItem> =
        fetchApiService.getFetchData()
}