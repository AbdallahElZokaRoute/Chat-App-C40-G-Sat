package com.route.chatappc40gsat.destinations

import kotlinx.serialization.Serializable

@Serializable
sealed interface Destination {
    @Serializable
    data object Splash : Destination

    @Serializable
    data object Login : Destination

    @Serializable
    data object Register : Destination

    @Serializable
    data object Home : Destination

    @Serializable
    data object CreateNewRoom : Destination
}
