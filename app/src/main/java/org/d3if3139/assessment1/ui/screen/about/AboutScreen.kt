package org.d3if3139.assessment1.ui.screen.about

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.d3if3139.assessment1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavHostController) {
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }, colors = IconButtonDefaults.iconButtonColors(contentColor = colorResource(
                    id = R.color.dark_purple
                ))) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack, contentDescription = stringResource(
                            R.string.back
                        )
                    )
                }
            },
            title = {
                Text(text = stringResource(id = R.string.about))
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = colorResource(R.color.lilac),
                titleContentColor = colorResource(R.color.dark_purple)
            )
        )
    }
    ) { padding ->
        Text(
            text = stringResource(R.string.app_description),
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        )

    }
}

