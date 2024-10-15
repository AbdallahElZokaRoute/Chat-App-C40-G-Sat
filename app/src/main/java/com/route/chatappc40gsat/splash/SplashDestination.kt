package com.route.chatappc40gsat.splash

sealed interface SplashDestination {
    data object Idle : SplashDestination
    data object Login : SplashDestination
    data object Home : SplashDestination

}