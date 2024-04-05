package org.d3if3139.assessment1.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("homeScreen")
    data object Dashboard: Screen("dashboardScreen")
    data object About: Screen("aboutScreen")
    data object Workout: Screen("workoutScreen")
    data object CalorieScreen: Screen("calorieScreen")
}