package com.altaygunbatan.uni_verse.repositories

import android.content.Context
import androidx.lifecycle.LiveData
import com.altaygunbatan.uni_verse.dataClasses.Event

class EventRepository(private val context: Context) {
    private val eventDao: EventDao = AppDatabase.getDatabase(context).eventDao()

    fun getEvents(): LiveData<List<Event>> {
        return eventDao.getAllEvents()
    }

    fun createEvent(event: Event) {
        eventDao.insertEvent(event)
    }

    fun editEvent(event: Event) {
        eventDao.updateEv ent(event)
    }

    fun deleteEvent(eventId: String) {
        eventDao.deleteEvent(eventId)
    }

    fun searchEvents(query: String) {
    }
}