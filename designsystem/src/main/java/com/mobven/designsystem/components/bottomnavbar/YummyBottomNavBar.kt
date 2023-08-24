package com.mobven.designsystem.components.bottomnavbar

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobven.components.R
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.theme.AdditionalWhite
import com.mobven.designsystem.theme.MainPrimary
import com.mobven.designsystem.theme.NeutralGrayscale10
import com.mobven.designsystem.theme.NeutralGrayscale80
import com.mobven.designsystem.theme.h5SemiBoldStyle
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
            .padding(top = 12.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 20.dp,
                spotColor = AdditionalWhite,
                ambientColor = AdditionalWhite
            )
            .height(88.dp)
            .background(color = NeutralGrayscale10),
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
fun RowScope.ItemBottomNavBar(
    @DrawableRes unselectedIcon: Int,
    @DrawableRes selectedIcon: Int,
    title: String,
    clickItemCallBack: () -> Unit,
    selectedItemTitle: String,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    Column(
        modifier = modifier
            .selectable(
                selected = selectedItemTitle == title,
                onClick = clickItemCallBack,
                enabled = true,
                role = Role.Tab,
                interactionSource = interactionSource,
                indication = null
            )
            .fillMaxSize()
            .weight(1f),
    ) {

        Crossfade(targetState = selectedItemTitle == title, label = "") { isSelected ->
            ItemIconNavBar(
                isSelected = isSelected,
                title = title,
                unselectedIcon = unselectedIcon,
                selectedIcon = selectedIcon
            )
        }
    }

}

@Composable
fun ItemIconNavBar(
    isSelected: Boolean,
    title: String,
    @DrawableRes unselectedIcon: Int,
    @DrawableRes selectedIcon: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        YummyIcon(
            painterRes = if (isSelected) selectedIcon else unselectedIcon,
            tint = if (isSelected) MainPrimary else NeutralGrayscale80
        )
        VerticalSpacer(4.dp)
        Text(
            text = title,
            style = MaterialTheme.typography.h5SemiBoldStyle,
            color = if (isSelected) MainPrimary else NeutralGrayscale80
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