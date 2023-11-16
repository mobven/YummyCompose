package com.mobven.yummy.presentation.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.designsystem.components.buttons.LikeButton
import com.mobven.designsystem.components.chip.LazyRowYummyChip
import com.mobven.designsystem.components.common.CardOne
import com.mobven.designsystem.components.common.YummyAsyncImage
import com.mobven.designsystem.components.common.YummyBigCard
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.components.text.YummyHead2SemiBoldText
import com.mobven.designsystem.components.text.YummyHead5MediumText
import com.mobven.designsystem.components.text.YummyHead5SemiBoldText
import com.mobven.designsystem.components.text.YummyHeadText
import com.mobven.designsystem.theme.neutralGrayscale60
import com.mobven.designsystem.theme.neutralGrayscale80
import com.mobven.designsystem.theme.neutralGrayscale90
import com.mobven.designsystem.theme.semanticSuccess
import com.mobven.yummy.R


@Composable
fun ShopScreen(
    onBackPressed: () -> Unit = {},
    favoritePressed: (name: String) -> Unit = {}
) {

    val chipList = listOf(
        "For You", "Noodles", "Rice", "Tacos", "Burger"
    )

    var selected by remember {
        mutableStateOf(chipList.firstOrNull().orEmpty())
    }

    val restaurant = Restaurant(
        name = "Grandma's shop",
        bannerImage = "https://dil-rjcorp.com/wp-content/uploads/2021/05/banner55.png",
        iconImage = "https://cdn.iconscout.com/icon/free/png-256/free-kfc-2-226243.png",
        isFavourite = false,
        address = "NYC, Broadway ave 79",
        distance = "",
        votes = "(1.2K)",
        rate = "4.8",
        totalOrders = "99+ orders"
    )

    LazyColumn(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
    ) {
        item {
            TopBanner(
                restaurant = restaurant,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background),
                backPressed = {
                    onBackPressed()
                },
                favouritePressed = {
                    favoritePressed.invoke("")
                },
                reviewsPressed = { }
            )
        }

        YummyShops(
            chipList,
            selected,
        ) {
            selected = it
        }

    }
}

@Composable
private fun TopBanner(
    restaurant: Restaurant,
    modifier: Modifier = Modifier,
    backPressed: () -> Unit,
    favouritePressed: () -> Unit,
    reviewsPressed: () -> Unit
) {
    val horizontalPadding = 24.dp

    Column(
        modifier = modifier
    ) {
        Box {
            YummyAsyncImage(
                imageUrl = restaurant.bannerImage,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .align(Alignment.TopCenter),
                placeholder = painterResource(id = R.drawable.placeholder_restaurant_banner),
                contentScaleType = ContentScale.Crop,
            )
            IconButton(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 57.dp, start = 24.dp)
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                onClick = {
                    backPressed.invoke()
                }
            ) {
                YummyIcon(painterRes = R.drawable.ic_arrow_left)
            }

            YummyAsyncImage(
                imageUrl = restaurant.iconImage,
                modifier = Modifier
                    .padding(
                        start = 24.dp,
                        top = 141.dp
                    )
                    .align(Alignment.BottomStart)
                    .size(80.dp)
                    .border(5.dp, MaterialTheme.colorScheme.background, CircleShape)
                    .padding(0.5.dp) // border 'ın dışında image in izi kalıyordu.
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.placeholder_restaurant_logo),
                contentScaleType = ContentScale.Crop,
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            YummyHeadText(
                text = restaurant.name,
            )

            LikeButton(
                isLiked = restaurant.isFavourite,
            ) {
                favouritePressed.invoke()
            }
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding)
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                YummyHead5MediumText(
                    text = restaurant.address
                )
                YummyHead5SemiBoldText(
                    text = "Opening",
                    color = MaterialTheme.colorScheme.semanticSuccess,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )
            }

            YummyIcon(
                painterRes = R.drawable.ic_info_circle
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding)
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(16.dp)
            )
            YummyHead5MediumText(
                text = restaurant.rate,
                color = MaterialTheme.colorScheme.neutralGrayscale90,
                modifier = Modifier
                    .padding(start = 2.dp)
            )
            YummyHead5MediumText(
                text = restaurant.votes,
                color = MaterialTheme.colorScheme.neutralGrayscale80,
                modifier = Modifier
                    .padding(start = 4.dp)
            )

            YummyIcon(
                painterRes = R.drawable.ic_bag_16,
                modifier = Modifier
                    .padding(start = 8.dp),
                tint = MaterialTheme.colorScheme.neutralGrayscale90
            )

            YummyHead5MediumText(
                text = restaurant.totalOrders,
                color = MaterialTheme.colorScheme.neutralGrayscale80,
                modifier = Modifier
                    .padding(start = 2.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            YummyHead5SemiBoldText(
                text = "Reviews",
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    reviewsPressed.invoke()
                }
            )

        }
    }
}

private fun LazyListScope.YummyShops(
    chipList: List<String>,
    selected: String,
    navigateToAllRestaurant: (name: String) -> Unit = {},
    selectedChipItem: (String) -> Unit
) {

    val horizontalPadding = 24.dp

    item {
        LazyRowYummyChip(
            chipList = chipList,
            startPadding = horizontalPadding,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            selectedChipItem.invoke(it)
        }
    }

    item {
        Row(
            modifier = Modifier
                .padding(horizontal = horizontalPadding)
                .padding(top = 24.dp)
                .clickable {
                    navigateToAllRestaurant.invoke(selected)
                }
        ) {
            YummyHead2SemiBoldText(
                text = selected,
                modifier = Modifier
                    .weight(1f)
            )
            YummyIcon(
                painterRes = com.mobven.components.R.drawable.ic_arrow_right,
                tint = Color.Black,
                modifier = Modifier
            )
        }
    }

    item {

        val listCardOne = (0..6).toList()

        LazyRow(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            items(listCardOne) {
                val startPadding = if (listCardOne.firstOrNull() == it) horizontalPadding else 0.dp

                CardOne(
                    title = "Pizza Hut",
                    imgResId = com.mobven.components.R.drawable.card_one_image,
                    distance = "1.5 km",
                    rating = 4.8,
                    reviewCount = "1.2k",
                    discountText = "%4 off your order",
                    isDiscountTextVisible = true,
                    isPromoVisible = true,
                    modifier = Modifier
                        .padding(start = startPadding, end = 14.dp)
                )
            }
        }
    }

    item {
        YummyHead2SemiBoldText(
            text = "Phở",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding)
                .padding(
                    top = 24.dp,
                    bottom = 16.dp
                )
        )
    }

    val listRestaurant = (0..6).toList()

    items(listRestaurant) {item ->
        Column {
            val restaurant = com.mobven.designsystem.components.common.Restaurant(
                "Hamburger",
                "1.5 km",
                "4.8",
                true,
                "1.2k"
            )
            YummyBigCard(
                true,
                restaurant,
                4,
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
                    .padding(bottom = 16.dp)
            )

            if (item != listRestaurant.last()) {
                Divider(
                    color = MaterialTheme.colorScheme.neutralGrayscale60,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .height(1.dp)
                )
            }
        }

    }
}

@Composable
@Preview
fun ShopScreenPreview() {
    MaterialTheme {
        ShopScreen()
    }
}