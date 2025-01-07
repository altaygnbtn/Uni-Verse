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

class EventViewModel(application: Application) : AndroidViewModel(application) {
    private val eventDao: EventDao = AppDatabase.getDatabase(application).eventDao()

    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> get() = _events

    private val _showOnlyLiked = MutableStateFlow(false)
    val showOnlyLiked: StateFlow<Boolean> get() = _showOnlyLiked




    init {
        viewModelScope.launch {
            eventDao.getAllEvents().collect {
                _events.value = it
            }
        }
    }

    fun toggleLike(event: Event) {
        viewModelScope.launch {
            val updatedEvent = event.copy(isLiked = !event.isLiked)
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
            eventDao.getEventsSortedByName().collect {
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
                eventDao.getAllEvents().collect {
                    _events.value = it
                }
            } else {
                eventDao.searchEventsByName(query).collect {
                    _events.value = it
                }
            }
        }
    }

}