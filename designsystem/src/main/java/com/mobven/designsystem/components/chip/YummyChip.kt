package com.mobven.designsystem.components.chip

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.mainSecondary
import com.mobven.designsystem.theme.neutralGrayscale30
import com.mobven.designsystem.theme.neutralGrayscale90
import kotlinx.coroutines.launch

@Composable
fun YummyChip(
    text: String,
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    clickListener: ((checked: Boolean) -> Unit)? = null
) {
    val backgroundColor by animateColorAsState(
        if (checked)
            MaterialTheme.colorScheme.mainSecondary
        else
            MaterialTheme.colorScheme.neutralGrayscale30,
        animationSpec = tween(300, easing = LinearEasing),
        label = ""
    )

    val textColor by animateColorAsState(
        if (checked) {
            MaterialTheme.colorScheme.additionalWhite
        } else {
            MaterialTheme.colorScheme.neutralGrayscale90
        },
        animationSpec = tween(300, easing = LinearEasing),
        label = ""
    )

    Text(
        text = text,
        color = textColor,
        style = MaterialTheme.typography.h4MediumStyle,
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .background(backgroundColor)
            .clickable {
                clickListener?.invoke(checked.not())
            }
            .padding(
                horizontal = 20.dp,
                vertical = 4.dp
            )
    )
}


@Composable
fun LazyRowYummyChip(
    chipList: List<String>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(horizontal = 10.dp),
    itemPadding: PaddingValues = PaddingValues(horizontal = 6.dp),
    selectedChipListener: (String) -> Unit = {}
) {
    var selectedChip by remember {
        mutableStateOf(chipList.firstOrNull().orEmpty())
    }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyRow(
        modifier = modifier,
        state = listState,
        contentPadding = contentPadding
    ) {
        itemsIndexed(chipList) { index, item ->
            YummyChip(
                text = item,
                checked = selectedChip == item,
                modifier = Modifier.padding(itemPadding)
            ) {
                selectedChip = item
                selectedChipListener.invoke(selectedChip)
                coroutineScope.launch {
                    listState.animateScrollToItem(index = index)
                }
            }
        }
    }
}

@Preview
@Composable
fun YummyChipPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(Color.White)
                .size(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var switch by remember {
                mutableStateOf(false)
            }
            YummyChip(
                text = "Noodles",
                checked = switch
            ) {
                switch = it
            }

        }
    }
}

@Preview
@Composable
fun LazyRowYummyChipPreview() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(Color.White)
                .height(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LazyRowYummyChip(
                chipList = listOf(
                    "For You",
                    "Noodles",
                    "Rice",
                    "Tacoco",
                    "Tacoco2",
                    "Tacoco21",
                    "T2acoco"
                ),
                modifier = Modifier.fillMaxWidth()
            ) {

            }

        }
    }
}