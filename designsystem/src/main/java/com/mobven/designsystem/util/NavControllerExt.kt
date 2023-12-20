package com.mobven.designsystem.util

import androidx.navigation.NavController

fun NavController.navigate(event: UiEvent.Navigate){
    this.navigate(event.route)
}