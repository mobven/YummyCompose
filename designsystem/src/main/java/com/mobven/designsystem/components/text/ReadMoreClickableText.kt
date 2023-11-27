package com.mobven.designsystem.components.text

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.mainPrimary

@Composable
fun ReadMoreClickableText(
    text: String,
    readMoreText:String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val annotatedString = buildAnnotatedString {
        append(text)
        addStyle(
            style = SpanStyle(
                color = MaterialTheme.colorScheme.mainPrimary
            ),
            start = text.indexOf(readMoreText),
            end = text.indexOf(readMoreText) + readMoreText.length
        )
    }

    Text(
        text = annotatedString,
        style = MaterialTheme.typography.h4MediumStyle,
        modifier = modifier.clickable(onClick = onClick)
    )
}