package com.example.fetchandroidexercise.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchandroidexercise.R
import com.example.fetchandroidexercise.data.FetchItemsRepository
import com.example.fetchandroidexercise.ui.FetchUiState
import com.example.fetchandroidexercise.ui.FetchViewModel
import com.example.fetchandroidexercise.ui.components.RefreshButton
import com.example.fetchandroidexercise.ui.theme.FetchAndroidExerciseTheme

/**
 * Composable function representing the error screen.
 *
 * @param modifier Optional modifier for adjusting layout and styling.
 */
@Composable
fun ErrorScreen(modifier: Modifier = Modifier, onRefresh: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = "Loading Icon",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(50.dp)
        )
        Text(
            text = stringResource(R.string.error_text),
            fontSize = 28.sp,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        RefreshButton(onRefresh)

    }
}

@Preview(showBackground = true)
@Composable
fun ErrorScreenPreview() {
    FetchAndroidExerciseTheme {
        ErrorScreen {

        }
    }
}