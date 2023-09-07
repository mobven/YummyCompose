package com.example.onboarding

import Onboarding
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class OnboardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Onboarding()
        }
    }
}