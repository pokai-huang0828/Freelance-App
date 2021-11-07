package com.example.freelance_app.view.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.freelance_app.data.dto.Job
import com.example.freelance_app.data.dto.Status
import com.example.freelance_app.data.mock.mockJobs
import com.example.freelance_app.ui.theme.*
import com.example.freelance_app.view.reusables.TopBar

@ExperimentalAnimationApi
@Composable
fun UserHistoryScreen(navController: NavController) {
    Scaffold(
        topBar = { TopBar(navController) },
        content = {
            UserHistoryContent()
        }
    )
}

@Composable
fun UserHistoryContent() {
    // In real app, we should get all user applied jobs here

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = marginMed)
    ) {
        Text(
            text = "My Applied Jobs",
            color = Color.Black,
            fontSize = fontSizeLarge,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = marginSmall)
        )

        // List of Applied Job
        LazyColumn() {
            items(mockJobs.size) {
                AppliedJobCard(mockJobs[it])
            }
        }
    }
}

@Composable
fun AppliedJobCard(job: Job) {
    Card(
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = 1.dp,
        modifier = Modifier.padding(
            vertical = marginSmall
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // Company logo
            Image(
                painter = rememberImagePainter(data = job.company.logo),
                contentDescription = "",
                modifier = Modifier
                    .size(avatarSize)
                    .aspectRatio(1f)
                    .weight(1f)
            )

            // Company name and position
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.weight(2f)
            ) {
                Text(
                    text = job.company.name,
                    color = Color.Black,
                    fontSize = fontSizeMed,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )

                Divider()

                Text(
                    text = job.position,
                )
            }

            // job post status
            Text(
                text = job.status.toString(),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .weight(1.5f)
                    .padding(10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(GetJobPostStatusColor(job.status))
                    .padding(2.dp)
            )
        }
    }
}

fun GetJobPostStatusColor(status: Status): Color {
    return when (status) {
        Status.PENDING -> Color.Blue;
        Status.EXPIRED -> Color.Red;
        Status.HIRED -> Color.Green;
    }
}
