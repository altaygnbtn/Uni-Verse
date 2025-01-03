package com.altaygunbatan.uni_verse.viewModels

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.altaygunbatan.uni_verse.dataClasses.Event
import com.altaygunbatan.uni_verse.database.AppDatabase
import com.altaygunbatan.uni_verse.database.EventDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EventViewModel(application: Application) : AndroidViewModel(application) {
    private val eventDao: EventDao = AppDatabase.getDatabase(application).eventDao()

    val events : Flow<List<Event>> = eventDao.getAllEvents()

    fun addEvent(event: Event) {
        viewModelScope.launch {
            eventDao.insertEvent(event)
        }

    }

    fun deleteEvent(event: Event) {
        viewModelScope.launch {
            eventDao.deleteEvent(event)
        }

    }
}