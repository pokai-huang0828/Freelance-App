package com.example.freelance_app.view.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.freelance_app.utils.CustomColors
import com.example.freelance_app.view.reusables.TopBar
import com.example.freelance_app.view.reusablesv2.Btn
import com.example.freelance_app.view.reusablesv2.CustomField


@ExperimentalAnimationApi
@Composable
fun CompanyPostScreen(
    navController: NavController,
    UserDetailsForCompanyScreen: () -> Unit,
    navigateToCompanyMainPage: () -> Unit
) {
    var description by remember {
        mutableStateOf(
            "Example: " + AppPreferences.job
        )
    }
    var skills by remember {
        mutableStateOf(
            "Example: " + AppPreferences.skills
        )
    }
    var dates by remember {
        mutableStateOf(AppPreferences.dates)
    }
    var switch by remember {
        mutableStateOf(AppPreferences.mode == "Save")
    }

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                TopBar(navController = navController)
                if (switch) {
                    DisplayCreatePost(
                        d = description,
                        s = skills,
                        date = dates,
                        UserDetailsForCompanyScreen = { UserDetailsForCompanyScreen() }
                    ) { d, s, date ->
                        description = d
                        skills = s
                        dates = date
                        switch = false
                    }
                } else {
                    DisplayDeleteVersion(
                        d = description,
                        s = skills,
                        date = dates,
                        { UserDetailsForCompanyScreen() }
                    ) {
                        navigateToCompanyMainPage()
                    }
                }
                Spacer(modifier = Modifier.padding(bottom = 200.dp))
            }
        }
    )
}

@Composable
fun DisplayCreatePost(
    s: String,
    d: String,
    date: String,
    UserDetailsForCompanyScreen: () -> Unit,
    clicked: (String, String, String) -> Unit,
) {
    var description by remember {
        mutableStateOf(d)
    }
    var skills by remember {
        mutableStateOf(s)
    }
    var dates by remember {
        mutableStateOf(date)
    }
    PostNameAndDate(text = "Dishwasher", edit = true, date = dates) {
        dates = it
    }
    Text(
        text = "Job Description:",
        color = Color.Black,
        fontSize = 20.sp,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp)
            .shadow(35.dp)
    )
    CustomField(
        text = description,
        label = "-",
        switch = true,
        bgColor = Color.White,
        textColor = Color.Black,
    ) { description = it }
    Text(
        text = "Needed Skills:",
        color = Color.Black,
        fontSize = 20.sp,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
            .shadow(35.dp)
    )
    CustomField(
        text = skills,
        label = "-",
        switch = true,
        bgColor = Color.White,
        textColor = Color.Black,
    ) { skills = it }

    ButtonGroup(btn1 = "Save", btn2 = "Applicants", { UserDetailsForCompanyScreen() }) {
        clicked(description, skills, dates)
    }

}

@Composable
fun DisplayDeleteVersion(
    d: String,
    s: String,
    date: String,
    UserDetailsForCompanyScreen: () -> Unit,
    navigateToCompanyMainPage: () -> Unit
) {
    PostNameAndDate(text = "Job Position: Dishwasher", edit = false, date = date) { }
    Text(
        text = "Job Description:",
        color = Color.Black,
        fontSize = 20.sp,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp)
            .shadow(35.dp)
    )
    CustomField(
        text = d,
        label = "-",
        switch = false,
        bgColor = CustomColors.primaryLight,
        textColor = CustomColors.primary,
    ) { }
    Text(
        text = "Needed Skills:",
        color = Color.Black,
        fontSize = 20.sp,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
            .shadow(35.dp)
    )
    CustomField(
        text = s,
        label = "-",
        switch = false,
        bgColor = CustomColors.primaryLight,
        textColor = CustomColors.primary,
    ) { }
    if (AppPreferences.mode != "UserMode") {
        ButtonGroup(btn1 = "Delete", btn2 = "Applicants", { UserDetailsForCompanyScreen() }) {
            navigateToCompanyMainPage()
        }
    }

}

@Composable
fun PostNameAndDate(
    text: String,
    edit: Boolean,
    date: String,
    transfer: (String) -> Unit,
) {
    var dates by remember { mutableStateOf(date) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 10.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(start = 20.dp)
                .shadow(35.dp)
        )
    }
    Text(
        text = "Dates:",
        color = Color.Black,
        fontSize = 20.sp,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp)
            .shadow(35.dp)
    )
    if (!edit) {
        CustomField(
            text = dates,
            label = "-",
            placeholder = "Dates",
            switch = false,
            bgColor = CustomColors.primaryLight,
            textColor = CustomColors.primary,
        ) {
            dates = it
        }
    } else {
        CustomField(
            text = dates,
            label = "-",
            placeholder = "Dates",
            switch = true,
            bgColor = Color.White,
            textColor = Color.Black,
        ) {
            dates = it
        }
    }
    transfer(dates)
}

@Composable
fun ButtonGroup(
    btn1: String,
    btn2: String,
    UserDetailsForCompanyScreen: () -> Unit,
    clicked: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp, horizontal = 20.dp)
    ) {
        Btn(text = btn1) { clicked() }
        Btn(text = btn2, padding = 15) { UserDetailsForCompanyScreen() }
    }
}
