package com.altaygunbatan.uni_verse.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.altaygunbatan.uni_verse.dataClasses.UserProfile

@Dao
interface UserProfileDao {

    @Query("SELECT * FROM UserProfile WHERE id = :id")
    suspend fun getUserProfile(id: Int = 1): UserProfile?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserProfile(profile: UserProfile)

    @Update
    suspend fun updateUserProfile(profile: UserProfile)
}