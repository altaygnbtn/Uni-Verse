package com.altaygunbatan.uni_verse.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.altaygunbatan.uni_verse.dataClasses.Event
import kotlinx.coroutines.flow.Flow


@Dao
interface EventDao {

    @Query("SELECT * FROM events")
    fun getAllEvents(): Flow<List<Event>> //get events

    @Insert
    suspend fun insertEvent(event: Event)       //import the events

    @Delete
    suspend fun deleteEvent(event: Event)       //delete the events

    @Update
    suspend fun updateEvent(event: Event)       //update the events


    @Query("SELECT * FROM events WHERE isLiked = 1")
    fun getLikedEvents(): Flow<List<Event>>                 //list the liked events if it is liked by the user

    @Query("SELECT * FROM events ORDER BY eventDate ASC")
    fun getEventsSortedByDate(): Flow<List<Event>>          //list the events by date

    @Query("SELECT * FROM events ORDER BY eventName ASC")   //list the events by name
    fun getEventsSortedByName(): Flow<List<Event>>

    @Query("SELECT * FROM events WHERE eventName LIKE '%' || :query || '%'")
    fun searchEventsByName(query: String): Flow<List<Event>>    //search the events by name



}