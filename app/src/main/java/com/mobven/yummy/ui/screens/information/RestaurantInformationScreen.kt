package com.mobven.yummy.ui.screens.information

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.YummyImage
import com.mobven.designsystem.components.toolbar.YummyToolbar
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.grayscale200
import com.mobven.designsystem.theme.h3BoldStyle
import com.mobven.designsystem.theme.h3MediumStyle
import com.mobven.designsystem.theme.h3SemiBoldStyle
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.mainPrimary
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

            LocationText(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )

            VerticalSpacer(height = 32.dp)

            YummyDivider(modifier = Modifier.fillMaxWidth())

            VerticalSpacer(height = 32.dp)

            Text(
                text = "About us",
                style = MaterialTheme.typography.h3BoldStyle,
                color = MaterialTheme.colorScheme.neutralGrayscale100
            )

            VerticalSpacer(height = 24.dp)

            ReadMoreClickableText(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua ut enim ad. See more...",
                onClick = {}
            )

            VerticalSpacer(height = 32.dp)

            YummyDivider(modifier = Modifier.fillMaxWidth())

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

            YummyDivider(modifier = Modifier.fillMaxWidth())

            VerticalSpacer(height = 24.dp)

            KeyValueText(
                key = "Phone number",
                value = "0560565913",
                modifier = Modifier.fillMaxWidth()
            )

        }
    }
}

@Composable
fun ReadMoreClickableText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val annotatedString = buildAnnotatedString {
        append(text)
        addStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.mainPrimary
            ),
            start = text.indexOf("See more..."),
            end = text.indexOf("See more...") + 11 // "See more" metninin uzunluğu kadar
        )
    }

    Text(
        text = annotatedString,
        style = MaterialTheme.typography.h4MediumStyle,
        modifier = modifier.clickable(onClick = onClick)
    )
}

@Composable
fun YummyDivider(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
        modifier = modifier
    ) {
        Divider(
            color = MaterialTheme.colorScheme.grayscale200,
            thickness = 1.dp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun LocationText(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Icon(
            painterResource(id = R.drawable.ic_location),
            contentDescription = "Location icon",
            modifier = Modifier.padding(horizontal = 10.dp)
        )

        Text(
            text = "NYC, Broadway ave 79",
            style = MaterialTheme.typography.h3SemiBoldStyle,
            color = MaterialTheme.colorScheme.neutralGrayscale100
        )
    }
}

@Composable
fun KeyValueText(
    key: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = key,
            style = MaterialTheme.typography.h3MediumStyle,
            color = MaterialTheme.colorScheme.neutralGrayscale100,
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = ":",
            style = MaterialTheme.typography.h3MediumStyle,
            color = MaterialTheme.colorScheme.neutralGrayscale100
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = value,
            style = MaterialTheme.typography.h3SemiBoldStyle,
            color = MaterialTheme.colorScheme.mainPrimary,
        )
    }
}


@Preview
@Composable
fun RestaurantInformationScreenPreview() {
    RestaurantInformationScreen {}
}