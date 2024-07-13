package com.example.fetchandroidexercise.ui

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
import com.example.fetchandroidexercise.data.FetchItem
import kotlinx.coroutines.Dispatchers
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
     * Retrieves data from the repository and updates the UI state.
     */
    private fun getFetchData() {
        viewModelScope.launch{
            fetchUiState = try{
                val fetchListResult = fetchItemRepository.getFetchItems()

                // Added coroutine to filterList() to ensure it does not freeze UI
                // In case filtering is expensive in the future (for scalability)
                val filteredList = withContext(Dispatchers.Default){
                    fetchItemRepository.filterList(fetchListResult)
                }
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