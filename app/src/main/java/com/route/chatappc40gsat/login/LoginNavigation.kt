package com.route.chatappc40gsat.login

sealed interface LoginNavigation {
    data object Idle : LoginNavigation
    data object Register : LoginNavigation
    data object Home : LoginNavigation
}