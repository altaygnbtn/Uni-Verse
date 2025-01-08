package com.altaygunbatan.uni_verse.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.altaygunbatan.uni_verse.dataClasses.Event
import com.altaygunbatan.uni_verse.dataClasses.UserProfile


@Database(entities = [Event::class, UserProfile::class], version = 9) // Increment version
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
    abstract fun userProfileDao(): UserProfileDao // Add DAO for UserProfile

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}