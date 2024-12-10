package com.altaygunbatan.uni_verse.dataClasses

data class Notification(
    val id: String,
    val message: String,
    val type: NotificationType
)

enum class NotificationType {
    EVENT_UPDATE,
    NEW_MESSAGE,
    NEARBY_EVENT
}