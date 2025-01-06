package com.altaygunbatan.uni_verse.dataClasses

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "events")
data class Event(

    @PrimaryKey(autoGenerate = true)
    val eventId: Int = 0,

    val eventName: String,
    val eventDate: String,
    val eventDetails: String,
    val eventImage: String? = null

)