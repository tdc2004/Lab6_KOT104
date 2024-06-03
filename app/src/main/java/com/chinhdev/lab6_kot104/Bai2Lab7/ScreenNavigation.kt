package com.chinhdev.lab6_kot104.Bai2Lab7

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chinhdev.lab6_kot104.Bai2Lab7.Screen
import com.chinhdev.lab6_kot104.Bai2Lab7.Screen1
import com.chinhdev.lab6_kot104.Bai2Lab7.Screen2
import com.chinhdev.lab6_kot104.Bai2Lab7.Screen3


@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SCREEN1.route,
    ) {
        composable(Screen.SCREEN1.route) { Screen1(navController) }
        composable(Screen.SCREEN2.route) { Screen2(navController) }
        composable(Screen.SCREEN3.route) { Screen3(navController) }
    }
}