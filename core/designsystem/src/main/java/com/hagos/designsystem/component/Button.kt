package com.hagos.designsystem.component

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hagos.designsystem.R
import com.hagos.designsystem.theme.*

@Composable
fun PrimaryCommonButton(
    modifier: Modifier = Modifier,
    title: Int = R.string.button,
    icon: Int? = R.drawable.ic_border_all_24,
    enabled: Boolean = false,
    onClick: () -> Unit = {}
) {
    var isPressed by remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .background(
                if (enabled) if (isPressed) brandSecondary else brandPrimary else surfacecontainer,
                RoundedCornerShape(12.dp)
            )
            .clickable(
                enabled = enabled,
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = null
            ){
                onClick()
            }
            .noRipplePointerInput(onClick = onClick) { pressed ->
                isPressed = pressed
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon != null) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                colorFilter = ColorFilter.tint(if (enabled) textLighten else textPale)
            )
            Spacer(modifier = Modifier.width(2.dp))
        }
        Text(
            text = stringResource(title),
            color = if (enabled) textLighten else textPale,
            style = TextStyle(
                lineHeight = 28.sp,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
    }
}


@Preview
@Composable
fun PreviewUniPrimaryButton(
) {
    ComposeNavigationTheme {
        PrimaryCommonButton(
            modifier = Modifier
                .height(64.dp)
                .fillMaxWidth(),
            enabled = true,
            title = R.string.button,
            onClick = {
                Log.e("Clicked", "Click")
            },
            icon = R.drawable.ic_add
        )
    }
}

@Preview
@Composable
fun Button1() {
    Button(onClick = {}) {
        Text(text = "Button")
    }
}