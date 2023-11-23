package com.hagos.composenavigation

import android.content.Context
import android.hardware.usb.UsbManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.hagos.composenavigation.screens.CupcakeApp
import com.hagos.designsystem.theme.ComposeNavigationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

//        val manager = getSystemService(Context.USB_SERVICE) as UsbManager
//        val deviceList = manager.deviceList
//        deviceList.values.forEach{ device ->
//            Log.e("==>${device.vendorId}", "${device.deviceId}")
//        }
        setContent {
            Box(Modifier.navigationBarsPadding()) {
                ComposeNavigationTheme {
                    CupcakeApp()
                }
            }
        }
    }
}