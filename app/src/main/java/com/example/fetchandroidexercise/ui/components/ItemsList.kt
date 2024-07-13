package com.example.fetchandroidexercise.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fetchandroidexercise.data.FetchItem
import com.example.fetchandroidexercise.ui.theme.FetchAndroidExerciseTheme

/**
 * Composable function that displays a list of `FetchItem`s grouped by `listId` in a LazyColumn.
 *
 * @param groupedItems A map where keys are list IDs and values are lists of FetchItem objects.
 * @param modifier Optional modifier for adjusting layout and styling.
 */
@Composable
fun ItemsList(groupedItems: Map<Int, List<FetchItem>>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier.fillMaxSize()) {
        groupedItems.forEach { (listId, items) ->
            item{
                ListHeader(listId)
            }
            items(
                items,
                key =  {it.id}
            ) { item ->
                ItemRow(item)
            }
        }
    }
}

@Preview
@Composable
fun ItemListPreview(){
    FetchAndroidExerciseTheme {
        val previewGroupedItems = mapOf(
            1 to listOf(FetchItem(0, 1, "Item 0"), FetchItem(0, 1, "Item 4")),
            2 to listOf(FetchItem(0, 1, "Item 0"), FetchItem(0, 1, "Item 4")),
            3 to listOf(FetchItem(0, 1, "Item 0"), FetchItem(0, 1, "Item 4")),
            4 to listOf(FetchItem(0, 1, "Item 0"), FetchItem(0, 1, "Item 4"))
        )

        ItemsList(groupedItems = previewGroupedItems)
    }
}