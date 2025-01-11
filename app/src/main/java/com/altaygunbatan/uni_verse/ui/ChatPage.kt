package com.example.identicalpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.altaygunbatan.uni_verse.R
import com.altaygunbatan.uni_verse.ui.MyBottomAppBar
import com.altaygunbatan.uni_verse.ui.MyTopAppBar
import com.altaygunbatan.uni_verse.ui.theme.bodyFontFamily
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily


@Composable
fun ChatPage(navController: NavController) {

    val selected = remember {
        mutableIntStateOf(R.drawable.chat_button)
    }

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
                .background(color = Color(red = 242, green = 244, blue = 243))
                .padding(innerPadding)
        ) {


            SearchBar()


            FriendsSection()


            GroupsSection()
        }


    }
}




@Composable
fun SearchBar() {
    var searchText = remember { mutableStateOf("") }

    // We can place it in a spacer or Box if we want some background or border
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        TextField(
            value = searchText.value,
            onValueChange = { searchText.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(
                    width = 2.dp,
                    color = Color(0xFF0A1045),
                    shape = RoundedCornerShape(8.dp)
                ),
            placeholder = {
                Text(text = "Search members…", color = Color.Gray)
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RectangleShape
        )
    }
}

//Friends Section

@Composable
fun FriendsSection() {
    // Title row (Friends + action icons to the right)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Friends",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = displayFontFamily,
            color = Color(0xFF0A1045),
            modifier = Modifier.weight(1f) // push icons to the right
        )

        // Icons next to "Friends"
        Icon(
            painter = painterResource(id = R.drawable.typcn_plus),
            contentDescription = null,
            tint = Color.Gray, // or a color if desired
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Icon(
            painter = painterResource(id = R.drawable.trash_button),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Icon(
            painter = painterResource(id = R.drawable.profile_button),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

//        Icon(
//            painter = painterResource(id = R.drawable.more_icon),
//            contentDescription = null,
//            tint = Color.Unspecified,
//            modifier = Modifier.size(24.dp)
//        )
    }

    // Individual friend items
    FriendItem(
        imageRes = R.drawable.emir,
        name = "Emir Bektaş"
    )
    FriendItem(
        imageRes = R.drawable.elif,
        name = "Elif Yanardağ"
    )
    FriendItem(
        imageRes = R.drawable.mete,
        name = "Mete Çalışır"
    )

    // "SEE ALL" button or text
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SEE ALL",
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = displayFontFamily,
            color = Color(0xFFFF3C31),
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Composable
fun FriendItem(imageRes: Int, name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = name,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = bodyFontFamily
        )
    }
}

// Group Section
@Composable
fun GroupsSection() {
    // Title row (Groups + action icons to the right)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Groups",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = displayFontFamily,
            color = Color(0xFF0A1045),
            modifier = Modifier.weight(1f)
        )

        Icon(
            painter = painterResource(id = R.drawable.typcn_plus),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Icon(
            painter = painterResource(id = R.drawable.trash_button),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Icon(
            painter = painterResource(id = R.drawable.profile_button),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

//        Icon(
//            painter = painterResource(id = R.drawable.more_icon),
//            contentDescription = null,
//            tint = Color.Unspecified,
//            modifier = Modifier.size(24.dp)
//        )
    }

    // Individual group items
    GroupItem(
        imageRes = R.drawable.music,
        groupName = "Music Lovers"
    )
    GroupItem(
        imageRes = R.drawable.recycle,
        groupName = "Re-CYCLE"
    )
    GroupItem(
        imageRes = R.drawable.sports,
        groupName = "Sports events"
    )

    // "SEE ALL"
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "SEE ALL",
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            color = Color(0xFFFF3C31),
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}


@Composable
fun GroupItem(imageRes: Int, groupName: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = groupName,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif
        )
    }
}


