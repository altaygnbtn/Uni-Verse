package com.altaygunbatan.uni_verse.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.altaygunbatan.uni_verse.dataClasses.Event

class EventViewModel : ViewModel() {
    private val _events = mutableStateListOf<Event>()
    val events: List<Event> get()= _events

    fun addEvent(event: Event) {
        _events.add(event)

    }

    fun editEvent(event : Event) {
        val index = _events.indexOfFirst { it.name == event.name }
        if (index != -1){
            _events[index] = event
        }
    }

    fun deleteEvent(event : Event) {
        _events.remove(event)

    }
}

