package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MyPage()
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMyPage() {
    MaterialTheme {
        MyPage()
    }
}

@Composable
fun MyPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .width(412.dp)
                .height(130.dp)
                .border(3.dp, Color(0xFFF2F4F3))
                .background(Color(0xFF0A1045))
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = "Logo",
                fontSize = 21.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                lineHeight = 25.2.sp,
                color = Color(0xFFF2F4F3),
                modifier = Modifier.offset(x = 23.dp, y = 24.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.bell),
                contentDescription = null,
                tint = Color(0xFFF2F4F3).copy(alpha = 0.7f),
                modifier = Modifier
                    .offset(x = 306.dp, y = 22.dp)
                    .size(width = 23.dp, height = 26.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.person),
                contentDescription = null,
                tint = Color(0xFFF2F4F3),
                modifier = Modifier
                    .offset(x = 361.dp, y = 24.dp)
                    .size(width = 21.dp, height = 24.dp)
                    .border(3.dp, Color(0xFFF2F4F3))
            )
        }
        Box(
            modifier = Modifier
                .offset(x = 35.dp, y = 95.dp)
                .size(width = 333.dp, height = 229.dp)
                .background(Color.White, shape = RoundedCornerShape(topStart = 15.dp))
        )
        Text(
            text = "General",
            color = Color(0xFFFF3C31),
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            fontSize = 32.sp,
            lineHeight = 38.4.sp,
            modifier = Modifier.offset(x = 50.dp, y = 97.dp)
        )
        Column(
            modifier = Modifier.offset(x = 37.dp, y = 142.dp)
        ) {
            Text(
                text = "Language Options",
                fontSize = 21.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFF0A1045),
                lineHeight = 24.61.sp
            )
            Text(
                text = "E-mail Updates",
                fontSize = 21.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFF0A1045),
                lineHeight = 24.61.sp
            )
            Text(
                text = "Distance Units",
                fontSize = 21.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFF0A1045),
                lineHeight = 24.61.sp
            )
            Text(
                text = "Theme Options",
                fontSize = 21.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFF0A1045),
                lineHeight = 24.61.sp
            )
        }
        Box(
            modifier = Modifier
                .offset(x = 37.dp, y = 336.dp)
                .size(width = 333.dp, height = 229.dp)
                .background(Color.White, shape = RoundedCornerShape(topStart = 15.dp))
        )
        Text(
            text = "Apps",
            color = Color(0xFFFF3C31),
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 38.4.sp,
            modifier = Modifier.offset(x = 50.dp, y = 345.dp)
        )
        Column(
            modifier = Modifier.offset(x = 42.dp, y = 397.dp)
        ) {
            Text(
                text = "Widget",
                fontSize = 21.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFF0A1045),
                lineHeight = 24.61.sp
            )
            Text(
                text = "Share",
                fontSize = 21.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFF0A1045),
                lineHeight = 24.61.sp
            )
            Text(
                text = "Rate",
                fontSize = 21.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                color = Color(0xFF0A1045),
                lineHeight = 24.61.sp
            )
            )
            Box(
                modifier = Modifier
                    .offset(x = 39.dp, y = 584.dp)
                    .size(width = 333.dp, height = 229.dp)
                    .background(Color.White, shape = RoundedCornerShape(topStart = 15.dp))
            )
            Text(
                text = "Help & Support",
                color = Color(0xFFFF3C31),
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily.SansSerif,
                lineHeight = 38.4.sp,
                modifier = Modifier.offset(x = 50.dp, y = 593.dp)
            )
            Column(
                modifier = Modifier.offset(x = 35.dp, y = 645.dp)
            ) {
                Text(
                    text = "FAQ",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xFF0A1045),
                    lineHeight = 24.61.sp
                )
                Text(
                    text = "Contact Support",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xFF0A1045),
                    lineHeight = 24.61.sp
                )
                Text(
                    text = "Live Support",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xFF0A1045),
                    lineHeight = 24.61.sp
                )
                )
                Box(
                    modifier = Modifier
                        .offset(y = 822.dp)
                        .size(width = 412.dp, height = 113.dp)
                        .background(Color(0xFF0A1045))
                        .align(Alignment.TopStart)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = null,
                        tint = Color(0xFFF2F4F3).copy(alpha = 0.7f),
                        modifier = Modifier
                            .offset(x = 28.dp, y = 32.dp)
                            .size(width = 31.dp, height = 24.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.map),
                        contentDescription = null,
                        tint = Color(0xFFF2F4F3).copy(alpha = 0.7f),
                        modifier = Modifier
                            .offset(x = 110.dp, y = 32.dp)
                            .size(width = 28.dp, height = 25.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.plus),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .offset(x = 175.dp, y = 17.dp)
                            .size(64.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.chat),
                        contentDescription = null,
                        tint = Color(0xFFF2F4F3).copy(alpha = 0.7f),
                        modifier = Modifier
                            .offset(x = 277.dp, y = 32.dp)
                            .size(31.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.settings),
                        contentDescription = null,
                        tint = Color(0xFFF2F4F3).copy(alpha = 0.7f),
                        modifier = Modifier
                            .offset(x = 356.dp, y = 29.dp)
                            .size(width = 27.dp, height = 28.dp)
                    )
                }
            }
        }
