package com.mobven.designsystem.components.inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobven.designsystem.theme.additionalGrey
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.neutralGrayscale100
import com.mobven.designsystem.theme.neutralGrayscale60

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultilineInputFiled(
    value: String,
    hint: String = "",
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Ascii,
    onValueChanged: (String) -> Unit,
) {

    Column(
        modifier = modifier
    ) {
        TextField(
            value = value.orEmpty(),
            onValueChange = onValueChanged,
            modifier = Modifier
                .fillMaxWidth()
                .height(96.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colorScheme.neutralGrayscale100,
                containerColor = MaterialTheme.colorScheme.additionalGrey,
                cursorColor = MaterialTheme.colorScheme.neutralGrayscale100,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = false,
            placeholder = {
                Text(
                    hint,
                    style = MaterialTheme.typography.h4MediumStyle,
                    color = MaterialTheme.colorScheme.neutralGrayscale60
                )
            },
            maxLines = 3,
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        )
    }
}


@Preview
@Composable
fun MultilineInputFiledPreview() {
    MultilineInputFiled(
        hint = "sample@gmail.com",
        value = "",
        onValueChanged = {},
        modifier = Modifier
            .fillMaxWidth()
    )
}
