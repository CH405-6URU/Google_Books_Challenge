package com.example.googlebookschallenge.network

import com.example.googlebookschallenge.data.Item
import com.example.googlebookschallenge.data.topClass
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

//https://www.googleapis.com/books/v1/volumes/

private const val BASE_URL =
    "https://www.googleapis.com/books/v1/volumes/?q=cicero"

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

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object BookApi {
    val retrofitService: BookApiService by lazy {
        retrofit.create(BookApiService::class.java)
    }
}