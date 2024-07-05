package com.example.fecthandroidexercise.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fecthandroidexercise.R
import com.example.fecthandroidexercise.network.FetchItem

@Composable
fun HomeScreen(
    fetchUiState: FetchUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    when(fetchUiState){
        is FetchUiState.Success -> ResultScreen(
            fetchUiState.items, modifier = modifier.fillMaxWidth()
        )
        is FetchUiState.Loading -> LoadingScreen(
            modifier = modifier.fillMaxWidth()
        )
        is FetchUiState.Error -> ErrorScreen(
            modifier = modifier.fillMaxWidth()
        )

    }
}


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

@Composable
fun ResultScreen(groupedItems: Map<Int, List<FetchItem>>, modifier: Modifier= Modifier){
//    Log.d("fetch Items", "${groupedItems.}")
    FetchItemsList(groupedItems, modifier)
    
}

@Composable
fun LoadingScreen(modifier : Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.loading_data_text)
        )
    }
}

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