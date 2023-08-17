package com.mobven.designsystem.components.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.mobven.components.R
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h3BoldStyle
import com.mobven.designsystem.theme.mainPrimary
import com.mobven.designsystem.theme.mainSecondary
import com.mobven.designsystem.theme.neutralGrayscale70
import com.mobven.designsystem.theme.neutralGrayscale80
import com.mobven.designsystem.theme.promoOrange
import com.mobven.designsystem.theme.smallSemiBoldStyle
import com.mobven.designsystem.theme.xsmallSemiBoldStyle

@Composable
fun CardOne(
    title: String,
    @DrawableRes imgResId: Int,
    distance: String,
    rating: Double,
    reviewCount: String,
    discountText: String,
    isDiscountTextVisible: Boolean,
    isPromoVisible: Boolean,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.width(192.dp)
    ) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.additionalWhite)
        ) {
            BoxWithConstraints(
                modifier = Modifier
                    .height(170.dp)
                    .padding(bottom = 20.dp)
            ) {
                if (isPromoVisible) {
                    PromoView()
                }
                YummyImage(
                    imgResId = imgResId,
                    modifier = Modifier
                        .height(140.dp)
                        .width(192.dp),
                    contentScale = ContentScale.Crop
                )
                Column(
                    modifier = Modifier
                        .zIndex(1f)
                        .padding(end = 8.dp)
                        .align(Alignment.BottomEnd)
                        .background(
                            MaterialTheme.colorScheme.mainSecondary,
                            shape = RoundedCornerShape(16.dp)
                        ),
                ) {
                    if (isDiscountTextVisible) {
                        Text(
                            text = discountText,
                            style = MaterialTheme.typography.smallSemiBoldStyle,
                            color = MaterialTheme.colorScheme.additionalWhite,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            Text(
                text = title, style = MaterialTheme.typography.h3BoldStyle,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, bottom = 4.dp, end = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = distance, color = MaterialTheme.colorScheme.neutralGrayscale70
                )
                Divider(
                    color = MaterialTheme.colorScheme.neutralGrayscale70,
                    modifier = Modifier
                        .height(12.dp)
                        .padding(horizontal = 4.dp)
                        .width(1.dp)
                )
                YummyImage(
                    imgResId = R.drawable.ic_star,
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                )
                Text(
                    text = rating.toString(), color = MaterialTheme.colorScheme.neutralGrayscale80
                )
                Text(
                    text = "($reviewCount)",
                    modifier = Modifier.padding(start = 4.dp),
                    color = MaterialTheme.colorScheme.neutralGrayscale80
                )
                YummyImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End),
                    imgResId = R.drawable.ic_heart_orange,
                )
            }
        }
    }
}

@Composable
fun PromoView() {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .background(MaterialTheme.colorScheme.promoOrange)
            .zIndex(1f),
    ) {
        Text(
            text = "PROMO",
            color = MaterialTheme.colorScheme.additionalWhite,
            style = MaterialTheme.typography.xsmallSemiBoldStyle,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
        )
    }
}

@Preview
@Composable
fun CardOnePreview() {
    CardOne(
        title = "Pizza Hut",
        imgResId = R.drawable.card_one_image,
        distance = "1.5 km",
        rating = 4.8,
        reviewCount = "1.2k",
        discountText = "%4 off your order",
        isDiscountTextVisible = true,
        isPromoVisible = true,
    )
}