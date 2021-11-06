package com.example.freelance_app.data.dto

data class Applicant(
    val id: Int,
    val profileImg: String, // URL
    val name: String = "",
    val email: String = "",
    val phone: String = "",
    val skills: String = "",
    val ratings: List<Rating> = mutableListOf(),
    val appliedJobs: List<Job> = mutableListOf()
)