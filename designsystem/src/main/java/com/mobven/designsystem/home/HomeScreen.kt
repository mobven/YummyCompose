package com.mobven.designsystem.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mobven.designsystem.util.UiEvent

@Composable
fun HomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = "Welcome Home Screen",
            textAlign = TextAlign.Center,
        )
    }
}