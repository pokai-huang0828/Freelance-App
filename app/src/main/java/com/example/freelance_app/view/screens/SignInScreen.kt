package com.example.freelance_app.view.screens

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.freelance_app.R
import com.example.freelance_app.ui.theme.FreelanceAppTheme
import com.example.freelance_app.ui.theme.fontSizeLarge
import com.example.freelance_app.ui.theme.fontSizeMed
import com.example.freelance_app.view.reusables.CustomButton
import com.example.freelance_app.view.reusables.InputField



@Composable
fun SignInScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(20.dp),
           horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(R.drawable.google_text),
              contentDescription = null,
              modifier = Modifier.size(100.dp))
        Text(text="Sign in",
             fontSize = fontSizeLarge,
             fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.size(5.dp))
        Text(text="with your Google Account. Learn more",
             fontSize = fontSizeMed)
        Spacer(modifier = Modifier.size(15.dp))
        InputField("Email or phone",
            "",
            onValueChange = { email = it },
            keyboardType = KeyboardType.Email,
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Column() {
                Text(text="Forgot password?",
                    fontSize = fontSizeMed)
                Spacer(modifier = Modifier.size(30.dp))
                Text(text="Create account",
                    fontSize = fontSizeMed)
            }
        }
        Row(modifier= Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End){
            CustomButton(
                modifier = Modifier
                    .height(50.dp).width(80.dp),
                onClick = {  },
            ) {
                Text(text = "Next")
            }
        }

    }
}
