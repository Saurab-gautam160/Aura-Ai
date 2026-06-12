package com.example.onboarding.data.local.entity



import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    private var db:
            AppDatabase? = null

    fun getDatabase(
        context: Context
    ): AppDatabase {

        return db ?: Room
            .databaseBuilder(
                context,
                AppDatabase::class.java,
                "aura_db"
            )
            .build()
            .also {

                db = it
            }
    }
}