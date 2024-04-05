package org.d3if3139.assessment1.navigation

sealed class Screen(val route: String) {
    data object Home: Screen("homeScreen/")
    data object Dashboard: Screen("dashboardScreen/{gender}")
    data object About: Screen("aboutScreen")
}