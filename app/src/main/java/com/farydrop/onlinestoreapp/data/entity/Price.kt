package com.farydrop.onlinestoreapp.data.entity

data class Price(
    val discount: Int,
    val price: String,
    val priceWithDiscount: String,
    val unit: String
)