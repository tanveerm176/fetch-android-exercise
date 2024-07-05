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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fetchandroidexercise.network.FetchItem

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

@Composable
fun ListHeader(listId: Int){
    Text(
        text = "ID Section ${listId}",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(8.dp)
    )
}
@Composable
fun FetchItemRow(item: FetchItem){
    Text(
        text = "Name: ${item.name}",
        fontSize = 14.sp,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    )
    Divider(color = Color.LightGray)
}