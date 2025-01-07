package com.altaygunbatan.uni_verse.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapPage(navController: NavController) {
    val selectedItem = remember { mutableStateOf("map") }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Logo",
                        fontFamily = displayFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "Notifications",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Person",
                            tint = Color.White
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF061A40))
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFF061A40)) {
                NavigationBarItem(
                    selected = selectedItem.value == "home",
                    onClick = { selectedItem.value = "home" },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home",
                            tint = Color.White
                        )
                    },
                    label = {
                        Text(
                            text = "Home",
                            color = Color.White,
                            fontSize = 10.sp
                        )
                    }
                )
                NavigationBarItem(
                    selected = selectedItem.value == "map",
                    onClick = { selectedItem.value = "map" },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Map,
                            contentDescription = "Map",
                            tint = Color.White
                        )
                    },
                    label = {
                        Text(
                            text = "Map",
                            color = Color.White,
                            fontSize = 10.sp
                        )
                    }
                )
                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add",
                            tint = Color.White
                        )
                    },
                    label = { Text("") }
                )
                NavigationBarItem(
                    selected = selectedItem.value == "chat",
                    onClick = { selectedItem.value = "chat" },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Chat,
                            contentDescription = "Chat",
                            tint = Color.White
                        )
                    },
                    label = {
                        Text(
                            text = "Chat",
                            color = Color.White,
                            fontSize = 10.sp
                        )
                    }
                )
                NavigationBarItem(
                    selected = selectedItem.value == "settings",
                    onClick = { selectedItem.value = "settings" },
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Settings",
                            tint = Color.White
                        )
                    },
                    label = {
                        Text(
                            text = "Settings",
                            color = Color.White,
                            fontSize = 10.sp
                        )
                    }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(LatLng(40.975, 29.08), 13f)
            }
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMapPage() {
    MapPage(navController = rememberNavController())
}
