package com.mobven.designsystem.components.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.theme.additionalDark
import com.mobven.designsystem.theme.neutralGrayscale80

@Composable
fun CardFive(
    modifier: Modifier = Modifier
) {
    var isFavourite by remember {
        mutableStateOf(true)
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .width(327.dp)
            .height(92.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            YummyImage(
                imgResId = R.drawable.dummy_hamburger, modifier = Modifier
                    .width(92.dp)
                    .height(92.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Fit
            )
            YummyCardFiveInfo(
                title = "Grandma's shop",
                description = "NYC, Broadway ave 79",
                ratioText = "4.8 (1.2k) | 1,5 km",
                isFavourite = isFavourite
            ) {
                isFavourite = isFavourite.not()
            }

            YummyImage(
                modifier = Modifier
                    .padding(top = 30.dp, start = 45.dp)
                    .width(12.35.dp)
                    .height(20.dp)
                    .wrapContentWidth(Alignment.End),
                imgResId = R.drawable.ic_right_direct
            )
        }
    }
}


@Composable
fun YummyCardFiveInfo(
    title: String,
    description: String,
    ratioText: String,
    isFavourite: Boolean,
    modifier: Modifier = Modifier,
    favoriteClicked: () -> Unit
) {
    Row {
        Column(
            modifier = Modifier.padding(start = 8.dp),
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.additionalDark,
                modifier = Modifier.padding(top = 4.dp)
            )

            Text(
                text = description,
                modifier = Modifier.padding(top = 2.dp)
            )
            Row(
                modifier = Modifier.padding(top = 12.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                YummyImage(
                    imgResId = R.drawable.ic_small_star,
                    modifier = Modifier
                        .padding(end = 6.dp),
                )
                Text(
                    text = ratioText,
                    color = MaterialTheme.colorScheme.neutralGrayscale80
                )
            }
        }

        YummyImage(
            modifier = Modifier
                .padding(top = 12.dp)
                .clickable {
                    favoriteClicked.invoke()
                },
            imgResId = if (isFavourite) R.drawable.ic_favourite else R.drawable.ic_no_favourite,
        )
    }

}


@Preview
@Composable
fun YummyCardFivePreview() {
    CardFive()
}