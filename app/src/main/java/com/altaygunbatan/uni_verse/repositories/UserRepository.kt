package com.altaygunbatan.uni_verse.repositories

import com.altaygunbatan.uni_verse.dataClasses.User

class UserRepository {

    fun getUserProfile(userId: String): User {
        // fetching user data from local database

        return User(
            id = userId,
            email = "selin.yilmaz@std.yeditepe.edu.tr",
            username = "Selin Yilmaz",
            department = "Computer Science",
            age = 22,
            gender = "female",
            school = "Yeditepe University",
            hobbies = listOf("Reading", "Coding"),
            friends = listOf()
        )
    }

    fun updateUserProfile(user: User) {

    }

}