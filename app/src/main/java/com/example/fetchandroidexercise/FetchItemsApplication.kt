package com.example.fetchandroidexercise

import android.app.Application
import com.example.fetchandroidexercise.data.AppContainer
import com.example.fetchandroidexercise.data.DefaultAppContainer

class FetchItemsApplication : Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}