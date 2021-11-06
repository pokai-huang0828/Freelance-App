package com.example.freelance_app.view.screens

import android.graphics.Color
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
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
    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.google_text),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        Text(
            text = "Sign in",
            fontSize = fontSizeLarge,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.size(5.dp))

        Text(
            buildAnnotatedString {
                append("with your Google Account.")

                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primary
                    )
                ) {
                    append("Learn more")
                }
            },
            fontSize = fontSizeMed
        )

        Spacer(modifier = Modifier.size(15.dp))

        InputField(
            "Email or phone",
            "",
            onValueChange = { email = it },
            keyboardType = KeyboardType.Email,
            modifier = Modifier.width(100.dp)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            Column() {
                Text(
                    text = "Forgot password?", color = MaterialTheme.colors.primary,
                    fontSize = fontSizeMed
                )
                Spacer(modifier = Modifier.size(50.dp))
                Text(
                    text = "Create account", color = MaterialTheme.colors.primary,
                    fontSize = fontSizeMed
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ) {
            CustomButton(
                modifier = Modifier
                    .height(50.dp)
                    .width(80.dp),
                onClick = { },
            ) {
                Text(text = "Next")
            }
        }
    }
}

