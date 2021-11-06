package com.example.freelance_app.data.dto

import java.util.*

data class CompanySchema(
    val name: String,
    val about: String,
    val jobPosts: List<Job>,
    val logo: String, // URL


)

data class Job(
    val name: String,
    val description: String,
    val neededSkills: String,
    val dates: Date,
    val applicants: List<Applicant>
)

data class Applicant(
    val name: String,
)