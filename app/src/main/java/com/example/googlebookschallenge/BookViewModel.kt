package com.example.googlebookschallenge.data


import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.googlebookschallenge.network.BookApi
import com.example.googlebookschallenge.network.ImageApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface BookUiState {
    data class Success(val books: MutableList<Item>) : BookUiState
    object Error : BookUiState
    object Loading : BookUiState
}

class BookViewModel : ViewModel() {
    var bookUiState: BookUiState by mutableStateOf(BookUiState.Loading)
    var imageSources = mutableListOf<Item>()

    init {
        getBookInfo()
    }

    private fun getBookInfo() {
        viewModelScope.launch {
            bookUiState = try {
                val result = BookApi.retrofitService.getBooks().items
               // Log.d("result", result.toString())
                for (element in result){
                    imageSources.add(ImageApi.retrofitService.getImage((element.id)))
                }
                Log.d("imageSources", imageSources.toString())
                BookUiState.Success(imageSources)
            } catch (e: IOException) {
                BookUiState.Error
            }

        }
    }
}