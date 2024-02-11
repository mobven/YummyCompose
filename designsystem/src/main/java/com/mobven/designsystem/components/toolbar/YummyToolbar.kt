package com.mobven.designsystem.components.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.theme.additionalDark
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h2BoldStyle
import com.mobven.designsystem.theme.neutralGrayscale100
import com.mobven.designsystem.util.yummyPadding

@Composable
fun YummyToolbar(
    title: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
    trailingIcon: @Composable (RowScope.() -> Unit)? = null,
    leadingIcon: @Composable (RowScope.() -> Unit)? = null,
    backgroundColor: Color = MaterialTheme.colorScheme.additionalWhite,
    elevation: Dp = 15.dp,
) {
    val measurePolicy = rememberYummyToolbarLayoutMeasurePolicy()

    Layout(
        measurePolicy = measurePolicy,
        modifier = modifier
            .shadow(
                elevation,
                spotColor = MaterialTheme
                    .colorScheme
                    .additionalDark.copy(alpha = 0.7f)
            )
            .background(backgroundColor)
            .yummyPadding(top = 45.dp, bottom = 12.dp, horizontal = 24.dp),
        content = {
            if (leadingIcon != null) {
                Row(
                    content = leadingIcon,
                    modifier = Modifier.layoutId(YummyToolbarItems.LEADING_ICON)
                )
            }

            Row(
                content = title, modifier = Modifier.layoutId(YummyToolbarItems.TITLE)
            )

            if (trailingIcon != null) {
                Row(
                    content = trailingIcon,
                    modifier = Modifier.layoutId(YummyToolbarItems.TRAILING_ICON)
                )
            }
        }
    )

}

@Composable
fun rememberYummyToolbarLayoutMeasurePolicy(): MeasurePolicy {
    return remember {
        MeasurePolicy { measurables, constraints ->
            var hasLeadingIcon = false
            var hasTrailingIcon = false

            val placeables =
                measurables.filter { it.layoutId != YummyToolbarItems.TITLE }.map { measurable ->
                    when (measurable.layoutId as YummyToolbarItems) {
                        YummyToolbarItems.LEADING_ICON -> {
                            hasLeadingIcon = true
                        }

                        YummyToolbarItems.TRAILING_ICON -> {
                            hasTrailingIcon = true
                        }

                        else -> {/* no-op */
                        }
                    }
                    Pair(
                        first = measurable.layoutId as YummyToolbarItems,
                        second = measurable.measure(constraints = constraints.copy(minWidth = 0))
                    )
                }.toMutableList().apply {
                    val sumOfIconWidths = sumOf { it.second.width }
                    val title =
                        measurables.first { it.layoutId == YummyToolbarItems.TITLE }.measure(
                            constraints.copy(
                                minWidth = 0,
                                maxWidth = constraints.maxWidth - if (hasLeadingIcon xor hasTrailingIcon) sumOfIconWidths * 2 else sumOfIconWidths
                            )
                        )
                    add(Pair(YummyToolbarItems.TITLE, title))
                }.toList()

            val maxHeight = placeables.maxOfOrNull { it.second.measuredHeight } ?: 0

            layout(constraints.maxWidth, maxHeight) {
                placeables.forEach { pair ->
                    when (pair.first) {
                        YummyToolbarItems.TITLE -> {
                            pair.second.apply {
                                placeRelative(
                                    ((constraints.maxWidth / 2f) - (width / 2f)).toInt(),
                                    ((maxHeight / 2f) - (height / 2f)).toInt()
                                )
                            }
                        }

                        YummyToolbarItems.LEADING_ICON -> {
                            pair.second.placeRelative(0, 0)
                        }

                        YummyToolbarItems.TRAILING_ICON -> {
                            pair.second.apply {
                                placeRelative(constraints.maxWidth - measuredWidth, 0)
                            }
                        }
                    }
                }
            }
        }
    }
}

internal enum class YummyToolbarItems {
    TITLE,
    LEADING_ICON,
    TRAILING_ICON,
}

@Preview(showBackground = true)
@Composable
fun YummyToolbarPreview() {
    YummyToolbar(
        title = {
            Text(
                text = "Restaurant Information", style = MaterialTheme.typography.h2BoldStyle
                    .copy(color = MaterialTheme.colorScheme.neutralGrayscale100)
            )
        },
        leadingIcon = {
            YummyIcon(
                painterRes = R.drawable.ic_arrow_left,
                modifier = Modifier
            )
        },
        modifier = Modifier.fillMaxWidth()
    )

}