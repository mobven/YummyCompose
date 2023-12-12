package com.mobven.yummy.ui.screens.information

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.YummyImage
import com.mobven.designsystem.components.text.KeyValueText
import com.mobven.designsystem.components.text.ReadMoreClickableText
import com.mobven.designsystem.components.text.TextWithIcon
import com.mobven.designsystem.components.toolbar.YummyToolbar
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.grayscale200
import com.mobven.designsystem.theme.h3BoldStyle
import com.mobven.designsystem.theme.neutralGrayscale100

@Composable
fun RestaurantInformationScreen(
    onBackClick: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.additionalWhite)
            .verticalScroll(rememberScrollState())
    ) {

        YummyToolbar(
            title = "Restaurant Information",
            icon = R.drawable.ic_arrow_left,
            onIconClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            Modifier.padding(horizontal = 24.dp)
        ) {

            VerticalSpacer(height = 24.dp)

            YummyImage(
                imgResId = R.drawable.location_frame,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            VerticalSpacer(height = 24.dp)

            TextWithIcon(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start),
                leadingIcon = {
                    Icon(
                        painterResource(id = R.drawable.ic_location),
                        contentDescription = "Location icon"
                    )
                },
                text = "NYC, Broadway ave 79"
            )

            VerticalSpacer(height = 32.dp)

            Divider(
                color = MaterialTheme.colorScheme.grayscale200,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            VerticalSpacer(height = 32.dp)

            Text(
                text = "About us",
                style = MaterialTheme.typography.h3BoldStyle,
                color = MaterialTheme.colorScheme.neutralGrayscale100
            )

            VerticalSpacer(height = 24.dp)

            ReadMoreClickableText(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad",
                readMoreText = "See more..."
            )

            VerticalSpacer(height = 32.dp)

            Divider(
                color = MaterialTheme.colorScheme.grayscale200,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            VerticalSpacer(height = 24.dp)

            KeyValueText(
                key = "Monday-Friday",
                value = "10:00 - 22.00",
                modifier = Modifier.fillMaxWidth()
            )

            VerticalSpacer(height = 24.dp)

            KeyValueText(
                key = "Saturday-Sunday",
                value = "12:00 - 20.00",
                modifier = Modifier.fillMaxWidth()
            )

            VerticalSpacer(height = 24.dp)

            Divider(
                color = MaterialTheme.colorScheme.grayscale200,
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )
            VerticalSpacer(height = 24.dp)

            KeyValueText(
                key = "Phone number",
                value = "0560565913",
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}

@Preview
@Composable
fun RestaurantInformationScreenPreview() {
    RestaurantInformationScreen {}
}