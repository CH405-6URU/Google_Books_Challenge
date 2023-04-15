package com.example.googlebookschallenge.data

@kotlinx.serialization.Serializable
data class ReadingModes(
    val image: Boolean,
    val text: Boolean
)