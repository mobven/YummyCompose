package com.mobven.designsystem.components.inputs

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobven.components.R
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.common.conditional
import com.mobven.designsystem.theme.AdditionalGrey
import com.mobven.designsystem.theme.NeutralGrayscale100
import com.mobven.designsystem.theme.NeutralGrayscale70
import com.mobven.designsystem.theme.SemanticError

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInputField(
    value: String,
    onValueChange: (String) -> Unit,
    cursorColor: Color,
    hint: String,
    modifier: Modifier = Modifier,
    isFocused: Boolean = false,
    isError: Boolean = false,
    errorMessage: String,
) {

    var passwordVisible by rememberSaveable {
        mutableStateOf(true)
    }

    val image = painterResource(id = R.drawable.eye_slash)


    Column {
        TextField(
            value = value.orEmpty(),
            onValueChange = onValueChange,
            Modifier
                .fillMaxWidth()
                .border(
                    1.dp, NeutralGrayscale70, RoundedCornerShape(
                        topStart = 20.dp,
                        bottomStart = 16.dp,
                        topEnd = 20.dp,
                        bottomEnd = 16.dp
                    )
                )
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
                .conditional(isError) {
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
                containerColor = AdditionalGrey,
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
                    style = TextStyle(fontSize = 16.sp)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisible) PasswordVisualTransformation('⬟') else VisualTransformation.None,
            textStyle = TextStyle(fontSize = 16.sp),
            trailingIcon = {
                IconButton(onClick = {passwordVisible = !passwordVisible}){
                    Icon(image, "")
                }
            }
        )
        VerticalSpacer(height = 8.dp)
        if (isError) {
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
fun PasswordVisibilityButton() {
    PasswordInputField(
        value = "Password",
        onValueChange = {},
        cursorColor = NeutralGrayscale100,
        hint = "Password",
        modifier = Modifier,
        isFocused = false,
        isError = false,
        errorMessage = ""
    )
}