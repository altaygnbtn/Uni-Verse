package com.altaygunbatan.uni_verse.ui

import android.provider.CalendarContract.Events
import android.provider.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.altaygunbatan.uni_verse.database.EventState
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
        composable("forgot") {
            ForgotPasswordPage(navController = navController)
        }
        composable("home") {
            HomePage(navController = navController, state = EventState(), onEvent = {})
        }
        composable ("map") {
            MapPage(navController = navController, state = EventState())
        }
        composable ("event_create") {
            CreateEventPage(navController = navController, state = EventState(), onEvent = {})
        }

    }
}