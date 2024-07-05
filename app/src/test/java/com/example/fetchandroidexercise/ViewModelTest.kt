package com.example.fetchandroidexercise

import com.example.fetchandroidexercise.ui.screens.FetchUiState
import com.example.fetchandroidexercise.ui.screens.FetchViewModel
import com.example.fetchandroidexercise.fake.FakeDataSource
import com.example.fetchandroidexercise.fake.FakeNetworkFetchItemsRepository
import com.example.fetchandroidexercise.rules.TestDispatcherRule
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