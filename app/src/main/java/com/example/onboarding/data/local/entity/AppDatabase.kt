package com.example.onboarding.data.local.entity



import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.onboarding.data.local.entity.dao.ChatDao

@Database(
    entities = [ChatMessage::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(
    Converters::class
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun chatDao(): ChatDao
}
