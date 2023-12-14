package com.mobven.designsystem.components.text

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobven.designsystem.theme.h3MediumStyle
import com.mobven.designsystem.theme.h3SemiBoldStyle
import com.mobven.designsystem.theme.mainPrimary
import com.mobven.designsystem.theme.neutralGrayscale100

@Composable
fun KeyValueText(
    key: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = key,
            style = MaterialTheme.typography.h3MediumStyle,
            color = MaterialTheme.colorScheme.neutralGrayscale100,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = ":",
            style = MaterialTheme.typography.h3MediumStyle,
            color = MaterialTheme.colorScheme.neutralGrayscale100
        )

        Text(
            text = value,
            style = MaterialTheme.typography.h3SemiBoldStyle,
            color = MaterialTheme.colorScheme.mainPrimary,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
