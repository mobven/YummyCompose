package com.mobven.designsystem.components.dialogs

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.mobven.designsystem.theme.grayScale
import com.mobven.designsystem.theme.h2SemiBoldStyle
import com.mobven.designsystem.theme.h5MediumStyle
import com.mobven.designsystem.theme.mainSecondary

@Composable
fun BaseDialog(
    title: String,
    description: String,
    @DrawableRes imgRes: Int,
    buttonText: String?,
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
                YummyImage(
                    imgResId = imgRes,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    style = MaterialTheme.typography.h2SemiBoldStyle,
                    color = MaterialTheme.colorScheme.mainSecondary,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = description,
                    style = MaterialTheme.typography.h5MediumStyle,
                    color = MaterialTheme.colorScheme.grayScale,
                    textAlign = TextAlign.Center
                )

                if (buttonText != null) {
                    YummyButton(
                        text = buttonText, modifier = Modifier.fillMaxWidth()
                    ) {
                        onConfirm()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun YummyBaseDialogPreview() {
    BaseDialog(
        title = "Thank you for your feedback",
        description = "We will continue improving our service and pleasing you in the next order. ",
        imgRes = R.drawable.ic_google,
        buttonText = "Back to homepage",
        onDismiss = { },
        onConfirm = { }
    )
}