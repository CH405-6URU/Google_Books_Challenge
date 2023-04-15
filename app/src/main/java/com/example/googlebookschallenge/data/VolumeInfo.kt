package com.example.googlebookschallenge.data

@kotlinx.serialization.Serializable
data class VolumeInfo(
    val subtitle: String? = null,
    val title: String
)