package com.mobven.designsystem.components.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.mobven.components.R
import com.mobven.designsystem.theme.additionalDark
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h4BoldStyle
import com.mobven.designsystem.theme.neutralGrayscale80
import com.mobven.designsystem.theme.smallMediumStyle
import com.mobven.designsystem.theme.smallSemiBoldStyle

@Composable
fun SmallCardSix(
    price: String,
    title: String,
    description: String,
    @DrawableRes imgRes: Int,
) {

    val count by remember {
        mutableStateOf(7)
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(327.dp)
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.additionalWhite)
        ) {
            BoxWithConstraints(
                modifier = Modifier
                    .height(56.dp)
            ) {
                if (count > 0) {
                    CountView(count = count)
                }

                YummyImage(
                    imgResId = imgRes,
                    modifier = Modifier
                        .width(56.dp)
                        .height(56.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Fit
                )
            }
            Column(
                modifier = Modifier.padding(start = 8.dp),
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h4BoldStyle,
                    color = MaterialTheme.colorScheme.additionalDark
                )

                Text(
                    text = description,
                    style = MaterialTheme.typography.smallMediumStyle,
                    color = MaterialTheme.colorScheme.additionalDark,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    modifier = Modifier
                        .height(56.dp)
                        .wrapContentHeight(),
                    text = price,
                    style = MaterialTheme.typography.h4BoldStyle,
                    color = MaterialTheme.colorScheme.neutralGrayscale80,
                )
            }
        }
    }
}

@Composable
fun CountView(count: Int) {
    Column(
        modifier = Modifier
            .padding(top = 4.dp, start = 4.dp)
            .background(
                MaterialTheme.colorScheme.additionalWhite,
                shape = RoundedCornerShape(50.dp)
            )
            .zIndex(1f),
    ) {
        Text(
            text = count.toString().plus("x"),
            color = MaterialTheme.colorScheme.additionalDark,
            style = MaterialTheme.typography.smallSemiBoldStyle,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 5.dp)
        )
    }
}

@Preview
@Composable
fun YummySmallCardSixPreview() {
    SmallCardSix(
        title = "Croissants",
        description = "happy not angry",
        price = "$7.02",
        imgRes = R.drawable.chicken_noodle
    )
}