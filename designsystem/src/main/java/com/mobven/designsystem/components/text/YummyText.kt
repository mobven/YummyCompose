package com.mobven.designsystem.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.mobven.designsystem.theme.h1SemiBoldStyle
import com.mobven.designsystem.theme.h2SemiBoldStyle
import com.mobven.designsystem.theme.h3SemiBoldStyle
import com.mobven.designsystem.theme.h4MediumStyle
import com.mobven.designsystem.theme.h4SemiBoldStyle
import com.mobven.designsystem.theme.h5MediumStyle
import com.mobven.designsystem.theme.h5SemiBoldStyle
import com.mobven.designsystem.theme.mainSecondary
import com.mobven.designsystem.theme.neutralGrayscale100

@Composable
fun YummyHeadText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.neutralGrayscale100,
    textSize: TextUnit = 32.sp
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h1SemiBoldStyle.copy(
            fontSize = textSize
        ),
        color = color,
        modifier = modifier
    )
}

@Composable
fun YummyHead1SemiBoldText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.neutralGrayscale100,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h1SemiBoldStyle,
        color = color,
        modifier = modifier
    )
}

@Composable
fun YummyHead3SemiBoldText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.neutralGrayscale100,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h3SemiBoldStyle,
        color = color,
        modifier = modifier
    )
}

@Composable
fun YummyHead4SemiBoldText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.neutralGrayscale100,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h4SemiBoldStyle,
        color = color,
        modifier = modifier
    )
}

@Composable
fun YummyHead4MediumText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.neutralGrayscale100,
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h4MediumStyle,
        color = color,
        modifier = modifier
    )
}

@Composable
fun YummyHead5MediumText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.neutralGrayscale100,
    textSize: TextUnit = MaterialTheme.typography.h5MediumStyle.fontSize
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h5MediumStyle.copy(
            fontSize = textSize
        ),
        color = color,
        modifier = modifier
    )
}

@Composable
fun YummyHead5SemiBoldText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.neutralGrayscale100,
    textSize: TextUnit = MaterialTheme.typography.h5SemiBoldStyle.fontSize,
    textDecoration: TextDecoration? = MaterialTheme.typography.h5SemiBoldStyle.textDecoration
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h5SemiBoldStyle.copy(
            fontSize = textSize,
            textDecoration = textDecoration
        ),
        color = color,
        modifier = modifier
    )
}

@Composable
fun YummyHead2SemiBoldText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.mainSecondary,
    textSize: TextUnit = MaterialTheme.typography.h2SemiBoldStyle.fontSize,
    textDecoration: TextDecoration? = MaterialTheme.typography.h2SemiBoldStyle.textDecoration
) {
    Text(
        text = text,
        style = MaterialTheme.typography.h2SemiBoldStyle.copy(
            fontSize = textSize,
            textDecoration = textDecoration
        ),
        color = color,
        modifier = modifier
    )
}