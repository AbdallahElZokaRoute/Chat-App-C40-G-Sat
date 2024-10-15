package com.route.domain.repository

import com.route.domain.entity.AppUser


interface UserRepository {
    suspend fun getUser(
        uid: String,
        onSuccess: (appUser: AppUser) -> Unit,
        onFailure: (Throwable) -> Unit
    )

    suspend fun saveUser(appUser: AppUser, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit)
}

interface UserOnlineDataSource {
    suspend fun getUser(
        uid: String,
        onSuccess: (appUser: AppUser) -> Unit,
        onFailure: (Throwable) -> Unit
    )

    suspend fun saveUser(appUser: AppUser, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit)
}
