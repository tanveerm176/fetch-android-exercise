package com.example.fecthandroidexercise.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.fecthandroidexercise.FetchItemsApplication
import com.example.fecthandroidexercise.data.FetchItemsRepository
import com.example.fecthandroidexercise.network.FetchItem
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface FetchUiState{
    data class Success(val items: List<FetchItem>) : FetchUiState
    object Error: FetchUiState
    object Loading: FetchUiState
}

class FetchViewModel(
    private val fetchItemRepository: FetchItemsRepository
): ViewModel() {
    var fetchUiState: FetchUiState by mutableStateOf(FetchUiState.Loading)
        private set

    init{
        getFetchData()
    }

    private fun filterList(fetchListResult: List<FetchItem>): List<FetchItem> {

        return fetchListResult.filter { !it.name.isNullOrBlank() }
            .sortedWith(compareBy({ it.listId }, { it.name }))

    }

    private fun getFetchData() {
        viewModelScope.launch{
            fetchUiState = try{
                val fetchListResult = fetchItemRepository.getFetchItems()
                val filteredList = filterList(fetchListResult)
                FetchUiState.Success(filteredList)
            }
            catch (e:IOException){
                FetchUiState.Error
            }
        }
    }

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