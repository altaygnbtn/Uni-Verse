package com.altaygunbatan.uni_verse.ui

import android.provider.ContactsContract.CommonDataKinds.Email
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun LoginPage( navController: NavController) {
    var isSelected by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "LOGIN",
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
        
        Row (horizontalArrangement = Arrangement.Center){
            RadioButton(
                selected = isSelected,
                onClick = { isSelected = !isSelected },
                modifier = Modifier.padding(start = 20.dp)
            )
            Text("Remember me")
        }

        Spacer(modifier = Modifier.height(20.dp))

        androidx.compose.material3.Button(
            onClick = {
                navController.navigate("home")
            },
            modifier = Modifier
                .size(width = 345.dp, height = 45.dp)
        )
        {
            Text(text = "SIGN IN")
        }
        
        TextButton(onClick = {  navController.navigate("forgot")
        }) {
            Text(text = "Forgot Password?")
        }

        Spacer(modifier = Modifier.height(20.dp))
        
        TextButton(onClick = { navController.navigate("signup")
        }) {
            Text("Don't have an account? Create an account here")
        }





    }
}

@Preview
@Composable
fun PreviewLogin() {
    LoginPage(rememberNavController())
}