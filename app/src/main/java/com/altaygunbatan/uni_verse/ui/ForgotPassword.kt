package com.altaygunbatan.uni_verse.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun ForgotPasswordPage(navController : NavController) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "FORGOT PASSWORD",
            modifier = Modifier.padding(start = 50.dp, top = 50.dp,)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "No problem! Enter the e-mail address associated with your account. We'll send you a secure link to reset your password")

        Spacer(modifier = Modifier.height(200.dp))

        Text(text = "Register E-Mail")

        Spacer(modifier = Modifier.height(10.dp))

        EmailTextField()

        Spacer(modifier = Modifier.height(40.dp))

        MyButton("SEND LINK")

        Spacer(modifier = Modifier.height(250.dp))

        TextButton(onClick = {
            navController.navigate("login")
        }) {
            Text(text = "Back")
        }


    }
}

@Preview
@Composable
fun ForgotPasswordPreview() {
    ForgotPasswordPage(rememberNavController())
}