package com.example.fetchandroidexercise.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.fetchandroidexercise.R
import com.example.fetchandroidexercise.components.ErrorScreen
import com.example.fetchandroidexercise.components.FetchItemsList
import com.example.fetchandroidexercise.components.LoadingScreen
import com.example.fetchandroidexercise.components.ResultScreen
import com.example.fetchandroidexercise.network.FetchItem

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
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    when(fetchUiState){
        is FetchUiState.Success -> ResultScreen(
            fetchUiState.items, modifier = modifier.fillMaxWidth()
        )
        is FetchUiState.Loading -> LoadingScreen(
            modifier = modifier.fillMaxWidth()
        )
        is FetchUiState.Error -> ErrorScreen(
            modifier = modifier.fillMaxWidth()
        )

    }
}