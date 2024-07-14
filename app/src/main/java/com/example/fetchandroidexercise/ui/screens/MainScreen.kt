@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.fetchandroidexercise.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fetchandroidexercise.ui.FetchViewModel
import com.example.fetchandroidexercise.ui.components.TopAppBar

/**
 * Composable function representing the main UI of the FetchItems application.
 * Uses Jetpack Compose Scaffold and Surface to structure the UI with a top app bar and content area.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    // Defines the scroll behavior for the top app bar
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(scrollBehavior, modifier = Modifier)
        }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ){
            val fetchViewModel: FetchViewModel = viewModel(
                factory = FetchViewModel.Factory
            )

            //Display HomeScreen with fetchUiState
            HomeScreen(
                fetchUiState = fetchViewModel.fetchUiState,
                contentPadding = it,
                modifier = Modifier.padding(it),
                onRefresh = {fetchViewModel.onRefresh()}
            )
        }

    }
}



