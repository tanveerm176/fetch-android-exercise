package com.example.fetchandroidexercise

import com.example.fetchandroidexercise.data.NetworkFetchItemsRepository
import com.example.fetchandroidexercise.fake.FakeDataSource
import com.example.fetchandroidexercise.fake.FakeFetchApiService
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test

class NetworkFetchRepositoryTest {

    @Test
    fun networkFetchItemsRepository_getFetchItems_verifyItemsList() =
        runTest{
            val repository = NetworkFetchItemsRepository(
                fetchApiService = FakeFetchApiService()
            )
            assertEquals(FakeDataSource.itemList, repository.getFetchItems())
        }
}