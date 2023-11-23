package com.hagos.composenavigation.addmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.hagos.designsystem.theme.ComposeNavigationTheme

class AddMenuActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ComposeNavigationTheme {
                AddMenuScreen(
                    onCancel = {
                        finish()
                    }
                )
            }
        }
    }
}
