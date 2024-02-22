package com.mobven.yummy.presentation.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.designsystem.components.chip.LazyHorizontalStaggeredYummyChip
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.components.search.SearchBar
import com.mobven.designsystem.theme.additionalDark
import com.mobven.designsystem.theme.h1BoldStyle
import com.mobven.designsystem.theme.h3NormalStyle
import com.mobven.designsystem.theme.h4SemiBoldStyle
import com.mobven.designsystem.theme.h5NormalStyle
import com.mobven.designsystem.theme.mainPrimary
import com.mobven.designsystem.theme.neutralGrayscale80
import com.mobven.designsystem.theme.neutralGrayscale90
import com.mobven.yummy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onBackPressed: () -> Unit = {}
) {
    var textState by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .height(80.dp)
                    .shadow(
                        15.dp,
                        spotColor = MaterialTheme
                            .colorScheme
                            .additionalDark.copy(alpha = 0.7f)
                    ),
                title = {
                    SearchBar(
                        text = textState,
                        onTextChange = { newText ->
                            textState = newText
                        },
                        hint = "What are you yearning for?",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, top = 10.dp)
                    )
                },
                navigationIcon = {
                    YummyIcon(
                        painterRes = com.mobven.components.R.drawable.ic_arrow_left,
                        tint = MaterialTheme.colorScheme.neutralGrayscale90,
                        modifier = Modifier.padding(start = 20.dp, top = 28.dp)
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val item = arrayListOf(
                SearchChipModel(
                    title = "Recent Search",
                    chipList = arrayListOf(
                        "Pizza",
                        "Hamburger",
                        "Meat Bread",
                        "Sushi",
                        "Donat",
                        "Ramen"
                    )
                ),
                SearchChipModel(
                    title = "Popular",
                    chipList = arrayListOf("Pizza", "Hamburger", "Meat Bread")
                )
            )

            AnimatedVisibility(visible = textState.isNotEmpty()) {
                Column {
                    Text(
                        text = "Not Found",
                        style = MaterialTheme.typography.h1BoldStyle,
                        color = MaterialTheme.colorScheme.mainPrimary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(40.dp, 24.dp, 40.dp, 12.dp)
                    )
                    Text(
                        text = "Sorry, the keyword could not be found, please try again with another keyword.",
                        style = MaterialTheme.typography.h3NormalStyle,
                        color = MaterialTheme.colorScheme.neutralGrayscale80,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 35.dp)
                    )
                }
            }

            AnimatedVisibility(visible = textState.isNullOrEmpty()) {
                Column(
                    modifier = Modifier.padding(top = 6.dp)
                ) {
                    item.forEach {
                        Text(
                            text = it.title,
                            style = MaterialTheme.typography.h4SemiBoldStyle,
                            modifier = Modifier.padding(24.dp, 24.dp, 18.dp, 8.dp)
                        )
                        LazyHorizontalStaggeredYummyChip(
                            chipList = it.chipList,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 17.dp),
                            style = MaterialTheme.typography.h5NormalStyle
                        ) {
                            textState = it
                        }
                    }
                }
            }
        }
    }
}


@Composable
@Preview
fun SearchScreenPreview() {
    MaterialTheme {
        SearchScreen()
    }
}