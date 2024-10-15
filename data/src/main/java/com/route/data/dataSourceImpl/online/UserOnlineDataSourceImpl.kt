package com.route.data.dataSourceImpl.online

import com.google.firebase.firestore.FirebaseFirestore
import com.route.domain.entity.AppUser
import com.route.domain.repository.UserOnlineDataSource
import kotlinx.coroutines.tasks.await

class UserOnlineDataSourceImpl(private val firestore: FirebaseFirestore) : UserOnlineDataSource {
    override suspend fun getUser(
        uid: String,
        onSuccess: (appUser: AppUser) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        try {
            val response = firestore.collection(AppUser.COLLECTION_NAME).document(uid).get()
                .await()
            val user = response.toObject(AppUser::class.java)
            if (user != null)
                onSuccess(user)
            else
                onFailure(Exception("User == Null"))
        } catch (e: Exception) {
            onFailure(e)
        }
    }

    override suspend fun saveUser(
        appUser: AppUser,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        try {
            if (appUser.uid != null) {
                val response =
                    firestore.collection(AppUser.COLLECTION_NAME).document(appUser.uid!!)
                        .set(appUser)
                onSuccess()
            } else
                onFailure(Exception("UID == null"))

        } catch (e: Exception) {
            onFailure(e)
        }
    }
}
