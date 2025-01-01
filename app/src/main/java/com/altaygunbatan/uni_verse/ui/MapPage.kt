package com.example.myproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.FontStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPage()
        }
    }
}

@Composable
fun MyPage() {
    Box(
        Modifier
            .width(412.dp)
            .height(935.dp)
    ) {
        Box(
            Modifier
                .width(412.dp)
                .height(130.dp)
                .offset(y = (-57).dp)
                .border(3.dp, Color(0xFFF2F4F3), RectangleShape)
                .background(Color(0xFF0A1045))
        ) {
            Text(
                text = "Logo",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Box(
            Modifier
                .width(412.dp)
                .height(113.dp)
                .offset(y = 822.dp)
                .background(Color(0xFF0A1045))
        )
        Box(
            Modifier
                .width(397.dp)
                .height(282.dp)
                .offset(x = 0.dp, y = 80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.map_image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                Modifier
                    .width(18.dp)
                    .height(23.dp)
                    .offset(x = 104.dp, y = 203.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.night_party),
                    contentDescription = null,
                    modifier = Modifier
                        .width(14.dp)
                        .height(13.67.dp)
                        .offset(x = 2.dp, y = 2.dp)
                )
            }
            Box(
                Modifier
                    .width(35.dp)
                    .height(45.dp)
                    .offset(x = 181.dp, y = 260.dp)
                    .background(Color(0xFFFF3C31))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.color_throw),
                    contentDescription = null,
                    modifier = Modifier
                        .width(31.dp)
                        .height(30.27.dp)
                        .offset(x = 2.dp, y = 3.dp)
                )
            }
            Box(
                Modifier
                    .width(18.dp)
                    .height(23.dp)
                    .offset(x = 238.dp, y = 282.dp)
                    .background(Color(0xFFFF3C31))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sand_party),
                    contentDescription = null,
                    modifier = Modifier
                        .width(14.34.dp)
                        .height(14.dp)
                        .offset(x = 2.dp, y = 2.dp)
                )
            }
        }
        Text(
            text = "Location based events",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Color(0xFF0A1045),
            modifier = Modifier.offset(x = 21.dp, y = 378.dp)
        )
        Box(
            Modifier
                .width(366.dp)
                .height(180.dp)
                .offset(x = 16.dp, y = 455.dp)
                .clip(RoundedCornerShape(topStart = 30.dp))
                .background(Color.White)
        ) {
            Box(
                Modifier
                    .width(51.2.dp)
                    .height(50.dp)
                    .offset(x = 23.dp, y = 7.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.color_throw),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(
                Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .offset(x = 342.dp, y = 17.dp)
                    .border(4.dp, Color(0xFF91A0A6), RectangleShape)
            )
            Text(
                text = "Colorfest yeditepe",
                fontFamily = FontFamily.SansSerif,
                fontSize = 21.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF0A1045),
                modifier = Modifier.offset(x = 88.dp, y = 18.dp)
            )
            Column(Modifier.offset(x = 102.dp, y = 47.dp)) {
                Text(
                    text = "Are you ready for a fun festival full of colors?",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 21.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF0A1045)
                )
                Text(
                    text = "April 23rd at 12:00 in ",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 21.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF0A1045)
                )
                Text(
                    text = "festival area",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 21.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF0A1045)
                )
            }
        }
        Box(
            Modifier
                .width(366.dp)
                .height(58.dp)
                .offset(x = 18.dp, y = 676.dp)
                .clip(RoundedCornerShape(topStart = 30.dp))
                .background(Color.White)
        ) {
            Box(
                Modifier
                    .width(51.dp)
                    .height(49.8.dp)
                    .offset(x = 25.dp, y = 2.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sand_party),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(
                Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .offset(x = 344.dp, y = 14.dp)
                    .border(4.dp, Color(0xFF91A0A6), RectangleShape)
            )
            Text(
                text = "Fair for elders",
                fontFamily = FontFamily.SansSerif,
                fontSize = 21.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF0A1045),
                modifier = Modifier.offset(x = 90.dp, y = 17.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyPage() {
    MyPage()
}


