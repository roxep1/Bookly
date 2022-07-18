package com.bashkir.bookly.data.models

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val price: Float,
    val image: String,
    val rate: Rate
)
