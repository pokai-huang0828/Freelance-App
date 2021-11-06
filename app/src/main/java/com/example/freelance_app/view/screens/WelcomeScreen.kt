package com.example.freelance_app.view.screens

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
import com.example.freelance_app.view.reusables.*



// These are testing for reusable components if you are going to work on this page
// You can delete them or keep them to check if you are not sure how to use these

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.primaryVariant)
        .padding(top = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row{
            Image(painter = painterResource(R.drawable.logo_onlytext),
                contentDescription = null,
                modifier= Modifier.size(250.dp))
        }

        Text(
            text="A solution for your emergency business",
            fontSize = fontSizeLarge,
            fontWeight = FontWeight.ExtraBold,
            color = White,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(200.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text (text="Are you an",
                    fontSize = fontSizeLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = White
                )
            }
            Spacer(modifier = Modifier.height(30.dp).weight(1f))
        }

        Spacer(modifier = Modifier.height(30.dp))

        CustomButton(
            modifier = Modifier
                .height(50.dp),
            onClick = {  },
        ) {
            Text(text = "Employer")
        }
        Text (text="Or",
            fontSize = fontSizeMed,
            color = White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(10.dp)
        )
        CustomButton(
            modifier = Modifier
                .height(50.dp),
            onClick = {  },
        ) {
            Text(text = "Applicant")
        }
    }
}





//    var email by remember { mutableStateOf("") }
//
//    Column {
//            TopBar()
//            InputField(
//                value = email,
//                label = "Email",
//                onValueChange = { email = it },
//                keyboardType = KeyboardType.Email,
//                modifier = Modifier
//                    .fillMaxWidth(),
//            )
//            Spacer(modifier = Modifier.size(5.dp))
//            CustomButton(
//                modifier = Modifier
//                    .height(50.dp),
//                onClick = {  },
//            ) {
//                Text(text = "Button")
//            }
//            Spacer(modifier = Modifier.size(5.dp))
//            SearchBar()
//            Spacer(modifier = Modifier.size(5.dp))
//            Avatar(imageUrl = "https://i1.kknews.cc/SIG=p567ci/3155000qo23rs0nr60p2.jpg")
//        }

