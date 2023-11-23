package com.hagos.composenavigation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hagos.designsystem.R
import kotlinx.coroutines.delay

@Preview(showSystemUi = true)
@Composable
fun SplashScreen(
    navigateHome: () -> Unit = {},
) {

    var timer:Int by remember{ mutableStateOf(0) }
    LaunchedEffect(Unit, block = {
        for (i in 0..7){
            delay(200)
            timer = i
        }
        navigateHome()
    })
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = getResource(timer)),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(100.dp)
        )
    }
}

fun getResource(order: Int): Int {
    return when (order) {
        0->R.drawable.ic_border_clear_24
        1 -> R.drawable.ic_border_top_24
        2 -> R.drawable.ic_border_right_24
        3 -> R.drawable.ic_border_bottom_24
        4 -> R.drawable.ic_border_left_24
        5 -> R.drawable.ic_border_horizontal_24
        6 -> R.drawable.ic_border_vertical_24
        7 -> R.drawable.ic_border_all_24
        else -> R.drawable.ic_border_all_24
    }
}