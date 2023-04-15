package com.example.googlebookschallenge.data

@kotlinx.serialization.Serializable
data class RetailPrice(
    val amountInMicros: Int,
    val currencyCode: String
)