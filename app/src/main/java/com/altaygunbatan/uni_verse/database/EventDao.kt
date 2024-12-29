package com.altaygunbatan.uni_verse.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.altaygunbatan.uni_verse.dataClasses.Event
import kotlinx.coroutines.flow.Flow


@Dao
interface EventDao {

    @Upsert
    suspend fun upsertEvent(event: Event)       //import and update

    @Delete
    suspend fun deleteEvent(event: Event)

//    @Query("SELECT * FROM Event ")
//    suspend fun getAllEvents(): Flow<List<Event>>       //get events

//    @Query("SELECT * FROM Event ")
//    fun getAllEvents(): Flow<List<Event>>       //get events

}