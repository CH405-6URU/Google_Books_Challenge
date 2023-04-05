package com.example.googlebookschallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.googlebookschallenge.ui.BookScreen
import com.example.googlebookschallenge.ui.mockData
import com.example.googlebookschallenge.ui.theme.GoogleBooksChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleBooksChallengeTheme {
                // mockData located in homescreen as placeholder
                BookScreen(mockData)
            }
        }
    }
}



