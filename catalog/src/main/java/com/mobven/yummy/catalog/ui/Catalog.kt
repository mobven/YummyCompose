package com.mobven.yummy.catalog.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
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
import com.mobven.designsystem.components.buttons.CheckoutYummyButtonPreview
import com.mobven.designsystem.components.buttons.CircularCounterButton
import com.mobven.designsystem.components.buttons.CounterButton
import com.mobven.designsystem.components.buttons.CounterButtonPreview
import com.mobven.designsystem.components.buttons.CounterButtonType
import com.mobven.designsystem.components.buttons.DetailedYummyButton
import com.mobven.designsystem.components.buttons.DetailedYummyButtonPreview
import com.mobven.designsystem.components.buttons.DisabledYummyButtonPreview
import com.mobven.designsystem.components.buttons.EnabledYummyButtonPreview
import com.mobven.designsystem.components.buttons.LikeButton
import com.mobven.designsystem.components.buttons.PreviewLikeButton
import com.mobven.designsystem.components.buttons.SocialMediaButton
import com.mobven.designsystem.components.buttons.SocialMediaButtonPreview
import com.mobven.designsystem.components.buttons.TinyCounterButtonPreview
import com.mobven.designsystem.components.buttons.YummyButton
import com.mobven.designsystem.components.buttons.YummyButtonContent
import com.mobven.designsystem.components.buttons.YummySegmentedButtonPreview
import com.mobven.designsystem.components.common.CardOnePreview
import com.mobven.designsystem.components.common.CardTwo
import com.mobven.designsystem.components.common.YummyBigCardPreview
import com.mobven.designsystem.components.common.YummyCardTwoPreview
import com.mobven.designsystem.theme.additionalDark

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
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        CircularCounterButton(5) {
                            Toast.makeText(context, "Circular Counter Button", Toast.LENGTH_SHORT)
                                .show()
                        }
                        CounterButtonPreview()
                        CounterButton(
                            type = CounterButtonType.BIG,
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
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        PreviewLikeButton()
                    }
                }
                item { Text("Social Media Buttons", Modifier.padding(top = 16.dp)) }
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        SocialMediaButtonPreview()
                    }
                }
                item { Text("Yummy Buttons", Modifier.padding(top = 16.dp)) }
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        EnabledYummyButtonPreview()
                        DisabledYummyButtonPreview()
                        DetailedYummyButtonPreview()
                        CheckoutYummyButtonPreview()
                    }
                }
                item { Text("Segmented Button", Modifier.padding(top = 16.dp)) }
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        YummySegmentedButtonPreview()
                    }
                }
                item { Text("Yummy Cards", Modifier.padding(top = 16.dp)) }
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        YummyBigCardPreview()
                        CardOnePreview()
                        YummyCardTwoPreview()
                    }
                }
            }
        }
    }
}