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
import com.altaygunbatan.uni_verse.R

// -- If you have a custom theme, import it here:
// import com.example.identicalpage.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FriendsAndGroupsPage()
        }
    }
}

@Composable
fun FriendsAndGroupsPage() {
    // We'll structure the UI in a Column with:
    // 1. Top bar
    // 2. Search bar
    // 3. Friends section
    // 4. Groups section
    // 5. Bottom bar

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            // 1) Top bar
            TopBarSection()

            // 2) Search bar
            SearchBar()

            // 3) Friends section
            FriendsSection()

            // 4) Groups section
            GroupsSection()
        }

        // 5) Bottom bar
        BottomBar(modifier = Modifier.align(Alignment.BottomCenter))
    }
}

/** ----------------- Top Bar ----------------- **/
@Composable
fun TopBarSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFF0A1045)) // Navy color from your example
    ) {
        // If you want a border on top, you can do .border(...) here.

        // "Logo" text or anything else you want at the top-left
        Text(
            text = "Logo",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Serif, // or your custom font
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
        )

        // Right-side icons
        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
        ) {
            IconButton(onClick = { /* TODO: Bell action */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.plus_button), // Example
                    contentDescription = null,
                    tint = Color.White
                )
            }

            // Add any other icons here if you want (like person, etc.)
        }
    }
}

/** ----------------- Search Bar ----------------- **/
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
                    shape = RectangleShape
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

/** ----------------- Friends Section ----------------- **/
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
            fontFamily = FontFamily.Serif,
            color = Color(0xFF0A1045),
            modifier = Modifier.weight(1f) // push icons to the right
        )

        // Icons next to "Friends"
        Icon(
            painter = painterResource(id = R.drawable.plus_button),
            contentDescription = null,
            tint = Color.Unspecified, // or a color if desired
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Icon(
            painter = painterResource(id = R.drawable.trash_button),
            contentDescription = null,
            tint = Color.Unspecified,
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
        imageRes = R.drawable.emir_bektas,
        name = "Emir Bektaş"
    )
    FriendItem(
        imageRes = R.drawable.elif_yanardag,
        name = "Elif Yanardağ"
    )
    FriendItem(
        imageRes = R.drawable.mete_calisir,
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
            fontFamily = FontFamily.Serif,
            color = Color(0xFFFF3C31),
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

/** Displays one friend’s circular avatar and name. */
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
            fontFamily = FontFamily.Serif
        )
    }
}

/** ----------------- Groups Section ----------------- **/
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
            fontFamily = FontFamily.Serif,
            color = Color(0xFF0A1045),
            modifier = Modifier.weight(1f)
        )

        Icon(
            painter = painterResource(id = R.drawable.plus_button),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))

        Icon(
            painter = painterResource(id = R.drawable.trash_button),
            contentDescription = null,
            tint = Color.Unspecified,
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

/** Displays one group’s circular avatar and name. */
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

/** ----------------- Bottom Bar ----------------- **/
@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    // If you have a single bottom bar image, you can place it in an Image composable.
    // Otherwise, replicate the icons as you did in your Login or Settings screens.
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color(0xFF0A1045)) // navy color
    ) {
        // Example with a single background image:
        // Image(painter = painterResource(id = R.drawable.bottom_bar), contentDescription = null, modifier = Modifier.fillMaxSize())

        // Or place multiple Icons horizontally:
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(id = R.drawable.home_button),
                contentDescription = "Home",
                tint = Color.White
            )

            Icon(
                painter = painterResource(id = R.drawable.map_button),
                contentDescription = "Map",
                tint = Color.White
            )

            Icon(
                painter = painterResource(id = R.drawable.plus_button),
                contentDescription = "Add",
                tint = Color.White
            )

            Icon(
                painter = painterResource(id = R.drawable.chat_button),
                contentDescription = "Chat",
                tint = Color.White
            )

            Icon(
                painter = painterResource(id = R.drawable.settings_button),
                contentDescription = "Settings",
                tint = Color.White
            )
        }
    }
}
