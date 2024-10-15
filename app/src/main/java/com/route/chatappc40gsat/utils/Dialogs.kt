package com.route.chatappc40gsat.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.route.chatappc40gsat.R
import com.route.chatappc40gsat.ui.theme.bluePrimaryColor


@Composable
fun ErrorDialog(message: MutableState<String>, modifier: Modifier = Modifier) {
    if (message.value.isNotEmpty())
        AlertDialog(onDismissRequest = { message.value = "" }, confirmButton = {
            TextButton(onClick = { message.value = "" }) {
                Text(text = stringResource(id = R.string.ok), color = bluePrimaryColor)
            }
        }, text = {
            Text(text = message.value)
        })
}

@Composable
fun LoadingDialog(showLoading: MutableState<Boolean>, modifier: Modifier = Modifier) {
    if (showLoading.value) {
        Dialog(onDismissRequest = { showLoading.value = false }) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.White, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = bluePrimaryColor)
            }
        }
    }
}
