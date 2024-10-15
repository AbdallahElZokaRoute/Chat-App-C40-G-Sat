package com.route.domain.usecase.user

import com.route.domain.entity.AppUser
import com.route.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(
        user: AppUser,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        return repository.saveUser(user, onSuccess, onFailure)

    }
}
