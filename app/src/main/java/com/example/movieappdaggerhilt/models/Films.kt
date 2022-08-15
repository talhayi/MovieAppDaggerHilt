package com.example.movieappdaggerhilt.models

data class Films(
    val response: List<FilmsItem?>? = null
)

data class FilmsItem(
    val image: Image? = null,
    val name: String? = null,
    val id: Int? = null,
)

data class Image(
    val original: String? = null,
    val medium: String? = null
)
