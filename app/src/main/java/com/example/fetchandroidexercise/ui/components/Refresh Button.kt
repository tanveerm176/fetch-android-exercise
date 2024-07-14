package com.example.fetchandroidexercise.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fetchandroidexercise.ui.FetchUiState
import com.example.fetchandroidexercise.ui.theme.FetchAndroidExerciseTheme

@Composable
fun RefreshButton(
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {

    Button(
        onClick = {
            Log.d("Refresh Button", "Refresh Button Clicked")
            onRefresh()
        },
        modifier = modifier,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Refresh Icon",
                )
                Text(text = "Refresh")

            }
        }
    }
}

@Preview
@Composable
fun PreviewRefreshButton() {
    FetchAndroidExerciseTheme {
        RefreshButton(onRefresh = { Log.d("Refresh Button", "Refresh Button Clicked") })
    }
}

