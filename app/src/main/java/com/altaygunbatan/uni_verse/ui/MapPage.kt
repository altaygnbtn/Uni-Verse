package com.altaygunbatan.uni_verse.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.altaygunbatan.uni_verse.R
import com.altaygunbatan.uni_verse.viewModels.EventViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PinConfig
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapPage(navController: NavController, viewModel: EventViewModel
) {
    val selected = remember {
        mutableIntStateOf(R.drawable.map_button)
    }

    val events by viewModel.events.collectAsState()


    val yeditepePosition = LatLng(40.972199819701856, 29.1521527716205 )  //40.972199819701856, 29.1521527716205
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(yeditepePosition, 17f)
    }
    val mapProperties = MapProperties(
        maxZoomPreference = 19f,
        minZoomPreference = 14f
    )

    Scaffold(
        topBar = {
            MyTopAppBar(navController, selected, viewModel)
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
        ) {




                GoogleMap(cameraPositionState = cameraPositionState,
                    properties = mapProperties) {



                            AdvancedMarker(
                                state = MarkerState(position = LatLng(40.972199819701856, 29.1521527716205 )),
                                title = "Marker in Color Fest Yeditepe",

                            )

                        }
                    }
                }
            }







