package com.mobven.yummy.ui.screens.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobven.designsystem.components.common.HorizontalSpacer
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.YummyIcon
import com.mobven.designsystem.components.common.YummyImage
import com.mobven.designsystem.components.inputs.ChatInput
import com.mobven.designsystem.components.toolbar.YummyToolbar
import com.mobven.designsystem.theme.additionalGrey
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.caption
import com.mobven.designsystem.theme.h2BoldStyle
import com.mobven.designsystem.theme.h5NormalStyle
import com.mobven.designsystem.theme.mainPrimary
import com.mobven.designsystem.theme.neutralGrayscale100
import com.mobven.designsystem.theme.neutralGrayscale90
import com.mobven.yummy.R
import com.mobven.yummy.ui.theme.YummyComposeTheme
import kotlinx.coroutines.launch

@Composable
fun ChatScreen() {

    val messages = remember {
        mutableStateListOf<String>()
    }

    val lazyListState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Header(
            title = "Message"
        )
        Body(
            messages = messages, lazyListState = lazyListState
        )
        Footer(onSendClicked = { message ->
            messages.add(message)
            scope.launch {
                lazyListState.animateScrollToItem(messages.lastIndex)
            }
        })
    }
}

@Composable
private fun Header(
    title: String
) {
    YummyToolbar(modifier = Modifier.fillMaxWidth(), title = {
        Text(text = title, style = with(MaterialTheme) {
            typography.h2BoldStyle.copy(color = colorScheme.neutralGrayscale100)
        })
    }, leadingIcon = {
        YummyIcon(
            painterRes = com.mobven.components.R.drawable.ic_arrow_left_with_frame,
            tint = MaterialTheme.colorScheme.neutralGrayscale90
        )
    }, trailingIcon = {
        YummyIcon(
            painterRes = com.mobven.components.R.drawable.ic_call
        )
    })
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ColumnScope.Body(
    messages: List<String>, lazyListState: LazyListState
) {
    LazyColumn(
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        state = lazyListState,
        modifier = Modifier
            .weight(1f)
            .imeNestedScroll()
    ) {
        itemsIndexed(messages) { index, message ->
            MessageItem(
                message = message,
                isIncomingMessage = index % 2 == 0,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun MessageItem(
    message: String, isIncomingMessage: Boolean, modifier: Modifier = Modifier
) {
    CompositionLocalProvider(
        LocalLayoutDirection provides if (isIncomingMessage) {
            LayoutDirection.Ltr
        } else {
            LayoutDirection.Rtl
        }
    ) {
        Column(modifier = modifier) {
            Row {
                YummyImage(
                    imgResId = R.drawable.planet,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(38.dp)
                        .align(Alignment.Bottom),
                )

                HorizontalSpacer(width = 8.dp)

                Column {
                    Text(
                        text = message,
                        style = MaterialTheme.typography.h5NormalStyle,
                        textAlign = TextAlign.Left,
                        color = with(MaterialTheme.colorScheme) { if (isIncomingMessage) neutralGrayscale100 else additionalWhite },
                        modifier = Modifier
                            .background(
                                with(MaterialTheme.colorScheme) { if (isIncomingMessage) additionalGrey else mainPrimary },
                                RoundedCornerShape(20.dp)
                            )
                            .padding(vertical = 8.dp, horizontal = 16.dp)
                    )

                    VerticalSpacer(height = 4.dp)

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        YummyIcon(painterRes = com.mobven.components.R.drawable.ic_double_tick)
                        Text(
                            text = "6:52 PM",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.neutralGrayscale100,
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun Footer(
    onSendClicked: (String) -> Unit
) {

    var message by rememberSaveable {
        mutableStateOf("")
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .imePadding()
            .navigationBarsPadding()
            .padding(bottom = 20.dp, start = 22.dp, end = 26.dp)
    ) {

        YummyIcon(
            painterRes = com.mobven.components.R.drawable.ic_camera,
            tint = MaterialTheme.colorScheme.neutralGrayscale90
        )

        HorizontalSpacer(width = 8.dp)

        YummyIcon(
            painterRes = com.mobven.components.R.drawable.ic_gallery,
            tint = MaterialTheme.colorScheme.neutralGrayscale90
        )

        HorizontalSpacer(width = 8.dp)

        ChatInput(
            value = message,
            onValueChange = {
                message = it
            },
            onSendClicked = {
                message = ""
                onSendClicked.invoke(it)
            }
        )
    }
}

@Preview
@Composable
fun ChatScreenPreview() {
    YummyComposeTheme {
        ChatScreen()
    }
}