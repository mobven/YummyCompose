package com.mobven.designsystem.components.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobven.designsystem.theme.h3SemiBoldStyle
import com.mobven.designsystem.theme.neutralGrayscale100

@Composable
fun TextWithIcon(
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    text: String,
) {
    Row(
        modifier = modifier
    ) {
        leadingIcon?.invoke()

        Text(
            text = text,
            style = MaterialTheme.typography.h3SemiBoldStyle,
            color = MaterialTheme.colorScheme.neutralGrayscale100,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
    }
}