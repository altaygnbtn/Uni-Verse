package com.altaygunbatan.uni_verse.dataClasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserProfile(
    @PrimaryKey val id: Int = 1, // Assuming a single-user app

    val profilePictureUri: String?,

    val fullName: String,

    val yearOfStudy: String,

    val department: String,

    val interests: String
)