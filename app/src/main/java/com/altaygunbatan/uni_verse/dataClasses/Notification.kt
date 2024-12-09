package com.altaygunbatan.uni_verse.dataClasses

data class Notification(
    val id: String,
    val message: String,
    val date: Long, // Timestamp of when the notification was sent
    val type: NotificationType
)

enum class NotificationType {
    EVENT_UPDATE,
    NEW_MESSAGE,
    NEARBY_EVENT
}