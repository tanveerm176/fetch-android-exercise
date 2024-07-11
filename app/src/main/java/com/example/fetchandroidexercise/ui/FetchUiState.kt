package com.example.fetchandroidexercise.ui

import com.example.fetchandroidexercise.network.FetchItem

/**
 * Sealed interface representing different UI states for retrieving items.
 */
sealed interface FetchUiState{

    /**
     * Represents a successful retrieve operation with the Fetch items.
     *
     * @property items Map of retrieved items grouped by list ID.
     */
    data class Success(val items: Map<Int, List<FetchItem>>) : FetchUiState

    /**
     * Represents an error state during the retrieve operation.
     */
    object Error: FetchUiState

    /**
     * Represents a loading state during the retrieve operation.
     */
    object Loading: FetchUiState
}