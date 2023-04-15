package com.example.googlebookschallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.googlebookschallenge.data.BookViewModel
import com.example.googlebookschallenge.ui.HomeScreen
import com.example.googlebookschallenge.ui.theme.GoogleBooksChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoogleBooksChallengeTheme {
                val bookViewModel: BookViewModel = viewModel()
                // mockData located in homescreen as placeholder
                HomeScreen(bookViewModel.bookUiState)
            }
        }
    }
}



