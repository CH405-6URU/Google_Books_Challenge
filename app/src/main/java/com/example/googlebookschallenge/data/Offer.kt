package com.example.googlebookschallenge.data

@kotlinx.serialization.Serializable
data class Offer(
    val finskyOfferType: Int,
    val giftable: Boolean,
    val listPrice: ListPriceX,
    val retailPrice: RetailPrice
)