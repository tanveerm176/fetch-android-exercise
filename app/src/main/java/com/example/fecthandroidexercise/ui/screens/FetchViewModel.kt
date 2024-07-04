package com.example.fecthandroidexercise.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fecthandroidexercise.network.FetchApi
import com.example.fecthandroidexercise.ui.FetchAndroidExerciseApp
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface FetchUiState{
    data class Success(val items: String) : FetchUiState
    object Error: FetchUiState
    object Loading: FetchUiState
}

class FetchViewModel: ViewModel() {
    var fetchUiState: FetchUiState by mutableStateOf(FetchUiState.Loading)
        private set

    init{
        getFetchData()
    }

    private fun getFetchData() {
        viewModelScope.launch{
            fetchUiState = try{
                val fetchListResult = FetchApi.retrofitService.getFetchData()
                FetchUiState.Success("${fetchListResult.size} Items")
            }
            catch (e:IOException){
                FetchUiState.Error
            }
        }
    }
}