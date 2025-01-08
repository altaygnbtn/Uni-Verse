package com.altaygunbatan.uni_verse.ui


import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.altaygunbatan.uni_verse.R
import com.altaygunbatan.uni_verse.dataClasses.UserProfile
import com.altaygunbatan.uni_verse.viewModels.UserProfileViewModel


@Composable
fun ProfilePage(profileViewModel: UserProfileViewModel, navController: NavController) {
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

    Scaffold(
        topBar = {
            MyTopAppBar(navController, selected)
        },
        bottomBar = {
            MyBottomAppBar(navController, selected)
        }

    ) { innerPadding ->



        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color(red = 242, green = 244, blue = 243))
                .wrapContentSize(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )

        {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween, // Space between image and text field


            ) {

                if (profilePictureUri != null) {
                    Image(
                        painter = rememberAsyncImagePainter(profilePictureUri),
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(150.dp) // Circle size
                            .clip(CircleShape) // Clip the image to circle
                            .border(2.dp, Color.Gray, CircleShape) // Optional border
                            .clickable {
                                launcher.launch("image/*") // Open image picker
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
                                launcher.launch("image/*") // Open image picker
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.edit_profile),
                            contentDescription = "edit profile"
                        )
                    }
                }
                TextField(
                    modifier = Modifier
                        .weight(1f),
                    value = fullName,
                    onValueChange = {
                        fullName = it
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(20.dp),
                    placeholder = { Text("Your Name") }

                )
            }
            Spacer(modifier = Modifier.height(16.dp))




                Spacer(modifier = Modifier.height(8.dp))

            TextField(
                modifier = Modifier
                    .padding(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(20.dp),
                value = yearOfStudy,
                onValueChange = { yearOfStudy = it },
                placeholder = {
                    androidx.compose.material3.Text(
                        text = "Year of Study",
                        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                        fontWeight = FontWeight.SemiBold
                    )
                },
            )

                Spacer(modifier = Modifier.height(8.dp))

            TextField(
                modifier = Modifier
                    .padding(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(20.dp),
                value = department,
                onValueChange = { department = it },
                placeholder = {
                    androidx.compose.material3.Text(
                        text = "Department",
                        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                        fontWeight = FontWeight.SemiBold
                    )
                },
            )

                Spacer(modifier = Modifier.height(8.dp))

            TextField(
                modifier = Modifier
                    .padding(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(20.dp),
                value = interests,
                onValueChange = { interests = it },
                placeholder = {
                    androidx.compose.material3.Text(
                        text = "Interests",
                        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                        fontWeight = FontWeight.SemiBold
                    )
                },
            )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    val updatedProfile = UserProfile(
                        profilePictureUri = profilePictureUri,
                        fullName = fullName,
                        yearOfStudy = yearOfStudy,
                        department = department,
                        interests = interests
                    )
                    profileViewModel.updateUserProfile(updatedProfile)
                    Toast.makeText(context, "Your changes are saved", Toast.LENGTH_SHORT).show()


                },
                    colors = androidx.compose.material.ButtonDefaults.buttonColors(
                        backgroundColor = Color(red = 10, green = 16, blue = 69, alpha = 255),
                        contentColor = Color.White
                    )
                ) {
                    Text("Save Profile", color = Color.White)
                }

        }
    }
}

