package com.altaygunbatan.uni_verse.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.altaygunbatan.uni_verse.R
import com.altaygunbatan.uni_verse.ui.theme.displayFontFamily
import com.altaygunbatan.uni_verse.viewModels.EventViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JoinEventPage(navController: NavController,
                  viewModel: EventViewModel
) {


    val events by viewModel.events.collectAsState()
    val showOnlyLiked by viewModel.showOnlyLiked.collectAsState()
    var searchQuery by remember { mutableStateOf("") }




    val showFilterDialog = remember { mutableStateOf(false) }

    val selected = remember {
        mutableIntStateOf(R.drawable.baseline_add_24)
    }



    Scaffold(
        topBar = {
            MyTopAppBar(navController, selected)
        },
        bottomBar = {
            MyBottomAppBar(navController, selected)
        }

    ) { paddingValues ->


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(color = Color(red = 242, green = 244, blue = 243)),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            Text(
                text = "Join Event",
                fontFamily = displayFontFamily,
                fontSize = 25.sp,
                color = Color(red = 10, green = 16, blue = 69, alpha = 255),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 30.dp, top = 5.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            ) {
                HomeTextField(viewModel)
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp), // Space between the buttons
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .size(width = 100.dp, height = 20.dp)
                    .padding(start = 20.dp)
            ) {

                IconButton(
                    onClick = {
                        selected.value = R.drawable.filter
                        showFilterDialog.value = true
                    },
                    modifier = Modifier.weight(1f)
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = "Filter Button",
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == R.drawable.filter) Color.Blue else Color.Gray
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = R.drawable.liked_event
                        viewModel.toggleShowOnlyLiked()
                    },
                    modifier = Modifier.weight(1f)
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.liked_event),
                        contentDescription = "Liked Events Button",
                        modifier = Modifier.size(30.dp),
                        tint = if (selected.value == R.drawable.liked_event) Color.Blue else Color.Gray
                    )
                }


            }


            // LazyColumn for displaying filtered events
            if (events.isEmpty()) {
                Text(
                    text = "No events available to join",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(events) { event ->
                        JoinEventCard(event, onLikeClicked = { viewModel.toggleLike(event) })
                    }
                }

            }
            if (showFilterDialog.value) {
                FilterDialog(
                    onDismiss = { showFilterDialog.value = false },
                    onFilterByName = {
                        viewModel.filterByName()
                        showFilterDialog.value = false
                    },
                    onFilterByDate = {
                        viewModel.filterByDate()
                        showFilterDialog.value = false
                    }
                )
            }

        }
    }
}

@Preview
@Composable
fun JoinEventPagePreview() {

    JoinEventPage(navController = rememberNavController(), viewModel = viewModel())
}
