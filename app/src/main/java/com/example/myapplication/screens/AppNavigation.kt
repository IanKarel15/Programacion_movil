package com.example.myapplication.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home") {
            MainScreen(
                onNavigateToLogin = { navController.navigate("login") },
                onNavigateToSignup = { navController.navigate("signup") }
            )
        }

        composable(route = "login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("contacts") },
                onNavigateToSignup = { navController.navigate("signup") }
            )
        }

        composable(route = "signup") {
            SignupScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable("contacts") {
            ContactScreen()
        }
    }
}

@Composable
fun MainScreen(onNavigateToLogin: () -> Unit, onNavigateToSignup: () -> Unit) {
    TODO("Not yet implemented")
}