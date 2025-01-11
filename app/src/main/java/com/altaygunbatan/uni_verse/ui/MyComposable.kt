package com.altaygunbatan.uni_verse.ui

import android.app.DatePickerDialog
import android.net.Uri
import android.os.Build
import android.widget.Toast

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column



import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow

import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.ButtonDefaults

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.RadioButton

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.TextButton

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

import androidx.navigation.NavController

import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.altaygunbatan.uni_verse.R
import com.altaygunbatan.uni_verse.dataClasses.Event
import com.altaygunbatan.uni_verse.dataClasses.UserProfile
import com.altaygunbatan.uni_verse.ui.theme.bodyFontFamily
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily
import com.altaygunbatan.uni_verse.viewModels.EventViewModel
import com.altaygunbatan.uni_verse.viewModels.UserProfileViewModel

import com.google.firebase.auth.FirebaseAuth
import java.time.LocalDate
import java.util.Calendar


@Composable
fun LoginPageEmailText(modifier: Modifier = Modifier) {

    Text(
        text = stringResource(id = R.string.login),
        fontFamily = displayFontFamily,
        fontSize = 32.sp,
        modifier = Modifier.padding(start = 32.dp, top = 45.dp,)
    )

    Spacer(modifier = Modifier.height(120.dp))

    Text(
        text = stringResource(id = R.string.email),
        fontFamily = bodyFontFamily,
        fontSize = 22.sp,
        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
        modifier = Modifier.padding(start = 46.dp))

    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun LoginToHomePage(modifier: Modifier = Modifier, onLoginSuccess: () -> Unit) {
    var errorMessage by remember { mutableStateOf("") }

    var email by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false)}

    val icon = if (passwordVisibility){
        painterResource(id = R.drawable.baseline_visibility_24)
    }
    else {
        painterResource(id = R.drawable.baseline_visibility_off_24)
    }
    var password by rememberSaveable { mutableStateOf("") }

    var isSelected by rememberSaveable { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ){
        androidx.compose.material.TextField(
            modifier = Modifier.size(width = 345.dp, height = 55.dp),
            value = email,
            onValueChange = {
                email = it
            },
            colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(20.dp)
        )
    }

    Spacer(modifier = Modifier.height(50.dp))


    Text(
        text = stringResource(id = R.string.password),
        fontFamily = bodyFontFamily,
        fontSize = 22.sp,
        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
        modifier = Modifier.padding(start = 46.dp)
    )

    Spacer(modifier = Modifier.height(20.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        androidx.compose.material.TextField(
            modifier = Modifier.size(width = 345.dp, height = 55.dp),
            value = password,
            onValueChange = {
                password = it
            },
            colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
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
                        contentDescription = "Click to change password visibility"
                    )
                }
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
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
        Text(
            stringResource(id = R.string.remember),
            fontFamily = bodyFontFamily,
            color = Color(red = 10, green = 16, blue = 69, alpha = 255))
    }

    Spacer(modifier = Modifier.height(20.dp))


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {

        androidx.compose.material.Button(
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
                backgroundColor = Color(red = 10, green = 16, blue = 69, alpha = 255),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .size(width = 345.dp, height = 45.dp)
        )
        {
            Text(
                text = stringResource(R.string.signIn),
                fontFamily = displayFontFamily,
                fontSize = 22.sp
            )
        }
    }

    Spacer(modifier = Modifier.height(10.dp))

}

@Composable
fun AccountForgotText(modifier: Modifier = Modifier, navController: NavController) {

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
        TextButton(onClick = {
            navController.navigate("forgot")
        }
        )
        {
            Text(text = stringResource(R.string.forgot),
                fontFamily = displayFontFamily,
                fontSize = 16.sp,
                color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                modifier = Modifier.padding(end = 20.dp))

        }
    }
    Spacer(modifier = Modifier.height(10.dp))
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
        TextButton(onClick = {
            navController.navigate("signup")
        }) {
            Text(
                stringResource(R.string.account),
                fontFamily = displayFontFamily,
                fontSize = 16.sp,
                color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                modifier = Modifier.padding(end = 20.dp))

        }
    }

}

