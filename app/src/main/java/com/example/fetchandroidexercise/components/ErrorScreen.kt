package com.example.fetchandroidexercise.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.fetchandroidexercise.R

/**
 * Composable function representing the error screen.
 *
 * @param modifier Optional modifier for adjusting layout and styling.
 */
@Composable
fun ErrorScreen(modifier : Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.error_text)
        )
    }
}