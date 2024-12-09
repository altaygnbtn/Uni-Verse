package com.altaygunbatan.uni_verse.API

import com.altaygunbatan.uni_verse.dataClasses.Event
import com.altaygunbatan.uni_verse.dataClasses.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface ApiService {
    @GET("events")
    suspend fun getEvents(): List<Event>

    @POST("events")
    suspend fun createEvent(@Body event: Event)

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: String): User

    @POST("users")
    suspend fun updateUser(@Body user: User)
}