package com.example.freelance_app.data.dto

data class CompanyJobs(
    val company: Company,
    val jobPosts: List<Job> = mutableListOf(),
)