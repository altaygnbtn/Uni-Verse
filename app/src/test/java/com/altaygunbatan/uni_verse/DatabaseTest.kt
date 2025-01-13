package com.altaygunbatan.uni_verse

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.altaygunbatan.uni_verse.dataClasses.Event
import com.altaygunbatan.uni_verse.database.AppDatabase
import com.altaygunbatan.uni_verse.database.EventDao
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class DatabaseTest {
    // Database and DAO instances
    private lateinit var database: AppDatabase
    private lateinit var eventDao: EventDao

    // Runs before every test
    @Before
    fun setup() {
        // Create an in-memory database for testing
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()

        // Get DAO instance
        eventDao = database.eventDao()
    }

    // Runs after every test
    @After
    fun teardown() {
        // Close the database
        database.close()
    }

    @Test
    fun testInsertAndRetrieveEvent() = runBlocking {
        // Create a sample event
        val event = Event(
            eventName = "Sample Event",
            eventDate = "2025-01-01",
            eventDetails = "Details about the event",
            eventLocation = "Somewhere",
            eventImage = "image_url"
        )

        // Insert the event
        eventDao.insertEvent(event)

        // Retrieve events and check
        val retrievedEvents = eventDao.getAllEvents().first()
        assertEquals(1, retrievedEvents.size)
        assertEquals("Sample Event", retrievedEvents[0].eventName)
    }

    @Test
    fun testDeleteEvent() = runBlocking {
        val event = Event(
            eventName = "Event to delete",
            eventDate = "2025-01-02",
            eventDetails = "Details to delete",
            eventLocation = "Somewhere else"
        )

        eventDao.insertEvent(event)

        val insertedEvent = eventDao.getAllEvents().first().first()
        eventDao.deleteEvent(insertedEvent)

        val retrievedEvents = eventDao.getAllEvents().first()
        assertTrue(retrievedEvents.isEmpty())
    }

    @Test
    fun testUpdateEvent() = runBlocking {
        val event = Event(
            eventName = "Initial Name",
            eventDate = "2025-01-03",
            eventDetails = "Initial Details",
            eventLocation = "Initial Location"
        )

        eventDao.insertEvent(event)

        val insertedEvent = eventDao.getAllEvents().first().first()
        val updatedEvent = insertedEvent.copy(eventName = "Updated Name")

        eventDao.updateEvent(updatedEvent)

        val retrievedEvents = eventDao.getAllEvents().first()
        assertEquals("Updated Name", retrievedEvents[0].eventName)
    }

}