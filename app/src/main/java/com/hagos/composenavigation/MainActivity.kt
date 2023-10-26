package com.hagos.composenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.hagos.composenavigation.screens.CupcakeApp
import com.hagos.designsystem.theme.ComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            Box(Modifier.navigationBarsPadding()) {
                ComposeNavigationTheme {
                    CupcakeApp()
                }
            }
        }
    }
}