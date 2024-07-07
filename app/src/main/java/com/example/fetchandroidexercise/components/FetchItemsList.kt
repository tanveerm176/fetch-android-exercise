package com.example.fetchandroidexercise.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchandroidexercise.network.FetchItem
import com.example.fetchandroidexercise.ui.theme.FetchAndroidExerciseTheme

/**
 * Composable function that displays a list of `FetchItem`s grouped by `listId` in a LazyColumn.
 *
 * @param groupedItems A map where keys are list IDs and values are lists of FetchItem objects.
 * @param modifier Optional modifier for adjusting layout and styling.
 */
@Composable
fun FetchItemsList(groupedItems: Map<Int, List<FetchItem>>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier.fillMaxSize()) {
        groupedItems.forEach { (listId, items) ->
            item{
                ListHeader(listId)
            }
            items(items) { item ->
                FetchItemRow(item)
            }
        }
    }
}

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

/**
 * Composable function that displays a row for a single FetchItem.
 *
 * @param item The FetchItem object to display in the row.
 */
@Composable
fun FetchItemRow(item: FetchItem){
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
fun ListHeaderPreview(){
    FetchAndroidExerciseTheme {
        ListHeader(listId = 3)
    }
}

@Preview
@Composable
fun FetchItemPreview(){
    FetchAndroidExerciseTheme {
        val previewFetchItem = FetchItem(id = 1, listId = 1, name = "230")
        FetchItemRow(previewFetchItem)
    }
}

/*TODO: Implement preview for list*/