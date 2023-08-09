package com.mobven.designsystem.components.bottomnavbar

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.theme.AdditionalWhite
import com.mobven.designsystem.theme.MainPrimary
import com.mobven.designsystem.theme.NeutralGrayscale10
import com.mobven.designsystem.theme.NeutralGrayscale80
import com.mobven.designsystem.theme.sfProFamily


@Composable
fun YummyBottomNavBar(
    navigationHomeScreen: () -> Unit,
    navigationFavouriteScreen: () -> Unit,
    navigationOrderScreen: () -> Unit,
    navigationRewardScreen: () -> Unit,
    selectedItemTitle: String,
    modifier: Modifier = Modifier
) {

    var stateSelectedItemTitle by remember {
        mutableStateOf(selectedItemTitle)
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 20.dp,
                spotColor = AdditionalWhite,
                ambientColor = AdditionalWhite
            )
            .height(88.dp)
            .background(color = NeutralGrayscale10)
            .padding(top = 12.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ItemBottomNavBar(
            selectedIcon = R.drawable.ic_home_selected,
            unselectedIcon = R.drawable.ic_home_unselected,
            title = "Home",
            selectedItemTitle = stateSelectedItemTitle,
            clickItemCallBack = {
                stateSelectedItemTitle = "Home"
                navigationHomeScreen.invoke()
            }
        )
        ItemBottomNavBar(
            selectedIcon = R.drawable.ic_favourite_selected,
            unselectedIcon = R.drawable.ic_favourite_unselected,
            title = "Favourite",
            selectedItemTitle = stateSelectedItemTitle,
            clickItemCallBack = {
                stateSelectedItemTitle = "Favourite"
                navigationFavouriteScreen.invoke()
            }
        )
        ItemBottomNavBar(
            selectedIcon = R.drawable.ic_order_selected,
            unselectedIcon = R.drawable.ic_order_unselected,
            title = "Order",
            selectedItemTitle = stateSelectedItemTitle,
            clickItemCallBack = {
                stateSelectedItemTitle = "Order"
                navigationOrderScreen.invoke()
            }
        )
        ItemBottomNavBar(
            selectedIcon = R.drawable.ic_reward_selected,
            unselectedIcon = R.drawable.ic_reward_unselected,
            title = "Reward",
            selectedItemTitle = stateSelectedItemTitle,
            clickItemCallBack = {
                stateSelectedItemTitle = "Reward"
                navigationRewardScreen.invoke()
            }
        )
    }
}

@Composable
fun ItemBottomNavBar(
    @DrawableRes unselectedIcon: Int,
    @DrawableRes selectedIcon: Int,
    title: String,
    clickItemCallBack: () -> Unit,
    selectedItemTitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clickable {
                clickItemCallBack.invoke()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        YummyIcon(
            painterRes = if (selectedItemTitle == title) selectedIcon else unselectedIcon,
            tint = if (selectedItemTitle == title) MainPrimary else NeutralGrayscale80
        )
        VerticalSpacer(4.dp)
        Text(
            text = title,
            fontFamily = sfProFamily,
            color = if (selectedItemTitle == title) MainPrimary else NeutralGrayscale80
        )
    }

}

@Preview
@Composable
fun YummyBottomNavBarHomePreview() {
    YummyBottomNavBar(
        navigationHomeScreen = {},
        navigationFavouriteScreen = {},
        navigationOrderScreen = {},
        navigationRewardScreen = {},
        selectedItemTitle = "Home"
    )
}

@Preview
@Composable
fun YummyBottomNavBarFavouritePreview() {
    YummyBottomNavBar(
        navigationHomeScreen = {},
        navigationFavouriteScreen = {},
        navigationOrderScreen = {},
        navigationRewardScreen = {},
        selectedItemTitle = "Favourite"
    )
}

@Preview
@Composable
fun YummyBottomNavBarOrderPreview() {
    YummyBottomNavBar(
        navigationHomeScreen = {},
        navigationFavouriteScreen = {},
        navigationOrderScreen = {},
        navigationRewardScreen = {},
        selectedItemTitle = "Order"
    )
}

@Preview
@Composable
fun YummyBottomNavBarRewardPreview() {
    YummyBottomNavBar(
        navigationHomeScreen = {},
        navigationFavouriteScreen = {},
        navigationOrderScreen = {},
        navigationRewardScreen = {},
        selectedItemTitle = "Reward"
    )
}