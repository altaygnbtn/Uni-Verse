

package com.altaygunbatan.uni_verse.ui

import android.app.Application
import android.app.DatePickerDialog
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.altaygunbatan.uni_verse.R
import com.altaygunbatan.uni_verse.dataClasses.Event
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily
import com.altaygunbatan.uni_verse.viewModels.EventViewModel
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateEventPage(
    navController: NavController,
    viewModel: EventViewModel) {

    var name by remember { mutableStateOf("") }
    var details by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        imageUri = uri
    }

    // DatePickerDialog
    val calendar = Calendar.getInstance()
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            date = "$dayOfMonth/${month + 1}/$year" // Format the date
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    val selected = remember {
        mutableIntStateOf(R.drawable.baseline_add_24)
    }

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MyTopAppBar(navController, selected)
        },
        bottomBar = {
            MyBottomAppBar(navController, selected)
        }

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = Color(red = 255, green = 250, blue = 241)),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            Text(
                text = "Create Event",
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
                    imageUri?.let {
                        Image(
                            painter = rememberAsyncImagePainter(model = it),
                            contentDescription = "Event Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(top = 16.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }

            TextField(
                modifier = Modifier
                    .padding(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp),
                value = name,
                onValueChange = { name = it },
                placeholder = {
                    Text(
                        text = "Event Name",
                        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                        fontWeight = FontWeight.SemiBold
                    )
                },
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    modifier = Modifier
                        .padding(16.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(20.dp),
                    value = date,
                    onValueChange = { date = it },
                    placeholder = {
                        Text(
                            text = "Event Date",
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

            TextField(
                modifier = Modifier
                    .padding(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp),
                value = details,
                onValueChange = { details = it },
                placeholder = {
                    Text(
                        text = "Event Details",
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
                            name = name,
                            details = details,
                            date = date,
                            imageUri = imageUri?.toString() // Save URI as a string
                        )
                        viewModel.addEvent(event)
                        navController.navigate("home")

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(red = 255, green = 60, blue = 49, alpha = 255)
                    )
                ) {
                    Text(
                        text = "Create",
                        fontFamily = displayFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp
                    )
                }
            }

        }
    }


}






@Preview
@Composable
fun CreateEventPageReview(modifier: Modifier = Modifier) {

    CreateEventPage(navController = rememberNavController(), viewModel = EventViewModel(application = Application()))

}