package com.example.googlebookschallenge.data


@kotlinx.serialization.Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String,
    val small: String? = null,
    val medium: String? = null,
    val large: String? = null,
    val extraLarge: String? = null
)