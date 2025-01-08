package com.altaygunbatan.uni_verse.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.altaygunbatan.uni_verse.R
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapPage(navController: NavController,
) {
    val selected = remember {
        mutableIntStateOf(R.drawable.map_button)
    }

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
                .background(color = Color(red = 255, green = 250, blue = 241))) {

                    GoogleMap(
                        cameraPositionState = cameraPositionState,
                        properties = mapProperties
                    ) {

                    }
                }
    }
}

@Preview
@Composable
fun MapPagePreview(modifier: Modifier = Modifier) {

    MapPage(rememberNavController())
}





