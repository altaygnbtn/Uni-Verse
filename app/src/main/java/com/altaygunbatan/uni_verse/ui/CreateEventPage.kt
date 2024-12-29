@file:Suppress("UNREACHABLE_CODE")

package com.altaygunbatan.uni_verse.ui

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.altaygunbatan.uni_verse.R
import com.altaygunbatan.uni_verse.database.EventActions
import com.altaygunbatan.uni_verse.database.EventState
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateEventPage(
    navController: NavController,
    state: EventState,
    onEvent: (EventActions) -> Unit) {


    val selected = remember {
        mutableStateOf(R.drawable.baseline_add_24)
    }

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold( modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MyTopAppBar(navController,selected)
        },
        bottomBar = {
            MyBottomAppBar(navController, selected, state)
        }

    ){ paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = Color(red = 255, green = 250, blue = 241)),
            verticalArrangement = Arrangement.spacedBy(16.dp)
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
                ImageUploadCard()
            }

            TextField(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp),
                value = state.name.value,
                onValueChange = { state.name.value = it },
                placeholder = {
                    Text(text = "Event Name",
                        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                        fontWeight = FontWeight.SemiBold)
                },
            )

            TextField(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp),
                value = state.date.value,
                onValueChange = { state.date.value = it },
                placeholder = {
                    Text(text = "Event Date",
                        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                        fontWeight = FontWeight.SemiBold)
                },
            )

            TextField(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(20.dp),
                value = state.details.value,
                onValueChange = { state.details.value = it },
                placeholder = {
                    Text(text = "Event Details",
                        color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                        fontWeight = FontWeight.SemiBold)
                },
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            ){
            Button(onClick = {
                onEvent(EventActions.SaveEvents(
                    name = state.name.value,
                    date = state.date.value,
                    details = state.details.value,

                ))

            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(red = 255, green = 60, blue = 49, alpha = 255))
                ) {
                Text(text = "Create",
                    fontFamily = displayFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp)
            }
            }

        }
    }




}



@Preview
@Composable
fun CreateEventPageReview(modifier: Modifier = Modifier) {
    CreateEventPage(navController = rememberNavController(), state = EventState(), onEvent = {})

}