package com.example.freelance_app.data.dto

data class Rating(
    val company: Company,
    val rating: Int = 0,
    val comment: String = "",
)