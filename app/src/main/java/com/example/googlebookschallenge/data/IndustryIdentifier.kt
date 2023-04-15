package com.example.googlebookschallenge.data

@kotlinx.serialization.Serializable
data class IndustryIdentifier(
    val identifier: String,
    val type: String
)