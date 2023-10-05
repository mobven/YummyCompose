package com.mobven.designsystem.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.mobven.components.R
import com.mobven.designsystem.theme.additionalDark
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h5SemiBoldStyle
import com.mobven.designsystem.theme.mainSecondary
import com.mobven.designsystem.theme.smallMediumStyle

@Composable
fun CardThree(
    title: String,
    modifier: Modifier = Modifier,
    discountText: String,
    isDiscountTextVisible: Boolean,
    isAddButtonVisible: Boolean
) {
    Card(
        shape = RoundedCornerShape(
            topStart = 12.dp,
            topEnd = 12.dp
        ),
        modifier = modifier
            .width(142.dp)
            .padding(bottom = 8.dp),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            BoxWithConstraints(
                modifier = Modifier
                    .padding(bottom = 4.dp)
            ) {
                YummyImage(
                    imgResId = R.drawable.card_three, modifier = Modifier
                        .width(142.dp)
                        .height(102.dp)
                        .fillMaxWidth(), contentScale = ContentScale.Crop
                )
                if (isAddButtonVisible)
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(
                                bottom = 4.dp,
                                end = 4.dp
                            )
                            .size(40.dp)
                            .background(
                                color = MaterialTheme.colorScheme.additionalWhite,
                                shape = CircleShape
                            )
                            .padding(6.dp)
                    ) {
                        YummyImage(
                            imgResId = R.drawable.ic_plus_28,
                            modifier = Modifier.size(28.dp),
                            contentScale = ContentScale.Fit
                        )
                    }
            }
            BoxWithConstraints(
                modifier = Modifier
                    .padding(bottom = 4.dp)
            ) {
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.additionalDark,
                    style = MaterialTheme.typography.h5SemiBoldStyle
                )
            }
            BoxWithConstraints {
                Column(
                    modifier = Modifier
                        .zIndex(1f)
                        .align(Alignment.BottomEnd)
                        .background(
                            MaterialTheme.colorScheme.mainSecondary,
                            shape = RoundedCornerShape(30.dp)
                        ),
                ) {
                    if (isDiscountTextVisible) {
                        Text(
                            text = discountText,
                            style = MaterialTheme.typography.smallMediumStyle,
                            color = MaterialTheme.colorScheme.additionalWhite,
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                        )
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun CardThreePreview() {
    CardThree(
        title = "Hamburger",
        discountText = "%4 off your order",
        isDiscountTextVisible = true,
        isAddButtonVisible = true
    )
}