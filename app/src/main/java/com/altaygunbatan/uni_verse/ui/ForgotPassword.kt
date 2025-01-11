package com.altaygunbatan.uni_verse.ui

import androidx.compose.foundation.background
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

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.AlertDialog

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TextButton

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.TextFieldDefaults

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.altaygunbatan.uni_verse.R
import com.altaygunbatan.uni_verse.ui.theme.bodyFontFamily
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily

import com.google.firebase.auth.FirebaseAuth


@Composable
fun ForgotPasswordPage(navController : NavController) {



    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color(red = 242, green = 244, blue = 243)),
    ) {

        ForgotPasswordPageText()

        ForgotPasswordPageToSendLink()

        ForgotPasswordPagrBackButton(navController = navController)


    }

}




@Preview
@Composable
fun PreviewForgotPasswordPage() {
    ForgotPasswordPage(navController = rememberNavController())

}