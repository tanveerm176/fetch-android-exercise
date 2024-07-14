package com.example.fetchandroidexercise.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.example.fetchandroidexercise.ui.theme.FetchAndroidExerciseTheme

@Composable
fun SearchBar() {
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchText by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = searchText,
        onValueChange = { text: String ->
            searchText = text
        },
        placeholder = { Text("Search for Item") },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(onSearch = {
            keyboardController?.hide()
        })
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchBar(){
    FetchAndroidExerciseTheme {
        SearchBar()
    }
}