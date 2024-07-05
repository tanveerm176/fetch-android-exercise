package com.example.fecthandroidexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.fecthandroidexercise.ui.FetchItemsApp
import com.example.fecthandroidexercise.ui.theme.FecthAndroidExerciseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            FecthAndroidExerciseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    FetchItemsApp()
                }
            }
        }
    }
}
