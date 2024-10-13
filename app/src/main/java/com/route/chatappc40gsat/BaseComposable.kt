package com.route.chatappc40gsat

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
inline fun <reified VM : BaseViewModel> BaseComposableScreen(content: @Composable (VM) -> Unit) {
    val viewModel: VM = hiltViewModel()
    content(viewModel)

}
