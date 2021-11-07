package com.example.freelance_app.view.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Logout
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.freelance_app.R
import com.example.freelance_app.data.dto.Applicant
import com.example.freelance_app.data.mock.applicant
import com.example.freelance_app.data.mock.mockApplicants
import com.example.freelance_app.data.mock.mockJobs
import com.example.freelance_app.ui.theme.White
import com.example.freelance_app.ui.theme.fontSizeLarge
import com.example.freelance_app.ui.theme.marginSmall
import com.example.freelance_app.view.navigation.Screen
import com.example.freelance_app.view.reusables.Avatar
import com.example.freelance_app.view.reusables.HeaderTypography
import com.example.freelance_app.view.reusables.RatingBox

@ExperimentalAnimationApi
@Composable
fun CompanyApplicationsScreen(navController: NavController) {
//fun CompanyApplicationsScreen(){
    var displayList by remember { mutableStateOf(mockApplicants) }
    Scaffold(
        topBar = { ApplicationsTopbar(navController = navController) },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Applications",
                    color = Color.Black,
                    fontSize = fontSizeLarge,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                ApplicantList(displayList, navController = navController)
            }

        }
    )
}

@Composable
fun ApplicantList(displayList: List<Applicant>, navController: NavController) {
    if (displayList.isEmpty()) {
        Text("No Applicants.")
    } else {
        LazyColumn() {
            items(displayList.size) {
                ListOfApplicants(displayList[it], navController = navController)
            }
        }
    }
}

@Composable
fun ListOfApplicants(applicant: Applicant, navController: NavController)
{
    var visible by remember { mutableStateOf(true) }
    AnimatedVisibility(visible) {
        Card(
            border = BorderStroke(1.dp, Color.LightGray),
            elevation = 1.dp,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .height(150.dp)
                .fillMaxWidth(0.9f),) {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .clickable { navController.navigate(Screen.UserDetailsForCompanyScreen.route) }
                    .fillMaxWidth()
                    .padding(vertical = marginSmall)
            ) {
                // User Avatar here
                Image(
                    alignment = Alignment.TopCenter,
                    painter = rememberImagePainter(data = applicant.profileImg),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(60.dp))

                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = applicant.name,
                        color = Color.Black,
                        fontSize = fontSizeLarge,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start,
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    RatingBox(rating = 5)
                    Spacer(modifier = Modifier.size(5.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Button(
                            modifier = Modifier
                                .width(100.dp),
                            onClick = { navController.navigate(Screen.CompanyMainPageScreen.route) },
                        ) {
                            Text(text = "Hire")
                        }
                        Spacer(modifier = Modifier.size(10.dp))
                        Button(
                            modifier = Modifier
                                .width(100.dp),
                            onClick = { visible = !visible },
                        ) {
                            Text(text = "Deny")
                        }
                        Spacer(modifier = Modifier.size(10.dp))
                    }
                }
            }
        }
    }

}

@Composable
fun ApplicationsTopbar(
    navController: NavController) {
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
                    onClick = { navController.navigate(Screen.WelcomeScreen.route) },
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