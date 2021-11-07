package com.example.freelance_app.view.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.freelance_app.R
import com.example.freelance_app.ui.theme.*
import com.example.freelance_app.view.navigation.Screen
import com.example.freelance_app.view.reusables.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.schedule


// These are testing for reusable components if you are going to work on this page
// You can delete them or keep them to check if you are not sure how to use these

@Composable
fun WelcomeScreen(navController: NavController) {
    var displayTransitionScreen by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    if (displayTransitionScreen) {
        SignInScreen(navController = navController)
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primaryVariant)
                .padding(bottom = 30.dp)
                .padding(horizontal = marginMed),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // App logo
            Row {
                Image(
                    painter = painterResource(R.drawable.logo_onlytext),
                    contentDescription = null,
                    modifier = Modifier.size(250.dp)
                )
            }

            // App banner text
            Text(
                text = "We Got Jobs for You!",
                fontSize = fontSizeLarge,
                fontWeight = FontWeight.ExtraBold,
                color = White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(100.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Sign In As",
                    fontSize = fontSizeMed,
                    fontWeight = FontWeight.ExtraBold,
                    color = White,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            CustomButton(
                modifier = Modifier.height(50.dp),
                onClick = { },
            ) {
                Text(
                    text = "Employer", fontSize = fontSizeMed
                )
            }

            Text(
                text = "Or",
                fontSize = fontSizeMed,
                color = White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )

            CustomButton(
                modifier = Modifier.height(50.dp),
                onClick = {
                    displayTransitionScreen = true
                    scope.launch {
                        delay(1500L)
                        navController.navigate(Screen.UserPostsScreen.route)
                    }
                },
            ) {
                Text(
                    text = "Job Seeker", fontSize = fontSizeMed,
                )
            }
        }

    }

}