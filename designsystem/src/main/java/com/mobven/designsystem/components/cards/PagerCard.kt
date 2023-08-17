package com.mobven.designsystem.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h1BoldStyle
import com.mobven.designsystem.theme.h5SemiBoldStyle
import com.mobven.designsystem.theme.mainPrimary

@Composable
fun PagerCard(
    image: ImageBitmap,
    modifier: Modifier = Modifier,
) {
    val colorScheme = MaterialTheme.colorScheme
    var page by remember {
        mutableStateOf(0)
    }
    var swipeDirection by remember {
        mutableStateOf(SwipeDirection.UNSPECIFIED)
    }
    var isSwiping by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(isSwiping) {
        if (isSwiping) {
            page = when (swipeDirection) {
                SwipeDirection.RIGHT -> page - 1
                SwipeDirection.LEFT -> page + 1
                SwipeDirection.UNSPECIFIED -> page
            }
            println(page)
        }
    }

    Box(
        modifier = modifier
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = {
                        isSwiping = true
                    },
                    onDragEnd = {
                        isSwiping = false
                    }
                ) { change, dragAmount ->
                    change.consume()
                    swipeDirection = when {
                        dragAmount.x.toInt() > 1 -> SwipeDirection.RIGHT
                        dragAmount.x.toInt() < -1 -> SwipeDirection.LEFT
                        else -> SwipeDirection.UNSPECIFIED
                    }
                }
            }
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .drawBehind {
                drawImage(
                    image,
                    dstSize = IntSize(width = size.width.toInt(), height = size.height.toInt())
                )
            }
            .drawBehind {
                val path = Path().apply {
                    lineTo(size.width / 2.2f, 0f)
                    lineTo(size.width / 1.5f, size.height)
                    lineTo(0.0f, size.height)
                    close()
                }
                drawPath(path, colorScheme.mainPrimary)
            }
    ) {
        Column(
            Modifier.padding(start = 24.dp, top = 24.dp)
        ) {
            Text(
                text = "WHAT TO \nEAT TODAY",
                style = MaterialTheme.typography.h1BoldStyle,
                color = colorScheme.additionalWhite
            )
            VerticalSpacer(height = 16.dp)
            Text(
                text = "shop up to 50% off",
                style = MaterialTheme.typography.h5SemiBoldStyle,
                color = colorScheme.additionalWhite
            )
        }
    }
}

enum class SwipeDirection {
    UNSPECIFIED,
    RIGHT,
    LEFT
}

@Preview
@Composable
fun PagerCardPreview() {
    PagerCard(
        image = ImageBitmap.imageResource(id = R.drawable.dummy_food),
        modifier = Modifier
            .height(148.dp)
            .fillMaxWidth()
    )
}