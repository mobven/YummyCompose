package com.mobven.designsystem.components.filter

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.mainSecondary
import com.mobven.designsystem.theme.neutralGrayscale30
import com.mobven.designsystem.theme.neutralGrayscale90
import kotlinx.coroutines.launch

@Composable
fun FilterChip(
    filterModel: FilterModel,
    modifier: Modifier = Modifier,
    clickListener: ((filterModel: FilterModel) -> Unit)? = null
) {
    val backgroundColor by animateColorAsState(
        if (filterModel.enable)
            MaterialTheme.colorScheme.mainSecondary
        else
            MaterialTheme.colorScheme.neutralGrayscale30,
        animationSpec = tween(300, easing = LinearEasing),
        label = "backgroundColor"
    )

    val textColor by animateColorAsState(
        if (filterModel.enable) {
            MaterialTheme.colorScheme.additionalWhite
        } else {
            MaterialTheme.colorScheme.neutralGrayscale90
        },
        animationSpec = tween(300, easing = LinearEasing),
        label = "textColor"
    )

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .background(backgroundColor)
            .clickable { clickListener?.invoke(filterModel) }
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (filterModel.enable) {
            filterModel.enableIcon?.let {
                Icon(
                    painterResource(id = it),
                    contentDescription = "Enable filter icon",
                    modifier = Modifier.padding(start = 20.dp)
                )
            }
        } else {
            filterModel.disableIcon?.let {
                Icon(
                    painterResource(id = it),
                    contentDescription = "Disable filter icon",
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }

        Text(
            modifier = Modifier.padding(horizontal = 20.dp),
            text = filterModel.text,
            color = textColor,
            style = MaterialTheme.typography.h4MediumStyle
        )
    }


}


@Composable
fun FilterList(
    chipList: List<FilterModel>,
    modifier: Modifier = Modifier
) {

    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LazyRow(
        modifier = modifier,
        state = listState,
        contentPadding = PaddingValues(horizontal = 10.dp)
    ) {
        itemsIndexed(chipList) { index, item ->
            FilterChip(
                filterModel = item,
                modifier = Modifier.padding(6.dp)
            ) {
                coroutineScope.launch {
                    listState.animateScrollToItem(index = index)
                }
            }
        }
    }
}

@Preview
@Composable
fun FilterListPreview() {
    FilterList(
        chipList = listOf(
            FilterModel(
                text = "Filter",
                enable = true,
                enableIcon = R.drawable.filter_icon_enable,
                disableIcon = R.drawable.filter_icon
            ),
            FilterModel(text = "Arrange",
                enableIcon = R.drawable.arrange_icon_enable
                ,disableIcon = R.drawable.arrange_icon),
            FilterModel("Promotion")
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 20.dp),
    )
}

data class FilterModel(
    val text: String,
    val enable: Boolean = false,
    @DrawableRes val enableIcon: Int? = null,
    @DrawableRes val disableIcon: Int? = null
)