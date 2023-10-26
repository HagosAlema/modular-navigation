package com.hagos.composenavigation.addmenu

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.hagos.composenavigation.R

@Composable
fun MenuSummaryScreen(){
    Text(text = stringResource(id = R.string.menu_summary))
}