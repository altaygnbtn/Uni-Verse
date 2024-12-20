package com.altaygunbatan.uni_verse.ui

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.altaygunbatan.uni_verse.ui.theme.primaryContainerLight
import com.altaygunbatan.uni_verse.ui.theme.primaryLight
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun EmailTextField() {

        var email by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.size(width = 345.dp, height = 45.dp),
        value =email,
        onValueChange = {
            email = it
        },
        label = {
            Text(text = "Email")
        }
    )
}

@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier.size(width = 345.dp, height = 45.dp),
        value =password,
        onValueChange = {
            password = it
        },
        label = {
            Text(text = "Password")
        }
    )
}



@Composable
fun MyButton( text: String) {

    Button(onClick = {},
        modifier = Modifier
            .size(width = 345.dp, height = 45.dp)
        )
    {
        Text(text)
    }
}

@Composable
fun MyButton2(text2: String, navController: NavController){
    Button(
        onClick = {
            navController.navigate("home")
        },
        modifier = Modifier.
        size(width = 241.dp, height = 33.dp),


    ){
        Text(text2)
    }
}






