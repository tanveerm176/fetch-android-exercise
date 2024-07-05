package com.example.fecthandroidexercise

import android.app.Application
import com.example.fecthandroidexercise.data.AppContainer
import com.example.fecthandroidexercise.data.DefaultAppContainer

class FetchItemsApplication : Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}