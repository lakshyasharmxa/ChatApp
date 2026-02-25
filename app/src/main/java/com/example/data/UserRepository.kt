package com.example.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import com.example.data.AppResult


data class User(
    val uid: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val email: String = ""
)

class UserRepository(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) {
    suspend fun signUp(
        email: String,
        password: String,
        firstName: String,
        lastName: String
    ): AppResult<Boolean> =
        try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val firebaseUser = result.user
            if (firebaseUser != null) {
                val user = User(
                    uid = firebaseUser.uid,
                    firstName = firstName,
                    lastName = lastName,
                    email = email
                )
                saveUserToFirestore(user)
                AppResult.Success(true)
            } else {
                AppResult.Error(Exception("User creation failed"))
            }
        } catch (e: Exception) {
            AppResult.Error(e)
        }

    suspend fun login(email: String, password: String): AppResult<Boolean> =
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            AppResult.Success(true)
        } catch (e: Exception) {
            AppResult.Error(e)
        }

    private suspend fun saveUserToFirestore(user: User) {
        firestore.collection("users")
            .document(user.uid)
            .set(user)
            .await()
    }
    suspend fun getCurrentUser(): AppResult<User> {
        return try {
            val firebaseUser = auth.currentUser
            if (firebaseUser != null) {
                val user = User(
                    email = firebaseUser.email ?: "",
                    firstName = firebaseUser.displayName ?: ""
                )
                AppResult.Success(user)
            } else {
                AppResult.Error(Exception("User not logged in"))
            }
        } catch (e: Exception) {
            AppResult.Error(e)
        }
    }
}
