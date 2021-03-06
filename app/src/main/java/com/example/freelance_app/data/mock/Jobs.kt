package com.example.freelance_app.data.mock

import com.example.freelance_app.data.dto.Company
import com.example.freelance_app.data.dto.Job
import com.example.freelance_app.data.dto.Status

val mockJobs: List<Job> = listOf(
    Job(
        id = 1,
        company = Company(
            id = 1,
            name = "ABC Company",
            description = "Good Company",
            logo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-6ElaNy55lU4TzRca41kHkW_PVQ9K6hA2tw&usqp=CAU"
        ),
        position = "Dish Washer",
        description = "We urgently need help on August 13th , 2021, 1pm - 5pm.",
        payInHour = 15.5f,
        status = Status.PENDING,
        category = "IT"
    ),
    Job(
        id = 1,
        company = Company(
            id = 1,
            name = "ABC Company",
            description = "Good Company",
            logo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-6ElaNy55lU4TzRca41kHkW_PVQ9K6hA2tw&usqp=CAU"
        ),
        position = "Coder",
        description = "We urgently need help on August 13th , 2021, 1pm - 5pm.",
        payInHour = 15.5f,
        status = Status.EXPIRED,
    ),
    Job(
        id = 1,
        company = Company(
            id = 1,
            name = "ABC Company",
            description = "Good Company",
            logo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-6ElaNy55lU4TzRca41kHkW_PVQ9K6hA2tw&usqp=CAU"
        ),
        position = "Baker",
        description = "We urgently need help on August 13th , 2021, 1pm - 5pm.",
        payInHour = 15.5f,
        status = Status.HIRED,
    ),
)