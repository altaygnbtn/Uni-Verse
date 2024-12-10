package com.altaygunbatan.uni_verse.viewModels

class EventViewModel(application: Application) : AndroidViewModel(application) {
    private val eventRepository = EventRepository(application)
    val eventsLiveData: LiveData<List<Event>> = eventRepository.getEvents()

    fun createEvent(event: Event) {
        eventRepository.createEvent(event)
    }

    fun editEvent(event: Event) {
        eventRepository.editEvent(event)
    }

    fun deleteEvent(eventId: String) {
        eventRepository.deleteEvent(eventId)
    }

    fun searchEvents(query: String) {
        eventRepository.searchEvents(query)
    }
}