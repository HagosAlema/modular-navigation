package com.hagos.composenavigation.screens

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

enum class BottomMenus(@StringRes val title: Int, val icon: ImageVector){
    Crypto(R.string.crypto_route, Icons.Filled.Home),
    Start(R.string.order, Icons.Filled.AddCircle),
    MyOrder(R.string.myorder_route, Icons.Filled.AccountBox),
}

@Preview
@Composable
fun BottomAppBar(
    onMenuItemClick: (String)->Unit = {}
){
    val menus = BottomMenus.values()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.secondaryContainer),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomMenus.values().forEach {
            Column(
                modifier = Modifier
                    .clickable {
                        onMenuItemClick(it.name)
                    }
                    .fillMaxHeight()
                    .padding(8.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(id = it.title))
                Icon(imageVector = it.icon, contentDescription = null)
            }
        }
    }
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
                canNavigateBack = !(currentScreen == CupcakeDestinations.Start || currentScreen == CupcakeDestinations.MyOrder || currentScreen == CupcakeDestinations.Crypto),
                navigateUp = { navController.navigateUp()})
        },
        bottomBar = { BottomAppBar {
//            navController.navigateSingleTop(it.name)
            navController.navigate(route = it){
                navController.graph.startDestinationRoute?.let {route->
                    popUpTo(route){
                        saveState = true
                    }
                }
                launchSingleTop = true
                restoreState = true

            }
        }},
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
                            navController.navigateSingleTop(CupcakeDestinations.Flavor.name)
                        }
                    )
                }
                composable(route = CupcakeDestinations.Flavor.name) {
                    val context = LocalContext.current
                    SelectOptionScreen(
                        subtotal = uiState.price,
                        onNextButtonClicked = {
                            navController.navigateSingleTop(CupcakeDestinations.Pickup.name)
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
                        onNextButtonClicked = { navController.navigateSingleTop(CupcakeDestinations.Summary.name) },
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
//                            shareOrder(context, subject, summary)
                            navController.navigateSingleTop(CupcakeDestinations.Congrats.name)
                        }
                    )
                }
                composable(route = CupcakeDestinations.Congrats.name){
                    CongratsScreen(
                        onDoneButtonClicked = {
                            cancelOrderAndNavigateToStart(viewModel, navController)
                        }
                    )
                }
                composable(route = CupcakeDestinations.Crypto.name){
                    CryptoScreen()
                }
                composable(route = CupcakeDestinations.MyOrder.name) {
                    MyOrderScreen()
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

fun NavHostController.navigateSingleTop(route:String) = this.navigate(route){launchSingleTop = true}