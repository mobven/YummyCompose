package com.mobven.components.common

import androidx.annotation.DrawableRes
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun YummyIcon(
    @DrawableRes painterRes: Int,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) {
    androidx.compose.material3.Icon(
        painter = painterResource(id = painterRes),
        contentDescription = null,
        tint = tint,
        modifier = modifier
    )
}