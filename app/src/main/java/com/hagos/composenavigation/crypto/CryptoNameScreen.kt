package com.hagos.composenavigation.crypto

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hagos.composenavigation.R
import com.hagos.designsystem.theme.ComposeNavigationTheme

@Preview
@Composable
fun CryptoNameScreen(
    viewModel: CryptoViewModel = viewModel(),
    onBack: ()->Unit = {},
    onNext: ()->Unit= {}
) {

    var nameState by remember { mutableStateOf("") }

    ComposeNavigationTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Spacer(modifier = Modifier.height(32.dp))
            Surface(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {
                    TextField(
                        value = nameState,
                        onValueChange = {
                            nameState = it
                        },
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = MaterialTheme.colorScheme.background
                        ),
                        placeholder = {
                            InputLabel()
                        },
                        singleLine = true
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                BottomButton(
                    icon = Icons.Default.SkipNext
                ) {
                    viewModel.setCryptoName(nameState)
                    onNext()
                }
            }
        }
    }
}

@Composable
fun InputLabel(label: Int = R.string.enter_name) {
    Text(
        text = stringResource(id = R.string.enter_name),
        color = MaterialTheme.colorScheme.onBackground,
    )
}

@Preview
@Composable
fun TopBar(
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 2.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = Modifier
                .size(48.dp)
                .clickable {
                    onClick()
                },
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null
        )
    }
}

@Preview
@Composable
fun BottomButton(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)
        .clip(shape = RoundedCornerShape(12.dp))
        .background(MaterialTheme.colorScheme.primary),
    title: Int = R.string.next,
    icon: ImageVector? = null,
    onClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .clickable {
                onClick()
            },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
        Text(
            text = stringResource(id = title),
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}