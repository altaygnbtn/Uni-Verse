package com.example.identicalpage



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.FontStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IdenticalPage()
        }
    }
}

@Composable
fun IdenticalPage() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .offset(x = 0.dp, y = (-54).dp)
                .size(width = 412.dp, height = 130.dp)
                .border(width = 3.dp, color = Color(0xFFF2F4F3), shape = RectangleShape)
        )

        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .offset(x = 16.dp, y = 91.dp)
                .size(width = 381.dp, height = 56.dp)
                .border(width = 2.dp, color = Color(0xFF0A1045), shape = RectangleShape),
            placeholder = {
                Text(text = "Search members…", color = Color.Gray)
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        Text(
            text = "Friends",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF0A1045),
            modifier = Modifier
                .offset(x = 19.dp, y = 153.dp)
                .size(width = 333.dp, height = 43.dp)
        )

        Box(
            modifier = Modifier
                .offset(x = 137.dp, y = 159.dp)
                .size(width = 33.dp, height = 33.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.plus_icon),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .offset(x = 177.dp, y = 162.dp)
                .size(width = 24.dp, height = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.trash_icon),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .offset(x = 217.dp, y = 162.dp)
                .size(width = 24.dp, height = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.person_icon),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .offset(x = 257.dp, y = 162.dp)
                .size(width = 24.dp, height = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.more_icon),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .offset(x = 24.dp, y = 202.dp)
                .size(width = 57.35.dp, height = 56.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.emir_bektas),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Text(
            text = "Emir Bektaş",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .offset(x = 90.dp, y = 217.dp)
        )

        Box(
            modifier = Modifier
                .offset(x = 24.dp, y = 279.dp)
                .size(width = 57.35.dp, height = 56.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.elif_yanardag),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Text(
            text = "Elif Yanardağ",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .offset(x = 90.dp, y = 294.dp)
        )

        Box(
            modifier = Modifier
                .offset(x = 24.dp, y = 361.dp)
                .size(width = 57.35.dp, height = 56.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.mete_calisir),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Text(
            text = "Mete Çalışır",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .offset(x = 90.dp, y = 376.dp)
        )

        Text(
            text = "SEE ALL",
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            color = Color(0xFFFF3C31),
            modifier = Modifier
                .offset(x = 164.dp, y = 410.dp)
                .size(width = 100.dp, height = 44.dp)
        )

        Text(
            text = "Groups",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = Color(0xFF0A1045),
            modifier = Modifier
                .offset(x = 20.dp, y = 437.dp)
                .size(width = 333.dp, height = 43.dp)
        )

        Box(
            modifier = Modifier
                .offset(x = 132.dp, y = 446.dp)
                .size(width = 33.dp, height = 33.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.plus_icon),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .offset(x = 173.dp, y = 450.dp)
                .size(width = 24.dp, height = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.trash_icon),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .offset(x = 205.dp, y = 450.dp)
                .size(width = 24.dp, height = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.person_icon),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .offset(x = 237.dp, y = 450.dp)
                .size(width = 24.dp, height = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.more_icon),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .offset(x = 21.dp, y = 495.dp)
                .size(width = 57.35.dp, height = 56.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.headphones),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Text(
            text = "Music Lovers",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .offset(x = 90.dp, y = 510.dp)
        )

        Box(
            modifier = Modifier
                .offset(x = 21.dp, y = 572.dp)
                .size(width = 57.35.dp, height = 56.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.recycle),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Text(
            text = "Re-CYCLE",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .offset(x = 90.dp, y = 587.dp)
        )

        Box(
            modifier = Modifier
                .offset(x = 21.dp, y = 654.dp)
                .size(width = 57.35.dp, height = 56.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.sports),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Text(
            text = "Sports events",
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .offset(x = 90.dp, y = 669.dp)
        )

        Text(
            text = "SEE ALL",
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            color = Color(0xFFFF3C31),
            modifier = Modifier
                .offset(x = 165.dp, y = 726.dp)
                .size(width = 100.dp, height = 44.dp)
        )

        Box(
            modifier = Modifier
                .offset(x = 0.dp, y = 825.dp)
                .size(width = 412.dp, height = 113.dp)
                .border(width = 0.dp, color = Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bottom_bar),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


