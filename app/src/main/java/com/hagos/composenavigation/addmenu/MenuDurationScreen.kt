package com.hagos.composenavigation.addmenu

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hagos.composenavigation.R
import com.hagos.composenavigation.components.AddMenuLayout

@Preview
@Composable
fun MenuDurationScreen(
    modifier: Modifier = Modifier,
    onNextButtonClicked: () -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
) {
    AddMenuLayout(
        modifier,
        R.string.back,
        R.string.add_menu,
        onNextButtonClicked,
        onCancelButtonClicked
    ) {
        Text(text = stringResource(id = R.string.menu_duration))
    }

}