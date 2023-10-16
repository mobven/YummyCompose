package com.mobven.designsystem.components.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.theme.NeutralGrayscale20
import com.mobven.designsystem.theme.NeutralGrayscale60
import com.mobven.designsystem.theme.h5NormalStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    state: MutableState<String>,
    hint: String
) {

    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = NeutralGrayscale20,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(size = 32.dp),
        singleLine = true,
        placeholder = {
            Text(
                hint,
                style = MaterialTheme.typography.h5NormalStyle,
                color = NeutralGrayscale60
            )
        },
        textStyle = MaterialTheme.typography.h5NormalStyle,
        leadingIcon = {
            Icon(
                painterResource(id = R.drawable.ic_search),
                contentDescription = "Search icon",
                tint = NeutralGrayscale60
            )
        }
    )

}

@Preview
@Composable
fun SearchBarPreviewEmpty() {
    val textState = remember { mutableStateOf("") }
    SearchBar(
        state = textState,
        hint = "What are you yearning for?"
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    val textState = remember { mutableStateOf("Yummy food") }
    SearchBar(
        state = textState,
        hint = "What are you yearning for?"
    )
}