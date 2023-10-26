package com.hagos.composenavigation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hagos.composenavigation.R

@Composable
fun AddMenuLayout(
    modifier: Modifier = Modifier,
    @StringRes cancel: Int = R.string.cancel,
    @StringRes next: Int = R.string.next,
    onNextButtonClicked: ()->Unit = {},
    onCancelButtonClicked: ()->Unit = {},
    content: @Composable() ()->Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        content()
        RowButtons(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 8.dp),
            cancel,
            next,
            onNextButtonClicked,
            onCancelButtonClicked,
        )
    }
}

@Preview
@Composable
fun AddMenuLayoutPreview(){
    AddMenuLayout {
        Text(text = "Test")
    }
}