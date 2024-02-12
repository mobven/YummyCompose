package com.mobven.yummy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.mobven.yummy.ui.navigation.YummyNavHost
import com.mobven.yummy.ui.screens.chat.CallScreen
import com.mobven.yummy.ui.screens.chat.ChatScreen
import com.mobven.yummy.ui.theme.YummyComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            YummyComposeTheme {

                YummyNavHost(
                    modifier = Modifier
                        .fillMaxSize()
                        .navigationBarsPadding()
                )

                //ChatScreen()
                //CallScreen()

                /* YummyBottomNavBar(
                     modifier = Modifier.fillMaxWidth(),
                     navController = navController,
                     backStackEntryState = navController.currentBackStackEntryAsState()
                 )*/

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