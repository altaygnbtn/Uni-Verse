package com.altaygunbatan.uni_verse.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun SignupPage( navController: NavController) {


    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "SIGN UP",
            modifier = Modifier.padding(start = 50.dp, top = 50.dp,)
        )

        Spacer(modifier = Modifier.height(200.dp))

        Text(
            text = "E-mail",
            modifier = Modifier.padding(start = 70.dp))

        Spacer(modifier = Modifier.height(10.dp))

        EmailTextField()

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Password",
            modifier = Modifier.padding(start = 70.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextField()

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = {

        },
            modifier = Modifier.size(width = 345.dp, height = 45.dp)) {
            Text("SIGN IN")
        }


        Spacer(modifier = Modifier.height(20.dp))

        MyButton2("PREVIEW",navController)

        Spacer(modifier = Modifier.height(100.dp))

        TextButton(onClick = {
            navController.navigate("login")
        }) {
            Text(text = "Back")
        }
    }
}






