package com.route.chatappc40gsat.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.route.chatappc40gsat.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthChatToolbar(
    modifier: Modifier = Modifier,
    text: String,
    isBackEnabled: Boolean = false,
    navController: NavController
) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = text)
        },
        modifier = modifier.fillMaxWidth(),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ), navigationIcon = {
            if (isBackEnabled) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = stringResource(
                        R.string.back_icon,
                    ), modifier = Modifier.clickable {
                        navController.navigateUp()
                    }
                )
            }

        }
    )

}

@Preview
@Composable
private fun AuthChatToolbarPreview() {
    AuthChatToolbar(text = "Login", isBackEnabled = true, navController = rememberNavController())
}
