package com.mobven.yummy.ui.screens.foodlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.designsystem.components.chip.LazyRowYummyChip
import com.mobven.designsystem.components.common.Restaurant
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.YummyBigCard
import com.mobven.designsystem.components.toolbar.SearchToolbar
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.neutralGrayscale60
import com.mobven.designsystem.theme.neutralGrayscale90

@Composable
fun FoodListScreen(
    onBackClick: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.additionalWhite)
            .verticalScroll(rememberScrollState())
    ) {

        SearchToolbar(
            searchText = "PIZZA",
            iconTint = MaterialTheme.colorScheme.neutralGrayscale90,
            modifier = Modifier.fillMaxWidth(),
            onIconClick = {},
            onTextChange = {}
        )

        Column() {

            VerticalSpacer(height = 24.dp)

            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = "325 results found",
                style = MaterialTheme.typography.h4MediumStyle,
                color = MaterialTheme.colorScheme.neutralGrayscale90
            )

            VerticalSpacer(height = 24.dp)

            val restaurant = Restaurant("Hamburger", "1.5 km", "4.8", false, "1.2k")
            YummyBigCard(
                true, restaurant, 4,
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

            VerticalSpacer(height = 24.dp)

            Divider(
                color = MaterialTheme.colorScheme.neutralGrayscale60,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            VerticalSpacer(height = 32.dp)

            YummyBigCard(
                true, restaurant, 4,
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

            VerticalSpacer(height = 32.dp)

            Divider(
                color = MaterialTheme.colorScheme.neutralGrayscale60,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            VerticalSpacer(height = 32.dp)

            YummyBigCard(
                true, restaurant, 4,
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )

        }
    }
}

@Preview
@Composable
fun FoodListScreenPreview() {
    FoodListScreen {}
}