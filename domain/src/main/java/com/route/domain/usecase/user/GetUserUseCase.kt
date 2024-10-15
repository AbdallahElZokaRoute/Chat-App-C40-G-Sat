package com.route.domain.usecase.user

import com.route.domain.entity.AppUser
import com.route.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(
        userId: String,
        onSuccess: (appUser: AppUser) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        return repository.getUser(userId, onSuccess, onFailure)

    }
}
