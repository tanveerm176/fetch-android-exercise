package com.example.fetchandroidexercise.ui

import android.content.ContentValues.TAG
import android.util.Log
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
import com.example.fetchandroidexercise.data.FetchItemsRepository
import com.example.fetchandroidexercise.network.FetchItem
import kotlinx.coroutines.launch
import java.io.IOException



/**
 * ViewModel for managing the retrieving and filtering of items.
 *
 * @property fetchItemRepository Repository for retrieving items.
 */
class FetchViewModel(
    private val fetchItemRepository: FetchItemsRepository
): ViewModel() {

    /**
     * Holds the current state of the retrieve operation.
     */
    var fetchUiState: FetchUiState by mutableStateOf(FetchUiState.Loading)
        private set

    /**
     * Initializes the ViewModel and starts retrieving data
     */
    init{
        getFetchData()
    }

    /**
     * Filters and groups the list of Fetch items.
     *
     * @param fetchListResult List of Fetch items to filter and group.
     * @return Map of filtered and grouped items by list ID
     */
    private fun filterList(fetchListResult: List<FetchItem>): Map<Int, List<FetchItem>> {

        val filteredList = fetchListResult.filter { !it.name.isNullOrBlank() }
        val sortedList = filteredList.sortedWith(
            compareBy<FetchItem> { it.listId }
                .thenBy { item-> item.name?.substringAfterLast(" ")?.toInt() }
        )
        /*val sortedList = filteredList.sortedWith(compareBy({it.listId}, {it.name}))*/
        val groupedList = sortedList.groupBy { it.listId }

        //Verify number of items after filter, sort and group
        //Should be 320
        /*val total_size = groupedList.values.sumOf { it.size }
        Log.d("number of items", "${total_size}")*/

        return groupedList

    }

    /**
     * Retrieves data from the repository and updates the UI state.
     */
    private fun getFetchData() {
        viewModelScope.launch{
            fetchUiState = try{
                val fetchListResult = fetchItemRepository.getFetchItems()
                val filteredList = filterList(fetchListResult)
                FetchUiState.Success(filteredList)
            }
            catch (e:IOException){
                Log.d("IO Exception", "${e.message}")
                FetchUiState.Error
            }
            catch(e: HttpException){
                Log.d("Http Exception","${e.message}")
                FetchUiState.Error
            }
        }
    }

    /**
     * Factory for creating an instance of FetchViewModel with required dependencies.
     */
    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer{
                val application = (this[APPLICATION_KEY] as FetchItemsApplication)
                val fetchItemRepository = application.container.fetchItemsRepository
                FetchViewModel(fetchItemRepository = fetchItemRepository)
            }
        }
    }
}