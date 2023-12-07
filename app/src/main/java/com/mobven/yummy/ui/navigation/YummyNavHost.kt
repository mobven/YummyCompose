package com.mobven.yummy.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mobven.designsystem.favourite.FavouriteScreen
import com.mobven.designsystem.home.HomeScreen
import com.mobven.designsystem.navbarnavigation.Route
import com.mobven.designsystem.order.OrderScreen
import com.mobven.designsystem.reward.RewardScreen
import com.mobven.designsystem.util.navigate
import com.mobven.yummy.ui.screens.login.LoginScreen

@Composable
fun YummyNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Route.LOGIN
    ) {
        composable(Route.LOGIN) {
            LoginScreen({
                        navController.popBackStack()
            }, {
                navController.navigate(Route.)
            })
        }
        composable(Route.HOME) {
            HomeScreen(onNavigate = navController::navigate)
        }
        composable(Route.FAVOURITE) {
            FavouriteScreen(onNavigate = navController::navigate)
        }
        composable(Route.ORDER) {
            OrderScreen(onNavigate = navController::navigate)
        }
        composable(Route.REWARD) {
            RewardScreen(onNavigate = navController::navigate)
        }
    }
}