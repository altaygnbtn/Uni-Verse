package com.altaygunbatan.uni_verse.ui

import android.net.Uri

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.shape.RoundedCornerShape

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Card
import androidx.compose.material.Divider

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

import androidx.navigation.NavController

import coil.compose.rememberAsyncImagePainter
import com.altaygunbatan.uni_verse.R
import com.altaygunbatan.uni_verse.dataClasses.Event
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily

import com.google.firebase.auth.FirebaseAuth


@Composable
fun EmailTextField() {

        var email by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier.size(width = 345.dp, height = 47.dp),
        value =email,
        onValueChange = {
            email = it
        },

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
fun HomeTextField(){
    var text by remember { mutableStateOf("") }
    TextField(
        onValueChange = {
            text = it
        },
        value = text,
        modifier = Modifier.size(width = 350.dp, height = 50.dp),
        shape = RoundedCornerShape(size = 20.dp),
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,

            containerColor = Color.White
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
        }
    )
}

fun signUpWithEmailAndPassword(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
    val auth = FirebaseAuth.getInstance()
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onResult(true, null)
            } else {
                onResult(false, task.exception?.message)
            }
        }
}

fun signInWithEmailAndPassword(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
    val auth = FirebaseAuth.getInstance()
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onResult(true, null)
            } else {
                onResult(false, task.exception?.message)
            }
        }
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
                    tint = if (selected.value == R.drawable.notification_button) Color.White else Color.Gray
                )

            }
            IconButton(onClick = { navController.navigate("profile") }) {
                Icon(
                    modifier = Modifier.size(width = 20.dp, height = 20.dp),
                    painter = painterResource(id = R.drawable.profile_button),
                    contentDescription = "Profile",
                    tint = if (selected.value == R.drawable.profile_button) Color.White else Color.Gray
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
                tint = if (selected.value == R.drawable.home_button) Color.White else Color.Gray
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
                tint = if (selected.value == R.drawable.map_button) Color.White else Color.Gray
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
                            text = "Please select a page to go",
                            style = MaterialTheme.typography.headlineSmall,
                            modifier = Modifier.padding(bottom = 8.dp),
                            color = Color.White
                        )
                        Divider()
                        Text(
                            text = "Create Event",
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
                            text = "Join Event",
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
                tint = if (selected.value == R.drawable.chat_button) Color.White else Color.Gray
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
                tint = if (selected.value == R.drawable.settings_button) Color.White else Color.Gray
            )
        }
    }
}


@Composable
fun ImageUploadCard() {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current

    // Launcher to pick an image

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        imageUri = uri
    }

    Card(
        modifier = Modifier
            .size(150.dp)
            .clickable {
                // Trigger the image picker when the card is clicked
                launcher.launch("image/*")
            },
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp
    ) {
        imageUri?.let {
            Image(
                painter = rememberAsyncImagePainter(model = it),
                contentDescription = "Event Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(top = 16.dp)
            )
        }
        }
    }


@Composable
fun EventCard(event: Event, onDelete: () -> Unit) {
    Card(
        modifier = Modifier.size(300.dp),
        elevation = 4.dp
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
                modifier = Modifier.padding(16.dp).
                background(Color.Black.copy(alpha = 0.6f)),

                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = event.eventName, style = MaterialTheme.typography.headlineMedium, color = Color.White)
                Text(text = event.eventDetails, style = MaterialTheme.typography.bodyMedium, color = Color.White)
                Text(text = "Date: ${event.eventDate}", style = MaterialTheme.typography.bodySmall, color = Color.White)
                IconButton(onClick = onDelete, modifier = Modifier.align(Alignment.End)) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "delete button")
                }
            }

        }
    }
}