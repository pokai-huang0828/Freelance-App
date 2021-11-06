package com.example.freelance_app.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.freelance_app.data.dto.Company
import com.example.freelance_app.data.dto.Job
import com.example.freelance_app.data.dto.Rating
import com.example.freelance_app.data.dto.Status
import com.example.freelance_app.ui.theme.*

val jobs: List<Job> = listOf(
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
        status = Status.ONGOING,
    ),
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
        status = Status.ONGOING,
    ),
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
        status = Status.ONGOING,
    ),
)

@Composable
//fun UserPostsScreen(navController: NavController) {
fun UserPostsScreen() {
    Scaffold(
//        topBar = { },
        content = {
            UserPostsContent()
        }
    )
}

@Composable
fun UserPostsContent() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(horizontal = marginMed)
            .verticalScroll(scrollState)
    ) {
        //
    }

    Column(
        modifier = Modifier
            .padding(horizontal = marginMed)
            .verticalScroll(scrollState)
    ) {
        // custom navbar

        // search bar

        // categories

        // jobs
        JobPosts()
    }
}

@Composable
fun JobPosts() {
    Column() {
        jobs.forEach {
            JobPost(it)
        }
    }
}

@Composable
fun JobPost(job: Job) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        JobPostTitle(job)

        // Job Description
        Text(
            text = job.description,
            color = Color.Black,
            textAlign = TextAlign.Start
        )

        // PayGrade and Apply Button
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(
                text = "$${job.payInHour}/hour",
                color = Color.Black,
                textAlign = TextAlign.Start
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Apply")
            }
        }
    }
}

@Composable
fun JobPostTitle(job: Job) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Company logo
            Image(
                painter = rememberImagePainter(data = job.company.logo),
                contentDescription = "",
                modifier = Modifier
                    .size(avatarSize)
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier.padding(horizontal = marginSmall))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = job.company.name,
                    color = Color.Black,
                    fontSize = fontSizeMed,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = job.position,
                    color = Color.Black,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}


