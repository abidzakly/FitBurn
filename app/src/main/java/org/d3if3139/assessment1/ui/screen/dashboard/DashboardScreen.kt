package org.d3if3139.assessment1.ui.screen.dashboard

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3139.assessment1.R
import org.d3if3139.assessment1.model.ExerciseList
import org.d3if3139.assessment1.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController, genderId: Int) {
    val context = LocalContext.current
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = stringResource(R.string.app_name))
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = colorResource(R.color.lilac),
                titleContentColor = colorResource(R.color.dark_purple)
            ),
            actions = {
                BackHandler(enabled = true) {
                    (context as Activity).finish()
                }
                IconButton(onClick = { navController.navigate(Screen.About.route) }) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = stringResource(R.string.about),
                        tint = colorResource(R.color.dark_purple)
                    )
                }
            }
        )
    }
    ) { padding ->
        ScreenContent(Modifier.padding(padding), genderId)
    }
}

@Composable
fun ScreenContent(modifier: Modifier, genderId: Int) {
    val navController = rememberNavController()
    val viewModel: DashboardViewModel = viewModel()
    val data = viewModel.data

    if (genderId == 1 || genderId == 2) {
        if (data.isEmpty()) {
            ListEmpty(isEmpty = true)
        } else {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(bottom = 84.dp)
            ) {
                items(data) {
                    if (it.gender == genderId) {
                        ItemCard(exerciseList = it, modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                navController.navigate(
                                    Screen.Workout.route.format(
                                        it.type,
                                        it.gender
                                    )
                                )
                            })
                    }
                }
            }
        }
    } else {
        ListEmpty(isEmpty = true)
    }

}

@Composable
fun ListEmpty(isEmpty: Boolean) {
    if (isEmpty) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.list_empty),
                fontSize = 48.sp,
                fontWeight = FontWeight(500),
                color = colorResource(R.color.dark_purple)
            )
        }
    }
}

@Composable
fun ItemCard(exerciseList: ExerciseList, modifier: Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(exerciseList.imageResourceId),
                contentDescription = stringResource(exerciseList.title),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(exerciseList.title),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
