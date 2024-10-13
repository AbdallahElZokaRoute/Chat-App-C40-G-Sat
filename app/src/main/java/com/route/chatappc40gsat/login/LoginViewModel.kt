package com.route.chatappc40gsat.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.route.chatappc40gsat.BaseViewModel
import com.route.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {
    val emailAddressState = mutableStateOf("")
    val emailAddressErrorState = mutableStateOf<String?>(null)
    val passwordState = mutableStateOf("")
    val passwordErrorState = mutableStateOf<String?>(null)

    fun validateFields(): Boolean {
        if (emailAddressState.value.isEmpty()) {
            emailAddressErrorState.value = "Required"
            return false
        } else {
            emailAddressErrorState.value = null
        }
        if (passwordState.value.isEmpty()) {
            passwordErrorState.value = "Required"
            return false
        } else {
            passwordErrorState.value = null
        }
        return true
    }

    fun login() {
        viewModelScope.launch {
            if (validateFields()) {
                showLoading()
                loginUseCase(
                    email = emailAddressState.value,
                    password = passwordState.value,
                    onSuccess = {

                    }, onFailure = {
                        showMessage(it.message ?: "")
                    })
            }
        }
    }

}
