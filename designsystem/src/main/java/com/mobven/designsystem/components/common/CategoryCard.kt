package com.mobven.designsystem.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
    modifier: Modifier = Modifier,
    icon: Int
) {
    Card(
        modifier = modifier
            .height(72.dp)
            .width(72.dp),
        shape = RectangleShape
    ) {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.additionalWhite)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BoxWithConstraints {
                    YummyImage(
                        imgResId = icon,
                        modifier = modifier
                            .height(48.dp)
                            .width(48.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.grayScale,
                    style = MaterialTheme.typography.h5SemiBoldStyle,
                )

            }
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