package com.example.data

import com.example.screen.Room
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class RoomRepository(private val firestore: FirebaseFirestore) {

    suspend fun createRoom(name: String): AppResult<Unit> = try {
        val room = Room(name = name)
        firestore.collection("rooms").add(room).await()
        AppResult.Success(Unit)
    } catch (e: Exception) {
        AppResult.Error(e)
    }

    suspend fun getRooms(): AppResult<List<Room>> = try {
        val querySnapshot = firestore.collection("rooms").get().await()
        val rooms = querySnapshot.documents.map { document ->
            document.toObject(Room::class.java)!!.copy(id = document.id)
        }
        AppResult.Success(rooms)
    } catch (e: Exception) {
        AppResult.Error(e)
    }
}