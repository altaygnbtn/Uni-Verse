package com.altaygunbatan.uni_verse.database

import com.altaygunbatan.uni_verse.dataClasses.Event

sealed interface EventActions {

    data class SaveEvents(val name: String, val date: String, val details: String): EventActions

    data class DeleteEvents(val event: Event): EventActions
}