package com.example.googlebookschallenge.network

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.googlebookschallenge.data.BookViewModel
import com.example.googlebookschallenge.data.ImageLinks
import com.example.googlebookschallenge.data.Item
import com.example.googlebookschallenge.data.topClass
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

//https://www.googleapis.com/books/v1/volumes/

private const val BASE_URL =
    "https://www.googleapis.com/books/v1/volumes/"

/**
 * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json{ignoreUnknownKeys = true}.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

/**
 * Retrofit service object for creating api calls
 */
interface BookApiService {
    @GET("?q=cicero")
    suspend fun getBooks(): topClass
}

interface ImageApiService {
    @GET("{id}")
    suspend fun getImage(@Path("id") id: String): Item
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object BookApi {
    val retrofitService: BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }
}

object ImageApi {
    val retrofitService: ImageApiService by lazy {
        retrofit.create(ImageApiService::class.java)
    }
}
