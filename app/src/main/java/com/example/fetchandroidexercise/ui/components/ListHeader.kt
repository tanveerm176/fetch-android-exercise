package com.example.fetchandroidexercise.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchandroidexercise.ui.theme.FetchAndroidExerciseTheme

/**
 * Composable function that displays a header for a section based on list ID.
 *
 * @param listId The ID of the list for which the header is displayed.
 */
@Composable
fun ListHeader(listId: Int){
    Text(
        text = "List ID Group ${listId}",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(8.dp)
    )
}

@Preview
@Composable
fun ListHeaderPreview(){
    FetchAndroidExerciseTheme {
        ListHeader(listId = 3)
    }
}