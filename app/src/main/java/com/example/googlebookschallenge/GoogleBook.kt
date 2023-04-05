package com.example.googlebookschallenge

import kotlinx.serialization.SerialName

data class GoogleBook(
    // constructors are temporary placeholders for making UI
    val id: String,
    @SerialName(value = "img_src")
    val imgSrc: String
)
