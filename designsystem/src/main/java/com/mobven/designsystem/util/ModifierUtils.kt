package com.mobven.designsystem.util

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun Modifier.yummyPadding(
    start: Dp = 0.dp,
    end: Dp = 0.dp,
    top: Dp = 0.dp,
    bottom: Dp = 0.dp,
    horizontal: Dp? = null,
    vertical: Dp? = null
) = this.then(
    Modifier.padding(
        start = horizontal ?: start,
        top = vertical ?: top,
        end = horizontal ?: end,
        bottom = vertical ?: bottom
    )
)
