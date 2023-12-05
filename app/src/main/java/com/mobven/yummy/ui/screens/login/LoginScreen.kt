package com.mobven.yummy.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.buttons.SocialMediaButton
import com.mobven.designsystem.components.buttons.YummyButton
import com.mobven.designsystem.components.common.VerticalSpacer
import com.mobven.designsystem.components.inputs.PasswordInputField
import com.mobven.designsystem.components.inputs.PhoneNumberField
import com.mobven.designsystem.components.toolbar.YummyToolbar
import com.mobven.designsystem.theme.additionalDark
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.grayscale200
import com.mobven.designsystem.theme.grayscale600
import com.mobven.designsystem.theme.h4BoldStyle
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.h5BoldStyle
import com.mobven.designsystem.theme.h5MediumStyle
import com.mobven.designsystem.theme.h5SemiBoldStyle
import com.mobven.designsystem.theme.neutralGrayscale100
import com.mobven.designsystem.theme.promoOrange

@Composable
fun LoginScreen(
    onBackClick: () -> Unit
) {

    var phoneNumberState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.additionalWhite)
            .verticalScroll(rememberScrollState())
    ) {

        YummyToolbar(
            title = "Sign in",
            icon = R.drawable.ic_arrow_left,
            onIconClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        )

        VerticalSpacer(height = 24.dp)

        PhoneNumberField(
            title = "Phone number",
            value = phoneNumberState,
            inputHint = "Enter your phone number",
            modifier = Modifier.padding(horizontal = 24.dp)
        ) { phoneNumber ->
            phoneNumberState = phoneNumber
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

        VerticalSpacer(height = 4.dp)

        Text(
            text = "Forgot password?",
            style = MaterialTheme.typography.h5SemiBoldStyle,
            color = MaterialTheme.colorScheme.promoOrange,
            modifier = Modifier
                .padding(start = 24.dp)
                .clickable {
                    //handle click event
                }
        )

        VerticalSpacer(height = 32.dp)

        YummyButton(
            text = "Sign in",
            isEnabled = phoneNumberState.isNotEmpty() && passwordState.isNotEmpty(),
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

        SignupText(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            //handle click event
        }
    }
}

@Composable
fun TextBetweenDividers(
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
        modifier = modifier
    ) {
        Divider(
            color = MaterialTheme.colorScheme.grayscale200,
            thickness = 1.dp,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.h4MediumStyle,
            color = MaterialTheme.colorScheme.grayscale600
        )
        Divider(
            color = MaterialTheme.colorScheme.grayscale200,
            thickness = 1.dp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun SignupText(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = "Do not have an account?",
            style = MaterialTheme.typography.h5MediumStyle,
            color = MaterialTheme.colorScheme.neutralGrayscale100
        )
        Text(
            text = "Sign up",
            style = MaterialTheme.typography.h5BoldStyle,
            color = MaterialTheme.colorScheme.promoOrange,
            modifier = Modifier.clickable(onClick = onClick)
        )
    }
}

@Composable
fun TripleSocialMediaButtons(
    onGoogleClick: () -> Unit,
    onFacebookClick: () -> Unit,
    onAppleClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        SocialMediaButton(
            "Continue with Google",
            R.drawable.ic_google,
            modifier = Modifier.fillMaxWidth(),
            Color(0xFF5384EE),
            onClick = onGoogleClick
        )
        VerticalSpacer(height = 12.dp)
        SocialMediaButton(
            "Continue with Facebook",
            R.drawable.ic_facebook,
            modifier = Modifier.fillMaxWidth(),
            Color(0xFF415792),
            onClick = onFacebookClick
        )
        VerticalSpacer(height = 12.dp)
        SocialMediaButton(
            "Continue with Apple",
            R.drawable.ic_apple,
            modifier = Modifier.fillMaxWidth(),
            MaterialTheme.colorScheme.additionalDark,
            onClick = onAppleClick
        )
    }
}


@Composable
fun PhoneNumberField(
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

        PhoneNumberField(
            hint = inputHint,
            value = value,
            onValueChanged = onInputChange,
            cursorColor = cursorColor,
            errorMessage = errorMessage,
        )
    }
}

@Composable
fun PasswordField(
    title: String,
    value: String,
    inputHint: String,
    hasError: Boolean,
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

        PasswordInputField(
            value = value,
            onValueChange = onInputChange,
            cursorColor = cursorColor,
            hint = inputHint,
            isError = hasError,
            errorMessage = errorMessage.orEmpty()
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen {}
}