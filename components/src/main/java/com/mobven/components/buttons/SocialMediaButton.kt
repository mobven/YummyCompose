package com.mobven.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobven.components.R
import com.mobven.components.common.YummyImage

@Composable
fun SocialMediaButton(
    title: String,
    @DrawableRes iconResId: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .sizeIn(100.dp, 44.dp)
            .clip(RoundedCornerShape(32.dp))
            .clickable { onClick() }
            .background(backgroundColor)
            .padding(horizontal = 24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(21.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            YummyImage(imgResId = iconResId)
            Text(title, color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview
@Composable
fun SocialMediaButtonPreview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
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
            Color.Black
        ) {}
    }
}