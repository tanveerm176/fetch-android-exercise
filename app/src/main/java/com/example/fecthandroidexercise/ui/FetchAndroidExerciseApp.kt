@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.fecthandroidexercise.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import com.example.fecthandroidexercise.ui.screens.FetchViewModel
import com.example.fecthandroidexercise.ui.theme.FecthAndroidExerciseTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fecthandroidexercise.ui.screens.HomeScreen

@Composable
fun FetchAndroidExerciseApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {FetchTopAppBar(scrollBehavior = scrollBehavior)}
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ){
            val fetchViewModel: FetchViewModel = viewModel()
            HomeScreen(
                fetchUiState = fetchViewModel.fetchUiState,
                contentPadding = it
            )
        }

    }
}


@Composable
fun FetchTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier= Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = "Fetch Android Exercise",
                style = MaterialTheme.typography.headlineSmall
            )
        },
        modifier = modifier
    )
}

@Preview
@Composable
fun FetchAndroidExerciseAppPreview(){
    FecthAndroidExerciseTheme{
        FetchAndroidExerciseApp()
    }
}