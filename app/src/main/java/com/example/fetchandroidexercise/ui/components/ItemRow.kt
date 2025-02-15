package com.example.fetchandroidexercise.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchandroidexercise.data.FetchItem
import com.example.fetchandroidexercise.ui.theme.FetchAndroidExerciseTheme

/**
 * Composable function that displays a row for a single FetchItem.
 *
 * @param item The FetchItem object to display in the row.
 */
@Composable
fun ItemRow(item: FetchItem){
    Text(
        text = "Name: ${item.name}",
        fontSize = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    )
    Divider(color = Color.LightGray)
}

@Preview
@Composable
fun ItemRowPreview(){
    FetchAndroidExerciseTheme {
        val previewFetchItem = FetchItem(id = 1, listId = 1, name = "230")
        ItemRow(previewFetchItem)
    }
}