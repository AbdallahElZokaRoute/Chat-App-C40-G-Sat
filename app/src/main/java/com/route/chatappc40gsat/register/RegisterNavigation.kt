package com.route.chatappc40gsat.register

sealed interface RegisterNavigation {
    data object Idle : RegisterNavigation
    data object NavigateUp : RegisterNavigation
    data object Home : RegisterNavigation
}