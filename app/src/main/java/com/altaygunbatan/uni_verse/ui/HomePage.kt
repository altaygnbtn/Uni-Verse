package com.altaygunbatan.uni_verse.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomePage( navController: NavController) {

Column {
    Text(text = "Hello World")
}
}

@Preview
@Composable
fun PreviewHomePage() {
    HomePage(rememberNavController())
}