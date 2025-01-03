package com.altaygunbatan.uni_verse.dataClasses

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "events")
data class Event(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,
    val date: String,
    val details: String,
    val imageUri: String? = null

)