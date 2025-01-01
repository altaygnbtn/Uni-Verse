package com.altaygunbatan.uni_verse.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.altaygunbatan.uni_verse.dataClasses.Event
import com.altaygunbatan.uni_verse.database.EventDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch




class EventViewModel(
    private val eventDao: EventDao
) : ViewModel() {

     val _state = MutableStateFlow(EventState())




    fun onEvent(event: EventActions) {
        when (event) {

            is EventActions.SaveEvents -> {
                val _event = Event(
                    name = _state.value.name.value,
                    date = _state.value.date.value,
                    details = _state.value.details.value,
                )
                viewModelScope.launch {
                    eventDao.upsertEvent(_event)
                }
                _state.update {
                    it.copy(
                        name = mutableStateOf(""),
                        date = mutableStateOf(""),
                        details = mutableStateOf(""),
                    )
                }

            }
            is EventActions.DeleteEvents -> {
                viewModelScope.launch {
                    eventDao.deleteEvent(event.event)
                }
            }
        }
    }
}

