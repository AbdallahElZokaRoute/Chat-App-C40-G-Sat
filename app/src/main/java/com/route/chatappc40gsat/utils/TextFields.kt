package com.route.chatappc40gsat.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.route.chatappc40gsat.R
import com.route.chatappc40gsat.ui.theme.bluePrimaryColor
import com.route.chatappc40gsat.ui.theme.lightGrey

@Composable
fun AuthTextField(
    state: MutableState<String>,
    label: String,
    error: String,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxWidth(0.85F)) {
        TextField(
            value = state.value,
            onValueChange = { newText ->
                state.value = newText
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = label)
            },
            isError = error.trim().isNotEmpty(),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = bluePrimaryColor,
                unfocusedIndicatorColor = lightGrey,
                errorIndicatorColor = Color.Red,
                unfocusedTextColor = Color.Black,
                focusedTextColor = Color.Black,
                errorTextColor = Color.Black,
                focusedContainerColor = Color.Transparent,
                errorContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent
            )
        )
        if (error.isNotEmpty())
            Text(text = error, color = Color.Red)

    }
}

@Preview
@Composable
private fun AuthTextFieldPreview() {
    val state = remember {
        mutableStateOf("ahmed@gmail.com")
    }
    AuthTextField(state, stringResource(R.string.email), "")
}
