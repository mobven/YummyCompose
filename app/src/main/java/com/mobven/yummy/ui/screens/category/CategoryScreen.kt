package com.mobven.yummy.ui.screens.category

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.common.CategoryCard
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.components.toolbar.YummyToolbar
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h2BoldStyle
import com.mobven.designsystem.theme.neutralGrayscale100

@Composable
fun CategoryScreen(
    onBackClick: () -> Unit
) {
    val categories = listOf(
        Category(title = "Flash deals", icon = R.drawable.category_sample_1),
        Category(title = "Nice shop", icon = R.drawable.category_sample_2),
        Category(title = "Fastfood", icon = R.drawable.category_sample_3),
        Category(title = "Bun pho", icon = R.drawable.category_sample_4),
        Category(title = "Rice", icon = R.drawable.category_sample_5),
        Category(title = "Vegetable", icon = R.drawable.category_sample_6),
        Category(title = "Korean food", icon = R.drawable.category_sample_7),
        Category(title = "Frozen", icon = R.drawable.category_sample_8),
        Category(title = "Drinks", icon = R.drawable.category_sample_9),
        Category(title = "Sweet food", icon = R.drawable.category_sample_10),
        Category(title = "BBQ", icon = R.drawable.category_sample_11),
    )

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.additionalWhite)
    ) {
        YummyToolbar(
            title = {
                Text(
                    text = "Category", style = MaterialTheme.typography.h2BoldStyle
                        .copy(color = MaterialTheme.colorScheme.neutralGrayscale100)
                )
            },
            leadingIcon = {
                YummyIcon(
                    painterRes = R.drawable.ic_arrow_left,
                    modifier = Modifier.clickable(onClick = onBackClick)
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
        VerticalSpacer(height = 24.dp)
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(categories) { _, category ->
                CategoryCard(title = category.title, icon = category.icon)
            }
        }
    }
}

data class Category(
    val title: String,
    val icon: Int
)

@Preview
@Composable
fun CategoryScreenPreview() {
    CategoryScreen {}
}
