package com.mobven.designsystem.components.inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
    modifier: Modifier = Modifier,
    hint: String = "",
    onValueChanged: (String) -> Unit,
) {

    Column(
        modifier = modifier
    ) {
        TextField(
            value = value,
            onValueChange = onValueChanged,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 96.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colorScheme.neutralGrayscale100,
                containerColor = MaterialTheme.colorScheme.additionalGrey,
                cursorColor = MaterialTheme.colorScheme.neutralGrayscale100,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(8.dp),
            placeholder = {
                Text(
                    hint,
                    style = MaterialTheme.typography.h4MediumStyle,
                    color = MaterialTheme.colorScheme.neutralGrayscale60
                )
            },
            textStyle = TextStyle(fontSize = 16.sp),
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
