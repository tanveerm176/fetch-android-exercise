@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.fetchandroidexercise.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.fetchandroidexercise.ui.screens.FetchViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fetchandroidexercise.R
import com.example.fetchandroidexercise.ui.screens.HomeScreen
import com.example.fetchandroidexercise.ui.theme.FetchAndroidExerciseTheme

/**
 * Composable function representing the main UI of the FetchItems application.
 * Uses Jetpack Compose Scaffold and Surface to structure the UI with a top app bar and content area.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FetchItemsApp() {
    // Defines the scroll behavior for the top app bar
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {
            FetchTopAppBar(scrollBehavior, modifier = Modifier)
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
                modifier = Modifier.padding(it)
            )
        }

    }
}


/**
 * Composable function for the custom top app bar.
 *
 * @param scrollBehavior The scroll behavior to apply to the top app bar.
 * @param modifier Optional modifier for adjusting layout and styling.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FetchTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier= Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.top_app_bar_title),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.ExtraBold
            )
        },
        modifier = modifier,
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    )
}

@Preview
@Composable
fun FetchAndroidExerciseAppPreview(){
    FetchAndroidExerciseTheme {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        FetchTopAppBar(scrollBehavior)
    }
}