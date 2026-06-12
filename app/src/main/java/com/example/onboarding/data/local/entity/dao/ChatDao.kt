package com.example.onboarding.data.local.entity.dao



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.onboarding.data.local.entity.ChatMessage
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatDao {

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun insert(
        message: ChatMessage
    )

    @Query(
        """
        SELECT *
        FROM chat_messages
        ORDER BY timestamp DESC
        LIMIT :limit
        OFFSET :offset
        """
    )
    suspend fun getMessages(
        limit: Int,
        offset: Int
    ): List<ChatMessage>

    @Query(
        """
        SELECT *
        FROM chat_messages
        ORDER BY timestamp DESC
        """
    )
    fun observeMessages():
            Flow<List<ChatMessage>>
}