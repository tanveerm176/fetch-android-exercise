package com.example.fetchandroidexercise.network

import kotlinx.serialization.Serializable

/**
* Data class representing an item from the API response
* Annotated with @Serializable for Kotlinx serialization
*
* @property id - Unique identifier of the item
* @property listId - Identifier of the list the item belongs to
* @property name - Name of the item
* */
@Serializable
data class FetchItem(
    val id: Int,
    val listId: Int,
    val name: String
)