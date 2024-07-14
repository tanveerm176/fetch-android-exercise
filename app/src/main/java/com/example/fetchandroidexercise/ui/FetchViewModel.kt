package com.example.fetchandroidexercise.ui

import android.util.Log
import androidx.compose.runtime.currentCompositionErrors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.example.fetchandroidexercise.FetchItemsApplication
import com.example.fetchandroidexercise.data.FetchItem
import com.example.fetchandroidexercise.data.FetchItemsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException


/**
 * ViewModel for managing the retrieving and filtering of items.
 *
 * @property fetchItemRepository Repository for retrieving items.
 */
class FetchViewModel(
    private val fetchItemRepository: FetchItemsRepository
) : ViewModel() {

    /**
     * Holds the current state of the retrieve operation.
     */
    var fetchUiState: FetchUiState by mutableStateOf(FetchUiState.Loading)
        private set

    private var currentItemsList: Map<Int, List<FetchItem>> = emptyMap()

    /**
     * Initializes the ViewModel and starts retrieving data
     */
    init {
        getFetchData()
    }


    /**
     * Retrieves data from the repository and updates the UI state.
     */
    private fun getFetchData() {
        viewModelScope.launch {
            delay(3000)
            fetchUiState = try {
                val fetchListResult = fetchItemRepository.getFetchItems()
                currentItemsList = fetchItemRepository.filterItems(fetchListResult)
                FetchUiState.Success(currentItemsList)
            } catch (e: IOException) {
                Log.d("IO Exception", "${e.message}")
                FetchUiState.Error(e)
            } catch (e: HttpException) {
                Log.d("Http Exception", "${e.message}")
                FetchUiState.Error(e)
            }
        }
    }

    /**
     * Filters items based on the search query.
     *
     * @param searchText The text to filter items by.
     */
    fun searchItem(searchText: String) {
        viewModelScope.launch {
            fetchUiState = try {
                if (searchText.isEmpty()) {
                    FetchUiState.Success(currentItemsList)
                } else {
                    val searchItemsList = currentItemsList.mapValues { (_, itemList) ->
                        itemList.filter { item ->
                            item.name?.contains(searchText, ignoreCase = true) ?: false
                        }

                    }
                    FetchUiState.Success(searchItemsList)
                }
            } catch (e: Exception) {
                Log.d("Search Exception", "${e.message}")
                FetchUiState.Error(e)
            }

        }
    }

    /**
     * Refreshes data by re-triggering the data retrieval process.
     */
    fun onRefresh() {
        getFetchData()
    }

    /**
     * Factory for creating an instance of FetchViewModel with required dependencies,
     * in this case is the FetchItemsRepository.
     * Provides a FetchItemsRepository instance to the ViewModel.
     * This is a form of dependency injection.
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FetchItemsApplication)
                val fetchItemRepository = application.container.fetchItemsRepository
                FetchViewModel(fetchItemRepository = fetchItemRepository)
            }
        }
    }
}