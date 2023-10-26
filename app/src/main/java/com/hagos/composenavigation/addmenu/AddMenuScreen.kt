package com.hagos.composenavigation.addmenu

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hagos.composenavigation.nav.AddMenuDestinations
import com.hagos.composenavigation.screens.navigateSingleTop

@Composable
fun AddMenuScreen(
    navHostController: NavHostController = rememberNavController(),
    onCancel: ()->Unit = {}
) {
    val backStackEntry by navHostController.currentBackStackEntryAsState()
    val currentScreen = AddMenuDestinations.valueOf(
        backStackEntry?.destination?.route ?: AddMenuDestinations.MenuName.name
    )
    val context: Context = LocalContext.current
    Scaffold {innerPadding->
        NavHost(
            navController = navHostController,
            startDestination = AddMenuDestinations.MenuName.name,
            modifier = Modifier.padding(innerPadding),
        ){
            composable(AddMenuDestinations.MenuName.name){
                MenuNameScreen(
                    onNextButtonClicked = {
                        navHostController.navigate(route = AddMenuDestinations.MenuPrice.name)
                    },
                    onCancelButtonClicked = onCancel
                )
            }
            composable(AddMenuDestinations.MenuPrice.name){
                MenuPriceScreen(
                    onNextButtonClicked = {
                        navHostController.navigate(route = AddMenuDestinations.MenuDuration.name)
                    },
                    onCancelButtonClicked = {
                        navHostController.navigateUp()
                    }
                )
            }
            composable(AddMenuDestinations.MenuDuration.name) {
                MenuDurationScreen(
                    onNextButtonClicked = {
                        navHostController.navigate(route = AddMenuDestinations.MenuSummary.name)
                    },
                    onCancelButtonClicked = {
                        navHostController.navigateUp()
                    }
                )
            }
            composable(AddMenuDestinations.MenuSummary.name){
                MenuSummaryScreen()
            }
            
        }

    }
}