package com.mobven.designsystem.components.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.theme.h3SemiBoldStyle
import com.mobven.designsystem.theme.neutralGrayscale100

@Composable
fun LocationText(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Icon(
            painterResource(id = R.drawable.ic_location),
            contentDescription = "Location icon",
            modifier = Modifier.padding(horizontal = 10.dp)
        )

        Text(
            text = "NYC, Broadway ave 79",
            style = MaterialTheme.typography.h3SemiBoldStyle,
            color = MaterialTheme.colorScheme.neutralGrayscale100
        )
    }
}