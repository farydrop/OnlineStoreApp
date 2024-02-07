package com.farydrop.onlinestoreapp.data.entity

data class Catalog(
    val imgOne: Int,
    val imgTwo: Int,
    val isFavorites: Boolean,
    val available: Int,
    val description: String,
    val feedback: Feedback,
    val id: String,
    val info: List<Info> = listOf(),
    val ingredients: String,
    val price: Price,
    val subtitle: String,
    val tags: List<String> = listOf(),
    val title: String
)
