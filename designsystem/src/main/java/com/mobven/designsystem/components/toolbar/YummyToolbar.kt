package com.mobven.designsystem.components.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h2BoldStyle
import com.mobven.designsystem.theme.neutralGrayscale100
import com.mobven.designsystem.theme.neutralGrayscale90

@Composable
fun YummyToolbar(
    title: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    iconTint: Color = Color.Unspecified,
    backgroundColor: Color = MaterialTheme.colorScheme.additionalWhite,
    elevation: Dp = 4.dp,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    titleStyle: TextStyle = MaterialTheme.typography.h2BoldStyle
        .copy(color = MaterialTheme.colorScheme.neutralGrayscale100),
    onIconClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .shadow(elevation)
            .background(backgroundColor)
    ) {
        YummyIcon(
            painterRes = icon,
            modifier = Modifier
                .padding(start = 24.dp)
                .clickable(interactionSource = interactionSource, indication = LocalIndication.current) {
                    onIconClick.invoke()
                },
            tint = iconTint
        )
        Text(
            text = title,
            modifier = Modifier.align(Alignment.Center),
            style = titleStyle
        )
    }
}

@Preview
@Composable
fun YummyToolbarPreview() {
    YummyToolbar(
        title = "Sign in",
        icon = R.drawable.ic_arrow_left,
        iconTint = MaterialTheme.colorScheme.neutralGrayscale90,
        titleStyle = MaterialTheme.typography.h2BoldStyle.copy(color = MaterialTheme.colorScheme.neutralGrayscale100),
        modifier = Modifier.fillMaxWidth()
    ) {
        //click
    }
}