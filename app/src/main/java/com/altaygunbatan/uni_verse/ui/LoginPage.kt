package com.altaygunbatan.uni_verse.ui

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.Image
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
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.altaygunbatan.uni_verse.ui.theme.backgroundDark
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily
import com.altaygunbatan.uni_verse.viewModels.AuthViewModel
import com.google.firebase.auth.FirebaseAuth


@Composable
fun LoginPage( navController: NavController, onLoginSuccess: () -> Unit) {
    var isSelected by rememberSaveable { mutableStateOf(false) }
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
            .background(color = Color(red = 255, green = 250, blue = 241))
    ){
        Text(
            text = "LOGIN",
            fontFamily = displayFontFamily,
            fontSize = 32.sp,
            modifier = Modifier.padding(start = 32.dp, top = 45.dp,)
        )

        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = "E-mail",
            fontFamily = displayFontFamily,
            fontSize = 22.sp,
            modifier = Modifier.padding(start = 46.dp))

        Spacer(modifier = Modifier.height(40.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ){
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

        Spacer(modifier = Modifier.height(95.dp))

        Text(
            text = "Password",
            fontFamily = displayFontFamily,
            fontSize = 22.sp,
            modifier = Modifier.padding(start = 46.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {
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
        Spacer(modifier = Modifier.height(30.dp))
        
        Row (verticalAlignment = Alignment.CenterVertically){
            RadioButton(
                selected = isSelected,
                onClick = { isSelected = !isSelected },
                modifier = Modifier.padding(start = 10.dp)
            )
            Text("Remember me")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {

            Button(
                onClick = {
                    signInWithEmailAndPassword(email, password) { success, error ->
                        if (success) {
                            onLoginSuccess()
                        } else {
                            errorMessage = error ?: "An unknown error occurred"
                        }
                    }
                },
                colors = androidx.compose.material.ButtonDefaults.buttonColors(
                    backgroundColor = Color(red = 40, green = 84, blue = 100),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .size(width = 345.dp, height = 45.dp)
            )
            {
                Text(text = "SIGN IN",
                    fontFamily = displayFontFamily,
                    fontSize = 22.sp)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            TextButton(onClick = {
                navController.navigate("forgot")
            }
            )
            {
                Text(text = "Forgot Password?",
                    fontFamily = displayFontFamily,
                    fontSize = 16.sp,
                    color = Color(red = 40, green = 84, blue = 100),
                    modifier = Modifier.padding(end = 20.dp))
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
            TextButton(onClick = {
                navController.navigate("signup")
            }) {
                Text("Don't have an account?",
                    fontFamily = displayFontFamily,
                    fontSize = 16.sp,
                    color = Color(red = 40, green = 84, blue = 100),
                    modifier = Modifier.padding(end = 20.dp))

            }
        }
    }
}



@Preview
@Composable
fun PreviewLoginPage() {
    LoginPage(navController = rememberNavController(), onLoginSuccess = {})

}