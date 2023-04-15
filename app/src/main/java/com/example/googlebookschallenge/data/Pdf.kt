package com.example.googlebookschallenge.data

@kotlinx.serialization.Serializable
data class Pdf(
    val acsTokenLink: String,
    val downloadLink: String,
    val isAvailable: Boolean
)