package com.route.data.repositoryImpl

import com.route.domain.entity.AppUser
import com.route.domain.repository.UserOnlineDataSource
import com.route.domain.repository.UserRepository

class UserRepositoryImpl(private val onlineDataSource: UserOnlineDataSource) : UserRepository {
    override suspend fun getUser(
        uid: String,
        onSuccess: (appUser: AppUser) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        onlineDataSource.getUser(uid, onSuccess, onFailure)
    }

    override suspend fun saveUser(
        appUser: AppUser,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        onlineDataSource.saveUser(appUser, onSuccess, onFailure)
    }


}