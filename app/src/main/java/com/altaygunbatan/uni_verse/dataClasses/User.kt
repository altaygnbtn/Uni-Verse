package com.altaygunbatan.uni_verse.dataClasses

data class User(
    val id: String,
    val email: String,
    val username: String,
    val department: String,
    val age: Int,
    val gender: String,
    val school: String,
    val hobbies: List<String>,
    val friends: List<User>
)
