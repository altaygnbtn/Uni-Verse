package com.altaygunbatan.uni_verse.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.altaygunbatan.uni_verse.ui.theme.bodyFontFamily
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily
import com.altaygunbatan.uni_verse.viewModels.AuthViewModel
import com.google.firebase.auth.FirebaseAuth


@Composable
fun ForgotPasswordPage(navController : NavController) {
    var email by rememberSaveable { mutableStateOf("") }

    var showMessage by remember { mutableStateOf(false) }

    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color(red = 255, green = 250, blue = 241))
    ) {
        Text(
            text = "FORGOT PASSWORD",
            fontFamily = displayFontFamily,
            fontSize = 32.sp,
            modifier = Modifier.padding(start = 30.dp, top = 47.dp,)
        )

        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = "No problem! Enter the e-mail address associated with your account. We'll send you a secure link to reset your password",
                fontFamily = bodyFontFamily,
                fontSize = 22.sp,
                color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                modifier = Modifier.padding(start = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = "Register E-Mail",
            fontFamily = bodyFontFamily,
            fontSize = 22.sp,
            modifier = Modifier.padding(start = 30.dp)
        )

        Spacer(modifier = Modifier.height(35.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {
            androidx.compose.material.TextField(
                modifier = Modifier.size(width = 345.dp, height = 55.dp),
                value = email,
                onValueChange = {
                    email = it
                },
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(20.dp),

                )

        }
        Spacer(modifier = Modifier.height(70.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {
            Button(
                onClick = {
                    sendPasswordResetEmail(email) { success, response ->
                        if (success) {
                            message = "Reset link sent to $email"
                        } else {
                            message = response ?: "Error occurred, please try again."
                        }
                        showMessage = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 10, green = 16, blue = 69, alpha = 255),

                ),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.size(width = 345.dp, height = 45.dp)
            ) {
                Text(
                    text = "SEND LINK",
                    color = Color.White,
                    fontFamily = displayFontFamily,
                    fontSize = 22.sp
                )
            }

        }

        Spacer(modifier = Modifier.height(180.dp))

        TextButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.padding(start = 19.dp)
        ) {
            Text(
                text = "Back",
                fontFamily = displayFontFamily,
                fontSize = 15.sp,
                color = Color(red = 10, green = 16, blue = 69, alpha = 255)
            )
        }


    }
    if (showMessage) {
        AlertDialog(
            onDismissRequest = { showMessage = false },
            title = { Text("Message") },
            text = { Text(message) },
            confirmButton = {
                TextButton(onClick = { showMessage = false }) {
                    Text("OK")
                }
            }
        )
    }
}


fun sendPasswordResetEmail(email: String, callback: (Boolean, String?) -> Unit) {
    if (email.isEmpty()) {
        callback(false, "Please enter your email.")
        return
    }

    FirebaseAuth.getInstance().sendPasswordResetEmail(email)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                callback(true, null)
            } else {
                callback(false, task.exception?.localizedMessage)
            }
        }
}

@Preview
@Composable
fun PreviewForgotPasswordPage() {
    ForgotPasswordPage(navController = rememberNavController())

}