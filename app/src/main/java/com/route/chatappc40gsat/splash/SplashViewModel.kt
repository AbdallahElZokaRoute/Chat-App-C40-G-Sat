package com.route.chatappc40gsat.splash

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.route.domain.entity.AppUser
import com.route.domain.usecase.user.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    val navigator = mutableStateOf<SplashDestination>(SplashDestination.Idle)
    fun navigate() {
        val user = Firebase.auth.currentUser
        if (user != null) {
            viewModelScope.launch {
                getUserUseCase(user.uid, onSuccess = {
                    navigator.value = SplashDestination.Home
                }, onFailure = {
                    Log.e("TAG", "navigate: $it")
                    navigator.value = SplashDestination.Login
                })
            }

        } else {
            navigator.value = SplashDestination.Login
        }
    }

}
