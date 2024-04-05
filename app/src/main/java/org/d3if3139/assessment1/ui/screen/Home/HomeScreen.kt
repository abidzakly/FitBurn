package org.d3if3139.assessment1.ui.screen.Home

import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import org.d3if3139.assessment1.R
import org.d3if3139.assessment1.navigation.Screen
import kotlin.math.round

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = stringResource(id = R.string.app_name))
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = colorResource(R.color.lilac),
                titleContentColor = colorResource(R.color.dark_purple)
            )
        )
    }
    ) { padding ->
        Button(onClick = { navController.navigate(Screen.Dashboard.route) }) {
            
        }
    }
}

