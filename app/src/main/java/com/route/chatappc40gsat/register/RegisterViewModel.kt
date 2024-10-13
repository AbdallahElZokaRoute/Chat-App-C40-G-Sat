package com.route.chatappc40gsat.register

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.chatappc40gsat.BaseViewModel
import com.route.domain.usecase.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
) : BaseViewModel() {
    val emailAddressState = mutableStateOf("")
    val emailAddressErrorState = mutableStateOf<String?>(null)
    val passwordState = mutableStateOf("")
    val passwordErrorState = mutableStateOf<String?>(null)
    val fullNameState = mutableStateOf("")
    val fullNameErrorState = mutableStateOf<String?>(null)

    fun validateFields(): Boolean {
        if (fullNameState.value.isEmpty()) {
            fullNameErrorState.value = "Required"
            return false
        } else
            fullNameErrorState.value = null
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

    fun register() {
        viewModelScope.launch {
            if (validateFields()) {
                showLoading()
                registerUseCase(email = emailAddressState.value, password = passwordState.value,
                    onSuccess = {

                    }, onFailure = {
                        showMessage(it.message ?: "")
                    }
                )
            }
        }
    }
}
