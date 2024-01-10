package com.mobven.designsystem.components.toolbar

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.components.filter.FilterList
import com.mobven.designsystem.components.filter.FilterModel
import com.mobven.designsystem.components.search.SearchBar
import com.mobven.designsystem.theme.additionalDark
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.neutralGrayscale90

@Composable
fun SearchToolbar(
    searchText: String,
    modifier: Modifier = Modifier,
    iconTint: Color = Color.Unspecified,
    backgroundColor: Color = MaterialTheme.colorScheme.additionalWhite,
    elevation: Dp = 15.dp,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onIconClick: () -> Unit,
    onTextChange: (String) -> Unit,
) {

    var textState by remember { mutableStateOf(searchText) }
    Column {
        Row(
            modifier = modifier
                .shadow(
                    elevation,
                    spotColor = MaterialTheme
                        .colorScheme
                        .additionalDark.copy(alpha = 0.7f)
                )
                .background(backgroundColor)
                .padding(top = 45.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            YummyIcon(
                painterRes = R.drawable.ic_arrow_left,
                modifier = Modifier
                    .padding(start = 24.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = LocalIndication.current
                    ) {
                        onIconClick.invoke()
                    },
                tint = iconTint
            )
            SearchBar(
                modifier = Modifier
                    .padding(start = 16.dp, end = 8.dp, top = 4.dp, bottom = 4.dp),
                text = textState,
                onTextChange = { newText ->
                    textState = newText
                    onTextChange.invoke(newText)
                },
                hint = "What are you yearning for?"
            )
        }

        FilterList(
            chipList = listOf(
                FilterModel(
                    text = "Filter",
                    enable = true,
                    enableIcon = R.drawable.filter_icon_enable,
                    disableIcon = R.drawable.filter_icon
                ),
                FilterModel(
                    text = "Arrange",
                    enableIcon = R.drawable.arrange_icon_enable,
                    disableIcon = R.drawable.arrange_icon
                ),
                FilterModel("Promotion")
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(vertical = 20.dp),
        )
    }

}

@Preview
@Composable
fun SearchToolbarPreview() {
    SearchToolbar(
        searchText = "PIZZA",
        iconTint = MaterialTheme.colorScheme.neutralGrayscale90,
        modifier = Modifier.fillMaxWidth(),
        onIconClick = {},
        onTextChange = {}
    )
}