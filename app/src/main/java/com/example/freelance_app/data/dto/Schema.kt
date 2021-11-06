package com.example.freelance_app.data.dto

import java.util.*

data class Company(
    val id: Int,
    val name: String,
    val about: String,
    val jobPosts: List<Job>,
    val logo: String, // URL
)

data class Job(
    val id: Int,
    val position: String,
    val company: Company,
    val category: Category,
    val description: String,
    val skills: List<Skill>,
    val applicants: List<Applicant>,
    val chosenApplicant: Applicant,
    val status: Status
)

enum class Status {
    Expired,
    Hired,
    Cancelled
}

enum class Skill {

}

enum class Category {
    Bakery,
    Beauty,
    restaurant
}

data class Applicant(
    val name: String,
)