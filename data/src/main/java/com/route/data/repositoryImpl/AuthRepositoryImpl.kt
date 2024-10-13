package com.route.data.repositoryImpl

import com.route.domain.repository.AuthOnlineDataSource
import com.route.domain.repository.AuthRepository

class AuthRepositoryImpl(private val onlineDataSource: AuthOnlineDataSource) : AuthRepository {
    override suspend fun login(
        email: String,
        password: String,
        onSuccess: (uid: String) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        onlineDataSource.login(email, password, onSuccess, onFailure)
    }

    override suspend fun register(
        email: String,
        password: String,
        onSuccess: (uid: String) -> Unit,
        onFailure: (throwable: Throwable) -> Unit
    ) {
        onlineDataSource.register(email, password, onSuccess, onFailure)
    }
}