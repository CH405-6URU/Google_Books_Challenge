package com.example.googlebookschallenge.data


@kotlinx.serialization.Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String
)