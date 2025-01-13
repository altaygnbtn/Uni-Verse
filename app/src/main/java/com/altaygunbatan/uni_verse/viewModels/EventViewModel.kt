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
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EventViewModel(application: Application) : AndroidViewModel(application) { //extend AndroidViewModel to access application context

    private val eventDao: EventDao = AppDatabase.getDatabase(application).eventDao() //get instance of EventDao from AppDatabase

    private val _events = MutableStateFlow<List<Event>>(emptyList()) //create a MutableStateFlow to hold the list of events
    val events: StateFlow<List<Event>> get() = _events

    private val _showOnlyLiked = MutableStateFlow(false)    //create a MutableStateFlow to hold the value of showOnlyLiked and default value is false
    val showOnlyLiked: StateFlow<Boolean> get() = _showOnlyLiked //get the value of showOnlyLiked

    private val _notifications = mutableStateListOf<String>()   // hold notifications as a mutable list of strings
    val notifications: List<String> = _notifications


    init {
        viewModelScope.launch {                             //launch a coroutine in the viewModelScope
            eventDao.getAllEvents().collect {               //collect the list of events from the database
                _events.value = it
            }
        }
    }

    fun toggleLike(event: Event) {
        viewModelScope.launch {
            val updatedEvent = event.copy(isLiked = !event.isLiked)         //update the event with the new value of isLiked
            eventDao.updateEvent(updatedEvent)
        }
    }

    fun toggleShowOnlyLiked() {
        _showOnlyLiked.update { !it }
        viewModelScope.launch {
            if (_showOnlyLiked.value) {
                eventDao.getLikedEvents().collect {
                    _events.value = it
                }
            } else {
                eventDao.getAllEvents().collect {
                    _events.value = it
                }
            }
        }
    }

    fun filterByName() {
        viewModelScope.launch {
            eventDao.getEventsSortedByName().collect { //collect the list of events from the database, block the coroutine scope until the flow emits a new value
                _events.value = it
            }
        }
    }

    fun filterByDate() {
        viewModelScope.launch {
            eventDao.getEventsSortedByDate().collect {
                _events.value = it
            }
        }
    }

    fun addEvent(event: Event) {
        viewModelScope.launch {
            eventDao.insertEvent(event)
            _notifications.add("Event '${event.eventName}' is created.") //add notifications message to _notifications

        }
    }

    fun deleteEvent(event: Event) {
        viewModelScope.launch {
            eventDao.deleteEvent(event)
        }
    }


    fun searchEvents(query: String) {
        viewModelScope.launch {
            if (query.isBlank()) {
                eventDao.getAllEvents().collect {       // if there is no text on Text Field the events are listed and change the new event value
                    _events.value = it
                }
            } else {
                eventDao.searchEventsByName(query).collect {
                    _events.value = it
                }
            }
        }
    }

    fun clearNotifications() {
        _notifications.clear()
    }


}