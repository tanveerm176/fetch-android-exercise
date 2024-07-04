package com.example.fecthandroidexercise.network

import kotlinx.serialization.Serializable

@Serializable
data class FetchItem(
    val id: Int,
    val listId: Int,
    val name: String
)