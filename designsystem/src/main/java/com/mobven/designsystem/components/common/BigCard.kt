package com.mobven.designsystem.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun YummyBigCard(isPromoEnabled: Boolean, discount: Int = 0) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
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

            YummyProductInfo()
        }
    }
}

@Composable
fun YummyProductInfo() {
    Text(
        text = "Hamburger",
        fontWeight = FontWeight.Bold,
    )
    Row(
        modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "1.5 km |",
            color = MaterialTheme.colorScheme.neutralGrayscale70
        )
        YummyImage(
            imgResId = R.drawable.ic_star,
            modifier = Modifier.padding(start = 6.dp, end = 6.dp),
        )
        Text(
            text = "4.8",
            color = MaterialTheme.colorScheme.neutralGrayscale80
        )
        Text(
            text = "(1.2k)",
            modifier = Modifier.padding(start = 4.dp),
            color = MaterialTheme.colorScheme.neutralGrayscale80
        )
        YummyImage(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            imgResId = R.drawable.ic_favourite,
        )
    }
}

@Preview
@Composable
fun YummyBigCardPreview() {
    YummyBigCard(true, 4)
}