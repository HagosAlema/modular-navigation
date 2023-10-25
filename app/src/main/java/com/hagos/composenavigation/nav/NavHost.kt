package com.hagos.composenavigation.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun NavHost(
    navController: NavController = rememberNavController(),
    startDestination: String,
    modifier: Modifier
){
}