package com.route.chatappc40gsat.login

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.route.chatappc40gsat.BaseComposableScreen
import com.route.chatappc40gsat.R
import com.route.chatappc40gsat.destinations.Destination
import com.route.chatappc40gsat.utils.AuthChatToolbar
import com.route.chatappc40gsat.utils.AuthTextField
import com.route.chatappc40gsat.utils.ChatButton

@Composable
fun LoginScreen(
    navController:
    NavController,
    modifier: Modifier = Modifier,
) {
    BaseComposableScreen<LoginViewModel> { viewModel ->


        Scaffold(topBar = {
            AuthChatToolbar(text = stringResource(R.string.login), navController = navController)
        }) { innerPadding ->
            innerPadding
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        painterResource(
                            id = R.drawable.bg
                        ),
                        contentScale = ContentScale.Crop
                    )
                    .padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.fillMaxHeight(0.3F))
                Text(
                    text = stringResource(R.string.welcome_back),
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(6.dp)
                        .padding(start = 10.dp)
                        .align(Alignment.Start)
                )
                AuthTextField(
                    state = viewModel.emailAddressState,
                    label = stringResource(id = R.string.email),
                    error = viewModel.emailAddressErrorState.value ?: "",
                )
                Spacer(modifier = Modifier.height(8.dp))
                AuthTextField(
                    state = viewModel.passwordState,
                    label = stringResource(id = R.string.password),
                    error = viewModel.passwordErrorState.value ?: ""
                )
                Spacer(modifier = Modifier.padding(8.dp))
                ChatButton(text = stringResource(id = R.string.login)) {

                }
                Text(
                    text = stringResource(R.string.register),
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp)
                        .align(Alignment.Start)
                        .clickable {
                            navController.navigate(Destination.Register)
                        }
                )

            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}
