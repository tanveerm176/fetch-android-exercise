package com.example.fecthandroidexercise.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
fun FetchItemView(item: FetchItem){
    Text(
        text = "List Id: ${item.listId} - Name: ${item.name}",
        modifier = Modifier.padding(16.dp)
    )
    Divider(color = Color.LightGray)
}

@Composable
fun FetchItemsList(items: List<FetchItem>){
    LazyColumn { 
        items(items){
            item -> FetchItemView(item = item)
        }
    }
}

@Composable
fun ResultScreen(items:List<FetchItem>, modifier: Modifier= Modifier){
    FetchItemsList(items = items)
    
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