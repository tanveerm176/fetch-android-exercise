package com.example.fetchandroidexercise.ui.screens

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
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
import com.example.fetchandroidexercise.ui.FetchUiState
import com.example.fetchandroidexercise.ui.theme.FetchAndroidExerciseTheme

/**
 * Composable function representing the loading screen.
 *
 * @param modifier Optional modifier for adjusting layout and styling.
 */
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier

    ) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "Loading Icon",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(50.dp)
        )
        Text(
            text = stringResource(R.string.loading_data_text),
            fontSize = 28.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoadingScreen() {
    FetchAndroidExerciseTheme {
        LoadingScreen()
    }
}