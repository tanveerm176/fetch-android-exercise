package com.example.fetchandroidexercise.data

import com.example.fetchandroidexercise.network.FetchApiService

/**
 * Repository interface for fetching items.
 */
interface FetchItemsRepository {
    /**
     * Suspend function to fetch items
     *
     * @return List of FetchItem objects*/
    suspend fun getFetchItems(): List<FetchItem>

    suspend fun filterList(fetchListResult: List<FetchItem>): Map<Int, List<FetchItem>>
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

    /**
     * Filters and groups the list of Fetch items.
     *
     * @param fetchListResult List of Fetch items to filter and group.
     * @return Map of filtered and grouped items by list ID
     */
    // Moved to repository from ViewModel to ensure separation of concerns
    // Repositories should conduct business logic and data manipulation
    override suspend fun filterList(fetchListResult: List<FetchItem>): Map<Int,
            List<FetchItem>> {

        val filteredList = fetchListResult.filter { !it.name.isNullOrBlank() }
        val sortedList = filteredList.sortedWith(
            compareBy<FetchItem> { it.listId }
                .thenBy { item -> item.name?.substringAfterLast(" ")?.toInt() }
        )

        /*Other method of sorting, results in list ordered by 1st digit
        instead of entire id number*/
        //val sortedList = filteredList.sortedWith(compareBy({it.listId}, {it.name}))
        val groupedList = sortedList.groupBy { it.listId }

        //Verify number of items after filter, sort and group
        //Should be 320
        /*val total_size = groupedList.values.sumOf { it.size }
        Log.d("number of items", "${total_size}")*/
        return groupedList

    }
}