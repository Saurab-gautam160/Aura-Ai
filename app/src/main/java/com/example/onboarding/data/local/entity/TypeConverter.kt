package com.example.onboarding.data.local.entity


import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromMeta(
        meta: MessageMeta
    ): String {

        return "${meta.isRead},${meta.isSynced}"
    }

    @TypeConverter
    fun toMeta(
        value: String
    ): MessageMeta {

        val parts =
            value.split(",")

        return MessageMeta(
            isRead =
                parts[0].toBoolean(),

            isSynced =
                parts[1].toBoolean()
        )
    }
}