package com.example.fetchandroidexercise.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fetchandroidexercise.ui.components.ItemsList
import com.example.fetchandroidexercise.data.FetchItem
import com.example.fetchandroidexercise.ui.components.RefreshButton

/**
 * Composable function representing the screen displaying retrieved items.
 *
 * @param groupedItems Map of items grouped by list ID to display.
 * @param modifier Optional modifier for adjusting layout and styling.
 */
@Composable
fun ResultScreen(
    groupedItems: Map<Int, List<FetchItem>>,
    modifier: Modifier = Modifier,
    onRefresh: () -> Unit
) {
    Box {
        ItemsList(groupedItems, modifier)

        RefreshButton(
            onRefresh,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(vertical = 56.dp, horizontal = 16.dp)
        )
    }
}