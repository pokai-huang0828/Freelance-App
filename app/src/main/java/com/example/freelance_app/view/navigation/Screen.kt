package com.example.freelance_app.view.navigation

import androidx.annotation.StringRes
import com.example.freelance_app.R

sealed class Screen(val route: String, @StringRes val resourceID: Int) {
    object WelcomeScreen : Screen("welcomeScreen", R.string.welcome_screen)
    object SignInScreen : Screen("signInScreen", R.string.sign_in_screen)
    object CompanyMainPageScreen : Screen("companyMainPageScreen", R.string.company_main_page_screen)
    object CompanyPostScreen : Screen("companyPostScreen", R.string.company_post_screen)
    object CompanyApplicantsScreen : Screen("companyApplicationsScreen", R.string.company_applications_screen)
    object UserPostsScreen : Screen("userPostsScreen", R.string.user_posts_screen)
    object UserHistoryScreen : Screen("userHistoryScreen", R.string.user_history_screen)
    object UserDetailsScreen : Screen("userDetailsScreen", R.string.user_details_screen)
    object UserDetailsForCompanyScreen : Screen("userDetailsForCompanyScreen", R.string.user_details_for_company_screen)
}