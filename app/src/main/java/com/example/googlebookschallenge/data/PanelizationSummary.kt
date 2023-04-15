package com.example.googlebookschallenge.data

@kotlinx.serialization.Serializable
data class PanelizationSummary(
    val containsEpubBubbles: Boolean,
    val containsImageBubbles: Boolean
)