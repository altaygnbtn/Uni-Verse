package com.altaygunbatan.uni_verse.ui

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.altaygunbatan.uni_verse.viewModels.EventViewModel


@Composable
fun AppNavigation(viewModel: EventViewModel) {

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
            HomePage(navController = navController, viewModel)
        }
        composable ("map") {
            MapPage(navController = navController)
        }
        composable ("event_create") {
            CreateEventPage(navController = navController, viewModel = viewModel)
        }
        composable ("event_join") {
            JoinEventPage(navController = navController, viewModel = viewModel)
        }

    }
}