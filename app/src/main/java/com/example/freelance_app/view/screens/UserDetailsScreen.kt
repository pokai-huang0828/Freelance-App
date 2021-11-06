package com.example.freelance_app.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.freelance_app.data.dto.Company
import com.example.freelance_app.data.dto.Rating
import com.example.freelance_app.ui.theme.*
import com.example.freelance_app.view.reusables.EditableRatingBox
import com.example.freelance_app.view.reusables.RatingBox

val comments: List<Rating> = listOf(
    Rating(
        company = Company(
            id = 1,
            name = "ABC Company",
            description = "Good Company",
            logo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-6ElaNy55lU4TzRca41kHkW_PVQ9K6hA2tw&usqp=CAU"
        ),
        rating = 5,
        comment = "Good Job!"
    ),
    Rating(
        company = Company(
            id = 1,
            name = "ABC Company",
            description = "Good Company",
            logo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-6ElaNy55lU4TzRca41kHkW_PVQ9K6hA2tw&usqp=CAU"
        ),
        rating = 5,
        comment = "Good Job!"
    ),
    Rating(
        company = Company(
            id = 1,
            name = "ABC Company",
            description = "Good Company",
            logo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-6ElaNy55lU4TzRca41kHkW_PVQ9K6hA2tw&usqp=CAU"
        ),
        rating = 5,
        comment = "Good Job!"
    )
)

@Composable
//fun UserDetailsScreen(navController: NavController) {
fun UserDetailsScreen() {
    Scaffold(
//        topBar = { },
        content = {
            UserDetailsEditContent()
        }
    )
}

@Composable
fun UserDetailsEditContent() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(horizontal = marginMed)
            .verticalScroll(scrollState)
    ) {
        UserDetailsProfileSection()
    }
}

@Composable
fun UserDetailsProfileSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = marginSmall)
    ) {
        // User Avatar here

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "4.9/5.0",
                color = Color.Black,
                fontSize = fontSizeLarge,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            RatingBox(rating = 5)

            Text(
                text = "out of 10 ratings",
            )
        }
    }

    Divider()

    UserDetailsInfoSection()

    Divider()

    UserDetailsFeedbacksSection()

}

@Composable
fun UserDetailsInfoSection() {
    Text(
        text = "Profile Info",
        color = Color.Black,
        fontSize = fontSizeLarge,
        fontWeight = FontWeight.SemiBold,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = marginSmall)
    )
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {

        // Place input fields here
    }
}

@Composable
fun UserDetailsFeedbacksSection() {
    var displayCommendPopup by remember { mutableStateOf(false) }
    var rating by remember { mutableStateOf(1) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = marginSmall)
        ) {
            Text(
                text = "Feedbacks",
                color = Color.Black,
                fontSize = fontSizeLarge,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Rate me",
                color = Color.Blue,
                fontSize = fontSizeMed,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    displayCommendPopup = !displayCommendPopup
                }
            )
        }

        // Comment Popup
        if (displayCommendPopup) {
            Text(
                text = "Comment",
                color = Color.Black,
                fontSize = fontSizeMed,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )
            // comment input field
            EditableRatingBox(){
                rating = it
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = marginSmall)
            ) {
                Button(onClick = { displayCommendPopup = false }) {
                    Text(text = "Cancel")
                }
                Spacer(modifier = Modifier.padding(horizontal = marginSmall))
                Button(onClick = { displayCommendPopup = false }) {
                    Text(text = "Confirm")
                }
            }
        }

        Column() {
            comments.forEach {
                UserDetailsFeedback(it)
            }
        }

    }
}

@Composable
fun UserDetailsFeedback(rating: Rating) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(bottom = marginSmall)
            .fillMaxWidth()
    ) {
        // Company logo
        Image(
            painter = rememberImagePainter(data = rating.company.logo),
            contentDescription = "",
            modifier = Modifier
                .size(avatarSize)
                .aspectRatio(1f)
        )

        Spacer(modifier = Modifier.padding(horizontal = marginSmall))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = rating.comment,
            )

            RatingBox(rating = rating.rating)
        }
    }
}


