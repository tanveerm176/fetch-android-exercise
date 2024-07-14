package com.example.fetchandroidexercise.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fetchandroidexercise.ui.FetchUiState
import com.example.fetchandroidexercise.ui.FetchViewModel

/**
 * Composable function representing the home screen of the FetchItems application.
 * Displays different screens based on the current state of `fetchUiState`.
 *
 * @param fetchUiState The current state of retrieving items, determining which screen to display.
 * @param modifier Optional modifier for adjusting layout and styling.
 * @param contentPadding Optional padding values for the content.
 */
@Composable
fun HomeScreen(
    fetchUiState: FetchUiState,
    modifier: Modifier = Modifier,
    onRefresh: () -> Unit,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    when(fetchUiState){
        is FetchUiState.Success -> ResultScreen(
            fetchUiState.items,
            modifier = modifier
                .fillMaxWidth()
                .padding(contentPadding),
            onRefresh = onRefresh
        )
        is FetchUiState.Loading -> LoadingScreen(
            modifier = modifier
                .fillMaxWidth()
                .padding(contentPadding)
        )
        is FetchUiState.Error -> ErrorScreen(
            modifier = modifier
                .fillMaxWidth()
                .padding(contentPadding),
            onRefresh = onRefresh
        )

    }
}