package com.example.freelance_app.view.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.freelance_app.view.screens.CompanyMainPageScreen
import com.example.freelance_app.view.screens.SignInScreen
import com.example.freelance_app.view.screens.WelcomeScreen
import com.example.freelance_app.view.screens.CompanyPostScreen
import com.example.freelance_app.view.screens.CompanyApplicationsScreen
import com.example.freelance_app.view.screens.UserPostsScreen
import com.example.freelance_app.view.screens.UserHistoryScreen

@ExperimentalAnimationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route
    ) {
        composable(route = Screen.WelcomeScreen.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.SignInScreen.route) {
            SignInScreen(navController = navController)
        }
        composable(route = Screen.CompanyMainPageScreen.route) {
            CompanyMainPageScreen(navController = navController)
        }
        composable(route = Screen.CompanyPostScreen.route) {
            CompanyPostScreen(navController = navController)
        }
        composable(route = Screen.CompanyApplicationsScreen.route) {
            CompanyApplicationsScreen(navController = navController)
        }
        composable(route = Screen.UserPostsScreen.route) {
            UserPostsScreen(navController = navController)
        }
        composable(route = Screen.UserHistoryScreen.route) {
            UserHistoryScreen(navController = navController)
        }
    }
}