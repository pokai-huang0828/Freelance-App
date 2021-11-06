package com.example.freelance_app.data.dto

data class Job(
    val id: Int,
    val company: Company,
    val position: String = "",
    val description: String = "",
    val payInHour: Float = 0.0f,
    val skills: String = "",
    val applicants: List<Applicant> = mutableListOf(),
    val chosenApplicant: Applicant,
    val status: Status
)