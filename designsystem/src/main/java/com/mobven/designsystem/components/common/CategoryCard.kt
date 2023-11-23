package com.mobven.designsystem.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.grayScale
import com.mobven.designsystem.theme.h5SemiBoldStyle

@Composable
fun CategoryCard(
    title: String,
    icon: Int
) {
    Card(
        modifier = Modifier
            .height(72.dp)
            .width(72.dp),
        shape = RectangleShape
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.additionalWhite),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            YummyImage(
                imgResId = icon,
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = title,
                color = MaterialTheme.colorScheme.grayScale,
                style = MaterialTheme.typography.h5SemiBoldStyle,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun CategoryCardPreview() {
    CategoryCard(
        title = "BBQ",
        icon = R.drawable.category_sample_1
    )
}