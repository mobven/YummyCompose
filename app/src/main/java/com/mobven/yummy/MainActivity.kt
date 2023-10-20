package com.mobven.yummy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mobven.designsystem.components.bottomnavbar.YummyBottomNavBar
import com.mobven.designsystem.favourite.FavouriteScreen
import com.mobven.designsystem.home.HomeScreen
import com.mobven.designsystem.navbarnavigation.Route
import com.mobven.designsystem.order.OrderScreen
import com.mobven.designsystem.reward.RewardScreen
import com.mobven.designsystem.util.navigate
import com.mobven.yummy.ui.theme.YummyComposeTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YummyComposeTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        YummyBottomNavBar(
                            modifier = Modifier.fillMaxWidth(),
                            navController = navController,
                            backStackEntryState = navController.currentBackStackEntryAsState()
                        )
                    }
                ) {
                    NavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        navController = navController,
                        startDestination = Route.HOME
                    ) {
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
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YummyComposeTheme {
        Greeting("Android")
    }
}