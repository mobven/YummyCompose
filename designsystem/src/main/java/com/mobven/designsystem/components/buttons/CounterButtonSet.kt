package com.mobven.designsystem.components.buttons

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.theme.additionalDark
import com.mobven.designsystem.theme.h5SemiBoldStyle
import com.mobven.designsystem.theme.neutralGrayscale50
import com.mobven.designsystem.theme.neutralGrayscale80

@Composable
fun CircularCounterButton(
    multiplier: Int,
    onClick: (Int) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(32.dp)
            .border(1.dp, MaterialTheme.colorScheme.neutralGrayscale50, CircleShape)
            .clip(CircleShape)
            .clickable { onClick(multiplier) }
    ) {
        Text(
            text = "${multiplier}x",
            color = MaterialTheme.colorScheme.additionalDark,
            style = MaterialTheme.typography.h5SemiBoldStyle
        )
    }
}

@Composable
fun CounterButton(
    type: CounterButtonType,
    counterValue: Int,
    modifier: Modifier = Modifier,
    onCounterChanged: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .size(
                if (type == CounterButtonType.NORMAL) DpSize(96.dp, 32.dp)
                else DpSize(112.dp, 40.dp)
            )
            .border(1.dp, MaterialTheme.colorScheme.neutralGrayscale50, RoundedCornerShape(24.dp))
            .padding(
                if (type == CounterButtonType.NORMAL) PaddingValues(horizontal = 4.dp)
                else PaddingValues(vertical = 8.dp, horizontal = 12.dp)
            ),
    ) {
        YummyIcon(
            painterRes = R.drawable.ic_minus,
            tint = MaterialTheme.colorScheme.neutralGrayscale80,
            modifier = Modifier
                .clip(CircleShape)
                .clickable {
                    onCounterChanged(counterValue - 1)
                })
        AnimatedContent(
            targetState = counterValue,
            contentAlignment = Alignment.Center,
            transitionSpec = {
                if (targetState > initialState) {
                    slideInVertically { height -> height } + fadeIn() togetherWith
                            slideOutVertically { height -> -height } + fadeOut()
                } else {
                    slideInVertically { height -> -height } + fadeIn() togetherWith
                            slideOutVertically { height -> height } + fadeOut()
                }.using(
                    SizeTransform(clip = false)
                )
            }, label = ""
        ) { targetCount ->
            Text(
                text = if (targetCount in 1..9) "0$targetCount" else targetCount.toString(),
                color = MaterialTheme.colorScheme.additionalDark,
                style = MaterialTheme.typography.h5SemiBoldStyle
            )
        }
        YummyIcon(
            painterRes = R.drawable.ic_plus,
            tint = MaterialTheme.colorScheme.additionalDark,
            modifier = Modifier
                .clip(CircleShape)
                .clickable {
                    onCounterChanged(counterValue + 1)
                })
    }
}

enum class CounterButtonType {
    NORMAL,
    BIG
}

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun TinyCounterButtonPreview() {
    CircularCounterButton(multiplier = 1) {

    }
}

@Preview(backgroundColor = 0xFFFFFF, showBackground = true)
@Composable
fun CounterButtonPreview() {
    var counterValue by remember {
        mutableIntStateOf(0)
    }
    CounterButton(type = CounterButtonType.BIG, counterValue) {
        counterValue = if (it >= 0) it else 0
    }
}