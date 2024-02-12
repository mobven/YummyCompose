package com.mobven.yummy.ui.screens.chat

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobven.components.R
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.components.common.YummyImage
import com.mobven.designsystem.components.toolbar.YummyToolbar
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.alert
import com.mobven.designsystem.theme.h2BoldStyle
import com.mobven.designsystem.theme.h3BoldStyle
import com.mobven.designsystem.theme.h3NormalStyle
import com.mobven.designsystem.theme.mainPrimary
import com.mobven.designsystem.theme.neutralGrayscale100
import com.mobven.designsystem.theme.neutralGrayscale30
import com.mobven.yummy.ui.theme.YummyComposeTheme
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun CallScreen() {

    var isCallActive by remember {
        mutableStateOf(true)
    }

    var timer by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(isCallActive) {
        while (isCallActive) {
            delay(1000)
            timer += 1000
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Header(
            title = "Call",
            onLeadingIconClick = {/* no-op */ }
        )
        Body(
            person = Person(
                name = "JackStauber",
                imgResId = com.mobven.yummy.R.drawable.planet
            ),
            timer = timer,
            isCallActive = isCallActive
        )
        Footer(
            endCallClicked = {
                isCallActive = false
            }
        )
    }
}

@Composable
private fun Header(
    title: String,
    onLeadingIconClick: () -> Unit
) {
    YummyToolbar(
        title = {
            Text(
                text = title,
                style = with(MaterialTheme) {
                    typography.h2BoldStyle.copy(color = colorScheme.neutralGrayscale100)
                }
            )
        },
        leadingIcon = {
            YummyIcon(
                painterRes = R.drawable.ic_arrow_left_with_frame,
                modifier = Modifier.clickable(onClick = onLeadingIconClick)
            )
        }
    )
}

@Composable
private fun ColumnScope.Body(
    person: Person,
    timer: Int,
    isCallActive: Boolean,
) {

    val timeFormat = SimpleDateFormat("mm:ss", Locale.getDefault())
    val circleColor = MaterialTheme.colorScheme.mainPrimary

    val infiniteTransition = rememberInfiniteTransition(label = "circle animation")

    val innerCircleAlpha by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 0.7f, animationSpec = infiniteRepeatable(
            animation = tween(CIRCLE_ANIMATION_DURATION, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "inner circle"
    )

    val middleCircleAlpha by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 0.3f, animationSpec = infiniteRepeatable(
            animation = tween(CIRCLE_ANIMATION_DURATION, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
            initialStartOffset = StartOffset(CIRCLE_ANIMATION_INITIAL_OFFSET),
        ),
        label = "middle circle"
    )

    val outerCircleAlpha by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 0.1f, animationSpec = infiniteRepeatable(
            animation = tween(CIRCLE_ANIMATION_DURATION, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
            initialStartOffset = StartOffset(CIRCLE_ANIMATION_DURATION),
        ),
        label = "outer circle"
    )

    Column(
        modifier = Modifier
            .weight(1f)
            .wrapContentHeight()
    ) {
        YummyImage(
            imgResId = person.imgResId,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 24.dp)
                .aspectRatio(1f)
                .drawWithContent {
                    if (isCallActive) {
                        drawCircle(
                            circleColor.copy(alpha = outerCircleAlpha),
                            radius = size.width / 2.1f,
                        )
                        drawCircle(
                            circleColor.copy(alpha = middleCircleAlpha),
                            radius = size.width / 4f + 48.dp.toPx(),
                        )
                        drawCircle(
                            circleColor.copy(alpha = innerCircleAlpha),
                            radius = size.width / 4f + 20.dp.toPx()
                        )
                    }
                    drawContent()
                })

        VerticalSpacer(height = 24.dp)

        Text(
            text = person.name, style = with(MaterialTheme) {
                typography.h3BoldStyle.copy(color = colorScheme.neutralGrayscale100)
            }, fontSize = 32.sp, modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        VerticalSpacer(height = 16.dp)

        Text(
            text = if (isCallActive) timeFormat.format(timer) else "The call has ended",
            style = with(MaterialTheme) {
                typography.h3NormalStyle.copy(color = colorScheme.neutralGrayscale100)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
private fun Footer(
    endCallClicked: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(
            space = 20.dp,
            alignment = Alignment.CenterHorizontally
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 48.dp)
    ) {
        YummyIcon(
            painterRes = R.drawable.ic_volume_up,
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.neutralGrayscale30)
                .padding(20.dp)
        )
        YummyIcon(
            painterRes = R.drawable.ic_voice,
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.neutralGrayscale30)
                .padding(20.dp)
        )
        YummyIcon(
            painterRes = R.drawable.ic_call_missed,
            tint = MaterialTheme.colorScheme.additionalWhite,
            modifier = Modifier
                .clip(CircleShape)
                .clickable(onClick = endCallClicked)
                .background(MaterialTheme.colorScheme.alert)
                .padding(20.dp)
        )
    }
}

data class Person(
    val name: String,
    @DrawableRes val imgResId: Int
)

private const val CIRCLE_ANIMATION_DURATION = 1800
private const val CIRCLE_ANIMATION_INITIAL_OFFSET = 1000

@Preview
@Composable
fun CallScreenPreview() {
    YummyComposeTheme {
        CallScreen()
    }
}