package com.mobven.yummy.ui.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.buttons.YummyButton
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.toolbar.YummyToolbar
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h4BoldStyle
import com.mobven.designsystem.theme.neutralGrayscale100
import com.mobven.yummy.ui.screens.login.PasswordField
import com.mobven.yummy.ui.screens.login.PhoneNumberField
import com.mobven.yummy.ui.screens.login.TextBetweenDividers
import com.mobven.yummy.ui.screens.login.TripleSocialMediaButtons

@Composable
fun RegisterScreen(
    onBackClick: () -> Unit
) {
    var nameState by remember {
        mutableStateOf("")
    }

    var phoneNumberState by remember {
        mutableStateOf("")
    }

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    var rePasswordState by remember {
        mutableStateOf("")
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.additionalWhite)
            .verticalScroll(rememberScrollState())
    ) {

        YummyToolbar(
            title = "Sign up",
            icon = R.drawable.ic_arrow_left,
            onIconClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        )

        VerticalSpacer(height = 16.dp)

        NameInputField(
            title = "Full name",
            value = nameState,
            inputHint = "Enter full name",
            modifier = Modifier.padding(horizontal = 24.dp)
        ) { name ->
            nameState = name
        }

        VerticalSpacer(height = 16.dp)

        PhoneNumberField(
            title = "Phone number",
            value = phoneNumberState,
            inputHint = "Enter your phone number",
            modifier = Modifier.padding(horizontal = 24.dp)
        ) { phoneNumber ->
            phoneNumberState = phoneNumber
        }

        VerticalSpacer(height = 16.dp)

        EmailInputField(
            title = "Email",
            value = emailState,
            inputHint = "Enter email",
            modifier = Modifier.padding(horizontal = 24.dp)
        ) { email ->
            emailState = email
        }

        VerticalSpacer(height = 16.dp)

        PasswordField(
            title = "Password",
            inputHint = "Enter Password",
            value = passwordState,
            hasError = false,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) { password ->
            passwordState = password
        }

        VerticalSpacer(height = 16.dp)

        PasswordField(
            title = "Password",
            inputHint = "Enter Password",
            value = rePasswordState,
            hasError = false,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) { rePassword ->
            rePasswordState = rePassword
        }

        VerticalSpacer(height = 16.dp)

        YummyButton(
            text = "Sign up",
            isEnabled = nameState.isNotEmpty() &&
                    phoneNumberState.isNotEmpty() &&
                    emailState.isNotEmpty() &&
                    passwordState.isNotEmpty() &&
                    rePasswordState.isNotEmpty(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            // handle click event
        }

        VerticalSpacer(height = 32.dp)

        TextBetweenDividers(text = "or", modifier = Modifier.padding(horizontal = 10.dp))

        VerticalSpacer(height = 24.dp)

        TripleSocialMediaButtons(
            modifier = Modifier.padding(horizontal = 24.dp),
            onGoogleClick = { /*handle click event*/ },
            onFacebookClick = { /*handle click event*/ },
            onAppleClick = { /*handle click event*/ }
        )

        VerticalSpacer(height = 24.dp)
    }
}

@Composable
fun NameInputField(
    title: String,
    inputHint: String,
    value: String,
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
    cursorColor: Color = Color.Unspecified,
    textStyle: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.h4BoldStyle.copy(
        color = MaterialTheme.colorScheme.neutralGrayscale100,
    ),
    onInputChange: (String) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = textStyle,
        )

        VerticalSpacer(height = 16.dp)

        com.mobven.designsystem.components.inputs.NameInputField(
            hint = inputHint,
            value = value,
            onValueChanged = onInputChange,
            cursorColor = cursorColor,
            errorMessage = errorMessage,
        )
    }
}

@Composable
fun EmailInputField(
    title: String,
    inputHint: String,
    value: String,
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
    cursorColor: Color = Color.Unspecified,
    textStyle: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.h4BoldStyle.copy(
        color = MaterialTheme.colorScheme.neutralGrayscale100,
    ),
    onInputChange: (String) -> Unit
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = textStyle,
        )

        VerticalSpacer(height = 16.dp)

        com.mobven.designsystem.components.inputs.EmailInputField(
            hint = inputHint,
            value = value,
            onValueChanged = onInputChange,
            cursorColor = cursorColor,
            errorMessage = errorMessage,
        )
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen {}
}