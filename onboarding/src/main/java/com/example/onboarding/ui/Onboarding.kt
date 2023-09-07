import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.designsystem.components.buttons.SocialMediaButton
import com.mobven.designsystem.components.buttons.YummyButton
import com.mobven.designsystem.components.common.YummyImage
import com.mobven.designsystem.theme.additionalDark
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.h5BoldStyle
import com.mobven.designsystem.theme.h5MediumStyle
import com.mobven.designsystem.theme.mainPrimary
import com.mobven.designsystem.theme.neutralGrayscale50
import com.mobven.designsystem.theme.neutralGrayscale70

@Preview(showBackground = true)
@Composable
fun Onboarding() {
    MaterialTheme {
        Surface {
            val contentPadding = WindowInsets
                .systemBars
                .add(WindowInsets(left = 16.dp, top = 16.dp, right = 16.dp, bottom = 16.dp))
                .asPaddingValues()

            Column(modifier = Modifier.fillMaxSize())
            {
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    item {
                        Box(
                            modifier = Modifier
                                .height(541.dp)
                                .fillMaxWidth()
                        ) {
                            YummyImage(
                                imgResId = R.drawable.bg_onboarding,
                                modifier = Modifier
                                    .matchParentSize(),
                                contentScale = ContentScale.Crop
                            )

                            YummyImage(
                                imgResId = R.drawable.ic_yummy_food,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .height(64.dp)
                                    .fillMaxWidth(),
                                contentScale = ContentScale.Fit
                            )
                        }
                    }
                }


                LazyColumn(
                    modifier = Modifier.weight(1f),
                    contentPadding = contentPadding,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            YummyButton(text = "Sign In", modifier = Modifier.fillMaxWidth()) {

                            }
                        }
                    }
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 4.dp, bottom = 4.dp, end = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Divider(
                                color = MaterialTheme.colorScheme.neutralGrayscale50,
                                modifier = Modifier
                                    .width(130.dp)
                                    .padding(horizontal = 4.dp)
                                    .height(1.dp)
                            )

                            Text(
                                text = "or",
                                style = MaterialTheme.typography.h4MediumStyle,
                                color = MaterialTheme.colorScheme.neutralGrayscale70,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )

                            Divider(
                                color = MaterialTheme.colorScheme.neutralGrayscale50,
                                modifier = Modifier
                                    .width(130.dp)
                                    .padding(horizontal = 4.dp)
                                    .height(1.dp)
                            )
                        }
                    }
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            SocialMediaButton(
                                "Continue with Google",
                                R.drawable.ic_google,
                                modifier = Modifier.fillMaxWidth(),
                                Color(0xFF5384EE)
                            ) {}
                            SocialMediaButton(
                                "Continue with Facebook ",
                                R.drawable.ic_facebook,
                                modifier = Modifier.fillMaxWidth(),
                                Color(0xFF415792)
                            ) {}
                            SocialMediaButton(
                                "Continue with Apple",
                                R.drawable.ic_apple,
                                modifier = Modifier.fillMaxWidth(),
                                MaterialTheme.colorScheme.additionalDark
                            ) {}
                        }
                    }
                    item {
                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            SignUpText()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SignUpText() {
    fun mergeTypographyWithColor(textStyle: TextStyle, color: Color) = SpanStyle(
        color = color,
        fontSize = textStyle.fontSize,
        fontWeight = textStyle.fontWeight,
        fontFamily = textStyle.fontFamily,
        letterSpacing = textStyle.letterSpacing,
    )

    val annotatedString = buildAnnotatedString {
        withStyle(
            style = mergeTypographyWithColor(
                MaterialTheme.typography.h5MediumStyle,
                Color.Black
            )
        ) {
            append("Do not have an account? ")
        }

        withStyle(
            style = mergeTypographyWithColor(
                MaterialTheme.typography.h5BoldStyle,
                MaterialTheme.colorScheme.mainPrimary
            )
        ) {
            append("Sign up")
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        ClickableText(
            text = annotatedString,
            onClick = { offset ->
                val clickedText = annotatedString.substring(offset, offset + "Sign up".length)
                if (clickedText == "Sign up") {
                    // Navigation to sign up page
                }
            }
        )
    }
}
