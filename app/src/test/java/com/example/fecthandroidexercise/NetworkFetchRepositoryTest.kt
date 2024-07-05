package com.example.fecthandroidexercise

import com.example.fecthandroidexercise.data.NetworkFetchItemsRepository
import com.example.fecthandroidexercise.fake.FakeDataSource
import com.example.fecthandroidexercise.fake.FakeFetchApiService
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