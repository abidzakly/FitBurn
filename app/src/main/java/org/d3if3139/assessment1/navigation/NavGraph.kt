package org.d3if3139.assessment1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import org.d3if3139.assessment1.ui.screen.about.AboutScreen
import org.d3if3139.assessment1.ui.screen.calorie.CalorieScreen
import org.d3if3139.assessment1.ui.screen.dashboard.DashboardScreen
import org.d3if3139.assessment1.ui.screen.home.HomeScreen
import org.d3if3139.assessment1.ui.screen.workout.WorkoutScreen

@Composable
fun SetupNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
        val dashboardUri =
            "android-app://org.d3if3139.assessment1.ui.screen.dashboard.DashboardScreen/"
        composable(
            route = Screen.Dashboard.route + "/{genderId}",
            deepLinks = listOf(navDeepLink { uriPattern = "$dashboardUri{genderId}" }),
            arguments = listOf(navArgument("genderId") {
                type = NavType.IntType
            })
        ) {
            val genderId: Int = it.arguments?.getInt("genderId") ?: -1
            DashboardScreen(navController, genderId)
        }
        composable(route = Screen.About.route) {
            AboutScreen(navController)
        }
        val workoutUri =
            "android-app://org.d3if3139.assessment1.ui.screen.workout.WorkoutScreen"
        composable(
            route = Screen.Workout.route + "/{typeId}" + "/{genderId}",
            deepLinks = listOf(navDeepLink { uriPattern = "$workoutUri{typeId}{genderId}" }),
            arguments =
            listOf(
                navArgument("typeId") {
                    type = NavType.IntType
                }, navArgument("genderId") {
                    type = NavType.IntType
                }
            )
        ) {
            val typeId: Int = it.arguments?.getInt("typeId") ?: -1
            val genderId: Int = it.arguments?.getInt("genderId") ?: -1
            WorkoutScreen(navController, typeId, genderId)
        }
        val calorieUri =
            "android-app://org.d3if3139.assessment1.ui.screen.calorie.CalorieScreen/"
        composable(
            route = Screen.CalorieScreen.route + "/{typeId}" + "/{genderId}",
            deepLinks = listOf(navDeepLink { uriPattern = "$calorieUri{typeId}/{genderId}" }),
            arguments =
            listOf(
                navArgument("typeId") {
                    type = NavType.IntType
                }, navArgument("genderId") {
                    type = NavType.IntType
                }
            )
        ) {
            val typeId: Int = it.arguments?.getInt("typeId") ?: -1
            val genderId: Int = it.arguments?.getInt("genderId") ?: -1
            CalorieScreen(navController, typeId, genderId)
        }
    }
}
