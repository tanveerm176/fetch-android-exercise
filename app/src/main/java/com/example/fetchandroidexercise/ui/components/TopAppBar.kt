package com.example.fetchandroidexercise.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.fetchandroidexercise.R
import com.example.fetchandroidexercise.ui.theme.FetchAndroidExerciseTheme

/**
 * Composable function for the custom top app bar.
 *
 * @param scrollBehavior The scroll behavior to apply to the top app bar.
 * @param modifier Optional modifier for adjusting layout and styling.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TopAppBarPreview(){
    FetchAndroidExerciseTheme {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        TopAppBar(scrollBehavior)
    }
}