package com.route.chatappc40gsat

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val showLoadingState = mutableStateOf(false)
    val messageState = mutableStateOf("")

    fun showLoading() {
        showLoadingState.value = true
    }

    fun hideLoading() {
        showLoadingState.value = false
    }

    fun showMessage(message: String) {
        messageState.value = message
    }

    fun hideMessage() {
        messageState.value = ""
    }
}