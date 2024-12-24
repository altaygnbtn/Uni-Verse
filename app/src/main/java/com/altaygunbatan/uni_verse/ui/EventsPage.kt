package com.altaygunbatan.uni_verse.ui

import android.provider.CalendarContract.Events
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.altaygunbatan.uni_verse.R
import com.altaygunbatan.uni_verse.dataClasses.Event
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily
import com.altaygunbatan.uni_verse.viewModels.EventViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventsPage(navController: NavController,
               events: List<Event>,
               onAddEvent: (Event) -> Unit,
               onEditEvent: (Event) -> Unit,
               onDeleteEvent: (Event) -> Unit) {

    var showDialog by remember { mutableStateOf(false) }
    var selectedEvent by remember { mutableStateOf<Event?>(null) }

    val context = LocalContext.current.applicationContext

    val selected = remember {
        mutableStateOf(R.drawable.baseline_event_24)
    }

    var text by remember { mutableStateOf("") }

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add Event")
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Logo",
                        fontFamily = displayFontFamily
                    )
                },
                actions = {
                    IconButton(
                        onClick = { navController.navigate("notification") },
                    ) {
                        Icon(

                            painter = painterResource(id = R.drawable.baseline_notifications_24),
                            contentDescription = "notification",
                            tint = if (selected.value == R.drawable.baseline_notifications_24) Color.White else Color.Gray
                        )

                    }
                    IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "Profile",
                            tint = if (selected.value == R.drawable.baseline_notifications_24) Color.White else Color.Gray
                        )

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(red = 40, green = 84, blue = 100, alpha = 255),
                    actionIconContentColor = Color.White,
                    titleContentColor = Color.White
                ),
                modifier = Modifier.clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                containerColor = Color(red = 40, green = 84, blue = 100, alpha = 255),
                contentColor = Color.White
            ) {

                IconButton(
                    onClick = {
                        selected.value = R.drawable.baseline_home_24
                        navController.navigate("home")
                    },
                    modifier = Modifier.weight(1f)
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_home_24),
                        contentDescription = "Home Button",
                        modifier = Modifier.size(height = 31.dp, width = 24.dp),
                        tint = if (selected.value == R.drawable.baseline_home_24) Color.White else Color.Gray
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = R.drawable.baseline_event_24
                        navController.navigate("events")
                    },
                    modifier = Modifier.weight(1f)
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_event_24),
                        contentDescription = "Event Button",
                        modifier = Modifier.size(height = 31.dp, width = 24.dp),
                        tint = if (selected.value == R.drawable.baseline_event_24) Color.White else Color.Gray
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    FloatingActionButton(
                        onClick = {},
                        containerColor = Color(red = 40, green = 84, blue = 100, alpha = 255),
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Add Button")
                    }
                }

                IconButton(
                    onClick = {
                        selected.value = R.drawable.baseline_chat_24
                        navController.navigate("chat")
                    },
                    modifier = Modifier.weight(1f)
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_chat_24),
                        contentDescription = "Chat Button",
                        modifier = Modifier.size(height = 31.dp, width = 24.dp),
                        tint = if (selected.value == R.drawable.baseline_chat_24) Color.White else Color.Gray
                    )
                }



                IconButton(
                    onClick = {
                        selected.value = R.drawable.baseline_settings_24
                        navController.navigate("settings")
                    },
                    modifier = Modifier.weight(1f)
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_settings_24),
                        contentDescription = "Settings Button",
                        modifier = Modifier.size(height = 31.dp, width = 24.dp),
                        tint = if (selected.value == R.drawable.baseline_settings_24) Color.White else Color.Gray
                    )
                }
            }
        }

    ) { innerPadding ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color(red = 255, green = 250, blue = 241)),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn {
                items(events) { event ->
                    EventItem(
                        event = event,
                        onEdit = { selectedEvent = it; showDialog = true },
                        onDelete = { onDeleteEvent(it) }
                    )
                }


            }

        }

    }
    if (showDialog) {
        EventDialog(
            event = selectedEvent,
            onDismiss = { showDialog = false; selectedEvent = null },
            onSave = {
                if (selectedEvent == null) {
                    onAddEvent(it)
                } else {
                    onEditEvent(it)
                }
                showDialog = false
                selectedEvent = null
            }
        )
    }
}


@Composable
fun EventPageWithViewModel(viewModel: EventViewModel = viewModel()) {
    EventsPage(
        events = viewModel.events,
        onAddEvent = { viewModel.addEvent(it) },
        onEditEvent = { viewModel.editEvent(it) },
        onDeleteEvent = { viewModel.deleteEvent(it) },
        navController = rememberNavController()
    )
    
}



@Preview
@Composable
fun PreviewEventsPage() {
    EventsPage(navController = rememberNavController(), events = emptyList(), onAddEvent = {}, onEditEvent = {}, onDeleteEvent = {})
}


