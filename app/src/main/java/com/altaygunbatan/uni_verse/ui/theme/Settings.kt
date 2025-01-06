package com.altaygunbatan.uni_verse.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Settings : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PageScreen()
        }
    }
}

@Composable
fun PageScreen() {
    Box(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .size(width = 412.dp, height = 130.dp)
                .offset(y = (-58).dp)
                .border(width = 3.dp, color = Color.White)
                .background(Color(0xFF0A1045))
        ) {
            Text(
                text = "Logo",
                color = Color(0xFFF2F4F3),
                fontFamily = FontFamily.Default,
                fontSize = 21.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 25.2.sp,
                modifier = Modifier.offset(x = 23.dp, y = 23.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.notification_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 23.dp, height = 26.dp)
                    .offset(x = 306.dp, y = 21.dp),
                colorFilter = ColorFilter.tint(Color(0xFFF2F4F3))
            )
            Image(
                painter = painterResource(id = R.drawable.person_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 21.dp, height = 24.dp)
                    .offset(x = 361.dp, y = 23.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
        Box(
            Modifier
                .size(width = 381.dp, height = 44.dp)
                .offset(x = 19.dp, y = 103.dp)
                .border(width = 2.dp, color = Color(0xFF0A1045), shape = RoundedCornerShape(topStart = 50.dp))
                .clip(RoundedCornerShape(topStart = 50.dp))
        ) {
            Text(
                text = "Search for events...",
                color = Color(0x0A10455E),
                fontFamily = FontFamily.Default,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 19.2.sp,
                modifier = Modifier.offset(x = 23.dp, y = 10.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.search_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 25.dp, height = 25.dp)
                    .offset(x = 356.dp, y = (-4).dp),
                colorFilter = ColorFilter.tint(Color(0xFF0A1045))
            )
        }
        Image(
            painter = painterResource(id = R.drawable.filter_symbol),
            contentDescription = null,
            modifier = Modifier
                .size(width = 25.dp, height = 25.dp)
                .offset(x = 29.dp, y = 153.dp),
            colorFilter = ColorFilter.tint(Color(0x0A1045B2))
        )
        Image(
            painter = painterResource(id = R.drawable.heart_symbol),
            contentDescription = null,
            modifier = Modifier
                .size(width = 27.dp, height = 27.dp)
                .offset(x = 69.dp, y = 152.dp),
            colorFilter = ColorFilter.tint(Color(0x0A1045B2))
        )
        Box(
            Modifier
                .size(width = 412.dp, height = 113.dp)
                .offset(y = 821.dp)
                .background(Color(0xFF0A1045))
        ) {
            Image(
                painter = painterResource(id = R.drawable.house_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 41.dp, height = 32.dp)
                    .offset(x = 24.dp, y = 33.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Image(
                painter = painterResource(id = R.drawable.map_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 36.dp, height = 32.dp)
                    .offset(x = 106.dp, y = 32.dp),
                colorFilter = ColorFilter.tint(Color(0xFFF2F4F3))
            )
            Box(
                Modifier
                    .size(64.dp)
                    .offset(x = 174.dp, y = 24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plus_symbol),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    colorFilter = ColorFilter.tint(Color(0xFFF2F4F3))
                )
            }
            Image(
                painter = painterResource(id = R.drawable.chat_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 21.33.dp, height = 21.44.dp)
                    .offset(x = 240.dp, y = 36.dp),
                colorFilter = ColorFilter.tint(Color(0xFFF2F4F3))
            )
            Image(
                painter = painterResource(id = R.drawable.settings_symbol),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 31.dp, height = 32.dp)
                    .offset(x = 347.dp, y = 33.dp),
                colorFilter = ColorFilter.tint(Color(0xFFF2F4F3))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PageScreenPreview() {
    MaterialTheme {
        PageScreen()
    }
}