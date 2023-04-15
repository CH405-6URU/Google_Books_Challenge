package com.example.googlebookschallenge.data

import kotlinx.serialization.Serializable


@Serializable
data class Response(
    val kind: String,
    val totalItems: Int,
    val items: List<GoogleBook>
)

@Serializable
data class GoogleBook(
    // constructors are temporary placeholders for making UI
    val id: String,
    val title: String,
    val thumbnail: String
)
