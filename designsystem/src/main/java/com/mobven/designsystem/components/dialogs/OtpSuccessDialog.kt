package com.mobven.designsystem.components.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.mobven.components.R
import com.mobven.designsystem.components.buttons.YummyButton
import com.mobven.designsystem.components.common.YummyImage
import com.mobven.designsystem.theme.additionalWhite
import com.mobven.designsystem.theme.h3SemiBoldStyle
import com.mobven.designsystem.theme.h4SemiBoldStyle
import com.mobven.designsystem.theme.h5MediumStyle
import com.mobven.designsystem.theme.mainPrimary
import com.mobven.designsystem.theme.neutralGrayscale100

@Composable
fun OtpSuccessDialog(
    phoneNumber: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {

    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            usePlatformDefaultWidth = true
        )
    ) {

        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.additionalWhite
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Registered Successfully",
                    style = MaterialTheme.typography.h3SemiBoldStyle,
                    color = MaterialTheme.colorScheme.neutralGrayscale100,
                    textAlign = TextAlign.Center
                )

                YummyImage(
                    imgResId = R.drawable.ic_tick_circle,
                    modifier = Modifier.size(60.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = phoneNumber.substring(0, 5) + "*".repeat(phoneNumber.length - 5),
                    style = MaterialTheme.typography.h4SemiBoldStyle,
                    color = MaterialTheme.colorScheme.mainPrimary,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Your phone number has been successfully registered",
                    style = MaterialTheme.typography.h5MediumStyle,
                    color = MaterialTheme.colorScheme.neutralGrayscale100,
                    textAlign = TextAlign.Center
                )

                YummyButton(
                    text = "Continue on hompage", modifier = Modifier.fillMaxWidth()
                ) {
                    onConfirm()
                }
            }
        }
    }
}


@Preview
@Composable
fun YummyOtpSuccessDialogPreview() {
    OtpSuccessDialog(
        phoneNumber = "05532110706",
        onDismiss = { },
        onConfirm = { }
    )
}