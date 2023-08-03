package com.mobven.components.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun YummyImage(
    @DrawableRes imgResId: Int,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.None
) {
    Image(
        painter = painterResource(id = imgResId),
        contentDescription = null,
        contentScale = contentScale,
        modifier = modifier
    )
}