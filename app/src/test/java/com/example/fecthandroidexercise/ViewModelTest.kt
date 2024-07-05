package com.example.fecthandroidexercise

import com.example.fecthandroidexercise.ui.screens.FetchUiState
import com.example.fecthandroidexercise.ui.screens.FetchViewModel
import com.example.fecthandroidexercise.fake.FakeDataSource
import com.example.fecthandroidexercise.fake.FakeNetworkFetchItemsRepository
import com.example.fecthandroidexercise.rules.TestDispatcherRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class ViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()
    @Test
    fun fetchViewModel_getFetchItems_verifyFetchUiStateSuccess() =
        runTest {
            val fetchViewModel = FetchViewModel(
                fetchItemRepository = FakeNetworkFetchItemsRepository()
            )
            assertEquals(
                FetchUiState.Success("${FakeDataSource.itemList} Items"),
                fetchViewModel.fetchUiState
            )
        }
}