package com.route.chatappc40gsat.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.route.chatappc40gsat.R
import com.route.chatappc40gsat.ui.theme.bluePrimaryColor

@Composable
fun ChatButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = bluePrimaryColor,
            contentColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth(0.85F),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = text, modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.weight(1F))
        Image(
            painter = painterResource(id = R.drawable.ic_arrow_forward),
            contentDescription = stringResource(
                R.string.icon_forward
            )
        )
    }
}
