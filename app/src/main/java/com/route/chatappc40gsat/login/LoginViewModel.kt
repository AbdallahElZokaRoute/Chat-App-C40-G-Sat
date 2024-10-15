package com.route.chatappc40gsat.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.route.chatappc40gsat.BaseViewModel
import com.route.domain.usecase.auth.LoginUseCase
import com.route.domain.usecase.user.GetUserUseCase
import com.route.domain.usecase.user.SaveUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val getUser: GetUserUseCase
) : BaseViewModel() {
    val emailAddressState = mutableStateOf("")
    val emailAddressErrorState = mutableStateOf("")
    val passwordState = mutableStateOf("")
    val passwordErrorState = mutableStateOf("")
    val navigation = mutableStateOf<LoginNavigation>(LoginNavigation.Idle)
    fun validateFields(): Boolean {
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

    fun login() {
        viewModelScope.launch {
            if (validateFields()) {
                showLoading()
                loginUseCase(
                    email = emailAddressState.value,
                    password = passwordState.value,
                    onSuccess = { uid ->
                        getUserFromFirestore(uid)
                    }, onFailure = {
                        hideLoading()
                        showMessage(it.message ?: "")
                    })
            }
        }
    }

    fun getUserFromFirestore(uid: String) {
        viewModelScope.launch {
            getUser(uid, onSuccess = {
                Log.e("TAG", "getUserFromFirestore: $it")
                hideLoading()
                navigation.value = LoginNavigation.Home
            }, onFailure = {
                hideLoading()
                Log.e("TAG", "getUserFromFirestore: $it")
                showMessage(it.message ?: "")
            })
        }
    }
}
