package com.mobven.yummy.catalog.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.bottomnavbar.YummyBottomNavBar
import com.mobven.designsystem.components.buttons.CheckoutYummyButton
import com.mobven.designsystem.components.buttons.CircularCounterButton
import com.mobven.designsystem.components.buttons.CounterButton
import com.mobven.designsystem.components.buttons.CounterButtonType
import com.mobven.designsystem.components.buttons.DetailedYummyButton
import com.mobven.designsystem.components.buttons.LikeButton
import com.mobven.designsystem.components.buttons.SocialMediaButton
import com.mobven.designsystem.components.buttons.YummyButton
import com.mobven.designsystem.components.buttons.YummyButtonContent
import com.mobven.designsystem.components.buttons.YummySegmentedButton
import com.mobven.designsystem.theme.additionalDark

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Catalog() {

    val context = LocalContext.current

    MaterialTheme {
        Surface {
            val contentPadding = WindowInsets
                .systemBars
                .add(WindowInsets(left = 16.dp, top = 16.dp, right = 16.dp, bottom = 16.dp))
                .asPaddingValues()
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = contentPadding,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item { Text("Bottom Nav Bar", Modifier.padding(top = 16.dp)) }
                item {
                    YummyBottomNavBar(
                        navigationHomeScreen = {
                            Toast.makeText(
                                context,
                                "Home Menu",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        navigationFavouriteScreen = {
                            Toast.makeText(
                                context,
                                "Fav Menu",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        navigationOrderScreen = {
                            Toast.makeText(
                                context,
                                "Order Menu",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        navigationRewardScreen = {
                            Toast.makeText(
                                context,
                                "Reward Menu",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        selectedItemTitle = "Home"
                    )
                }
                item { Text("Counter Buttons", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        CircularCounterButton(5) {
                            Toast.makeText(context, "Circular Counter Button", Toast.LENGTH_SHORT)
                                .show()
                        }
                        CounterButton(
                            type = CounterButtonType.BIG,
                            counterValue = 3,
                            onCounterChanged = {
                                Toast.makeText(
                                    context,
                                    "Big Counter Button: $it",
                                    Toast.LENGTH_SHORT
                                ).show()
                            })
                        CounterButton(
                            type = CounterButtonType.NORMAL,
                            counterValue = 3,
                            onCounterChanged = {
                                Toast.makeText(
                                    context,
                                    "Normal Counter Button: $it",
                                    Toast.LENGTH_SHORT
                                ).show()
                            })
                    }
                }
                item { Text("Like Buttons", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        LikeButton(isLiked = true) {
                            Toast.makeText(context, "Like Button Clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
                item { Text("Social Media Buttons", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        SocialMediaButton(
                            "Continue with Google",
                            R.drawable.ic_google,
                            modifier = Modifier.fillMaxWidth(),
                            Color(0xFF5384EE)
                        ) {}
                        SocialMediaButton(
                            "Continue with Facebook ",
                            R.drawable.ic_facebook,
                            modifier = Modifier.fillMaxWidth(),
                            Color(0xFF415792)
                        ) {}
                        SocialMediaButton(
                            "Continue with Apple",
                            R.drawable.ic_apple,
                            modifier = Modifier.fillMaxWidth(),
                            MaterialTheme.colorScheme.additionalDark
                        ) {}
                    }
                }
                item { Text("Yummy Buttons", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        YummyButton("Yummy Button Enabled") {
                            Toast.makeText(context, "Yummy Button Clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                        YummyButton("Yummy Button Disabled", isEnabled = false) {
                            Toast.makeText(context, "Like Button Clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                        DetailedYummyButton(
                            size = 3, content = listOf(
                                YummyButtonContent(
                                    imgUrl = null, imgRes = null, contentSize = null
                                ),
                                YummyButtonContent(
                                    imgUrl = null, imgRes = null, contentSize = 2
                                ),
                                YummyButtonContent(
                                    imgUrl = null, imgRes = null, contentSize = null
                                )
                            )
                        ) {
                            Toast.makeText(
                                context,
                                "Detailed Yummy Button Clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        CheckoutYummyButton(multiplier = "2", amount = "100.00") {
                            Toast.makeText(
                                context,
                                "Checkout Yummy Button Clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
                item { Text("Segmented Button", Modifier.padding(top = 16.dp)) }
                item {
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        YummySegmentedButton(
                            firstTitle = "First",
                            secondTitle = "Second",
                            animationDurationInMillis = 300,
                            onIndexChanged = {
                                Toast.makeText(
                                    context,
                                    "Segmented Button Change: $it",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )
                    }
                }
            }
        }
    }
}