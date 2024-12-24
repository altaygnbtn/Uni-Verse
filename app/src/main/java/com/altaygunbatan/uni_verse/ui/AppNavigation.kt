package com.altaygunbatan.uni_verse.ui

import android.provider.CalendarContract.Events
import android.provider.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.altaygunbatan.uni_verse.viewModels.AuthViewModel


@Composable
fun AppNavigation(modifier : Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login"){


        composable("login") {
            LoginPage(navController = navController, onLoginSuccess = {navController.navigate("home")})
        }
        composable("signup") {
            SignupPage(navController = navController, onSignupSuccess = {navController.navigate("login")})
        }
        composable("home") {
            HomePage(navController = navController)
        }
        composable ("chat") {
            ChatPage(navController = navController)
        }
        composable ("events") {
            EventsPage(navController = navController, events = emptyList(), onAddEvent = {}, onEditEvent = {}, onDeleteEvent = {})
        }
        composable ("notification") {
            NotificationPage(navController = navController)
        }
        composable ("settings") {
            SettingsPage(navController = navController)
        }
        composable("forgot") {
            ForgotPasswordPage(navController = navController)
        }

    }
}