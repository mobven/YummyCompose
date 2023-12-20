package com.mobven.designsystem.components.lazy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mobven.designsystem.theme.neutralGrayscale60


inline fun <T> LazyListScope.itemsWithDivider(
    items: List<T>,
    dividerModifier: Modifier = Modifier,
    dividerColor: Color? = null,
    crossinline itemContent: @Composable LazyItemScope.(item: T) -> Unit
) = itemsWithDivider(
    items = items,
    divider = {
        Divider(
            color = dividerColor ?: MaterialTheme.colorScheme.neutralGrayscale60,
            modifier = dividerModifier
        )
    },
    itemContent = itemContent
)

inline fun <T> LazyListScope.itemsWithDivider(
    items: List<T>,
    crossinline divider: @Composable () -> Unit,
    crossinline itemContent: @Composable LazyItemScope.(item: T) -> Unit
) = items(
    items.count()
) { index ->
    val item = items[index]

    Column {
        itemContent(item)
        if (item != items.last()) {
            divider()
        }
    }
}