@Composable
fun SignUpPageEmailText(modifier: Modifier = Modifier) {

    Text(
        text = stringResource(id = R.string.signUp),
        fontFamily = displayFontFamily,
        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
        fontSize = 32.sp,
        modifier = Modifier.padding(start = 32.dp, top = 45.dp)
    )

    Spacer(modifier = Modifier.height(120.dp))

    Text(
        text = stringResource(id = R.string.email),
        fontFamily = bodyFontFamily,
        fontSize = 22.sp,
        modifier = Modifier.padding(start = 46.dp))

    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun SignUpPageToLogin(modifier: Modifier = Modifier, onSignupSuccess: () -> Unit) {

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
            colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(20.dp)
        )
    }
    Spacer(modifier = Modifier.height(50.dp))

    Text(
        text = stringResource(id = R.string.password),
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

        androidx.compose.material.TextField(
            modifier = Modifier.size(width = 345.dp, height = 55.dp),
            value = password,
            onValueChange = {
                password = it
            },
            colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
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
                        contentDescription = "Click to change password visibility"
                    )
                }
            }, keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation()
        )
    }

    Spacer(modifier = Modifier.height(60.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        androidx.compose.material.Button(
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
                text = stringResource(R.string.createAccount),
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
}

@Composable
fun PreviewOrLogin(modifier: Modifier = Modifier, navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        MyButton2(stringResource(id = R.string.preview), navController)

    }
    Spacer(modifier = Modifier.height(100.dp))

    TextButton(onClick = {
        navController.navigate("login") },
        modifier = Modifier.padding(start = 19.dp)) {
        Text(text = stringResource(id = R.string.back),
            fontFamily = displayFontFamily,
            fontSize = 15.sp,
            color = Color(red = 10, green = 16, blue = 69, alpha = 255))
    }

}

@Composable
fun ForgotPasswordPageText(modifier: Modifier = Modifier) {



    Text(
        text = stringResource(id = R.string.forgot_password),
        fontFamily = displayFontFamily,
        fontSize = 32.sp,
        modifier = Modifier.padding(
            start = 30.dp,
            top = 47.dp
        )
    )

    Spacer(modifier = Modifier.height(30.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = stringResource(R.string.forgot_text),
            fontFamily = bodyFontFamily,
            fontSize = 22.sp,
            color = Color(red = 10, green = 16, blue = 69, alpha = 255),
            modifier = Modifier.padding(start = 10.dp)
        )
    }
    Spacer(modifier = Modifier.height(100.dp))

    Text(
        text = stringResource(R.string.register),
        fontFamily = bodyFontFamily,
        fontSize = 22.sp,
        modifier = Modifier.padding(start = 30.dp)
    )

    Spacer(modifier = Modifier.height(35.dp))

}

@Composable
fun ForgotPasswordPageToSendLink(modifier: Modifier = Modifier) {

    var email by rememberSaveable { mutableStateOf("") }

    var showMessage by remember { mutableStateOf(false) }

    var message by remember { mutableStateOf("") }

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
            colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
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
                    message = if (success) {
                        "Reset link sent to $email"
                    } else {
                        response ?: "Error occurred, please try again."
                    }
                    showMessage = true
                }
            },
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color(red = 10, green = 16, blue = 69, alpha = 255),

                ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.size(width = 345.dp, height = 45.dp)
        ) {
            Text(
                text = stringResource(id = R.string.send_link),
                color = Color.White,
                fontFamily = displayFontFamily,
                fontSize = 22.sp
            )
        }

    }

    Spacer(modifier = Modifier.height(180.dp))



}


