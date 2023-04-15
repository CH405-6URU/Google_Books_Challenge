package com.example.googlebookschallenge.data

@kotlinx.serialization.Serializable
data class ListPriceX(
    val amountInMicros: Int,
    val currencyCode: String
)