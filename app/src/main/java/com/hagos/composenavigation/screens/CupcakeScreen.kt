package com.hagos.composenavigation.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hagos.composenavigation.R
import com.hagos.composenavigation.data.DataSource
import com.hagos.composenavigation.nav.CupcakeDestinations
import com.hagos.composenavigation.viewmodel.OrderViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CupcakeAppBar(
    currentScreen: CupcakeDestinations,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(id = currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null
                    )
                }
            }
        }
    )
}

@Composable
fun CupcakeApp(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = CupcakeDestinations.valueOf(
        backStackEntry?.destination?.route ?: CupcakeDestinations.Start.name
    )
    Scaffold(
        topBar = {
            CupcakeAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp()})
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = CupcakeDestinations.Start.name,
            modifier = Modifier.padding(innerPadding),
            builder = {
                composable(route = CupcakeDestinations.Start.name) {
                    StartOrderScreen(
                        quantityOptions = DataSource.quantityOptions,
                        onNextButtonClicked = {
                            viewModel.setQuantity(it)
                            navController.navigate(CupcakeDestinations.Flavor.name)
                        }
                    )
                }
                composable(route = CupcakeDestinations.Flavor.name) {
                    val context = LocalContext.current
                    SelectOptionScreen(
                        subtotal = uiState.price,
                        onNextButtonClicked = {
                            navController.navigate(CupcakeDestinations.Pickup.name)
                        },
                        onCancelButtonClicked = {
                            cancelOrderAndNavigateToStart(viewModel, navController)
                        },
                        options = DataSource.flavors.map { id -> context.resources.getString(id) },
                        onSelectionChanged = { viewModel.setFlavor(it) }
                    )
                }
                composable(route = CupcakeDestinations.Pickup.name) {
                    SelectOptionScreen(
                        subtotal = uiState.price,
                        onNextButtonClicked = { navController.navigate(CupcakeDestinations.Summary.name) },
                        onCancelButtonClicked = {
                            cancelOrderAndNavigateToStart(viewModel, navController)
                        },
                        options = uiState.pickupOptions,
                        onSelectionChanged = { viewModel.setDate(it) }
                    )
                }
                composable(route = CupcakeDestinations.Summary.name) {
                    val context = LocalContext.current
                    OrderSummaryScreen(
                        orderUiState = uiState,
                        onCancelButtonClicked = {
                            cancelOrderAndNavigateToStart(viewModel, navController)
                        },
                        onSendButtonClicked = { subject: String, summary: String ->
                            shareOrder(context, subject, summary)
                        }
                    )
                }
            },
        )
    }
}

private fun shareOrder(context: Context, subject: String, summary: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.new_cupcake_order)
        )
    )
}

private fun cancelOrderAndNavigateToStart(
    viewModel: OrderViewModel,
    navController: NavHostController
) {
    viewModel.resetOrder()
    navController.popBackStack(CupcakeDestinations.Start.name, false)
}