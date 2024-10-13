package com.route.domain.usecase

import com.route.domain.repository.AuthRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String,
        onSuccess: (uid: String) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        repository.register(email, password, onSuccess, onFailure)
    }
}