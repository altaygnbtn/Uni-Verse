package com.altaygunbatan.uni_verse.database

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.altaygunbatan.uni_verse.dataClasses.Event

data class EventState(

    val events: List<Event> = emptyList(),
    val name: MutableState<String> = mutableStateOf(""),
    val date: MutableState<String> = mutableStateOf(""),
    val details: MutableState<String> = mutableStateOf(""),

)
