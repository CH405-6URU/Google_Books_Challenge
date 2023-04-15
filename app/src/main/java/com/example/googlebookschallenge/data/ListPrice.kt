package com.example.googlebookschallenge.data

@kotlinx.serialization.Serializable
data class ListPrice(
    val amount: Int,
    val currencyCode: String
)