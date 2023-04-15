package com.example.googlebookschallenge.data

@kotlinx.serialization.Serializable
data class RetailPriceX(
    val amount: Double,
    val currencyCode: String
)