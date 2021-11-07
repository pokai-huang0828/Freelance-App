package com.example.freelance_app.view.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.freelance_app.R
import com.example.freelance_app.data.dto.Applicant
import com.example.freelance_app.data.dto.Rating
import com.example.freelance_app.data.mock.applicant
import com.example.freelance_app.ui.theme.*
import com.example.freelance_app.view.reusables.Avatar
import com.example.freelance_app.view.reusables.EditableRatingBox
import com.example.freelance_app.view.reusables.InputField
import com.example.freelance_app.view.reusables.RatingBox

@ExperimentalAnimationApi
@Composable
fun UserDetailsForCompanyScreen(navController: NavController) {
//fun UserDetailsForCompanyScreen() {
    Scaffold(
        topBar = { UserDetailsForCompanyScreenTopBar() },
        content = {
            UserDetailsForCompanyEditContent()
        }
    )
}

@Composable
fun UserDetailsForCompanyEditContent() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(horizontal = marginMed)
            .verticalScroll(scrollState)
    ) {
        UserDetailsForCompanyProfileSection()
    }
}

@Composable
fun UserDetailsForCompanyProfileSection() {
    // in real app, we will get the applicant from database here

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
        Avatar(imageUrl = applicant.profileImg)

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

    UserDetailsForCompanyInfoSection(applicant)
    UserDetailsForCompanyFeedbacksSection(applicant)
}

@Composable
fun UserDetailsForCompanyInfoSection(applicant: Applicant) {
    Text(
        text = applicant.name,
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
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
    ) {

        // User info here
        Text(text = "Email: ${applicant.email}")
        Text(text = "Phone: ${applicant.phone}")
        Text(text = "Skills: ${applicant.skills}")
    }

    Divider(Modifier.padding(top = marginSmall))
}

@Composable
fun UserDetailsForCompanyFeedbacksSection(applicant: Applicant) {
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
            applicant.ratings.forEach {
                UserDetailsForCompanyFeedback(it)
            }
        }
    }
}

@Composable
fun UserDetailsForCompanyFeedback(rating: Rating) {
    Card(
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = 1.dp,
        modifier = Modifier.padding(
            vertical = marginSmall
        )
    ) {
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
                RatingBox(rating = rating.rating)

                Text(
                    text = rating.comment,
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun UserDetailsForCompanyScreenTopBar(
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
                if (navController != null) {
                    IconButton(
                        onClick = { navController.popBackStack() },
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
                        onClick = { navController.popBackStack() },
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
                    }
                }
            }
        }
    }
}

