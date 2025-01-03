package com.altaygunbatan.uni_verse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.altaygunbatan.uni_verse.ui.AppNavigation
import com.altaygunbatan.uni_verse.ui.CreateEventPage
import com.altaygunbatan.uni_verse.ui.ForgotPasswordPage
import com.altaygunbatan.uni_verse.ui.HomePage
import com.altaygunbatan.uni_verse.ui.LoginPage
import com.altaygunbatan.uni_verse.ui.MapPage
import com.altaygunbatan.uni_verse.ui.SignupPage
import com.altaygunbatan.uni_verse.ui.theme.AppTypography
import com.altaygunbatan.uni_verse.ui.theme.UniVerseTheme
import com.altaygunbatan.uni_verse.viewModels.AuthViewModel
import com.altaygunbatan.uni_verse.viewModels.EventViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

//            val authViewModel: AuthViewModel by viewModels()
//            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                AppNavigation(modifier = Modifier.padding(innerPadding),authViewModel = AuthViewModel())
//            AppNavigation()

            val viewModel = ViewModelProvider(this).get(EventViewModel::class.java)
            val navController = rememberNavController()

            AppNavigation(viewModel)



            UniVerseTheme {

                }

            }
        }
    }







