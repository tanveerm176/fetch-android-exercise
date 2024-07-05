package com.example.fetchandroidexercise.fake

import com.example.fetchandroidexercise.network.FetchItem

object FakeDataSource {
    const val idOne = 100
    const val listIdOne = 1
    const val nameOne = "name1"

    const val idTwo = 200
    const val listIdTwo = 2
    const val nameTwo = "name2"

    val itemList = listOf(
        FetchItem(
            id = idOne,
            listId = listIdOne,
            name = nameOne
        ),
        FetchItem(
            id = idTwo,
            listId = listIdTwo,
            name = nameTwo
        )
    )

}