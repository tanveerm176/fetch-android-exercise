package com.example.fecthandroidexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fecthandroidexercise.ui.FetchAndroidExerciseApp
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
                    FetchAndroidExerciseApp()
                }
            }
        }
    }
}
