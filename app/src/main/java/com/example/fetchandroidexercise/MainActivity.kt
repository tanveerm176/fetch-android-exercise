package com.example.fetchandroidexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.fetchandroidexercise.ui.screens.MainScreen
import com.example.fetchandroidexercise.ui.theme.FetchAndroidExerciseTheme

/**
 * Main entry point of the application, extending [ComponentActivity].
 * Sets up the UI and theme for displaying the FetchItemsApp.
 */
class MainActivity : ComponentActivity() {

    /**
     * Called when the activity is starting. Initializes the UI and theme.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     * this Bundle contains the data it most recently supplied in [onSaveInstanceState].
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge() // Enables edge-to-edge display
        super.onCreate(savedInstanceState)
        setContent {
            FetchAndroidExerciseTheme { // Apply the application theme
                Surface(
                    modifier = Modifier.fillMaxSize(), // Fill entire screen
                ) {
                    MainScreen() // Displays the FetchItemsApp composable content
                }
            }
        }
    }
}
