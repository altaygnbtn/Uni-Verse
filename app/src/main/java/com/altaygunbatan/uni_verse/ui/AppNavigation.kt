package com.altaygunbatan.uni_verse.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigation(modifier : Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login"){


        composable("login") {
                LoginPage(navController = navController)
            }
        composable("signup") {
            SignupPage(navController = navController)
        }
        composable("home") {
            HomePage(navController = navController)
        }
        composable("forgot") {
            ForgotPasswordPage(navController = navController)
        }

    }
}