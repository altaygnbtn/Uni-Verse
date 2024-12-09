package com.altaygunbatan.uni_verse.dataClasses


data class Event(

    val title: String,
    val description: String,
    val location: String,
    val date: Long,
    val time: String,
    val organizer: String,
    val participantLimit: Int,
    val category: String,
    val image: String,
    val attendees: List<String>,
    val comments: List<Comment>
)

data class Comment(
    val userId: String,
    val feedback: String,
    val rating: Int
)