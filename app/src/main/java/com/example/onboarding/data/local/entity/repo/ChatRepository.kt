package com.example.onboarding.data.local.entity.repo

import com.example.onboarding.data.local.entity.dao.ChatDao




import com.example.onboarding.data.local.entity.ChatMessage

class ChatRepository(
    private val dao: ChatDao
) {

    suspend fun saveMessage(
        sender: String,
        message: String
    ) {

        dao.insert(

            ChatMessage(
                sender = sender,
                message = message,
                timestamp =
                    System.currentTimeMillis()
            )
        )
    }

    suspend fun loadPage(
        page: Int
    ): List<ChatMessage> {

        return dao.getMessages(
            limit = 20,
            offset = page * 20
        )
    }

    fun observeMessages() =
        dao.observeMessages()
}