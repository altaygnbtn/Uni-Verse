package com.altaygunbatan.uni_verse.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.altaygunbatan.uni_verse.viewModels.EventViewModel
import com.google.android.gms.maps.model.LatLng


@RequiresApi(Build.VERSION_CODES.O)
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
            MapPage(navController = navController, viewModel)
        }
        composable ("event_create") {
            CreateEventPage(navController = navController, viewModel = viewModel)
        }
        composable ("event_join") {
            JoinEventPage(navController = navController, viewModel = viewModel)
        }


    }
}