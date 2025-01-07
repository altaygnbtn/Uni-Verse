package com.altaygunbatan.uni_verse.dataClasses

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate


@Entity(tableName = "events")
data class Event(

    @PrimaryKey(autoGenerate = true)
    val eventId: Int = 0,

    val eventName: String,
    val eventDate: String,
    val eventDetails: String,
    val eventImage: String? = null,
    var isLiked: Boolean = false // New property

)
