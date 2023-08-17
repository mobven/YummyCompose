package com.mobven.designsystem.components.cards

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.YummyImage
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h1BoldStyle
import com.mobven.designsystem.theme.h5SemiBoldStyle
import com.mobven.designsystem.theme.mainPrimary
import com.mobven.designsystem.theme.mainSecondary
import com.mobven.designsystem.theme.neutralGrayscale40
import com.mobven.designsystem.theme.neutralGrayscale90
import com.mobven.designsystem.theme.semanticSuccess
import kotlinx.coroutines.delay

@Composable
fun PagerCard(
    items: List<PagerCardItem>,
    modifier: Modifier = Modifier,
    isAutomaticSwipeEnable: Boolean = true,
) {
    val colorScheme = MaterialTheme.colorScheme
    var page by rememberSaveable {
        mutableStateOf(0)
    }
    var swipeDirection by remember {
        mutableStateOf(SwipeDirection.UNSPECIFIED)
    }
    var isSwiping by remember {
        mutableStateOf(false)
    }
    val selectedItem by remember(page) {
        mutableStateOf(items[page])
    }

    LaunchedEffect(isSwiping) {
        if (isSwiping) {
            page = when (swipeDirection) {
                SwipeDirection.RIGHT -> if (page > 0) page - 1 else items.lastIndex
                SwipeDirection.LEFT -> if (page < items.lastIndex) page + 1 else 0
                SwipeDirection.UNSPECIFIED -> page
            }
        }
    }

    if (isAutomaticSwipeEnable) {
        LaunchedEffect(Unit) {
            while (true) {
                delay(3000)
                page = if (page < items.lastIndex) page + 1 else 0
            }
        }
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .pointerInput(Unit) {
                detectDragGestures(onDragStart = {
                    isSwiping = true
                }, onDragEnd = {
                    isSwiping = false
                }) { change, dragAmount ->
                    change.consume()
                    swipeDirection = when {
                        dragAmount.x.toInt() > 1 -> SwipeDirection.RIGHT
                        dragAmount.x.toInt() < -1 -> SwipeDirection.LEFT
                        else -> SwipeDirection.UNSPECIFIED
                    }
                }
            }
    ) {
        YummyImage(
            imgResId = selectedItem.img,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .fillMaxSize()
                .drawBehind {
                    val path = Path().apply {
                        lineTo(size.width / 2.2f, 0f)
                        lineTo(size.width / 1.5f, size.height)
                        lineTo(0.0f, size.height)
                        close()
                    }
                    drawPath(path, selectedItem.backgroundColor)
                }
        ) {
            Column(
                Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items.forEachIndexed { index, _ ->
                        Box(
                            modifier = Modifier
                                .height(4.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .weight(1f)
                                .background(
                                    if (page == index) colorScheme.additionalWhite
                                    else colorScheme.neutralGrayscale40
                                )
                        )
                    }
                }
            }
        }
        Column(
            modifier.padding(start = 24.dp)
        ) {
            VerticalSpacer(height = 24.dp)
            Text(
                text = selectedItem.title,
                style = MaterialTheme.typography.h1BoldStyle,
                color = colorScheme.additionalWhite
            )
            VerticalSpacer(height = 16.dp)
            Text(
                text = selectedItem.subTitle,
                style = MaterialTheme.typography.h5SemiBoldStyle,
                color = colorScheme.additionalWhite
            )
        }
    }
}


enum class SwipeDirection {
    UNSPECIFIED, RIGHT, LEFT
}

data class PagerCardItem(
    @DrawableRes val img: Int, val title: String, val subTitle: String, val backgroundColor: Color
)

@Preview
@Composable
fun PagerCardPreview() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        PagerCard(
            items = listOf(
                PagerCardItem(
                    img = R.drawable.dummy_food,
                    title = "WHAT TO \nEAT TODAY",
                    subTitle = "shop up to 50% off",
                    backgroundColor = MaterialTheme.colorScheme.mainPrimary
                ), PagerCardItem(
                    img = R.drawable.yummy_big_card,
                    title = "TURKISH \nKEBAB",
                    subTitle = "shop up to 20% off",
                    backgroundColor = MaterialTheme.colorScheme.semanticSuccess
                ), PagerCardItem(
                    img = R.drawable.card_three,
                    title = "Fresh \nArtichoke",
                    subTitle = "sale %30",
                    backgroundColor = MaterialTheme.colorScheme.mainSecondary
                ), PagerCardItem(
                    img = R.drawable.card_one_image,
                    title = "Yummy \nFood",
                    subTitle = "sale 5%",
                    backgroundColor = MaterialTheme.colorScheme.neutralGrayscale90
                )
            ),
            isAutomaticSwipeEnable = true, modifier = Modifier
                .height(148.dp)
                .fillMaxWidth()
        )
    }
}