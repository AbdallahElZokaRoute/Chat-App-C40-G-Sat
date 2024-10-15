package com.route.chatappc40gsat.register

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.route.chatappc40gsat.BaseViewModel
import com.route.domain.entity.AppUser
import com.route.domain.usecase.auth.RegisterUseCase
import com.route.domain.usecase.user.SaveUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val saveUser: SaveUserUseCase,
) : BaseViewModel() {
    val emailAddressState = mutableStateOf("")
    val emailAddressErrorState = mutableStateOf("")
    val passwordState = mutableStateOf("")
    val passwordErrorState = mutableStateOf("")
    val fullNameState = mutableStateOf("")
    val fullNameErrorState = mutableStateOf("")
    val navigation = mutableStateOf<RegisterNavigation>(RegisterNavigation.Idle)
    fun validateFields(): Boolean {
        if (fullNameState.value.isEmpty()) {
            fullNameErrorState.value = "Required"
            return false
        } else
            fullNameErrorState.value = ""
        if (emailAddressState.value.isEmpty()) {
            emailAddressErrorState.value = "Required"
            return false
        } else {
            emailAddressErrorState.value = ""
        }
        if (passwordState.value.isEmpty()) {
            passwordErrorState.value = "Required"
            return false
        } else {
            passwordErrorState.value = ""
        }


        return true
    }

    fun navigateUp() {
        navigation.value = RegisterNavigation.NavigateUp
    }

    fun navigateToHome() {
        navigation.value = RegisterNavigation.Home
    }

    fun register() {
        viewModelScope.launch {
            if (validateFields()) {
                showLoading()
                registerUseCase(email = emailAddressState.value, password = passwordState.value,
                    onSuccess = { uid ->
                        saveUserToFireStore(
                            AppUser(
                                fullName = fullNameState.value,
                                email = emailAddressState.value,
                                uid = uid
                            )
                        )
                    }, onFailure = {
                        hideLoading()
                        showMessage(it.message ?: "")
                    }
                )
            }
        }
    }

    private fun saveUserToFireStore(appUser: AppUser) {
        viewModelScope.launch {
            saveUser(appUser, onSuccess = {
                hideLoading()
                navigateToHome()
            }, onFailure = {
                hideLoading()
                showMessage(it.message ?: "")
            })
        }
    }

}
