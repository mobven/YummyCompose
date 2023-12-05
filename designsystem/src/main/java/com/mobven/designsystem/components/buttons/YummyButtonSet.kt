package com.mobven.designsystem.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mobven.components.R
import com.mobven.designsystem.components.common.HorizontalSpacer
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h3SemiBoldStyle
import com.mobven.designsystem.theme.h4BoldStyle
import com.mobven.designsystem.theme.mainPrimary
import com.mobven.designsystem.theme.neutralGrayscale100
import com.mobven.designsystem.theme.neutralGrayscale30
import com.mobven.designsystem.theme.neutralGrayscale90
import com.mobven.designsystem.theme.xsmallBoldStyle

@Composable
fun YummyButton(
    text: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .sizeIn(86.dp, 48.dp)
            .clip(RoundedCornerShape(24.dp))
            .clickable { onClick() }
            .background(
                if (isEnabled) MaterialTheme.colorScheme.mainPrimary
                else MaterialTheme.colorScheme.neutralGrayscale30
            )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h4BoldStyle,
            color = if (isEnabled) MaterialTheme.colorScheme.additionalWhite
            else MaterialTheme.colorScheme.neutralGrayscale90
        )
    }
}

@Composable
private fun YummyButtonContentItem(
    model: YummyButtonContent,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = model.imgUrl ?: model.imgRes,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.dummy_hamburger),
            modifier = modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        if (model.contentSize != null) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(14.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.additionalWhite)
            ) {
                Text(
                    text = model.contentSize.toString(),
                    color = MaterialTheme.colorScheme.neutralGrayscale100,
                    style = MaterialTheme.typography.xsmallBoldStyle,
                )
            }
        }
    }
}

@Composable
private fun DummyButtonEndContent(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.additionalWhite,
            style = MaterialTheme.typography.h4BoldStyle
        )
        HorizontalSpacer(width = 8.dp)
        YummyIcon(
            painterRes = R.drawable.ic_arrow_right,
            tint = MaterialTheme.colorScheme.additionalWhite
        )
    }
}

@Composable
private fun YummyButtonStartIcon(
    content: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(Color.White)
    ) {
        Text(
            text = content,
            style = MaterialTheme.typography.h3SemiBoldStyle,
            color = MaterialTheme.colorScheme.neutralGrayscale100
        )
    }
}

@Composable
private fun YummyButtonMiddleContent(
    models: List<YummyButtonContent>
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        models.forEachIndexed { index, yummyButtonContentItem ->
            if (index < 3) {
                YummyButtonContentItem(model = yummyButtonContentItem)
            }
        }
    }
}

@Composable
fun DetailedYummyButton(
    size: Int,
    content: List<YummyButtonContent>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .clickable { onClick() }
            .background(MaterialTheme.colorScheme.mainPrimary)
            .padding(4.dp)
    ) {
        YummyButtonStartIcon(content = size.toString())
        YummyButtonMiddleContent(models = content)
        DummyButtonEndContent("See detail", modifier = Modifier.padding(end = 12.dp))
    }
}

@Composable
fun CheckoutYummyButton(
    multiplier: String,
    amount: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .clickable { onClick() }
            .background(MaterialTheme.colorScheme.mainPrimary)
            .padding(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 12.dp)
    ) {
        YummyButtonStartIcon(content = multiplier)
        HorizontalSpacer(width = 12.dp)
        Text(
            text = amount,
            color = MaterialTheme.colorScheme.additionalWhite,
            style = MaterialTheme.typography.h4BoldStyle,
            modifier = Modifier.weight(1f)
        )
        DummyButtonEndContent("Checkout")
    }
}

@Preview
@Composable
fun DisabledYummyButtonPreview() {
    YummyButton(text = "Button", isEnabled = false, modifier = Modifier.fillMaxWidth()) {}
}

@Preview
@Composable
fun EnabledYummyButtonPreview() {
    YummyButton(text = "Button", modifier = Modifier.fillMaxWidth()) {}
}

@Preview
@Composable
fun DetailedYummyButtonPreview() {
    DetailedYummyButton(
        size = 4, content = listOf(
            YummyButtonContent(
                imgUrl = null, imgRes = null, contentSize = null
            ),
            YummyButtonContent(
                imgUrl = null, imgRes = null, contentSize = 2
            ),
            YummyButtonContent(
                imgUrl = null, imgRes = null, contentSize = null
            )
        )
    ) {}
}

@Preview
@Composable
fun CheckoutYummyButtonPreview() {
    CheckoutYummyButton(
        multiplier = "x4",
        amount = "48.000d"
    ) {}
}

data class YummyButtonContent(
    val imgUrl: String?,
    @DrawableRes val imgRes: Int?,
    val contentSize: Int?
)