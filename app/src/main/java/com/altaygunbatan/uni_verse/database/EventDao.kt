package com.altaygunbatan.uni_verse.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.altaygunbatan.uni_verse.dataClasses.Event
import kotlinx.coroutines.flow.Flow


@Dao
interface EventDao {

    @Insert
    suspend fun insertEvent(event: Event)       //import the events

    @Delete
    suspend fun deleteEvent(event: Event)       //delete the events



}