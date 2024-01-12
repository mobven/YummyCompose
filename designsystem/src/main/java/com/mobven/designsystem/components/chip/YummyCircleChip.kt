package com.mobven.designsystem.components.chip

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.mainSecondary
import com.mobven.designsystem.theme.neutralGrayscale30
import com.mobven.designsystem.theme.neutralGrayscale90
import kotlinx.coroutines.launch


@Composable
fun YummyCircleChip(
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

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .size(40.dp)
            .clickable {
                clickListener?.invoke(checked.not())
            },
    ) {
        Text(
            text = text,
            color = textColor,
            maxLines = 1,
            style = MaterialTheme.typography.h4MediumStyle,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )
    }
}

@Composable
fun LazyRowYummyCircleChip(
    chipList: List<String>,
    modifier: Modifier = Modifier,
    defaultSelectedChip: String? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 0.dp),
    itemPadding: PaddingValues = PaddingValues(horizontal = 6.dp),
    selectedChipListener: (String) -> Unit = {}
) {
    var selectedChip by remember {
        mutableStateOf(defaultSelectedChip)
    }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyRow(
        modifier = modifier,
        state = listState,
        contentPadding = contentPadding
    ) {
        itemsIndexed(chipList) { index, item ->
            YummyCircleChip(
                text = item,
                checked = selectedChip == item,
                modifier = Modifier.padding(itemPadding)
            ) {
                selectedChip = item
                selectedChipListener.invoke(selectedChip.orEmpty())
                coroutineScope.launch {
                    listState.animateScrollToItem(index = index)
                }
            }
        }
    }
}
