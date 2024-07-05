package com.example.fetchandroidexercise.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.fetchandroidexercise.network.FetchItem

/**
 * Composable function representing the screen displaying retrieved items.
 *
 * @param groupedItems Map of items grouped by list ID to display.
 * @param modifier Optional modifier for adjusting layout and styling.
 */
@Composable
fun ResultScreen(groupedItems: Map<Int, List<FetchItem>>, modifier: Modifier = Modifier){
    FetchItemsList(groupedItems, modifier)
}