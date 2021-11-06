package com.example.freelance_app.data.dto

data class Company(
    val id: Int,
    val name: String,
    val description: String,
    val jobPosts: List<Job>,
    val logo: String, // URL
)