@Composable
fun ForgotPasswordPagrBackButton(modifier: Modifier = Modifier, navController: NavController) {

    TextButton(
        onClick = {
            navController.popBackStack()
        },
        modifier = Modifier.padding(start = 19.dp)
    ) {
        Text(
            text = stringResource(id = R.string.back),
            fontFamily = displayFontFamily,
            fontSize = 15.sp,
            color = Color(red = 10, green = 16, blue = 69, alpha = 255)
        )
    }

}

@Composable
fun MyButton2(text2:String, navController: NavController){
    Button (modifier = Modifier.size(width = 241.dp, height = 40.dp),
        onClick = { navController.navigate("home") },
        colors = androidx.compose.material3.ButtonDefaults.buttonColors(
            containerColor = Color(red = 10, green = 16, blue = 69, alpha = 255),
            contentColor = Color.White
        )) {
        Text(text = text2,
            fontFamily = displayFontFamily,
            fontSize = 22.sp,
            color = Color.White)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTextField(viewModel: EventViewModel){
    var text by remember { mutableStateOf("") }

    var searchQuery by remember { mutableStateOf("") }

    androidx.compose.material.TextField(
        onValueChange = {
            searchQuery = it
        },
        value = searchQuery,
        singleLine = true,
        modifier = Modifier.size(width = 350.dp, height = 50.dp),
        shape = RoundedCornerShape(size = 20.dp),
        colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        ),
        trailingIcon = {
            Icon(painter = painterResource(id = R.drawable.baseline_search_24),
                contentDescription = "Search Button")
        },
        placeholder = {
            androidx.compose.material3.Text(
                text = "Search for events...",
                fontFamily = displayFontFamily,
                fontSize = 12.sp
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),

        keyboardActions = KeyboardActions(onSearch = {
            viewModel.searchEvents(searchQuery)
        })
    )


}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(navController: NavController, selected: MutableState<Int>) {
    TopAppBar(
        title = {
            androidx.compose.material3.Text(
                "Logo",
                fontFamily = displayFontFamily
            )
        },
        actions = {
//
            IconButton(
                onClick = { navController.navigate("notification") },
            ) {
                Icon(
                    modifier = Modifier.size(width = 20.dp, height = 20.dp),
                    painter = painterResource(id = R.drawable.notification_button),
                    contentDescription = "notification button",
                    tint = if (selected.value == R.drawable.notification_button) Color(red = 255, green = 81, blue = 71, alpha = 255) else Color.White
                )

            }
            IconButton(onClick = { navController.navigate("profile") }) {
                Icon(
                    modifier = Modifier.size(width = 20.dp, height = 20.dp),
                    painter = painterResource(id = R.drawable.profile_button),
                    contentDescription = "Profile",
                    tint = if (selected.value == R.drawable.profile_button) Color(red = 255, green = 81, blue = 71, alpha = 255) else Color.Gray
                )

            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(red = 10, green = 16, blue = 69, alpha = 255),
            actionIconContentColor = Color.White,
            titleContentColor = Color.White
        ),
        modifier = Modifier.clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
    )

    }

@Composable
fun HomePageTextField(modifier: Modifier = Modifier, viewModel: EventViewModel) {

    Spacer(modifier = Modifier.height(10.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        HomeTextField(viewModel)

    }
    Spacer(modifier = Modifier.height(20.dp))

    androidx.compose.material3.Text(
        text = stringResource(R.string.my_events),
        fontFamily = displayFontFamily,
        fontSize = 20.sp,
        style = TextStyle(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(start = 30.dp)
    )

}

@Composable
fun HomePageDisplayEvents(modifier: Modifier = Modifier, viewModel: EventViewModel) {

    val events by viewModel.events.collectAsState(initial = emptyList())

    if (events.isEmpty()) {
        androidx.compose.material3.Text(
            text = "No events available",
            modifier = Modifier.fillMaxSize(),
            textAlign = TextAlign.Center
        )
    } else {
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(events) { event ->
                EventCard(event, onDelete = { viewModel.deleteEvent(event) })
            }
        }


    }

}

@Composable
fun MyBottomAppBar(navController: NavController, selected: MutableState<Int>
) {
    var showPopup by remember { mutableStateOf(false) }

    BottomAppBar(
        modifier = Modifier.clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
        containerColor = Color(red = 10, green = 16, blue = 69, alpha = 255),
        contentColor = Color.White
    ) {

        IconButton(
            onClick = {
                selected.value = R.drawable.home_button // change it to png
                navController.navigate("home")
            },
            modifier = Modifier.weight(1f)
        ) {

            Icon(
                painter = painterResource(id = R.drawable.home_button),
                contentDescription = "Home Button",
                modifier = Modifier.size(30.dp),
                tint = if (selected.value == R.drawable.home_button) Color(red = 255, green = 81, blue = 71, alpha = 255) else Color.White
            )
        }

        IconButton(
            onClick = {
                selected.value = R.drawable.map_button
                navController.navigate("map") //change to map
            },
            modifier = Modifier.weight(1f)
        ) {

            Icon(
                painter = painterResource(id = R.drawable.map_button),
                contentDescription = "Event Button",
                modifier = Modifier.size(30.dp),
                tint = if (selected.value == R.drawable.map_button) Color(red = 255, green = 81, blue = 71, alpha = 255) else Color.White
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            FloatingActionButton(
                onClick = {
//                    navController.navigate("event_create")
                    showPopup = true           },
                containerColor = Color(red = 10, green = 16, blue = 69, alpha = 255),
                contentColor = Color.Red
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_add_24),
                    contentDescription = "Add Button"
                )
            }
        }
        if (showPopup) {
            Dialog(onDismissRequest = { showPopup = false }) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    tonalElevation = 8.dp,
                    color = Color(red = 10, green = 16, blue = 69, alpha = 255)
                ) {
                    Column(
                        Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(id = R.string.select_page),
                            fontFamily = displayFontFamily,
                            modifier = Modifier.padding(bottom = 8.dp),
                            color = Color.White
                        )
                        Divider()
                        Text(
                            text = stringResource(R.string.create_event_page),
                            fontFamily = bodyFontFamily,
                            color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .clickable {
                                    showPopup = false
                                    navController.navigate("event_create")
                                },
                            fontSize = 18.sp
                        )
                        Text(
                            text = stringResource(R.string.joint_event_page),
                            fontFamily = bodyFontFamily,
                            color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .clickable {
                                    showPopup = false
                                    navController.navigate("event_join")
                                },
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
        IconButton(
            onClick = {
                selected.value = R.drawable.chat_button
                navController.navigate("chat")
            },
            modifier = Modifier.weight(1f)
        ) {

            Icon(
                painter = painterResource(id = R.drawable.chat_button),
                contentDescription = "Chat Button",
                modifier = Modifier.size(30.dp),
                tint = if (selected.value == R.drawable.chat_button) Color(red = 255, green = 81, blue = 71, alpha = 255) else Color.White
            )
        }



        IconButton(
            onClick = {
                selected.value = R.drawable.settings_button
                navController.navigate("settings")
            },
            modifier = Modifier.weight(1f)
        ) {

            Icon(
                painter = painterResource(id = R.drawable.settings_button),
                contentDescription = "Settings Button",
                modifier = Modifier.size(30.dp),
                tint = if (selected.value == R.drawable.settings_button) Color(red = 255, green = 81, blue = 71, alpha = 255) else Color.White
            )
        }
    }
}


@Composable
fun CreateEventPageImageUpload(modifier: Modifier = Modifier) {
    var eventImage by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        eventImage = uri
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Card(
            modifier = Modifier
                .size(200.dp)
                .fillMaxWidth()
                .aspectRatio(1f)
                .clickable {
                    // Trigger the image picker when the card is clicked
                    launcher.launch("image/*")
                },
            shape = RoundedCornerShape(16.dp),
            elevation = 4.dp,
        ) {
            eventImage?.let {
                Image(
                    painter = rememberAsyncImagePainter(model = it),
                    contentDescription = "Event Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun CreateEvent(modifier: Modifier = Modifier, navController: NavController, viewModel: EventViewModel) {

    var eventName by remember { mutableStateOf("") }
    var eventDetails by remember { mutableStateOf("") }
    var eventDate by remember { mutableStateOf("") }
    val context = LocalContext.current

    val calendar = Calendar.getInstance()
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            eventDate = "$dayOfMonth/${month + 1}/$year" // Format the date
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    var eventImage by remember { mutableStateOf<Uri?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        eventImage = uri
    }

    androidx.compose.material3.Text(
        text = stringResource(R.string.create_event),
        fontFamily = displayFontFamily,
        fontSize = 25.sp,
        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 30.dp)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Card(
            modifier = Modifier
                .size(200.dp)
                .fillMaxWidth()
                .aspectRatio(1f)
                .clickable {
                    // Trigger the image picker when the card is clicked
                    launcher.launch("image/*")
                },
            shape = RoundedCornerShape(16.dp),
            elevation = 4.dp,
        ) {
            eventImage?.let {
                Image(
                    painter = rememberAsyncImagePainter(model = it),
                    contentDescription = "Event Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }


    androidx.compose.material.TextField(
        modifier = Modifier
            .padding(16.dp),
        colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(20.dp),
        value = eventName,
        onValueChange = { eventName = it },
        placeholder = {
            androidx.compose.material3.Text(
                text = stringResource(id = R.string.event_name),
                color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                fontWeight = FontWeight.SemiBold
            )
        },
    )
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material.TextField(
            modifier = Modifier
                .padding(16.dp),
            colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,

                ),
            shape = RoundedCornerShape(20.dp),
            value = eventDate,
            onValueChange = { eventDate = it },
            placeholder = {
                androidx.compose.material3.Text(
                    text = stringResource(id = R.string.event_date),
                    color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                    fontWeight = FontWeight.SemiBold
                )
            },
            enabled = false
        )
        IconButton(onClick = { datePickerDialog.show() }) {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.fe_calendar),
                contentDescription = "Select Date"
            )
        }
    }


    androidx.compose.material.TextField(
        modifier = Modifier
            .padding(16.dp),
        colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,

            ),
        shape = RoundedCornerShape(20.dp),
        value = eventDetails,
        onValueChange = { eventDetails = it },
        placeholder = {
            androidx.compose.material3.Text(
                text = stringResource(id = R.string.event_details),
                color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                fontWeight = FontWeight.SemiBold
            )
        },
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        Button(
            onClick = {
                val event = Event(
                    eventName = eventName,
                    eventDetails = eventDetails,
                    eventDate = eventDate,
                    eventImage = eventImage?.toString(), // Save URI as a string

                )
                viewModel.addEvent(event)
                navController.navigate("home")

            },
            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                containerColor = Color(red = 255, green = 60, blue = 49, alpha = 255)
            )
        ) {
            androidx.compose.material3.Text(
                text = "Create",
                fontFamily = displayFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        }
    }

}


@Composable
fun JoinEventPageFilters(modifier: Modifier = Modifier, viewModel: EventViewModel) {

    val events by viewModel.events.collectAsState()
    val showOnlyLiked by viewModel.showOnlyLiked.collectAsState()
    var searchQuery by remember { mutableStateOf("") }




    val showFilterDialog = remember { mutableStateOf(false) }

    val selected = remember {
        mutableIntStateOf(R.drawable.baseline_add_24)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
    ) {
        HomeTextField(viewModel)
    }
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp), // Space between the buttons
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .size(width = 100.dp, height = 20.dp)
            .padding(start = 20.dp)
    ) {

        IconButton(
            onClick = {
                selected.value = R.drawable.filter
                showFilterDialog.value = true
            },
            modifier = Modifier.weight(1f)
        ) {

            Icon(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Filter Button",
                modifier = Modifier.size(30.dp),
                tint = if (selected.value == R.drawable.filter) Color.Red else Color.Blue
            )

        }

        IconButton(
            onClick = {
                selected.value = R.drawable.liked_event
                viewModel.toggleShowOnlyLiked()
            },
            modifier = Modifier.weight(1f)
        ) {

            Icon(
                painter = painterResource(id = R.drawable.liked_event),
                contentDescription = "Liked Events Button",
                modifier = Modifier.size(30.dp),
                tint = if (selected.value == R.drawable.liked_event) Color.Red else Color.Blue
            )
        }
// LazyColumn for displaying filtered events


    }

    if (events.isEmpty()) {
        androidx.compose.material3.Text(
            text = "No events available to join",
            textAlign = TextAlign.Center
        )
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(events) { event ->
                JoinEventCard(event, onLikeClicked = { viewModel.toggleLike(event) })
            }
        }

    }
    if (showFilterDialog.value) {
        FilterDialog(
            onDismiss = { showFilterDialog.value = false },
            onFilterByName = {
                viewModel.filterByName()
                showFilterDialog.value = false
            },
            onFilterByDate = {
                viewModel.filterByDate()
                showFilterDialog.value = false
            }
        )
    }


}

@Composable
fun SaveProfileChanges(modifier: Modifier = Modifier, profileViewModel: UserProfileViewModel) {

    val context = LocalContext.current // Get the context here

    val profile by profileViewModel.profile.collectAsState()
    var fullName by remember { mutableStateOf(profile?.fullName ?: "") }
    var yearOfStudy by remember { mutableStateOf(profile?.yearOfStudy ?: "") }
    var department by remember { mutableStateOf(profile?.department ?: "") }
    var interests by remember { mutableStateOf(profile?.interests ?: "") }
    var profilePictureUri by remember { mutableStateOf(profile?.profilePictureUri) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        profilePictureUri = uri.toString()
    }

    val selected = remember {
        mutableIntStateOf(R.drawable.profile_button)
    }

    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween, // Space between image and text field


    ) {
        //profile picture picker from gallery
        if (profilePictureUri != null) {        // show the profile picture
            Image(
                painter = rememberAsyncImagePainter(profilePictureUri),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(150.dp) // Circle size
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape) // border
                    .clickable {
                        launcher.launch("image/*") // image picker
                    },
                contentScale = ContentScale.Crop
            )
        } else {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
                    .clickable {
                        launcher.launch("image/*")
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.edit_profile),
                    contentDescription = "edit profile"
                )
            }
        }
        androidx.compose.material.TextField(
            modifier = Modifier
                .weight(1f),
            value = fullName,
            onValueChange = {
                fullName = it
            },
            colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(20.dp),
            placeholder = { Text(stringResource(id = R.string.profile_name)) }

        )
    }
    Spacer(modifier = Modifier.height(16.dp))




    Spacer(modifier = Modifier.height(8.dp))

    androidx.compose.material.TextField(
        modifier = Modifier
            .padding(16.dp),
        colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(20.dp),
        value = yearOfStudy,
        onValueChange = { yearOfStudy = it },
        placeholder = {
            androidx.compose.material3.Text(
                text = stringResource(id = R.string.year),
                color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                fontWeight = FontWeight.SemiBold
            )
        },
    )

    Spacer(modifier = Modifier.height(8.dp))

    androidx.compose.material.TextField(
        modifier = Modifier
            .padding(16.dp),
        colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(20.dp),
        value = department,
        onValueChange = { department = it },
        placeholder = {
            androidx.compose.material3.Text(
                text = stringResource(id = R.string.department),
                color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                fontWeight = FontWeight.SemiBold
            )
        },
    )

    Spacer(modifier = Modifier.height(8.dp))

    androidx.compose.material.TextField(
        modifier = Modifier
            .padding(16.dp),
        colors = androidx.compose.material.TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(20.dp),
        value = interests,
        onValueChange = { interests = it },
        placeholder = {
            androidx.compose.material3.Text(
                text = stringResource(id = R.string.interests),
                color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                fontWeight = FontWeight.SemiBold
            )
        },
    )

    Spacer(modifier = Modifier.height(16.dp))

    androidx.compose.material.Button(
        onClick = {
            val updatedProfile = UserProfile(
                profilePictureUri = profilePictureUri,
                fullName = fullName,
                yearOfStudy = yearOfStudy,
                department = department,
                interests = interests
            )
            profileViewModel.updateUserProfile(updatedProfile)
            Toast.makeText(context, "Your changes are saved!", Toast.LENGTH_SHORT).show()


        },
        colors = androidx.compose.material.ButtonDefaults.buttonColors(
            backgroundColor = Color(red = 10, green = 16, blue = 69, alpha = 255),
            contentColor = Color.White
        )
    ) {
        Text(stringResource(id = R.string.save_profile), color = Color.White)
    }

}

