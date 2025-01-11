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
import com.altaygunbatan.uni_verse.viewModels.UserProfileViewModel
import com.google.android.gms.maps.model.LatLng
import okhttp3.internal.http2.Settings


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(viewModel: EventViewModel, profileViewModel: UserProfileViewModel) {

    val navController = rememberNavController()




    NavHost(navController = navController, startDestination = "login"){ //start destination is login page


        composable("login") {
            LoginPage(navController = navController, onLoginSuccess = {navController.navigate("home")}) //navigate to HomePage if successful
        }
        composable("signup") {
            SignupPage(navController = navController, onSignupSuccess = {navController.navigate("login")}) //navigate to SignupPage if successful
        }
        composable("forgot") {
            ForgotPasswordPage(navController = navController) //navigate the ForgotPasswordPage
        }
        composable("home") {
            HomePage(navController = navController, viewModel)     //navigate the HomePage
        }
        composable ("map") {
            MapPage(navController = navController, viewModel)      //navigate to MapPage
        }
        composable ("event_create") {
            CreateEventPage(navController = navController, viewModel = viewModel)   //navigate to CreateEventPage
        }
        composable ("event_join") {
            JoinEventPage(navController = navController, viewModel = viewModel) //navigate to JoinEventPage
        }
        composable ("profile") {
            ProfilePage(navController = navController, profileViewModel = profileViewModel) //navigate to ProfilePage
        }
        composable ("settings") {
            SettingsPage(navController = navController) //navigate to SettingsPage
        }


    }
}