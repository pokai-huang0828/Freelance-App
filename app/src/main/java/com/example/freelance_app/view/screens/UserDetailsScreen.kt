package com.example.freelance_app.view.screens

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.freelance_app.view.reusables.RatingBox

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
        modifier = Modifier.scrollable(
            state = scrollState,
            orientation = Orientation.Vertical
        )
    ) {
        UserDetailsProfileSection()
    }
}

@Composable
fun UserDetailsProfileSection() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "4.9/5.0",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            RatingBox(rating = 5)

            Text(
                text = "out of 10 ratings",
            )
        }
    }
}

@Composable
fun UserDetailsInfoSection() {

}

@Composable
fun UserDetailsFeedbacksSection() {

}

@Composable
fun UserDetailsFeedback() {

}

@Composable
fun CommendPopup() {

}


