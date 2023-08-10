package com.mobven.designsystem.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mobven.components.R
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.theme.additionalDark
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h4SemiBoldStyle
import com.mobven.designsystem.theme.h5MediumStyle
import com.mobven.designsystem.theme.neutralGrayscale80

@Composable
fun RestaurantWithLocationCard(
    modifier: Modifier = Modifier,
    location: String,
    title: String,
    image: String,
    contentScaleType: ContentScale = ContentScale.Fit,
    contentDesc: String = "This is a default content description",
    onClickAction: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(4, 4),
        modifier = modifier
            .width(210.dp)
            .clickable {
                onClickAction.invoke()
            },
    ) {
        Column(modifier = Modifier.background(color = MaterialTheme.colorScheme.additionalWhite)) {
            AsyncImage(
                model = image,
                contentDescription = contentDesc,
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = painterResource(id = R.drawable.location),
                contentScale = contentScaleType
            )
            VerticalSpacer(height = 8.dp)
            Text(
                text = title,
                style = MaterialTheme.typography.h4SemiBoldStyle,
                color = MaterialTheme.colorScheme.additionalDark,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            VerticalSpacer(height = 4.dp)
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.Start),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = "Home icon"
                )
                Text(
                    text = location,
                    style = MaterialTheme.typography.h5MediumStyle,
                    color = MaterialTheme.colorScheme.neutralGrayscale80
                )
            }
            VerticalSpacer(height = 4.dp)

        }
    }
}


@Preview
@Composable
fun CardPreview() {
    RestaurantWithLocationCard(
        location = "Nhà hàng Elisandra",
        title = "Elisandra's restaurant",
        image = "https://www.freecodecamp.org/news/content/images/2022/09/jonatan-pie-3l3RwQdHRHg-unsplash.jpg",
        onClickAction = {}
    )
}