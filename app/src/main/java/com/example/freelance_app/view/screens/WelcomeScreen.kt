package com.example.freelance_app.view.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.freelance_app.ui.theme.White
import com.example.freelance_app.view.reusables.*



// These are testing for reusable components if you are going to work on this page
// You can delete them or keep them to check if you are not sure how to use these


@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun WelcomeScreen(navController: NavController) {
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
}
