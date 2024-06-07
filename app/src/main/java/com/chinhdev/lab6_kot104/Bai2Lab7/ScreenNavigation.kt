package com.chinhdev.lab6_kot104.Bai2Lab7

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.chinhdev.lab6_kot104.Bai2Lab7.Screen
import com.chinhdev.lab6_kot104.Bai2Lab7.Screen1
import com.chinhdev.lab6_kot104.Bai2Lab7.Screen2
import com.chinhdev.lab6_kot104.Bai2Lab7.Screen3
import com.chinhdev.lab6_kot104.Bai3Lab7.LoginScreen
import com.chinhdev.lab6_kot104.MovieScreen
//import com.chinhdev.lab6_kot104.model.MainViewModel


@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
//    val mainViewModel: MainViewModel = viewModel()
//    val moviesState = mainViewModel.movies.observeAsState(initial = emptyList())
    NavHost(
        navController = navController,
        startDestination = Screen.LOGIN.route,
    ) {
        composable(Screen.LOGIN.route) { LoginScreen(navController) }
        composable(Screen.MOVIE_SCREEN.route) { MovieScreen() }
        composable(Screen.SCREEN1.route) { Screen1(navController) }
        composable(Screen.SCREEN2.route) { Screen2(navController) }
        composable(Screen.SCREEN3.route) { Screen3(navController) }
    }
}