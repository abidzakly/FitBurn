package org.d3if3139.assessment1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.d3if3139.assessment1.ui.screen.About.AboutScreen
import org.d3if3139.assessment1.ui.screen.Dashboard.DashboardScreen
import org.d3if3139.assessment1.ui.screen.Home.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
        HomeScreen(navController)
        }
        composable(route = Screen.Dashboard.route) {
        DashboardScreen(navController)
        }
        composable(route = Screen.About.route) {
        AboutScreen(navController)
        }
    }
}
