package com.mobven.designsystem.components.inputs

import androidx.compose.foundation.border
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.conditional
import com.mobven.designsystem.theme.NeutralGrayscale100
import com.mobven.designsystem.theme.SemanticError
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.neutralGrayscale100
import com.mobven.designsystem.theme.neutralGrayscale60
import com.mobven.designsystem.theme.neutralGrayscale80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameInputField(
    hint: String,
    value: String? = null,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    cursorColor: Color,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    errorMessage: String?,
    isFocused: Boolean = false
) {

    Column {
        TextField(
            value = value.orEmpty(),
            onValueChange = onValueChanged,
            modifier = Modifier
                .fillMaxWidth()
                .conditional(isFocused) {
                    border(
                        1.dp, NeutralGrayscale100,
                        RoundedCornerShape(
                            topStart = 20.dp,
                            bottomStart = 16.dp,
                            topEnd = 20.dp,
                            bottomEnd = 16.dp
                        )
                    )
                }
                .border(
                    1.dp, MaterialTheme.colorScheme.neutralGrayscale60, RoundedCornerShape(
                        topStart = 20.dp,
                        bottomStart = 16.dp,
                        topEnd = 20.dp,
                        bottomEnd = 16.dp
                    )
                )
                .conditional(errorMessage != null) {
                    border(
                        1.dp, SemanticError, RoundedCornerShape(
                            topStart = 20.dp,
                            bottomStart = 16.dp,
                            topEnd = 20.dp,
                            bottomEnd = 16.dp
                        )
                    )
                }
                .height(56.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colorScheme.neutralGrayscale100,
                containerColor = Color.White,
                cursorColor = cursorColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(
                topStart = 20.dp,
                bottomStart = 16.dp,
                topEnd = 20.dp,
                bottomEnd = 16.dp
            ),
            singleLine = true,
            placeholder = {
                Text(
                    hint,
                    style = MaterialTheme.typography.h4MediumStyle,
                    color = MaterialTheme.colorScheme.neutralGrayscale80
                )
            },
            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = visualTransformation
        )
        VerticalSpacer(height = 8.dp)
        if (errorMessage != null) {
            Text(
                text = errorMessage, style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 24.sp,
                    color = SemanticError,
                )
            )
        }
    }
}


@Preview
@Composable
fun NameInputFieldPreview() {
    NameInputField(
        hint = "Full Name",
        value = null,
        onValueChanged = {},
        modifier = Modifier
            .fillMaxWidth(),
        cursorColor = NeutralGrayscale100,
        errorMessage = "Sample Error Message",
        isFocused = true
    )
}

@Preview
@Composable
fun NameInputFieldErrorPreview() {
    NameInputField(
        hint = "sample@gmail.com",
        value = null,
        onValueChanged = {},
        modifier = Modifier
            .fillMaxWidth(),
        cursorColor = NeutralGrayscale100,
        errorMessage = "Sample Error Message",
    )
}