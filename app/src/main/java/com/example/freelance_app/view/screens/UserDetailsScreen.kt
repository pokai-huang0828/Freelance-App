package com.example.freelance_app.view.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.freelance_app.R
import com.example.freelance_app.data.dto.Company
import com.example.freelance_app.data.dto.Rating
import com.example.freelance_app.ui.theme.*
import com.example.freelance_app.view.reusables.*

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

@ExperimentalAnimationApi
@Composable
//fun UserDetailsScreen(navController: NavController) {
fun UserDetailsScreen() {
    Scaffold(
        topBar = { UserDetailsScreenTopBar() },
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
    var displayCommendPopup by remember { mutableStateOf(false) }
    var rating by remember { mutableStateOf(1) }
    var comment by remember { mutableStateOf("") }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = marginSmall)
    ) {
        // User Avatar here
        Avatar(imageUrl = "https://static.wikia.nocookie.net/pokemon/images/4/49/Ash_Pikachu.png/revision/latest?cb=20200405125039")

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

            Button(
                onClick = { displayCommendPopup = !displayCommendPopup },
            ) {
                Text(text = "Rate me")
            }
        }
    }

    // Comment Popup
    if (displayCommendPopup) {
        Divider()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = marginSmall)
        ) {
            Text(
                text = "Rate me",
                color = Color.Black,
                fontSize = fontSizeMed,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start
            )
            // comment input field
            InputField(value = comment, label = "Leave me comment") {
                comment = it
            }
            EditableRatingBox() {
                rating = it
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
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

    }

    Divider()

    UserDetailsInfoSection()
    UserDetailsFeedbacksSection()
}

@Composable
fun UserDetailsInfoSection() {
    var name by remember { mutableStateOf("Tommy") }
    var email by remember { mutableStateOf("Tommy@domain.com") }
    var phone by remember { mutableStateOf("604-123-1234") }
    var skills by remember { mutableStateOf("Cooking, Writing, Dancing") }

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
        InputField(value = name, label = "Name") {
            name = it
        }
        InputField(value = email, label = "Email") {
            email = it
        }
        InputField(value = phone, label = "Phone") {
            phone = it
        }
        InputField(value = skills, label = "Skills") {
            skills = it
        }
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = marginSmall)
    ) {
        Button(
            onClick = { },
        ) {
            Text(text = "Save")
        }
    }

    Divider()
}

@Composable
fun UserDetailsFeedbacksSection() {
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
                text = "Ratings",
                color = Color.Black,
                fontSize = fontSizeLarge,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

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
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
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

@ExperimentalAnimationApi
@Composable
fun UserDetailsScreenTopBar(
    navController: NavController? = null,
) {
    Column(Modifier.shadow(elevation = 5.dp)) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.primaryVariant)
                .fillMaxWidth()
                .height(60.dp)
                .padding(vertical = 3.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_onlytext),
                contentDescription = "logo_text only",
                modifier = Modifier.size(200.dp)
            )
            Row(
                modifier = Modifier
                    .height(60.dp)
                    .padding(2.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
//                if (navController != null) {
                IconButton(
//                        onClick = { navController.popBackStack() },
                    onClick = { },
                    modifier = Modifier
                        .padding(5.dp)
                        .size(45.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Logout,
                        contentDescription = "Logout",
                        tint = White,
                        modifier = Modifier
                            .size(30.dp)
                    )
                }
                IconButton(
//                        onClick = { navController.popBackStack() },
                    onClick = { },
                    modifier = Modifier
                        .padding(5.dp)
                        .size(45.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIos,
                        contentDescription = "Back",
                        tint = White,
                        modifier = Modifier
                            .size(30.dp)
                    )
//                    }
                }
            }
        }
    }
}