@Composable
fun EventCard(event: Event, onDelete: () -> Unit) {
    Card(
        modifier = Modifier.size(300.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Box {
            event.eventImage?.let { uri ->
                Image(
                    painter = rememberAsyncImagePainter(model = uri),
                    contentDescription = "Event Background",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
//                background(Color.Black.copy(alpha = 0.0f)),
,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = event.eventName, style = MaterialTheme.typography.headlineMedium, color = Color.White, fontWeight = FontWeight.Bold, fontFamily = displayFontFamily)
                Text(text = event.eventDetails, style = MaterialTheme.typography.bodyMedium, color = Color.White, fontWeight = FontWeight.Bold, fontFamily = displayFontFamily)
                Text(text = "Date: ${event.eventDate}", style = MaterialTheme.typography.bodySmall, color = Color.White, fontWeight = FontWeight.Bold, fontFamily = displayFontFamily)
                IconButton(onClick = onDelete, modifier = Modifier.align(Alignment.End)) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "delete button")
                }
            }

        }
    }
}

@Composable
fun JoinEventCard(event: Event, onLikeClicked: () -> Unit) {
    val context = LocalContext.current // Get the context here

    Card(
        modifier = Modifier
            .size(300.dp)
            .padding(8.dp), //new added
        elevation = 4.dp,
        shape = RoundedCornerShape(10.dp)
    ) {

            Box {
                event.eventImage?.let { uri ->
                    Image(
                        painter = rememberAsyncImagePainter(model = uri),
                        contentDescription = "Event Background",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
//                    .background(Color.Black.copy(alpha = 0.6f)),
                    ,verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = event.eventName, style = MaterialTheme.typography.headlineMedium, color = Color.White, fontWeight = FontWeight.Bold, fontFamily = displayFontFamily)
                    Text(text = event.eventDetails, style = MaterialTheme.typography.bodyMedium, color = Color.White, fontWeight = FontWeight.Bold, fontFamily = displayFontFamily)
                    Text(text = "Date: ${event.eventDate}", style = MaterialTheme.typography.bodySmall, color = Color.White, fontWeight = FontWeight.Bold, fontFamily = displayFontFamily)
                    Button(onClick = {
                        // Logic for joining event
                        Toast.makeText(context, "You joined the event: ${event.eventName}", Toast.LENGTH_SHORT).show()
                    }) {
                        Text("Join")
                    }
                    // Like button
                    IconButton(onClick = onLikeClicked) {
                        Icon(
                            imageVector = if (event.isLiked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Like Event"
                        )
                    }

                }

            }
        }
    }

@Composable
fun FilterDialog(
    onDismiss: () -> Unit,
    onFilterByName: () -> Unit,
    onFilterByDate: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = "Filter Events",
            color = Color.Red,
            fontFamily = displayFontFamily)
             },
        text = {
            Column {
                TextButton(onClick = onFilterByName) {
                    Text(text = "Sort by Name",
                        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                        fontFamily = bodyFontFamily)
                }
                TextButton(onClick = onFilterByDate) {
                    Text(text = "Sort by Date",
                        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                        fontFamily = bodyFontFamily)
                }
            }
        },
        confirmButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("Close",
                    color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                    fontFamily = bodyFontFamily)
            }
        }
    )
}




