package com.mobven.designsystem.components.bottomnavbar

import androidx.annotation.DrawableRes
import androidx.compose.animation.Crossfade
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
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mobven.components.R
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.navbarnavigation.Route
import com.mobven.designsystem.theme.AdditionalDark
import com.mobven.designsystem.theme.AdditionalWhite
import com.mobven.designsystem.theme.MainPrimary
import com.mobven.designsystem.theme.NeutralGrayscale10
import com.mobven.designsystem.theme.NeutralGrayscale80
import com.mobven.designsystem.theme.h5SemiBoldStyle
import com.mobven.designsystem.util.UiEvent
import com.mobven.designsystem.util.navigate


@Composable
fun YummyBottomNavBar(
    navController: NavController,
    backStackEntryState: State<NavBackStackEntry?>,
    modifier: Modifier = Modifier,
) {

    val selectedItemTitle = backStackEntryState.value?.destination?.route ?: Route.HOME

    Row(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 20.dp,
                spotColor = AdditionalDark,
                ambientColor = AdditionalDark
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
            selectedItemTitle = selectedItemTitle,
            clickItemCallBack = {
                navController.navigate(UiEvent.Navigate(Route.HOME))
            }
        )
        ItemBottomNavBar(
            selectedIcon = R.drawable.ic_favourite_selected,
            unselectedIcon = R.drawable.ic_favourite_unselected,
            title = "Favourite",
            selectedItemTitle = selectedItemTitle,
            clickItemCallBack = {
                navController.navigate(UiEvent.Navigate(Route.FAVOURITE))
            }
        )
        ItemBottomNavBar(
            selectedIcon = R.drawable.ic_order_selected,
            unselectedIcon = R.drawable.ic_order_unselected,
            title = "Order",
            selectedItemTitle = selectedItemTitle,
            clickItemCallBack = {
                navController.navigate(UiEvent.Navigate(Route.ORDER))
            }
        )
        ItemBottomNavBar(
            selectedIcon = R.drawable.ic_reward_selected,
            unselectedIcon = R.drawable.ic_reward_unselected,
            title = "Reward",
            selectedItemTitle = selectedItemTitle,
            clickItemCallBack = {
                navController.navigate(UiEvent.Navigate(Route.REWARD))
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
                selected = selectedItemTitle.equals(title, true),
                onClick = clickItemCallBack,
                enabled = true,
                role = Role.Tab,
                interactionSource = interactionSource,
                indication = null
            )
            .weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Crossfade(targetState = selectedItemTitle.equals(title, true), label = "") { isSelected ->
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
        navController = rememberNavController(),
        backStackEntryState = rememberNavController().currentBackStackEntryAsState()
    )
}

@Preview
@Composable
fun YummyBottomNavBarFavouritePreview() {
    YummyBottomNavBar(
        navController = rememberNavController(),
        backStackEntryState = rememberNavController().currentBackStackEntryAsState()
    )
}

@Preview
@Composable
fun YummyBottomNavBarOrderPreview() {
    YummyBottomNavBar(
        navController = rememberNavController(),
        backStackEntryState = rememberNavController().currentBackStackEntryAsState()
    )
}

@Preview
@Composable
fun YummyBottomNavBarRewardPreview() {
    MaterialTheme {
        YummyBottomNavBar(
            navController = rememberNavController(),
            backStackEntryState = rememberNavController().currentBackStackEntryAsState()
        )
    }
}