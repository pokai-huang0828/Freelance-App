package com.example.freelance_app.view.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.freelance_app.ui.theme.fontSizeLarge
import com.example.freelance_app.utils.CustomColors
import com.example.freelance_app.view.reusables.TopBar
import com.example.freelance_app.view.reusablesv2.Btn
import com.example.freelance_app.view.reusablesv2.CustomField
import com.example.freelance_app.view.reusablesv2.HeaderTypography


@ExperimentalAnimationApi
@Composable
fun CompanyPostScreen(navigateToCompanyMainPage: () -> Unit) {
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                TopBar()
                PostNameAndDate(text = "Dishwasher")
                Text(
                    text = "Job Description:",
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                CustomField(
                    text = "Washes all wares including pots, plans, flatware, " +
                            "and glasses, by hand or using dishwashers. Correctly " +
                            "places and stores clean equipment, dishes, and utensils" +
                            " in assigned storage areas. ... May assist in cleaning " +
                            "and preparing various foods " +
                            "for cooking and/or serving, as directed. ",
                    label = "-",
                    switch = false,
                    bgColor = CustomColors.primaryLight,
                    textColor = CustomColors.primary,
                ) {}
                Text(
                    text = "Needed Skills:",
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .padding(top = 20.dp)
                )
                CustomField(
                    text = "-> Manual dexterity\n" +
                            "-> Ability to keep kitchen clean and tidy\n" +
                            "-> Reliability, professionalism and keen sense of cleanliness\n" +
                            "-> Organizational skills\n" +
                            "-> Flexibility and willingness to work shifts\n" +
                            "-> Physical strength and stamina",
//                    modifier = Modifier.padding(top = (-15).dp),
                    label = "-",
                    switch = false,
                    bgColor = CustomColors.primaryLight,
                    textColor = CustomColors.primary,
                ) {}

                ButtonGroup(btn1 = AppPreferences.data, btn2 = "Applicants") {
                    navigateToCompanyMainPage()
                }
                Spacer(modifier = Modifier.padding(bottom = 200.dp))
            }
        }
    )
}

@Composable
fun PostNameAndDate(text: String) {
    var description by remember { mutableStateOf(text) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 10.dp)
    ) {
        HeaderTypography(
            text = text,
            fontWeight = FontWeight.Bold,
            alignment = Arrangement.Start,
            modifier = Modifier
                .padding(start = 20.dp)
                .weight(1f)
                .offset(y = (-15).dp)
        )
        CustomField(
            text = "From Nov 5\n" +
                    "Till Nov 6\n" +
                    "2021",
            modifier = Modifier.weight(1f),
            label = "Dates",
            placeholder = "Dates",
            switch = false,
            bgColor = CustomColors.primaryLight,
            textColor = CustomColors.primary,
        ) {}
    }
}

@Composable
fun ButtonGroup(btn1: String, btn2: String, cliked: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp, horizontal = 20.dp)
    ) {
        Btn(text = btn1) { cliked() }
        Btn(text = btn2, padding = 15) { cliked() }
    }
}
