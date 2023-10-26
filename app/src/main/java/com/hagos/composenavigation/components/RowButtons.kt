package com.hagos.composenavigation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hagos.composenavigation.R

@Preview
@Composable
fun RowButtons(
    modifier: Modifier = Modifier,
    @StringRes cancel: Int = R.string.cancel,
    @StringRes next: Int = R.string.next,
    onNextButtonClicked: () -> Unit = {},
    onCancelButtonClicked: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
    ) {
        OutlinedButton(
            onClick = onCancelButtonClicked,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(id = cancel))
        }
        Button(
            onClick = onNextButtonClicked,
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(id = next))
        }
    }
}