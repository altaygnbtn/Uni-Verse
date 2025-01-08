package com.altaygunbatan.uni_verse.repositories

import com.altaygunbatan.uni_verse.dataClasses.UserProfile
import com.altaygunbatan.uni_verse.database.UserProfileDao

class UserProfileRepository(private val userProfileDao: UserProfileDao) {


    suspend fun getUserProfile(): UserProfile? = userProfileDao.getUserProfile()

    suspend fun saveUserProfile(profile: UserProfile) = userProfileDao.insertUserProfile(profile)

    suspend fun updateUserProfile(profile: UserProfile) = userProfileDao.updateUserProfile(profile)
}
