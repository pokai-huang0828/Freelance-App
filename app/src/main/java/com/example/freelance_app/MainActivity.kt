package com.example.freelance_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.example.freelance_app.ui.theme.FreelanceAppTheme
import com.example.freelance_app.view.navigation.Navigation
import com.example.freelance_app.view.screens.*

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppPreferences.init(this)
        setContent {
            FreelanceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
//                    UserDetailsForCompanyScreen()
//                        CompanyApplicationsScreen()
//                    UserDetailsScreen()
//                    UserPostsScreen()
//                    UserHistoryScreen()
                }
            }
        }
    }
}
