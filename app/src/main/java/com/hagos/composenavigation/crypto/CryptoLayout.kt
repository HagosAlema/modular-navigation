package com.hagos.composenavigation.crypto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CryptoLayout(
    topBar: @Composable (()->Unit)->Unit,
    bottomBar: @Composable (onNext: ()->Unit)->Unit,
    content: @Composable ()->Unit = {},
    onBack: ()->Unit = {},
    onNext: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        bottomBar = {
            bottomBar{
                onNext()
            }
        },
        topBar = {
            topBar {
                onBack()
            }
        }
    ) { internalPadding ->
        Surface(
            modifier = Modifier.padding(internalPadding)
        ) {
            content()
        }

    }
}

fun topBar(function: () -> Unit) {
    TODO("Not yet implemented")
}
