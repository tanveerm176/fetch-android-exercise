package com.example.fetchandroidexercise.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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

/**
 * A search bar with an outlined text field and a search icon.
 *
 * @param searchForItem A function invoked with the search text when the search action is performed.
 *
 * The search action can be triggered by either clicking the search icon or pressing the search key on the keyboard.
 *
 * Example usage:
 * ```
 * SearchBar { query ->
 *     // Perform search with the provided query
 * }
 * ```
 */
@Composable
fun SearchBar(searchForItem: (String) -> Unit) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchText by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = searchText,
        onValueChange = { newSearchText ->
            searchText = newSearchText
        },
        placeholder = { Text("Search for Item") },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(onSearch = {
            searchForItem(searchText)
            keyboardController?.hide()
        }),
        trailingIcon = {
            IconButton(onClick = {searchForItem(searchText)})
            {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
        },
        singleLine = true

    )
}


@Preview(showBackground = true)
@Composable
fun PreviewSearchBar() {
    FetchAndroidExerciseTheme {
        SearchBar {

        }
    }
}