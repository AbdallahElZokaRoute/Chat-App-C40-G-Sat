package com.route.domain.usecase

import com.route.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String,
        onSuccess: (uid: String) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        repository.login(email, password, onSuccess, onFailure)
    }
}