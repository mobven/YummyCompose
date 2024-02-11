package com.mobven.yummy.ui.screens.chat

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.components.toolbar.YummyToolbar
import com.mobven.designsystem.theme.h2BoldStyle
import com.mobven.designsystem.theme.neutralGrayscale100

@Composable
fun ChatScreen() {
    Column {
        YummyToolbar(
            title = {
                Text(
                    text = "Message", style = MaterialTheme.typography.h2BoldStyle
                        .copy(color = MaterialTheme.colorScheme.neutralGrayscale100)
                )
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                YummyIcon(
                    painterRes = com.mobven.components.R.drawable.ic_arrow_left,
                    modifier = Modifier.clickable {
                        /* no-op */
                    }
                )
            },
            trailingIcon = {

            }
        )
    }
}

@Preview
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}