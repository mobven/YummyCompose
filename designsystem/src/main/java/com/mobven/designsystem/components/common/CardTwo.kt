package com.mobven.designsystem.components.common

import androidx.compose.foundation.clickable
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
import com.mobven.designsystem.theme.neutralGrayscale80

@Composable
fun CardTwo(
    modifier: Modifier = Modifier
) {
    var isFavourite by remember {
        mutableStateOf(true)
    }

    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .width(155.5.dp)
            .height(190.dp)
            .padding(bottom = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            BoxWithConstraints(modifier = Modifier
                .padding(bottom = 4.dp)) {
                YummyImage(
                    imgResId = R.drawable.yummy_card_two, modifier = Modifier
                        .width(155.5.dp)
                        .height(126.dp)
                        .fillMaxWidth(), contentScale = ContentScale.Crop
                )
            }
            YummyCardTwoInfo(
                title = "Hamburger",
                ratioText = "4.8 (1.2k)",
                isFavourite = isFavourite
            ) {
                isFavourite = isFavourite.not()
            }
        }
    }
}


@Composable
fun YummyCardTwoInfo(
    title: String,
    ratioText: String,
    isFavourite: Boolean,
    modifier: Modifier = Modifier,
    favoriteClicked: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
        )
        Row(
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
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
            YummyImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)
                    .clickable {
                        favoriteClicked.invoke()
                    },
                imgResId = if (isFavourite) R.drawable.ic_favourite else R.drawable.ic_no_favourite,
            )
        }
    }
}


@Preview
@Composable
fun YummyCardTwoPreview() {
    CardTwo()
}