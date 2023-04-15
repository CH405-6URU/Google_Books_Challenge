package com.example.googlebookschallenge.data

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlebookschallenge.network.BookApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BookUiState {
    data class Success(val books: List<Item>) : BookUiState
    object Error : BookUiState
    object Loading : BookUiState
}

class BookViewModel : ViewModel() {
    var bookUiState: BookUiState by mutableStateOf(BookUiState.Loading)

    init {
        getBookInfo()
    }

    private fun getBookInfo() {
        viewModelScope.launch {
            bookUiState = try {
                val result = BookApi.retrofitService.getBooks().items
                Log.d("result", result.toString())

                BookUiState.Success(result)
            } catch (e: IOException) {
                BookUiState.Error
            }
        }
    }
}