package com.mobven.components.buttons

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun YummySegmentedButton(
    selectedIndex: Int = 0,
    onIndexChanged: (Int) -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .size(327.dp, 44.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFFF2F2F2))
    ) {

        var firstItemColor by remember {
            mutableStateOf(
                if (selectedIndex == 0) Color.White
                else Color(0xFF78828A)
            )
        }
        var secondItemColor by remember {
            mutableStateOf(
                if (selectedIndex == 1) Color.White
                else Color(0xFF78828A)
            )
        }
        val translationXState by animateDpAsState(
            animationSpec = tween(300),
            targetValue = if (selectedIndex == 0) 0.dp else maxWidth / 2,
            label = ""
        ) {
            firstItemColor = if (selectedIndex == 0) Color.White
            else Color(0xFF78828A)
            secondItemColor = if (selectedIndex == 1) Color.White
            else Color(0xFF78828A)
        }

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(maxWidth / 2)
                .graphicsLayer {
                    translationX = translationXState.toPx()
                }
                .padding(vertical = 2.dp, horizontal = 2.5.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF332C45))
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Restaurants",
                color = firstItemColor,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 24.sp,
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
                text = "Dishes",
                color = secondItemColor,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 24.sp,
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

@Preview
@Composable
fun YummySegmentedButtonPreview() {
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    YummySegmentedButton(selectedIndex) {
        selectedIndex = it
    }
}