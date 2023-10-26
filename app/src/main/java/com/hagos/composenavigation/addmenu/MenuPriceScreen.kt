package com.hagos.composenavigation.addmenu

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.hagos.composenavigation.R
import com.hagos.composenavigation.components.AddMenuLayout

@Composable
fun MenuPriceScreen(
    modifier: Modifier = Modifier,
    onNextButtonClicked : () -> Unit,
    onCancelButtonClicked: () -> Unit,
){
    AddMenuLayout(
        modifier,
        R.string.back,
        R.string.next,
        onNextButtonClicked,
        onCancelButtonClicked
    ) {
        Text(text = stringResource(id = R.string.menu_price))
    }

}