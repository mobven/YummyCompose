package com.mobven.designsystem.components.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.mobven.components.R

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

@Composable
fun YummyAsyncImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentDesc: String = "",
    placeholder: Painter = painterResource(id = R.drawable.ic_image),
    contentScaleType: ContentScale = ContentScale.None
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDesc,
        modifier = modifier,
        placeholder = placeholder,
        contentScale = contentScaleType
    )
}