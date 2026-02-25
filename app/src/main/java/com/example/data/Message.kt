package com.example.data

import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class Message(
    val senderId: String = "",
    val senderFirstName: String = "",
    val text: String = "",
    @ServerTimestamp
    val timestamp: Date? = null,
    val isSentByCurrentUser: Boolean = false
)

sealed class AppResult<out T> {
    data class Success<out T>(val data: T) : AppResult<T>()
    data class Error(val exception: Exception) : AppResult<Nothing>()
}