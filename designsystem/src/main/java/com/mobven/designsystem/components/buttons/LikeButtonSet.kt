package com.mobven.designsystem.components.buttons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.theme.mainPrimary
import com.mobven.designsystem.theme.neutralGrayscale70

@Composable
fun LikeButton(
    isLiked: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    val interactionSource = remember {
        MutableInteractionSource()
    }

    var isScaled by rememberSaveable {
        mutableStateOf(false)
    }

    val scale by animateFloatAsState(
        targetValue = if (isScaled) 1.5f else 1f,
        animationSpec = tween(400),
        finishedListener = {
            isScaled = false
        },
        label = ""
    )

    YummyIcon(
        painterRes = if (isLiked) R.drawable.ic_heart_filled
        else R.drawable.ic_heart_outlined,
        tint = if (isLiked) MaterialTheme.colorScheme.mainPrimary
        else MaterialTheme.colorScheme.neutralGrayscale70,
        modifier = modifier
            .scale(scale)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                isScaled = !isLiked
                onClick.invoke()
            }
    )
}

@Preview
@Composable
fun PreviewLikeButton() {
    var isLiked by remember {
        mutableStateOf(false)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LikeButton(
            isLiked,
            modifier = Modifier.size(24.dp)
        ) {
            isLiked = !isLiked
        }
    }
}