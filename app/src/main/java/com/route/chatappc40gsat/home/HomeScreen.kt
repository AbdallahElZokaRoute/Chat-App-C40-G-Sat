package com.route.chatappc40gsat.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.route.chatappc40gsat.R
import com.route.chatappc40gsat.destinations.Destination


@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Destination.CreateNewRoom) }) {
                Image(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = stringResource(
                        R.string.add_room_button
                    )
                )
            }
        }
    ) { innerPadding ->
        innerPadding
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(painterResource(id = R.drawable.bg), contentScale = ContentScale.Crop)
        ) {

        }

    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
