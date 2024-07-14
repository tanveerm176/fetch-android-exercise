package com.example.fetchandroidexercise

import android.app.Application
import com.example.fetchandroidexercise.di.AppContainer
import com.example.fetchandroidexercise.di.DefaultAppContainer

/**
 * Custom Application class for initializing the application-wide dependencies.
 * Initializes an instance of [DefaultAppContainer] to provide dependency injection.
 */
class FetchItemsApplication : Application(){
    /**
     * Property to hold the application-wide dependency container.
     */
    lateinit var container: AppContainer

    /**
     * Called when the application is starting. Initializes the dependency container.
     */
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}