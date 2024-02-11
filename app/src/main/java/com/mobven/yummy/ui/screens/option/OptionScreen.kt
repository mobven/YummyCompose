package com.mobven.yummy.ui.screens.option

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.designsystem.components.buttons.CircularCounterButton
import com.mobven.designsystem.components.buttons.CounterButton
import com.mobven.designsystem.components.buttons.CounterButtonType
import com.mobven.designsystem.components.buttons.YummyButton
import com.mobven.designsystem.components.chip.LazyRowYummyCircleChip
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.components.common.YummyImage
import com.mobven.designsystem.components.inputs.MultilineInputFiled
import com.mobven.designsystem.components.text.ReadMoreClickableText
import com.mobven.designsystem.components.text.YummyHead1SemiBoldText
import com.mobven.designsystem.components.text.YummyHead3SemiBoldText
import com.mobven.designsystem.components.text.YummyHead4MediumText
import com.mobven.designsystem.components.text.YummyHead4SemiBoldText
import com.mobven.designsystem.components.toolbar.YummyToolbar
import com.mobven.designsystem.theme.h2BoldStyle
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.mainPrimary
import com.mobven.designsystem.theme.neutralGrayscale100
import com.mobven.designsystem.theme.neutralGrayscale50
import com.mobven.designsystem.theme.neutralGrayscale70
import com.mobven.designsystem.util.yummyPadding
import com.mobven.yummy.R

@Composable
fun OptionScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Column {
                YummyImage(
                    imgResId = R.drawable.img_banner_option,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(172.dp),
                    contentScale = ContentScale.Crop
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .yummyPadding(
                            horizontal = 24.dp,
                            top = 16.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    YummyHead1SemiBoldText(
                        text = "Hamburger"
                    )
                    YummyHead3SemiBoldText(
                        text = "$32.04",
                        color = MaterialTheme.colorScheme.mainPrimary
                    )
                }

                ReadMoreClickableText(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Tortor ac leo lorem nisl. Viverra vulputate sodales quis et dui, lacus. Iaculis eu egestas egestas vulputate sodales quis et dui, lacus. Iaculis eu egestas egestas , lacus. Iaculis eu egestas egestas ",
                    readMoreText = " Read More",
                    textStyle = MaterialTheme.typography.h4MediumStyle.copy(
                        color = MaterialTheme.colorScheme.neutralGrayscale70
                    ),
                    minimizedMaxLines = 3,
                    modifier = Modifier
                        .fillMaxWidth()
                        .yummyPadding(
                            horizontal = 24.dp,
                            top = 12.dp
                        )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .yummyPadding(
                            horizontal = 24.dp,
                            top = 40.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    YummyHead4SemiBoldText(
                        text = "Quantity"
                    )

                    var counterValue by remember {
                        mutableIntStateOf(0)
                    }

                    CounterButton(type = CounterButtonType.BIG, counterValue) {
                        counterValue = if (it >= 0) it else 0
                    }
                }

                Divider(
                    color = MaterialTheme.colorScheme.neutralGrayscale50,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                )
            }
        }

        item {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .yummyPadding(
                            horizontal = 24.dp,
                            top = 16.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    YummyHead4SemiBoldText(
                        text = "Size"
                    )

                    LazyRowYummyCircleChip(
                        chipList = listOf("S", "L", "XL"),
                        contentPadding = PaddingValues(),
                        itemPadding = PaddingValues(start = 16.dp)
                    )
                }

                TopingColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                )

                YummyHead4SemiBoldText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .yummyPadding(
                            horizontal = 24.dp,
                            top = 16.dp
                        ),
                    text = "Notes"
                )

                var noteText by remember {
                    mutableStateOf("")
                }

                MultilineInputFiled(
                    value = noteText,
                    hint = "Do you have something to say to the restaurant? Are not ?",
                    onValueChanged = { noteText = it },
                    modifier = Modifier
                        .yummyPadding(
                            horizontal = 24.dp,
                            top = 16.dp
                        )
                )


                YummyButton(
                    text = "Add to Cart - $23",
                    modifier = Modifier
                        .fillMaxWidth()
                        .yummyPadding(
                            horizontal = 24.dp,
                            top = 24.dp,
                            bottom = 8.dp
                        )
                ) {

                }
            }
        }
    }
}

@Composable
fun TopingColumn(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        YummyHead4SemiBoldText(
            modifier = Modifier
                .fillMaxWidth()
                .yummyPadding(
                    horizontal = 24.dp
                ),
            text = "Toping"
        )

        var counterValueMushroom by remember {
            mutableIntStateOf(0)
        }

        CounterTextRow(
            counterValue = counterValueMushroom,
            centerText = "Mushroom",
            endText = "3.00$",
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            counterValueMushroom = if (it >= 0) it else 0
        }

        var counterValuePaprika by remember {
            mutableIntStateOf(1)
        }

        CounterTextRow(
            counterValue = counterValuePaprika,
            centerText = "Paprika",
            endText = "$3.02",
            type = CounterTextRowType.CircularCounterButton
        ) {
            counterValuePaprika = if (it >= 0) it else 0
        }

        var counterValueMozarella by remember {
            mutableIntStateOf(1)
        }

        CounterTextRow(
            counterValue = counterValueMozarella,
            centerText = "Mozarella Cheese",
            endText = "$3.00",
            type = CounterTextRowType.CircularCounterButton
        ) {
            counterValueMozarella = if (it >= 0) it else 0
        }

        var counterValueBeef by remember {
            mutableIntStateOf(1)
        }

        CounterTextRow(
            counterValue = counterValueBeef,
            centerText = "Beef",
            endText = "$2.00",
            type = CounterTextRowType.CircularCounterButton
        ) {
            counterValueBeef = if (it >= 0) it else 0
        }
    }
}

@Composable
fun CounterTextRow(
    counterValue: Int,
    modifier: Modifier = Modifier,
    centerText: String = "",
    endText: String = "",
    type: CounterTextRowType = CounterTextRowType.CounterButton(CounterButtonType.BIG),
    onCounterChanged: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
            .padding(
                top = 12.dp
            )

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 24.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            when (type) {
                CounterTextRowType.CircularCounterButton -> {
                    CircularCounterButton(
                        multiplier = counterValue,
                        onClick = onCounterChanged
                    )
                }

                is CounterTextRowType.CounterButton -> {
                    CounterButton(
                        type = type.counterButtonType,
                        counterValue = counterValue,
                        onCounterChanged = onCounterChanged,
                        modifier = Modifier.size(width = 96.dp, height = 32.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )

            YummyHead4MediumText(
                text = centerText,
                modifier = Modifier
                    .padding(start = 12.dp)
            )
            YummyHead4MediumText(
                text = endText,
                modifier = Modifier
                    .padding(start = 12.dp)
            )

        }

        Divider(
            color = MaterialTheme.colorScheme.neutralGrayscale50,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun OptionScreenPreview() {
    MaterialTheme {
        Scaffold(
            topBar = {
                YummyToolbar(
                    title = {
                        Text(
                            text = "Option", style = MaterialTheme.typography.h2BoldStyle
                                .copy(color = MaterialTheme.colorScheme.neutralGrayscale100)
                        )
                    },
                    leadingIcon = {
                        YummyIcon(
                            painterRes = com.mobven.components.R.drawable.ic_arrow_left
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                OptionScreen()
            }
        }
    }
}

