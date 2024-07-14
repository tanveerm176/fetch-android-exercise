@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fetchandroidexercise.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import com.example.fetchandroidexercise.ui.components.SearchBar
import com.example.fetchandroidexercise.ui.components.TopAppBar

/**
 * Composable function representing the main UI of the FetchItems application.
 * Uses Jetpack Compose Scaffold and Surface to structure the UI with a top app bar and content area.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    // Defines the scroll behavior for the top app bar
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val fetchViewModel: FetchViewModel = viewModel(
        factory = FetchViewModel.Factory
    )

    Scaffold(
        topBar = {
            TopAppBar(scrollBehavior, modifier = Modifier)
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column {
                SearchBar()

                //Display HomeScreen with fetchUiState
                HomeScreen(
                    fetchUiState = fetchViewModel.fetchUiState,
                    contentPadding = PaddingValues(),
                    modifier = Modifier.fillMaxSize(),
                    onRefresh = { fetchViewModel.onRefresh() }
                )

            }
        }

    }
}



