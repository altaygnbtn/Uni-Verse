package com.altaygunbatan.uni_verse.ui

import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.altaygunbatan.uni_verse.R
import com.altaygunbatan.uni_verse.ui.theme.bodyFontFamily
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily


@Composable
fun SignupPage( navController: NavController, onSignupSuccess: () -> Unit) {
    var password by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false)}

    val icon = if (passwordVisibility){
        painterResource(id = R.drawable.baseline_visibility_24)
    }
    else {
        painterResource(id = R.drawable.baseline_visibility_off_24)
    }
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color(red = 242, green = 244, blue = 243))
    ){
        Text(
            text = "SIGN UP",
            fontFamily = displayFontFamily,
            color = Color(red = 10, green = 16, blue = 69, alpha = 255),
            fontSize = 32.sp,
            modifier = Modifier.padding(start = 32.dp, top = 45.dp)
        )

        Spacer(modifier = Modifier.height(120.dp))

        Text(
            text = "E-mail",
            fontFamily = bodyFontFamily,
            fontSize = 22.sp,
            modifier = Modifier.padding(start = 46.dp))

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {
            TextField(
                modifier = Modifier.size(width = 345.dp, height = 55.dp),
                value = email,
                onValueChange = {
                    email = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Password",
            fontFamily = bodyFontFamily,
            fontSize = 22.sp,
            modifier = Modifier.padding(start = 46.dp),

        )
        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ){

        TextField(
            modifier = Modifier.size(width = 345.dp, height = 55.dp),
            value =password,
            onValueChange = {
                password = it
            },
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(20.dp),
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Toggle password visibility"
                    )
                }
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if(passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
}

        Spacer(modifier = Modifier.height(60.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {
            Button(
                onClick = {
                    signUpWithEmailAndPassword(email, password) { success, error ->
                        if (success) {
                            onSignupSuccess()
                        } else {
                            errorMessage = error ?: "An unknown error occurred"
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(red = 10, green = 16, blue = 69, alpha = 255),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.size(width = 345.dp, height = 47.dp)
            ) {
                Text(
                    text = "Create Account",
                    fontFamily = displayFontFamily,
                    fontSize = 22.sp
                )
            }
        }
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }


            Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {
            MyButton2("PREVIEW", navController)

        }
        Spacer(modifier = Modifier.height(100.dp))

        TextButton(onClick = {
            navController.navigate("login") },
            modifier = Modifier.padding(start = 19.dp)) {
            Text(text = "Back",
                fontFamily = displayFontFamily,
                fontSize = 15.sp,
                color = Color(red = 10, green = 16, blue = 69, alpha = 255))
        }
    }


}


@Preview
@Composable
fun SignupPagePreview() {
    SignupPage(navController = rememberNavController(), onSignupSuccess = {})
}






