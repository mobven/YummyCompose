package com.mobven.components.buttons

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobven.components.R
import com.mobven.components.common.YummyImage

@Composable
fun TinyCounterButton(
    multiplier: Int
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(32.dp)
            .border(1.dp, Color(0xFFBFC6CC), CircleShape)
    ) {
        Text(
            text = "${multiplier}x",
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 20.sp
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SmallCounterButton(
    counterValue: Int,
    onCounterChanged: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .size(96.dp, 32.dp)
            .border(1.dp, Color(0xFF9CA4AB), RoundedCornerShape(24.dp))
            .padding(vertical = 8.dp, horizontal = 12.dp),
    ) {
        YummyImage(imgResId = R.drawable.ic_minus, modifier = Modifier
            .clip(CircleShape)
            .clickable {
                onCounterChanged(counterValue - 1)
            })
        AnimatedContent(
            targetState = counterValue,
            transitionSpec = {
                if (targetState > initialState) {
                    slideInVertically { height -> height } + fadeIn() with
                            slideOutVertically { height -> -height } + fadeOut()
                } else {
                    slideInVertically { height -> -height } + fadeIn() with
                            slideOutVertically { height -> height } + fadeOut()
                }.using(
                    SizeTransform(clip = false)
                )
            }, label = ""
        ) { targetCount ->
            Text(
                text = if (targetCount in 1..9) "0$targetCount" else targetCount.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                lineHeight = 24.sp
            )
        }
        YummyImage(imgResId = R.drawable.ic_plus, modifier = Modifier
            .clip(CircleShape)
            .clickable {
                onCounterChanged(counterValue + 1)
            })
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BigCounterButton(
    counterValue: Int,
    onCounterChanged: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .size(112.dp, 40.dp)
            .border(1.dp, Color(0xFF9CA4AB), RoundedCornerShape(24.dp))
            .padding(vertical = 8.dp, horizontal = 12.dp),
    ) {
        YummyImage(imgResId = R.drawable.ic_minus, modifier = Modifier
            .clip(CircleShape)
            .clickable {
                onCounterChanged(counterValue - 1)
            })
        AnimatedContent(
            targetState = counterValue,
            transitionSpec = {
                if (targetState > initialState) {
                    slideInVertically { height -> height } + fadeIn() with
                            slideOutVertically { height -> -height } + fadeOut()
                } else {
                    slideInVertically { height -> -height } + fadeIn() with
                            slideOutVertically { height -> height } + fadeOut()
                }.using(
                    SizeTransform(clip = false)
                )
            }, label = ""
        ) { targetCount ->
            Text(
                text = if (targetCount in 1..9) "0$targetCount" else targetCount.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                lineHeight = 24.sp
            )
        }
        YummyImage(imgResId = R.drawable.ic_plus, modifier = Modifier
            .clip(CircleShape)
            .clickable {
                onCounterChanged(counterValue + 1)
            })
    }
}

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun TinyCounterButtonPreview() {
    TinyCounterButton(multiplier = 1)
}

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun SmallCounterButtonPreview() {
    var counterValue by remember {
        mutableStateOf(0)
    }
    SmallCounterButton(counterValue) {
        counterValue = it
    }
}

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun BigCounterButtonPreview() {
    var counterValue by remember {
        mutableStateOf(0)
    }
    BigCounterButton(counterValue) {
        counterValue = it
    }
}