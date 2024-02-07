package com.farydrop.onlinestoreapp.data.entity

data class Item(
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
) {
    constructor(
        available: Int,
        description: String,
        feedback: Feedback,
        info: List<Info>,
        ingredients: String,
        price: Price,
        subtitle: String,
        tags: List<String>,
        title: String
    ) : this(
        available,
        description,
        feedback,
        "0",
        info,
        ingredients,
        price,
        subtitle,
        tags,
        title
    )
}