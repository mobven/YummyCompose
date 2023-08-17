package com.mobven.designsystem.components.buttons

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.designsystem.theme.additionalGrey
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h4BoldStyle
import com.mobven.designsystem.theme.mainSecondary
import com.mobven.designsystem.theme.neutralGrayscale70

@Composable
fun YummySegmentedButton(
    firstTitle: String,
    secondTitle: String,
    selectedIndex: Int = 0,
    animationDurationInMillis: Int,
    segmentedButtonColors: SegmentedButtonColors = SegmentedButtonColors(
        boxColor = MaterialTheme.colorScheme.mainSecondary,
        backgroundColor = MaterialTheme.colorScheme.additionalGrey,
        enableTextColor = MaterialTheme.colorScheme.additionalWhite,
        disableTextColor = MaterialTheme.colorScheme.neutralGrayscale70
    ),
    onIndexChanged: (Int) -> Unit,
) {
    BoxWithConstraints(
        modifier = Modifier
            .size(327.dp, 44.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(segmentedButtonColors.backgroundColor)
    ) {

        val firstItemColor by remember(selectedIndex) {
            mutableStateOf(
                if (selectedIndex == 0) segmentedButtonColors.enableTextColor
                else segmentedButtonColors.disableTextColor
            )
        }
        val secondItemColor by remember(selectedIndex) {
            mutableStateOf(
                if (selectedIndex == 1) segmentedButtonColors.enableTextColor
                else segmentedButtonColors.disableTextColor
            )
        }
        val translationXState by animateDpAsState(
            animationSpec = tween(animationDurationInMillis),
            targetValue = if (selectedIndex == 0) 0.dp else maxWidth / 2,
            label = ""
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(maxWidth / 2)
                .graphicsLayer {
                    translationX = translationXState.toPx()
                }
                .padding(vertical = 2.dp, horizontal = 2.5.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(segmentedButtonColors.boxColor)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = firstTitle,
                color = firstItemColor,
                style = MaterialTheme.typography.h4BoldStyle,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        onIndexChanged(0)
                    }
                    .wrapContentHeight(Alignment.CenterVertically)
                    .weight(1f)
            )
            Text(
                text = secondTitle,
                color = secondItemColor,
                style = MaterialTheme.typography.h4BoldStyle,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        onIndexChanged(1)
                    }
                    .wrapContentHeight(Alignment.CenterVertically)
                    .weight(1f),
            )
        }
    }
}

data class SegmentedButtonColors(
    val boxColor: Color,
    val backgroundColor: Color,
    val enableTextColor: Color,
    val disableTextColor: Color,
)

@Preview
@Composable
fun YummySegmentedButtonPreview() {
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        YummySegmentedButton(
            firstTitle = "Restaurants",
            secondTitle = "Dishes",
            selectedIndex = selectedIndex,
            animationDurationInMillis = 500
        ) {
            selectedIndex = it
        }
    }
}