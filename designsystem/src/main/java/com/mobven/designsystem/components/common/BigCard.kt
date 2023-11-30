package com.mobven.designsystem.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.mobven.components.R
import com.mobven.designsystem.theme.mainSecondary
import com.mobven.designsystem.theme.neutralGrayscale70
import com.mobven.designsystem.theme.neutralGrayscale80
import com.mobven.designsystem.theme.promoOrange

@Composable
fun YummyBigCard(
    isPromoEnabled: Boolean,
    restaurant: Restaurant,
    discount: Int = 0,
    modifier: Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
    ) {
        BoxWithConstraints(modifier = Modifier.height(160.dp)) {
            if (isPromoEnabled) {
                Column(
                    modifier = Modifier
                        .zIndex(1f)
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                        .background(MaterialTheme.colorScheme.promoOrange),
                ) {
                    Text(
                        text = "PROMO",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }
            YummyImage(
                imgResId = R.drawable.yummy_big_card, modifier = Modifier
                    .height(144.dp)
                    .fillMaxWidth(), contentScale = ContentScale.Crop
            )
            if (discount > 0) {
                Column(
                    modifier = Modifier
                        .zIndex(1f)
                        .padding(end = 16.dp, top = 16.dp)
                        .align(Alignment.BottomEnd)
                        .background(
                            MaterialTheme.colorScheme.mainSecondary,
                            shape = RoundedCornerShape(16.dp)
                        ),
                ) {
                    Text(
                        text = "$discount% off your order",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
            }
        }

        YummyProductInfo(restaurant)
    }
}

@Composable
fun YummyProductInfo(restaurant: Restaurant) {
    Text(
        text = restaurant.productName,
        fontWeight = FontWeight.Bold,
    )
    Row(
        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${restaurant.distance} |",
            color = MaterialTheme.colorScheme.neutralGrayscale70
        )
        YummyImage(
            imgResId = R.drawable.ic_star,
            modifier = Modifier.padding(start = 6.dp, end = 6.dp),
        )
        Text(
            text = restaurant.rate,
            color = MaterialTheme.colorScheme.neutralGrayscale80
        )
        Text(
            text = "(${restaurant.commentNumber})",
            modifier = Modifier.padding(start = 4.dp),
            color = MaterialTheme.colorScheme.neutralGrayscale80
        )
        YummyImage(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            imgResId = if (restaurant.isFavourite) R.drawable.ic_favourite else R.drawable.ic_not_favourite,
        )
    }
}

@Preview
@Composable
fun YummyBigCardPreview() {
    val restaurant = Restaurant("Hamburger", "1.5 km", "4.8", true, "1.2k")
    YummyBigCard(true, restaurant, 4, Modifier.fillMaxWidth())
}

data class Restaurant(
    val productName: String,
    val distance: String,
    val rate: String,
    val isFavourite: Boolean,
    val commentNumber: String
)