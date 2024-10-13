package com.route.domain.repository

interface AuthRepository {
    suspend fun login(
        email: String,
        password: String,
        onSuccess: (uid: String) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    )

    suspend fun register(
        email: String,
        password: String,
        onSuccess: (uid: String) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    )
}

interface AuthOnlineDataSource {
    suspend fun login(
        email: String,
        password: String,
        onSuccess: (uid: String) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    )

    suspend fun register(
        email: String,
        password: String,
        onSuccess: (uid: String) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    )
}
