package com.route.data.dataSourceImpl.online

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.route.domain.repository.AuthOnlineDataSource
import kotlinx.coroutines.tasks.await

class AuthOnlineDataSourceImpl(
    private val auth: FirebaseAuth
) : AuthOnlineDataSource {
    override suspend fun login(
        email: String,
        password: String,
        onSuccess: (uid: String) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        try {
            val task = auth.signInWithEmailAndPassword(email, password).await()
            if (task.user != null) {
                onSuccess(task.user?.uid ?: "")
            }
        } catch (e: Exception) {
            Log.e("TAG", "login: ${e.message}")
            onFailure(e)
        }

    }

    override suspend fun register(
        email: String,
        password: String,
        onSuccess: (uid: String) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        try {
            val task = auth.createUserWithEmailAndPassword(email, password).await()
            if (task.user != null) {
                onSuccess(task.user?.uid ?: "")
            }
        } catch (e: Exception) {
            Log.e("TAG", "register: ${e.message}")
            onFailure(e)
        }
    }
}