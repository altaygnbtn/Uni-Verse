package com.altaygunbatan.uni_verse.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.altaygunbatan.uni_verse.R
import com.altaygunbatan.uni_verse.ui.theme.bodyFontFamily
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily
import com.altaygunbatan.uni_verse.viewModels.EventViewModel

@Composable
fun SettingsPage(navController: NavController, viewModel: EventViewModel) {


    val selected = remember {
        mutableIntStateOf(R.drawable.settings_button)
    }

    Scaffold(
        topBar = {
            MyTopAppBar(navController,selected, viewModel)
        },
        bottomBar = {
            MyBottomAppBar(navController, selected)
        }

    ) { paddingValues ->

        // Main content (scrollable if needed)
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(color = Color(red = 242, green = 244, blue = 243))
                .fillMaxSize()
        ) {
            SettingsSectionHeader(title = "General")
            Spacer(modifier = Modifier.height(8.dp))
            SettingsListItem(label = "Language Options")
            SettingsListItem(label = "E-mail Updates")
            SettingsListItem(label = "Distance Units")
            SettingsListItem(label = "Theme Options")

            Spacer(modifier = Modifier.height(24.dp))


            SettingsSectionHeader(title = "Apps")
            Spacer(modifier = Modifier.height(8.dp))
            SettingsListItem(label = "Widget")
            SettingsListItem(label = "Share")
            SettingsListItem(label = "Rate")

            Spacer(modifier = Modifier.height(24.dp))

            SettingsSectionHeader(title = "Help & Support")
            Spacer(modifier = Modifier.height(8.dp))
            SettingsListItem(label = "FAQ")
            SettingsListItem(label = "Contact Support")
            SettingsListItem(label = "Live Support")
        }


    }
}


@Composable
fun SettingsSectionHeader(title: String) {
    Text(
        text = title,
        fontFamily = displayFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        color = Color(0xFFFF3C31), // Same red used in your screenshot
        modifier = Modifier
            .padding(horizontal = 16.dp)
    )
}

@Composable
fun SettingsListItem(label: String) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFD9D9F3).copy(alpha = 0.8f)), // pick a light grayish/purple
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Bullet (you can just prepend '•' to the text if you prefer)
        Text(
            text = "•",
            fontFamily = bodyFontFamily,
            fontSize = 18.sp,
            color = Color(0xFF0A1045), // navy text
            modifier = Modifier.padding(start = 16.dp, end = 8.dp)
        )


        // Item label
        Text(
            text = label,
            fontFamily = bodyFontFamily,
            fontSize = 18.sp,
            color = Color(0xFF0A1045),
        )
    }
}